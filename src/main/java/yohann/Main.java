package yohann;

import yohann.enums.MomentOfTheDay;

import java.time.LocalTime;
import java.util.Locale;
import java.util.Scanner;

import static yohann.VerifierPalindrome.determineMomentOfTheDay;

public class Main {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        LangueInterface language = locale.getLanguage().equals(new Locale("fr").getLanguage()) ? new LangFR() : new LangEn();

        MomentOfTheDay momentOfTheDay = determineMomentOfTheDay(LocalTime.now());

        VerifierPalindrome checker = new VerifierPalindrome(language, momentOfTheDay);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez un mot pour vérifier s'il s'agit d'un palindrome :");
        String inputString = scanner.nextLine();

        String result = checker.verify(inputString);

        System.out.print(result);
    }

}
