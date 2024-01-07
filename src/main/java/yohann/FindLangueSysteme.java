package yohann;


public class FindLangueSysteme implements LangueInterface {

    private LangueInterface langueDetectee;

    public FindLangueSysteme() {
        var code = System.getProperty("use.language");

        if (code.equals("fr")) this.langueDetectee = new LangueFr();
        else this.langueDetectee = new LangueAng();
    }

    @Override
    public String saluer() {
        return "salut";
    }

    @Override
    public String feliciter() {
        return "bien joué";
    }

}