package org.codingdojo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.codingdojo.Face.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RollTest {

    public static Stream<Arguments> should_return_the_full_roll() {
        return Stream.of(
            Arguments.of(new Roll(ONE, ONE, ONE, ONE, ONE), Stream.of(ONE, ONE, ONE, ONE, ONE)),
            Arguments.of(new Roll(ONE, TWO, THREE, FOUR, FIVE), Stream.of(ONE, TWO, THREE, FOUR, FIVE)),
            Arguments.of(new Roll(FIVE, SIX, ONE, TWO, ONE), Stream.of(FIVE, SIX, ONE, TWO, ONE)),
            Arguments.of(new Roll(FOUR, ONE, TWO, THREE, ONE), Stream.of(FOUR, ONE, TWO, THREE, ONE))
        );
    }

    public static Stream<Arguments> should_return_the_roll_filtered_for_specific_face_values() {
        return Stream.of(
            Arguments.of(new Roll(ONE, ONE, ONE, ONE, ONE), ONE, Stream.of(ONE, ONE, ONE, ONE, ONE)),
            Arguments.of(new Roll(ONE, TWO, THREE, FOUR, FIVE), FOUR, Stream.of(FOUR)),
            Arguments.of(new Roll(FIVE, SIX, ONE, FIVE, FIVE), FIVE, Stream.of(FIVE, FIVE, FIVE)),
            Arguments.of(new Roll(FOUR, ONE, TWO, THREE, TWO), TWO, Stream.of(TWO, TWO))
        );
    }

    public static Stream<Arguments> should_find_highest_pair() {
        return Stream.of(
            Arguments.of(new Roll(ONE, TWO, ONE, ONE, ONE), Set.of(ONE)),
            Arguments.of(new Roll(ONE, TWO, ONE, TWO, ONE), Set.of(TWO)),
            Arguments.of(new Roll(FIVE, SIX, ONE, FIVE, ONE), Set.of(FIVE)),
            Arguments.of(new Roll(ONE, TWO, FOUR, SIX, FIVE), Collections.EMPTY_SET)
        );
    }

    public static Stream<Arguments> should_identify_straights() {
        return Stream.of(
            Arguments.of(new Roll(ONE, TWO, THREE, FOUR, FIVE), Set.of(ONE, TWO, THREE, FOUR, FIVE)),
            Arguments.of(new Roll(TWO, THREE, FOUR, FIVE, SIX), Set.of(TWO, THREE, FOUR, FIVE, SIX)),
            Arguments.of(new Roll(TWO, SIX, THREE, FOUR, FIVE), Set.of(TWO, SIX, THREE, FOUR, FIVE)),
            Arguments.of(new Roll(ONE, ONE, THREE, ONE, ONE), Collections.EMPTY_SET)
        );
    }

    public static Stream<Arguments> should_find_all_pairs() {
        return Stream.of(
            Arguments.of(new Roll(ONE, TWO, ONE, ONE, ONE), Set.of(ONE)),
            Arguments.of(new Roll(ONE, TWO, ONE, TWO, ONE), Set.of(ONE, TWO)),
            Arguments.of(new Roll(FIVE, SIX, ONE, FIVE, ONE), Set.of(FIVE, ONE)),
            Arguments.of(new Roll(ONE, TWO, FOUR, SIX, FIVE), Collections.EMPTY_SET)
        );
    }

    public static Stream<Arguments> should_find_yatzys() {
        return Stream.of(
            Arguments.of(new Roll(ONE, ONE, ONE, ONE, ONE), Set.of(ONE)),
            Arguments.of(new Roll(ONE, ONE, ONE, SIX, ONE), Collections.EMPTY_SET)
        );
    }

    public static Stream<Arguments> should_identify_two_pairs() {
        return Stream.of(
            Arguments.of(new Roll(ONE, ONE, ONE, ONE, ONE), false),
            Arguments.of(new Roll(ONE, SIX, ONE, SIX, ONE), true)
        );
    }

    public static Stream<Arguments> should_find_three_of_a_kind() {
        return Stream.of(
            Arguments.of(new Roll(ONE, FOUR, FIVE, ONE, SIX), Collections.EMPTY_SET),
            Arguments.of(new Roll(ONE, SIX, ONE, SIX, ONE), Set.of(ONE))
        );
    }

    public static Stream<Arguments> should_find_four_of_a_kind() {
        return Stream.of(
            Arguments.of(new Roll(ONE, ONE, ONE, FOUR, ONE), Set.of(ONE)),
            Arguments.of(new Roll(ONE, SIX, ONE, SIX, ONE), Collections.EMPTY_SET)
        );
    }

    public static Stream<Arguments> should_identify_three_of_a_kind() {
        return Stream.of(
            Arguments.of(new Roll(ONE, FOUR, FIVE, ONE, SIX), false),
            Arguments.of(new Roll(ONE, SIX, ONE, SIX, ONE), true)
        );
    }

    @ParameterizedTest
    @MethodSource
    void should_return_the_full_roll(Roll roll, Stream<Face> fullRoll) {
        assertEquals(fullRoll.toList(), roll.fullRoll().combination().toList());
    }

    @ParameterizedTest
    @MethodSource
    void should_return_the_roll_filtered_for_specific_face_values(Roll roll, Face value, Stream<Face> filteredRoll) {
        assertEquals(filteredRoll.toList(), roll.filteredRollForOnly(value).combination().toList());
    }

    @ParameterizedTest
    @MethodSource
    void should_identify_straights(Roll roll, Set<Face> straight) {
        assertEquals(straight, roll.findStraight().combination().collect(Collectors.toSet()));
    }

    @ParameterizedTest
    @MethodSource
    void should_find_yatzys(Roll roll, Set<Face> yatzy) {
        assertEquals(yatzy, roll.findYatzy().combination().collect(Collectors.toSet()));
    }

    @ParameterizedTest
    @MethodSource
    void should_find_all_pairs(Roll roll, Set<Face> pairs) {
        assertEquals(pairs, roll.findPairs().combination().collect(Collectors.toSet()));
    }

    @ParameterizedTest
    @MethodSource
    void should_find_highest_pair(Roll roll, Set<Face> highestPair) {
        assertEquals(highestPair, roll.findHighestPair().combination().collect(Collectors.toSet()));
    }

    @ParameterizedTest
    @MethodSource
    void should_identify_three_of_a_kind(Roll roll, boolean isThreeOfAKind) {
        assertEquals(!isThreeOfAKind, roll.doesNotHaveThreeOfAKind());
    }

    @ParameterizedTest
    @MethodSource
    void should_find_three_of_a_kind(Roll roll, Set<Face> threeOfAKind) {
        assertEquals(threeOfAKind, roll.findThreeOfAKind().combination().collect(Collectors.toSet()));
    }

    @ParameterizedTest
    @MethodSource
    void should_find_four_of_a_kind(Roll roll, Set<Face> fourOfAKind) {
        assertEquals(fourOfAKind, roll.findFourOfAKind().combination().collect(Collectors.toSet()));
    }


    @ParameterizedTest
    @MethodSource
    void should_identify_two_pairs(Roll roll, boolean isTwoPairs) {
        assertEquals(!isTwoPairs, roll.doesNotHaveTwoPairs());
    }

}