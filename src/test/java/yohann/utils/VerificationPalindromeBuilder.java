package yohann.utils;

import yohann.VerifierPalindrome;
import yohann.LangueInterface;
import yohann.enums.MomentOfTheDay;

public class VerificationPalindromeBuilder {
    private LangueInterface langue;
    private MomentOfTheDay momentOfTheDay;

    /**
     * Constructeur pour le builder de VerificationPalindrome.
     * Initialise le builder avec une langue spécifique et par défaut le moment de la journée à MATIN.
     *
     * @param langue L'interface de langue pour la localisation des messages.
     */
    public VerificationPalindromeBuilder(LangueInterface langue) {
        this.langue = langue;
        this.momentOfTheDay = MomentOfTheDay.MATIN;
    }

    /**
     * Définit le moment de la journée pour le builder.
     * Cette méthode permet une configuration en chaîne (fluent interface).
     *
     * @param momentOfTheDay Le moment de la journée à utiliser pour le VerifierPalindrome.
     * @return Le builder lui-même pour permettre la mise en chaîne.
     */
    public VerificationPalindromeBuilder withMomentOfTheDay(MomentOfTheDay momentOfTheDay) {
        this.momentOfTheDay = momentOfTheDay;
        return this;
    }

    /**
     * Construit et renvoie une instance de VerifierPalindrome avec la langue et le moment de la journée configurés.
     *
     * @return Une nouvelle instance de VerifierPalindrome.
     */
    public VerifierPalindrome Build() {
        return new VerifierPalindrome(this.langue, this.momentOfTheDay);
    }

}
