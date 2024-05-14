package com.fisglobal.fisglobalfranklinike.game;

import com.fisglobal.fisglobalfranklinike.TestBase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DiceGameTest extends TestBase {

    private static DiceGame diceGame;

    @BeforeAll
    static void setup(){
        diceGame = new DiceGame();

    }

    /**
     * Use this ParameterizedTest to test results of different combination, is as expected
     * @param entriesAndResults
     */
    @ParameterizedTest
    @ArgumentsSource(MyDiceGameArgumentsProvider.class)
    void testScoreMethod(EntriesAndResults entriesAndResults) {
        final int score = diceGame.score(entriesAndResults.entries());

        assertEquals(entriesAndResults.result(), score);
    }

    @Test
    void testNullEntryThrowExpectedExceptionWithMsg(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            diceGame.score(null);
        });
        assertEquals("Null or incorrect entries.", e.getMessage());
    }

    @Test
    void testEntriesEmptyOrTooMany(){
        //length greater than 6
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            diceGame.score(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1});
        });
        assertEquals("Null or incorrect entries.", e.getMessage());

        //length less than 1
        e = assertThrows(IllegalArgumentException.class, () -> {
            diceGame.score(new int[]{});
        });
        assertEquals("Null or incorrect entries.", e.getMessage());
    }

    @Test
    void testEntryValuesIncorrect(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            diceGame.score(new int[]{-1,-2});
        });
        assertEquals("Values should be between 1 and 6.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () -> {
            diceGame.score(new int[]{1,2,3,4,-1});
        });
        assertEquals("Values should be between 1 and 6.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () -> {
            diceGame.score(new int[]{1,2,3,4,7});
        });
        assertEquals("Values should be between 1 and 6.", e.getMessage());
    }


}