package yohann.utils;

import yohann.LangueInterface;
import yohann.enums.Langue;
import yohann.enums.MomentOfTheDay;

public class LangueStub implements LangueInterface {

    private final Langue language;

    public LangueStub(Langue language) {
        this.language = language;
    }

    @Override
    public String getCongrats() {
        return "Congrats";
    }

    @Override
    public String getGreeting(MomentOfTheDay time) {
        return "Greeting for " + time;
    }

    @Override
    public String getGreeting() {
        return null;
    }

    @Override
    public String getGoodbye(MomentOfTheDay momentOfTheDay) {
        return "Goodbye";
    }

    @Override
    public String getWellSaid() {
        return "Well Said";
    }

    @Override
    public Langue getLanguageEnum() {
        return language;
    }
}
