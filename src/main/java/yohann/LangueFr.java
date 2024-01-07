package yohann;

public class LangueFr implements LangueInterface {
    @Override
    public String feliciter() {
        return Expressions.Felicitations;
    }
    @Override
    public String saluer() {
        return Expressions.Bonjour;
    }

    @Override
    public String toString() {
        return "Langue Francaise";
    }
}
