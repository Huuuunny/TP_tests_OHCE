package yohann;

import yohann.enums.*;

public interface LangueInterface {
    String getCongrats();
    String getGreeting(MomentOfTheDay time);
    String getGreeting();
    String getGoodbye(MomentOfTheDay momentOfTheDay);
    String getWellSaid();
    Langue getLanguageEnum();
}
