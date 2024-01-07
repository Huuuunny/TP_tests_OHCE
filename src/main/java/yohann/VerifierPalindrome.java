package yohann;

import yohann.enums.MomentOfTheDay;

import java.time.LocalTime;
import java.util.Locale;

public class VerifierPalindrome {

    private final LangueInterface language;
    private final MomentOfTheDay momentOfTheDay;

    /**
     * Constructeur pour initialiser le vérificateur de palindrome avec une langue et un moment de la journée.
     *
     * @param language La langue utilisée pour les messages de sortie.
     * @param momentOfTheDay Le moment de la journée pour adapter les salutations.
     */
    public VerifierPalindrome(LangueInterface language, MomentOfTheDay momentOfTheDay) {
        this.language = language;
        this.momentOfTheDay = momentOfTheDay;
    }

    /**
     * Obtient la langue du système et retourne l'interface de langue correspondante.
     *
     * @return LangFR si la langue du système est français, sinon LangEn.
     */
    public static LangueInterface getSystemLanguage() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage().equals(new Locale("fr").getLanguage()) ? new LangFR() : new LangEn();
    }

    /**
     * Vérifie si la chaîne fournie est un palindrome.
     * Affiche des messages de salutation, de félicitation ou d'au revoir basés sur la langue et le moment de la journée.
     *
     * @param string La chaîne à vérifier.
     * @return Le résultat de la vérification sous forme de chaîne formatée.
     */
    public String verify(String string) {
        String mirror = new StringBuilder(string).reverse().toString();
        StringBuilder result = new StringBuilder();

        result.append(language.getGreeting(momentOfTheDay)).append(System.lineSeparator());
        result.append(mirror);

        if (mirror.equalsIgnoreCase(string)) {
            result.append(System.lineSeparator()).append(language.getWellSaid());
            result.append(System.lineSeparator()).append(language.getCongrats());
        }

        result.append(System.lineSeparator()).append(language.getGoodbye(momentOfTheDay));
        return result.toString();
    }

    /**
     * Détermine le moment de la journée en fonction de l'heure actuelle.
     *
     * @param time L'heure locale actuelle.
     * @return Le moment de la journée correspondant (MATIN, APRES_MIDI, SOIREE, NUIT).
     */
    public static MomentOfTheDay determineMomentOfTheDay(LocalTime time) {
        if (time.getHour() < 12) {
            return MomentOfTheDay.MATIN;
        } else if (time.getHour() < 18) {
            return MomentOfTheDay.APRES_MIDI;
        } else if (time.getHour() < 22) {
            return MomentOfTheDay.SOIREE;
        } else {
            return MomentOfTheDay.NUIT;
        }
    }

}
