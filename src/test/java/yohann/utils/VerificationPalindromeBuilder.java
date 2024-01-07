package yohann.utils;

import yohann.LangueInterface;
import yohann.MomentDeLaJournee;

public class VerificationPalindromeBuilder {
    private LangueInterface langue;

    public static VerificationPalindromeBuilder Default() {
        return new VerificationPalindromeBuilder().Build();
    }

    public VerificationPalindromeBuilder AyantPourLangue(LangueInterface langue){
        this.langue = langue;
        return this;
    }

    public VerificationPalindromeBuilder AyantPourLangue(Function<LangueBuilder, LangueBuilder> configuration) {
        var langueBuilder = new LangueBuilder();
        langueBuilder = configuration.apply(langueBuilder);
        this.langue = langueBuilder.Build();

        return this;
    }

    public VerificationPalindromeBuilder Build() {
        return new VerificationPalindromeBuilder(this.langue, this.moment);
    }

    public VerificationPalindromeBuilder AyantPourMomentDeLaJournée(MomentDeLaJournee momentDeLaJournée) {
        this.moment = momentDeLaJournée;
        return this;
    }

}
