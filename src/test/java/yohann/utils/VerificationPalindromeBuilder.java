package yohann.utils;

import yohann.VerifierPalindrome;
import yohann.LangueInterface;
import yohann.enums.MomentOfTheDay;

public class VerificationPalindromeBuilder {
    private LangueInterface langue;
    private MomentOfTheDay momentOfTheDay;

    public VerificationPalindromeBuilder(LangueInterface langue) {
        this.langue = langue;
        this.momentOfTheDay = MomentOfTheDay.MATIN; // Valeur par défaut
    }

    public VerificationPalindromeBuilder withMomentOfTheDay(MomentOfTheDay momentOfTheDay) {
        this.momentOfTheDay = momentOfTheDay;
        return this;
    }

    public VerifierPalindrome Build() {
        return new VerifierPalindrome(this.langue, this.momentOfTheDay);
    }

}
