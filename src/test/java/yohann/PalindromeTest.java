package yohann;

import yohann.enums.MomentOfTheDay;
import yohann.utils.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("Si pas un palindrome, on ne félicite pas")
    public void testSansPalindromePasDeFélicitations(){
        // ETANT DONNE un non-palindrome
        String palindrome = "test";
        var langueSpy = new LangueSpy();
        var vérificateur = new VerificationPalindromeBuilder()
                .AyantPourLangue(langueSpy)
                .Build();

        // QUAND on vérifie si c'est un palindrome
        vérificateur.Vérifier(palindrome);

        // ALORS le résultat ne comporte pas de félicitations
        assertFalse(langueSpy.FéliciterAÉtéInvoqué());
    }

    static Stream<Arguments> casTestBonjour() {
        return Stream.of(
                Arguments.of("test", new LangueFrançaise(), MomentDeLaJournée.Matin, Expressions.Bonjour),
                Arguments.of("radar", new LangueFrançaise(), MomentDeLaJournée.Matin, Expressions.Bonjour),
                Arguments.of("test", new LangueAnglaise(), MomentDeLaJournée.Matin, Expressions.Hello),
                Arguments.of("radar", new LangueAnglaise(), MomentDeLaJournée.Matin, Expressions.Hello)
        );
    }

    @ParameterizedTest
    @MethodSource("casTestBonjour")
    @DisplayName("Avant toute chose, on salue")
    public void testBonjour(String chaîne, LangueInterface langue, int momentDeLaJournée, String salutations){
        // ETANT DONNE une chaîne
        // ET un utilisateur parlant une <langue>
        // ET que nous sommes le <momentDeLaJournée>
        var vérification = new VerificationPalindromeBuilder()
                .AyantPourLangue(langue)
                .AyantPourMomentDeLaJournee(momentDeLaJournée)
                .Build();

        // QUAND on vérifie si c'est un palindrome
        String résultat =  vérification.Vérifier(chaîne);

        // ALORS toute réponse est précédée de <salutations>
        // dans cette <langue> à ce moment de la journée
        String[] lines = résultat.split(System.lineSeparator());
        assertEquals(salutations, lines[0]);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "radar"})
    @DisplayName("Après avoir répondu, on s'acquitte")
    public void testAuRevoir(String chaîne){
        // ETANT DONNE une chaîne
        // QUAND on vérifie si c'est un palindrome
        var verification = new VerificationPalindromeBuilder()
                .AyantPourLangue(langue)
                .AyantPourMomentDeLaJournee(momentDeLaJournee)
                .build();

        // ALORS toute réponse est suivie de "Au Revoir"
        String[] lines = résultat.split(System.lineSeparator());
        String lastLine = lines[lines.length - 1];
        assertEquals(Expressions.AuRevoir, lastLine);
    }
}
