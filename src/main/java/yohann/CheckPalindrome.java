package yohann;

import yohann.enums.MomentOfTheDay;

import java.time.LocalTime;
import java.util.Locale;

public class CheckPalindrome {

    private final LangueInterface language;
    private final MomentOfTheDay momentOfTheDay;

    public CheckPalindrome(LangueInterface language, MomentOfTheDay momentOfTheDay) {
        this.language = language;
        this.momentOfTheDay = momentOfTheDay;
    }
    public static LangueInterface getSystemLanguage() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage().equals(new Locale("fr").getLanguage()) ? new LangFR() : new LangEn();
    }

    public String verify(String string) {
        String mirror = new StringBuilder(string).reverse().toString();
        StringBuilder result = new StringBuilder(); // Initialise StringBuilder pour construire la réponse

        result.append(language.getGreeting(momentOfTheDay)).append(System.lineSeparator());
        result.append(mirror);

        if (mirror.equalsIgnoreCase(string)) {
            result.append(System.lineSeparator()).append(language.getWellSaid());
            result.append(System.lineSeparator()).append(language.getCongrats());
        }

        result.append(System.lineSeparator()).append(language.getGoodbye(momentOfTheDay));
        return result.toString();
    }

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
