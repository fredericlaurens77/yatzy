package org.codingdojo;

import org.codingdojo.scorer.YatzyScorer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.codingdojo.Face.ONE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyScorerTest {
    public static Stream<Arguments> should_score_faces() {
        return Stream.of(
            Arguments.of(Stream.of(ONE), 50),
            Arguments.of(Stream.empty(), 0)
        );
    }
    @ParameterizedTest
    @MethodSource
    void should_score_faces(Stream<Face> combination, int sum) {
        YatzyScorer yatzyScorer = new YatzyScorer(combination);
        assertEquals(sum, yatzyScorer.score());
    }
}

