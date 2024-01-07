package yohann.enums;

import yohann.enums.Langue;

public enum Greetings {

    // Définition des salutations pour le français et l'anglais, adaptées aux moments de la journée
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

    /**
     * Obtient la salutation correspondante à l'enum.
     *
     * @return La salutation définie pour l'enum.
     */
    public String getGreeting() {
        return greeting;
    }

    /**
     * Renvoie une salutation adaptée au langage et au moment de la journée.
     *
     * @param language La langue utilisée (français ou anglais).
     * @param time Le moment de la journée (matin, après-midi, soirée, nuit).
     * @return La salutation correspondante.
     */
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

    /**
     * Renvoie une formule d'adieu adaptée au langage et au moment de la journée.
     *
     * @param language La langue utilisée (français ou anglais).
     * @param time Le moment de la journée.
     * @return La formule d'adieu correspondante.
     */
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

    /**
     * Renvoie une formule de félicitations adaptée au langage.
     *
     * @param language La langue utilisée (français ou anglais).
     * @return La formule de félicitations.
     */
    public static String getCongratsByLanguageAndTime(Langue language) {
        return (language == Langue.FRENCH) ?
                Greetings.FELICITATIONS_FR.getGreeting() :
                Greetings.FELICITATIONS_EN.getGreeting();
    }

    /**
     * Renvoie une confirmation de palindrome adaptée au langage.
     *
     * @param language La langue utilisée (français ou anglais).
     * @return La confirmation de palindrome.
     */
    public static String getConfirmPalindrom(Langue language) {
        return (language == Langue.FRENCH) ?
                Greetings.BIEN_DIT_FR.getGreeting() :
                Greetings.BIEN_DIT_EN.getGreeting();
    }

}