package org.codingdojo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.codingdojo.Face.ONE;
import static org.codingdojo.Face.SIX;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultScorerTest {

    public static Stream<Arguments> should_score_faces() {
        return Stream.of(
            Arguments.of(Stream.of(ONE, ONE, ONE, ONE, ONE), 1, 5),
            Arguments.of(Stream.of(ONE, ONE, ONE, ONE, ONE), 2, 10),
            Arguments.of(Stream.of(ONE, ONE, ONE, SIX, ONE), 1, 10)
        );
    }

    @ParameterizedTest
    @MethodSource
    void should_score_faces(Stream<Face> combination, int multiplier, int score) {
        DefaultScorer defaultScorer = new DefaultScorer(combination, multiplier);
        assertEquals(score, defaultScorer.score());
    }
}
