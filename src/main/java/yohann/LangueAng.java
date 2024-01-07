package yohann;

public class LangueAng implements LangueInterface {
    @Override
    public String feliciter() {
        return Expressions.Congrats;
    }
    @Override
    public String saluer() {
        return Expressions.Hello;
    }

    @Override
    public String toString() {
        return "Langue Anglaise";
    }
}
