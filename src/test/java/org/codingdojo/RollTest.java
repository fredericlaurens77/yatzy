package org.codingdojo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

import static org.codingdojo.Face.*;
import static org.junit.jupiter.api.Assertions.*;

class RollTest {

    public static Stream<Arguments> should_return_the_sum() {
        return Stream.of(
            Arguments.of(new Roll(ONE, ONE, ONE, ONE, ONE), 5),
            Arguments.of(new Roll(ONE, TWO, THREE, FOUR, FIVE), 15),
            Arguments.of(new Roll(FIVE, SIX, ONE, TWO, ONE), 15),
            Arguments.of(new Roll(FOUR, ONE, TWO, THREE, ONE), 11)
        );
    }

    public static Stream<Arguments> should_return_the_sum_of_specific_face_values() {
        return Stream.of(
            Arguments.of(new Roll(ONE, ONE, ONE, ONE, ONE), ONE, 5),
            Arguments.of(new Roll(ONE, TWO, THREE, FOUR, FIVE), FOUR, 4),
            Arguments.of(new Roll(FIVE, SIX, ONE, FIVE, FIVE), FIVE, 15),
            Arguments.of(new Roll(FOUR, ONE, TWO, THREE, TWO), TWO, 4)
        );
    }

    public static Stream<Arguments> should_return_the_faces_with_specific_numbers_of_occurrences() {
        return Stream.of(
            Arguments.of(new Roll(ONE, ONE, ONE, ONE, ONE), 5, Set.of(ONE)),
            Arguments.of(new Roll(TWO, TWO, THREE, FOUR, FOUR), 2, Set.of(TWO, FOUR)),
            Arguments.of(new Roll(FIVE, SIX, ONE, FIVE, FIVE), 3, Set.of(FIVE)),
            Arguments.of(new Roll(FOUR, ONE, TWO, THREE, TWO), 3, Collections.EMPTY_SET)
        );
    }

    @ParameterizedTest
    @MethodSource
    void should_return_the_sum(Roll roll, int sum){
        assertEquals(sum, roll.sum());
    }

    @ParameterizedTest
    @MethodSource
    void should_return_the_sum_of_specific_face_values(Roll roll, Face value, int sum){
        assertEquals(sum, roll.sumOfAll(value));
    }

    @ParameterizedTest
    @MethodSource
    void should_return_the_faces_with_specific_numbers_of_occurrences(Roll roll, int occurrences, Set<Face> facesFound){
        assertEquals(facesFound, roll.facesOccurring(occurrences));
    }
}