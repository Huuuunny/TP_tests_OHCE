package yohann;

import yohann.enums.Langue;
import yohann.enums.MomentOfTheDay;

import static yohann.enums.Greetings.*;
import static yohann.enums.Langue.ENGLISH;

public class LangEn implements LangueInterface {

    @Override
    public String getCongrats() {
        return getCongratsByLanguageAndTime(ENGLISH);
    }

    @Override
    public String getGreeting(MomentOfTheDay time) {
        return getGreetingByLanguageAndTime(ENGLISH, time);
    }


    @Override
    public String getGoodbye(MomentOfTheDay time) {
        return getGoodByeByLanguageAndTime(ENGLISH, time);
    }

    @Override
    public String getWellSaid() {
        return getConfirmPalindrom(ENGLISH);
    }

    @Override
    public Langue getLanguageEnum() {
        return Langue.ENGLISH;
    }

    @Override
    public String toString() {
        return "English language";
    }
}
