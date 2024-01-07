package yohann;

import java.time.LocalTime;

public class FindMomentDeLaJournee {

    public static MomentDeLaJournee Find() {
        var heure = LocalTime.now().getHour();

        if(heure<8) return MomentDeLaJournee.nuit;
        if(heure<12) return MomentDeLaJournee.matin;
        if(heure<16) return MomentDeLaJournee.apresMidi;
        if(heure<22) return MomentDeLaJournee.soir;
        return MomentDeLaJournee.nuit;
    }


}
