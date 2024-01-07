package yohann;

import yohann.enums.MomentOfTheDay;

import java.time.LocalTime;
import java.util.Locale;
import java.util.Scanner;

import static yohann.VerifierPalindrome.determineMomentOfTheDay;

public class Main {
    /**
     * Point d'entrée principal de l'application.
     *
     * Ce programme demande à l'utilisateur de saisir un mot et vérifie si ce mot est un palindrome,
     * en affichant des messages personnalisés selon la langue et le moment de la journée.
     */
    public static void main(String[] args) {
        // Détermination de la langue du système
        Locale locale = Locale.getDefault();
        LangueInterface language = locale.getLanguage().equals(new Locale("fr").getLanguage()) ? new LangFR() : new LangEn();

        // Détermination du moment de la journée
        MomentOfTheDay momentOfTheDay = determineMomentOfTheDay(LocalTime.now());

        // Création d'un vérificateur de palindrome avec la langue et le moment de la journée
        VerifierPalindrome checker = new VerifierPalindrome(language, momentOfTheDay);

        // Initialisation du scanner pour lire l'entrée de l'utilisateur
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez un mot pour vérifier s'il s'agit d'un palindrome :");
        String inputString = scanner.nextLine();

        // Vérification du palindrome et affichage du résultat
        String result = checker.verify(inputString);

        System.out.print(result);
    }

}
