package yohann;

import yohann.enums.Langue;
import yohann.enums.MomentOfTheDay;

import static yohann.enums.Greetings.*;
import static yohann.enums.Langue.ENGLISH;
import static yohann.enums.Langue.FRENCH;

public class LangFR implements LangueInterface {

    @Override
    public String getCongrats() {
        return getCongratsByLanguageAndTime(FRENCH);
    }

    @Override
    public String getGreeting(MomentOfTheDay time) {
        return getGreetingByLanguageAndTime(FRENCH, time);
    }


    @Override
    public String getGoodbye(MomentOfTheDay time) {
        return getGoodByeByLanguageAndTime(FRENCH, time);
    }

    @Override
    public String getWellSaid() {
        return getConfirmPalindrom(FRENCH);
    }

    @Override
    public Langue getLanguageEnum() {
        return Langue.FRENCH;
    }

    @Override
    public String toString() {
        return "English language";
    }
}
