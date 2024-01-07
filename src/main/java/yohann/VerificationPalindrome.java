package yohann;

public class VerificationPalindrome {

    private final LangueInterface langue;
    public VerificationPalindrome(LangueInterface langue, MomentDeLaJournee moment){
        this.langue = langue;
    }

    public String Verifier(String chaine) {
        String miroir =  new StringBuilder(chaine)
                .reverse()
                .toString();

        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append(this.langue.saluer());
        resultBuilder.append(System.lineSeparator());
        resultBuilder.append(miroir);
        resultBuilder.append(System.lineSeparator());

        if(miroir.equals(chaine)) {
            resultBuilder.append(this.langue.feliciter());
            resultBuilder.append(System.lineSeparator());
        }

        resultBuilder.append(Expressions.AuRevoir);
        return resultBuilder.toString();
    }

}
