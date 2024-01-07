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

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {
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

    static Stream<Arguments> fournirCasPourSalutations() {
        return Stream.of(
                Arguments.of("radar", new LangFR(), MomentOfTheDay.MATIN),
                Arguments.of("kayak", new LangFR(), MomentOfTheDay.APRES_MIDI),
                Arguments.of("non", new LangFR(), MomentOfTheDay.SOIREE),
                Arguments.of("non", new LangFR(), MomentOfTheDay.NUIT),
                Arguments.of("radar", new LangEn(), MomentOfTheDay.MATIN),
                Arguments.of("kayak", new LangEn(), MomentOfTheDay.APRES_MIDI),
                Arguments.of("non", new LangEn(), MomentOfTheDay.SOIREE),
                Arguments.of("non", new LangEn(), MomentOfTheDay.NUIT)
        );
    }

    @ParameterizedTest
    @MethodSource("fournirCasPourSalutations")
    public void testBonjourAvecBonneLangue(String inputString, LangueInterface language, MomentOfTheDay moment) {
        VerifierPalindrome checker = new VerificationPalindromeBuilder(language)
                .withMomentOfTheDay(moment)
                .Build();
        String result = checker.verify(inputString);

        String expected = Greetings.getGreetingByLanguageAndTime(language.getLanguageEnum(), moment);

        assertTrue(result.startsWith(expected));
    }

    static Stream<Arguments> fournirCasPourAuRevoir() {
        return Stream.of(
                Arguments.of("radar", new LangFR(), MomentOfTheDay.MATIN),
                Arguments.of("non", new LangFR(), MomentOfTheDay.APRES_MIDI),
                Arguments.of("anna", new LangFR(), MomentOfTheDay.SOIREE),
                Arguments.of("anna", new LangFR(), MomentOfTheDay.NUIT),
                Arguments.of("radar", new LangEn(), MomentOfTheDay.MATIN),
                Arguments.of("non", new LangEn(), MomentOfTheDay.APRES_MIDI),
                Arguments.of("anna", new LangEn(), MomentOfTheDay.SOIREE),
                Arguments.of("anna", new LangEn(), MomentOfTheDay.NUIT)
        );
    }

    @ParameterizedTest
    @MethodSource("fournirCasPourAuRevoir")
    public void testAuRevoirAvecBonneLangue(String inputString, LangueInterface language, MomentOfTheDay moment) {
        VerifierPalindrome checker = new VerificationPalindromeBuilder(language)
                .withMomentOfTheDay(moment)
                .Build();
        String result = checker.verify(inputString);

        String expected = Greetings.getGoodByeByLanguageAndTime(language.getLanguageEnum(), moment);

        assertTrue(result.endsWith(expected));
    }
}
