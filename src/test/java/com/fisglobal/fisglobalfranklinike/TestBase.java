package com.fisglobal.fisglobalfranklinike;

import com.fisglobal.fisglobalfranklinike.game.EntriesAndResults;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class TestBase {

    protected static class MyDiceGameArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    new EntriesAndResults(new int[]{1, 2, 3, 1, 1}, 1000),
                    //A single one
                    new EntriesAndResults(new int[]{1}, 100),
                    new EntriesAndResults(new int[]{1,2}, 100),
                    new EntriesAndResults(new int[]{1,2,3}, 100),
                    new EntriesAndResults(new int[]{1,2,3,4}, 100),
                    new EntriesAndResults(new int[]{1,2,3,4,6}, 100),
                    //A single five
                    new EntriesAndResults(new int[]{5}, 50),
                    //Straight
                    new EntriesAndResults(new int[]{1,2,3,4,5,6}, 1200),
                    //Three Pairs
                    new EntriesAndResults(new int[]{2,2,3,3,4,4}, 800),
                    new EntriesAndResults(new int[]{1,1,2,2,3,3}, 800),
                    new EntriesAndResults(new int[]{5,5,4,4,3,3}, 800),
                    new EntriesAndResults(new int[]{1,1,3,3,5,5}, 800),
                    //Six-of-a-kind
                    new EntriesAndResults(new int[]{1,1,1,1,1,1}, 8000),
                    new EntriesAndResults(new int[]{2,2,2,2,2,2}, 1600),
                    new EntriesAndResults(new int[]{3,3,3,3,3,3}, 2400),
                    new EntriesAndResults(new int[]{4,4,4,4,4,4}, 3200),
                    new EntriesAndResults(new int[]{5,5,5,5,5,5}, 4000),
                    new EntriesAndResults(new int[]{6,6,6,6,6,6}, 4800),
                    //Five-of-a-kind
                    new EntriesAndResults(new int[]{1,1,1,1,1,3}, 4000),
                    new EntriesAndResults(new int[]{2,2,2,2,2,4}, 800),
                    new EntriesAndResults(new int[]{3,3,3,3,3,6}, 1200),
                    new EntriesAndResults(new int[]{4,4,4,4,4,2}, 1600),
                    new EntriesAndResults(new int[]{5,5,5,5,5,3}, 2000),
                    new EntriesAndResults(new int[]{6,6,6,6,6,2}, 2400),
                    new EntriesAndResults(new int[]{6,6,6,6,6,1}, 2500),
                    new EntriesAndResults(new int[]{6,6,6,6,6,5}, 2450),
                    //Four-of-a-kind
                    new EntriesAndResults(new int[]{1,1,1,1,3,3}, 2000),
                    new EntriesAndResults(new int[]{2,2,2,2,4,4}, 400),
                    new EntriesAndResults(new int[]{3,3,3,3,6,6}, 600),
                    new EntriesAndResults(new int[]{4,4,4,4,2,2}, 800),
                    new EntriesAndResults(new int[]{5,5,5,5,3,3}, 1000),
                    new EntriesAndResults(new int[]{6,6,6,6,2,2}, 1200),
                    new EntriesAndResults(new int[]{6,6,6,6,1,4}, 1300),
                    new EntriesAndResults(new int[]{6,6,6,6,5,4}, 1250),
                    new EntriesAndResults(new int[]{6,6,6,6,1,5}, 1350),

                    //Triples
                    new EntriesAndResults(new int[]{1,1,1,2,3,4}, 1000),
                    new EntriesAndResults(new int[]{2,2,2,3,4,6}, 200),
                    new EntriesAndResults(new int[]{3,3,3,2,4,6}, 300),
                    new EntriesAndResults(new int[]{4,4,4,2,3,6}, 400),
                    new EntriesAndResults(new int[]{5,5,5,6,4,2}, 500),
                    new EntriesAndResults(new int[]{6,6,6,4,3,2}, 600),
                    new EntriesAndResults(new int[]{1,1,1,2,2,2}, 1200),
                    new EntriesAndResults(new int[]{1,1,1,3,3,3}, 1300),
                    new EntriesAndResults(new int[]{1,1,1,4,4,4}, 1400),
                    new EntriesAndResults(new int[]{1,1,1,5,5,5}, 1500),
                    new EntriesAndResults(new int[]{1,1,1,6,6,6}, 1600),
                    new EntriesAndResults(new int[]{2,2,2,3,3,3}, 500),
                    new EntriesAndResults(new int[]{2,2,2,4,4,4}, 600),
                    new EntriesAndResults(new int[]{2,2,2,5,5,5}, 700),
                    new EntriesAndResults(new int[]{2,2,2,6,6,6}, 800),
                    new EntriesAndResults(new int[]{3,3,3,4,4,4}, 700),
                    new EntriesAndResults(new int[]{3,3,3,5,5,5}, 800),
                    new EntriesAndResults(new int[]{3,3,3,6,6,6}, 900),
                    new EntriesAndResults(new int[]{4,4,4,5,5,5}, 900),
                    new EntriesAndResults(new int[]{4,4,4,6,6,6}, 1000),
                    new EntriesAndResults(new int[]{5,5,5,6,6,6}, 1100),
                    new EntriesAndResults(new int[]{6,6,6,1,3,2}, 700),
                    new EntriesAndResults(new int[]{6,6,6,5,3,2}, 650),
                    new EntriesAndResults(new int[]{6,6,6,1,5,2}, 750)
            ).map(Arguments::of);
        }
    }

}
