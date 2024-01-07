package yohann;

public class MomentDeLaJournee {

    private final String moment;

    public static MomentDeLaJournee matin = new MomentDeLaJournee("Matin");
    public static MomentDeLaJournee nuit = new MomentDeLaJournee("Nuit");
    public static MomentDeLaJournee apresMidi = new MomentDeLaJournee("Après-Midi");
    public static MomentDeLaJournee soir = new MomentDeLaJournee("Soir");
    public static MomentDeLaJournee inconnu = new MomentDeLaJournee("Inconnu");

    public MomentDeLaJournee(String label) {
        this.moment = label;
    }

    @Override
    public String toString(){
        return this.moment;
    }
}
