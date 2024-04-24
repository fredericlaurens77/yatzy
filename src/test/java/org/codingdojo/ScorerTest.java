package org.codingdojo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.codingdojo.Face.ONE;
import static org.codingdojo.Face.SIX;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScorerTest {

    public static Stream<Arguments> should_sum_faces_with_multiplying_factor() {
        return Stream.of(
            Arguments.of(new Roll(ONE, ONE, ONE, ONE, ONE), 2, 10),
            Arguments.of(new Roll(ONE, ONE, ONE, SIX, ONE), 3, 30)
        );
    }

    public static Stream<Arguments> should_sum_faces() {
        return Stream.of(
            Arguments.of(new Roll(ONE, ONE, ONE, ONE, ONE), 5),
            Arguments.of(new Roll(ONE, ONE, ONE, SIX, ONE), 10)
        );
    }

    @ParameterizedTest
    @MethodSource
    void should_sum_faces(Roll roll, int sum) {
        assertEquals(sum, Scorer.sumFaces(roll.fullRoll()));
    }

    @ParameterizedTest
    @MethodSource
    void should_sum_faces_with_multiplying_factor(Roll roll, int times, int sum) {
        assertEquals(sum, Scorer.sumFacesWithMultiplier(roll.fullRoll(), times));
    }
}
