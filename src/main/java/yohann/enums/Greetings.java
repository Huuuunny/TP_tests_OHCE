package yohann.enums;

import yohann.enums.Langue;

public enum Greetings {
    BONJOUR_MATIN_FR("Bonjour, matin !"),
    BONJOUR_APRES_MIDI_FR("Bonjour, après-midi !"),
    BONSOIR_SOIREE_FR("Bonsoir, soirée !"),
    BONNE_NUIT_FR("Bonne nuit !"),

    BONJOUR_MATIN_EN("Good morning!"),
    BONJOUR_APRES_MIDI_EN("Good afternoon!"),
    BONSOIR_SOIREE_EN("Good evening!"),
    BONNE_NUIT_EN("Good night!"),

    AUREVOIR_MATIN_FR("Au revoir, matin !"),
    AUREVOIR_APRES_MIDI_FR("Au revoir, après-midi !"),
    AUREVOIR_SOIREE_FR("Au revoir, soirée !"),
    AUREVOIR_NUIT_FR("Bonne nuit et au revoir !"),
    AUREVOIR_MATIN_EN("Goodbye, morning!"),
    AUREVOIR_APRES_MIDI_EN("Goodbye, afternoon!"),
    AUREVOIR_SOIREE_EN("Goodbye, evening!"),
    AUREVOIR_NUIT_EN("Good night and goodbye!"),

    FELICITATIONS_FR("Félicitations !"),
    FELICITATIONS_EN("Congratulations!"),

    BIEN_DIT_FR("Bien dit !"),
    BIEN_DIT_EN("Well said !");

    private final String greeting;

    Greetings(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }

    public static String getGreetingByLanguageAndTime(Langue language, MomentOfTheDay time) {
        if (language == Langue.FRENCH) {
            switch (time) {
                case MATIN:
                    return Greetings.BONJOUR_MATIN_FR.getGreeting();
                case APRES_MIDI:
                    return Greetings.BONJOUR_APRES_MIDI_FR.getGreeting();
                case SOIREE:
                    return Greetings.BONSOIR_SOIREE_FR.getGreeting();
                case NUIT:
                    return Greetings.BONNE_NUIT_FR.getGreeting();
            }
        } else {
            switch (time) {
                case MATIN:
                    return Greetings.BONJOUR_MATIN_EN.getGreeting();
                case APRES_MIDI:
                    return Greetings.BONJOUR_APRES_MIDI_EN.getGreeting();
                case SOIREE:
                    return Greetings.BONSOIR_SOIREE_EN.getGreeting();
                case NUIT:
                    return Greetings.BONNE_NUIT_EN.getGreeting();
            }
        }
        return "Hello";
    }

    public static String getGoodByeByLanguageAndTime(Langue language, MomentOfTheDay time) {
        if (language == Langue.FRENCH) {
            switch (time) {
                case MATIN:
                    return Greetings.AUREVOIR_MATIN_FR.getGreeting();
                case APRES_MIDI:
                    return Greetings.AUREVOIR_APRES_MIDI_FR.getGreeting();
                case SOIREE:
                    return Greetings.AUREVOIR_SOIREE_FR.getGreeting();
                case NUIT:
                    return Greetings.AUREVOIR_NUIT_FR.getGreeting();
            }
        } else {
            switch (time) {
                case MATIN:
                    return Greetings.AUREVOIR_MATIN_EN.getGreeting();
                case APRES_MIDI:
                    return Greetings.AUREVOIR_APRES_MIDI_EN.getGreeting();
                case SOIREE:
                    return Greetings.AUREVOIR_SOIREE_EN.getGreeting();
                case NUIT:
                    return Greetings.AUREVOIR_NUIT_EN.getGreeting();
            }
        }
        return "Goodbye";
    }

    public static String getCongratsByLanguageAndTime(Langue language) {
        return (language == Langue.FRENCH) ?
                Greetings.FELICITATIONS_FR.getGreeting() :
                Greetings.FELICITATIONS_EN.getGreeting();
    }

    public static String getConfirmPalindrom(Langue language) {
        return (language == Langue.FRENCH) ?
                Greetings.BIEN_DIT_FR.getGreeting() :
                Greetings.BIEN_DIT_EN.getGreeting();
    }

}