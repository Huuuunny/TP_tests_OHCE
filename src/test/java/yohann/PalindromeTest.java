package yohann;

import org.junit.jupiter.params.provider.Arguments;
import yohann.enums.Greetings;
import yohann.enums.Langue;
import yohann.enums.MomentOfTheDay;
import yohann.utils.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static yohann.VerifierPalindrome.determineMomentOfTheDay;
import static yohann.VerifierPalindrome.getSystemLanguage;

public class PalindromeTest {
    /**
     * Teste si la méthode de vérification renvoie bien la chaîne inversée pour des chaînes non palindromes.
     */
    @ParameterizedTest
    @ValueSource(strings = {"test", "kayak"})
    @DisplayName("La chaîne entrée est renvoyée à l'envers")
    public void testMiroir(String chaine) {
        // ETANT DONNE une chaîne n'étant pas un palindrome
        // QUAND on vérifie si c'est un palindrome
        VerifierPalindrome stringToVerify = new VerificationPalindromeBuilder(new LangFR())
                .withMomentOfTheDay(MomentOfTheDay.MATIN)
                .Build();
        // ALORS on obtient son miroir
        String result = stringToVerify.verify(chaine);

        String inversion = new StringBuilder(chaine)
                .reverse()
                .toString();

        assertTrue(result.contains(inversion));
    }

    /**
     * Teste si la méthode de vérification identifie correctement un palindrome en français,
     * et vérifie les différentes parties du message retourné.
     */
    @Test
    public void testFrenchPalindrome() {
        VerifierPalindrome stringToVerify = new VerificationPalindromeBuilder(new LangFR())
                .withMomentOfTheDay(MomentOfTheDay.MATIN)
                .Build();
        String palindrome = "radar";
        String result = stringToVerify.verify(palindrome);

        String expectedStart = Greetings.getGreetingByLanguageAndTime(Langue.FRENCH, MomentOfTheDay.MATIN);
        String confirm = Greetings.getConfirmPalindrom(Langue.FRENCH);
        String congrats = Greetings.getCongratsByLanguageAndTime(Langue.FRENCH);
        String expectedEnd = Greetings.getGoodByeByLanguageAndTime(Langue.FRENCH, MomentOfTheDay.MATIN);


        assertTrue(result.startsWith(expectedStart));
        assertTrue(result.contains(palindrome));
        assertTrue(result.contains(confirm));
        assertTrue(result.contains(congrats));
        assertTrue(result.endsWith(expectedEnd));
    }

    /**
     * Fournit différents cas de test pour tester les salutations selon la langue et le moment de la journée.
     */
    static Stream<Arguments> fournirCasPourSalutations() {
        return Stream.of(
                Arguments.of("elu par cette crapule", new LangFR(), MomentOfTheDay.MATIN),
                Arguments.of("kayak", new LangFR(), MomentOfTheDay.APRES_MIDI),
                Arguments.of("radar", new LangFR(), MomentOfTheDay.SOIREE),
                Arguments.of("radar", new LangFR(), MomentOfTheDay.NUIT),
                Arguments.of("elu par cette crapule", new LangEn(), MomentOfTheDay.MATIN),
                Arguments.of("kayak", new LangEn(), MomentOfTheDay.APRES_MIDI),
                Arguments.of("radar", new LangEn(), MomentOfTheDay.SOIREE),
                Arguments.of("radar", new LangEn(), MomentOfTheDay.NUIT)
        );
    }

    /**
     * Teste si les bonnes salutations sont utilisées selon la langue et le moment de la journée pour un palindrome.
     */
    @ParameterizedTest
    @MethodSource("fournirCasPourSalutations")
    public void testBonjourAvecBonneLangue(String inputString, LangueInterface language, MomentOfTheDay moment) {
        VerifierPalindrome stringToVerify = new VerificationPalindromeBuilder(language)
                .withMomentOfTheDay(moment)
                .Build();
        String result = stringToVerify.verify(inputString);

        String expected = Greetings.getGreetingByLanguageAndTime(language.getLanguageEnum(), moment);

        assertTrue(result.startsWith(expected));
    }

    /**
     * Fournit différents cas de test pour tester les formules d'adieu selon la langue et le moment de la journée.
     */
    static Stream<Arguments> fournirCasPourAuRevoir() {
        return Stream.of(
                Arguments.of("elu par cette crapule", new LangFR(), MomentOfTheDay.MATIN),
                Arguments.of("kayak", new LangFR(), MomentOfTheDay.APRES_MIDI),
                Arguments.of("radar", new LangFR(), MomentOfTheDay.SOIREE),
                Arguments.of("radar", new LangFR(), MomentOfTheDay.NUIT),
                Arguments.of("elu par cette crapule", new LangEn(), MomentOfTheDay.MATIN),
                Arguments.of("kayak", new LangEn(), MomentOfTheDay.APRES_MIDI),
                Arguments.of("non", new LangEn(), MomentOfTheDay.SOIREE),
                Arguments.of("non", new LangEn(), MomentOfTheDay.NUIT)
        );
    }

    /**
     * Teste si les bonnes formules d'adieu sont utilisées selon la langue et le moment de la journée pour un palindrome.
     */
    @ParameterizedTest
    @MethodSource("fournirCasPourAuRevoir")
    public void testAuRevoirAvecBonneLangue(String inputString, LangueInterface language, MomentOfTheDay moment) {
        VerifierPalindrome stringToVerify = new VerificationPalindromeBuilder(language)
                .withMomentOfTheDay(moment)
                .Build();
        String result = stringToVerify.verify(inputString);

        String expected = Greetings.getGoodByeByLanguageAndTime(language.getLanguageEnum(), moment);

        assertTrue(result.endsWith(expected));
    }

    /**
     * Teste si la langue et le moment de la journée du système sont correctement identifiés et utilisés dans la vérification.
     */
    @Test
    public void testLangueEtHeureSysteme() {
        LangueInterface systemLanguage = getSystemLanguage();
        MomentOfTheDay systemMoment = determineMomentOfTheDay(LocalTime.now());
        VerifierPalindrome stringToVerify = new VerifierPalindrome(systemLanguage, systemMoment);

        String inputString = "kayak";
        String result = stringToVerify.verify(inputString);

        String expectedStart = Greetings.getGreetingByLanguageAndTime(systemLanguage.getLanguageEnum(), systemMoment);
        String expectedEnd = Greetings.getGoodByeByLanguageAndTime(systemLanguage.getLanguageEnum(), systemMoment);

        assertTrue(result.startsWith(expectedStart));
        assertTrue(result.endsWith(expectedEnd));
    }

    /**
     * Teste si la chaîne résultante de la vérification ne se termine pas par un saut de ligne.
     */
    @Test
    public void testPasDeSautDeLigneFin() {
        LangueInterface systemLanguage = getSystemLanguage();
        MomentOfTheDay systemMoment = determineMomentOfTheDay(LocalTime.now());
        VerifierPalindrome stringToVerify = new VerifierPalindrome(systemLanguage, systemMoment);

        String inputString = "radar";
        String result = stringToVerify.verify(inputString);

        // Check que le dernier caractère n'est pas un saut de ligne
        char lastChar = result.charAt(result.length() - 1);
        boolean hasNoFinalNewLine = lastChar != '\n' && lastChar != '\r';
        assertTrue(hasNoFinalNewLine, "Le dernier caractère ne doit pas être un saut de ligne");
    }
}
