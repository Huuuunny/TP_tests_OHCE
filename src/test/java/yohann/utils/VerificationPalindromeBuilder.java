package yohann.utils;

public class VerificationPalindromeBuilder {
    private LangueInterface langue;
    private int momentDeLaJournee = 0;

    public static VerificationPalindrome Default() {
        return new VerificationPalindromeBuilder().Build();
    }

    public VerificationPalindrome Build() {
        return new VerificationPalindrome(this.langue, this.momentDeLaJournee);
    }

    public VerificationPalindromeBuilder AyantPourLangue(LangueInterface langue){
        this.langue = langue;
        return this;
    }

    public VerificationPalindromeBuilder AyantPourMomentDeLaJournee(int momentDeLaJournee) {
        this.momentDeLaJournee = momentDeLaJournee;
        return this;
    }

}
