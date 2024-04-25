package org.codingdojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.codingdojo.Face.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    public static Stream<Arguments> chance_score_should_be_the_sum_of_all_dice() {
        return Stream.of(
            Arguments.of(new Roll(TWO, THREE, FOUR, FIVE, ONE), 15),
            Arguments.of(new Roll(THREE, THREE, FOUR, FIVE, ONE), 16),
            Arguments.of(new Roll(ONE, ONE, THREE, THREE, SIX), 14),
            Arguments.of(new Roll(FOUR, FIVE, FIVE, SIX, ONE), 21)
        );
    }

    public static Stream<Arguments> yatzy_score_should_be_50() {
        return Stream.of(
            Arguments.of(new Roll(FOUR, FOUR, FOUR, FOUR, FOUR)),
            Arguments.of(new Roll(SIX, SIX, SIX, SIX, SIX)),
            Arguments.of(new Roll(ONE, ONE, ONE, ONE, ONE))
        );
    }

    public static Stream<Arguments> yatzy_score_should_be_0_when_not_a_yatzy() {
        return Stream.of(
            Arguments.of(new Roll(SIX, SIX, SIX, SIX, THREE)),
            Arguments.of(new Roll(ONE, ONE, ONE, TWO, ONE))
        );
    }

    public static Stream<Arguments> ones_score_should_be_the_sum_of_ones() {
        return Stream.of(
            Arguments.of(new Roll(ONE, TWO, THREE, FOUR, FIVE), 1),
            Arguments.of(new Roll(ONE, TWO, ONE, FOUR, FIVE), 2),
            Arguments.of(new Roll(SIX, TWO, TWO, FOUR, FIVE), 0),
            Arguments.of(new Roll(ONE, TWO, ONE, ONE, ONE), 4),
            Arguments.of(new Roll(THREE, THREE, THREE, FOUR, FIVE), 0)
        );
    }

    public static Stream<Arguments> twos_score_should_be_the_sum_of_twos() {
        return Stream.of(
            Arguments.of(new Roll(ONE, TWO, THREE, TWO, SIX), 4),
            Arguments.of(new Roll(TWO, TWO, TWO, TWO, TWO), 10),
            Arguments.of(new Roll(SIX, THREE, SIX, FIVE, ONE), 0)
        );
    }

    public static Stream<Arguments> threes_score_should_be_the_sum_of_threes() {
        return Stream.of(
            Arguments.of(new Roll(ONE, TWO, TWO, TWO, SIX), 0),
            Arguments.of(new Roll(ONE, TWO, THREE, TWO, THREE), 6),
            Arguments.of(new Roll(TWO, THREE, THREE, THREE, THREE), 12)
        );
    }

    public static Stream<Arguments> fours_score_should_be_the_sum_of_fours() {
        return Stream.of(
            Arguments.of(new Roll(FIVE, FIVE, FIVE, FIVE, FIVE), 0),
            Arguments.of(new Roll(FOUR, FOUR, FOUR, FIVE, FIVE), 12),
            Arguments.of(new Roll(FOUR, FOUR, FIVE, FIVE, FIVE), 8),
            Arguments.of(new Roll(FOUR, FIVE, FIVE, FIVE, FIVE), 4),
            Arguments.of(new Roll(ONE, ONE, TWO, FOUR, FOUR), 8)
        );
    }

    public static Stream<Arguments> fives_score_should_be_the_sum_of_fives() {
        return Stream.of(
            Arguments.of(new Roll(FOUR, FOUR, FOUR, SIX, SIX), 0),
            Arguments.of(new Roll(FOUR, FOUR, FOUR, FIVE, FIVE), 10),
            Arguments.of(new Roll(FOUR, FOUR, FIVE, FIVE, FIVE), 15),
            Arguments.of(new Roll(FOUR, FIVE, FIVE, FIVE, FIVE), 20)
        );
    }

    public static Stream<Arguments> sixes_score_should_be_the_sum_of_sixes() {
        return Stream.of(
            Arguments.of(new Roll(FOUR, FOUR, FOUR, FIVE, FIVE), 0),
            Arguments.of(new Roll(FOUR, FOUR, SIX, FIVE, FIVE), 6),
            Arguments.of(new Roll(SIX, FIVE, SIX, SIX, FIVE), 18)
        );
    }

    public static Stream<Arguments> one_pair_score_should_be_the_sum_of_highest_pair() {
        return Stream.of(
            Arguments.of(new Roll(THREE, FOUR, THREE, FIVE, SIX), 6),
            Arguments.of(new Roll(FIVE, THREE, THREE, THREE, FIVE), 10),
            Arguments.of(new Roll(FIVE, THREE, SIX, SIX, FIVE), 12),
            Arguments.of(new Roll(THREE, THREE, THREE, FOUR, FOUR), 8),
            Arguments.of(new Roll(ONE, ONE, SIX, TWO, SIX), 12),
            Arguments.of(new Roll(THREE, THREE, THREE, FOUR, ONE), 6),
            Arguments.of(new Roll(THREE, THREE, THREE, THREE, ONE), 6)
        );
    }

    public static Stream<Arguments> two_pair_score_should_be_the_sum_of_the_two_pairs() {
        return Stream.of(
            Arguments.of(new Roll(THREE, THREE, FIVE, FOUR, FIVE), 16),
            Arguments.of(new Roll(ONE, ONE, TWO, THREE, THREE), 8)
        );
    }

    public static Stream<Arguments> two_pair_score_should_be_ignore_a_third_occurrence() {
        return Stream.of(
            Arguments.of(new Roll(THREE, THREE, FIVE, FIVE, FIVE), 16),
            Arguments.of(new Roll(ONE, ONE, TWO, TWO, TWO), 6)
        );
    }

    public static Stream<Arguments> three_of_a_kind_score_should_be_the_sum() {
        return Stream.of(
            Arguments.of(new Roll(THREE, THREE, THREE, FOUR, FIVE), 9),
            Arguments.of(new Roll(FIVE, THREE, FIVE, FOUR, FIVE), 15)
        );
    }

    public static Stream<Arguments> four_of_a_kind_score_should_be_the_sum() {
        return Stream.of(
            Arguments.of(new Roll(THREE, THREE, THREE, THREE, FIVE), 12),
            Arguments.of(new Roll(FIVE, FIVE, FIVE, FOUR, FIVE), 20)
        );
    }

    public static Stream<Arguments> full_house_should_score_sum_of_two_groups() {
        return Stream.of(
            Arguments.of(new Roll(SIX, TWO, TWO, TWO, SIX), 18),
            Arguments.of(new Roll(ONE, ONE, TWO, TWO, TWO), 8)
        );
    }

    public static Stream<Arguments> full_house_should_score_0_when_not_a_full_house() {
        return Stream.of(
            Arguments.of(new Roll(TWO, THREE, FOUR, FIVE, SIX)),
            Arguments.of(new Roll(TWO, TWO, THREE, THREE, FOUR)),
            Arguments.of(new Roll(FOUR, FOUR, FOUR, FOUR, FOUR))
        );
    }

    @ParameterizedTest
    @MethodSource
    void chance_score_should_be_the_sum_of_all_dice(Roll roll, int score) {
        assertEquals(score, Yatzy.scoreChance(roll));
    }

    @ParameterizedTest
    @MethodSource
    void yatzy_score_should_be_50(Roll roll) {
        assertEquals(50, Yatzy.scoreYatzy(roll));
    }

    @ParameterizedTest
    @MethodSource
    void yatzy_score_should_be_0_when_not_a_yatzy(Roll roll) {
        assertEquals(0, Yatzy.scoreYatzy(roll));
    }


    @ParameterizedTest
    @MethodSource
    void ones_score_should_be_the_sum_of_ones(Roll roll, int score) {
        assertEquals(score, Yatzy.scoreOnes(roll));
    }

    @ParameterizedTest
    @MethodSource
    void twos_score_should_be_the_sum_of_twos(Roll roll, int score) {
        assertEquals(score, Yatzy.scoreTwos(roll));
    }

    @ParameterizedTest
    @MethodSource
    void threes_score_should_be_the_sum_of_threes(Roll roll, int score) {
        assertEquals(score, Yatzy.scoreThrees(roll));
    }

    @ParameterizedTest
    @MethodSource
    void fours_score_should_be_the_sum_of_fours(Roll roll, int score) {
        assertEquals(score, Yatzy.scoreFours(roll));
    }

    @ParameterizedTest
    @MethodSource
    void fives_score_should_be_the_sum_of_fives(Roll roll, int score) {
        assertEquals(score, Yatzy.scoreFives(roll));
    }

    @ParameterizedTest
    @MethodSource
    void sixes_score_should_be_the_sum_of_sixes(Roll roll, int score) {
        assertEquals(score, Yatzy.scoreSixes(roll));
    }

    @Test
    void one_pair_score_should_be_zero_when_there_is_no_pair() {
        assertEquals(0, Yatzy.scorePair(new Roll(ONE, TWO, THREE, FOUR, FIVE)));
    }

    @ParameterizedTest
    @MethodSource
    void one_pair_score_should_be_the_sum_of_highest_pair(Roll roll, int score) {
        assertEquals(score, Yatzy.scorePair(roll));
    }

    @Test
    void two_pair_score_should_be_zero_when_there_is_only_one_pair() {
        assertEquals(0, Yatzy.scoreTwoPairs(new Roll(ONE, ONE, TWO, THREE, FOUR)));
    }

    @Test
    void two_pair_score_should_be_zero_when_it_is_a_four_of_a_kind() {
        assertEquals(0, Yatzy.scoreTwoPairs(new Roll(THREE, THREE, THREE, THREE, ONE)));
    }

    @ParameterizedTest
    @MethodSource
    void two_pair_score_should_be_the_sum_of_the_two_pairs(Roll roll, int score) {
        assertEquals(score, Yatzy.scoreTwoPairs(roll));
    }

    @ParameterizedTest
    @MethodSource
    void two_pair_score_should_be_ignore_a_third_occurrence(Roll roll, int score) {
        assertEquals(score, Yatzy.scoreTwoPairs(roll));
    }

    @Test
    void three_of_a_kind_score_should_be_zero() {
        assertEquals(0, Yatzy.scoreThreeOfAKind(new Roll(THREE, THREE, FOUR, FIVE, SIX)));
    }

    @ParameterizedTest
    @MethodSource
    void three_of_a_kind_score_should_be_the_sum(Roll roll, int score) {
        assertEquals(score, Yatzy.scoreThreeOfAKind(roll));
    }

    @Test
    void three_of_a_kind_score_should_ignore_a_fourth_occurrence() {
        assertEquals(9, Yatzy.scoreThreeOfAKind(new Roll(THREE, THREE, THREE, THREE, ONE)));
    }

    @Test
    void three_of_a_kind_score_should_ignore_a_fourth_and_fifth_occurrence() {
        assertEquals(9, Yatzy.scoreThreeOfAKind(new Roll(THREE, THREE, THREE, THREE, THREE)));
    }

    @Test
    void four_of_a_kind_score_should_be_zero() {
        assertEquals(0, Yatzy.scoreFourOfAKind(new Roll(TWO, TWO, TWO, FIVE, FIVE)));
    }

    @ParameterizedTest
    @MethodSource
    void four_of_a_kind_score_should_be_the_sum(Roll roll, int score) {
        assertEquals(score, Yatzy.scoreFourOfAKind(roll));
    }

    @Test
    void four_of_a_kind_score_should_ignore_a_fifth_occurrence() {
        assertEquals(8, Yatzy.scoreFourOfAKind(new Roll(TWO, TWO, TWO, TWO, TWO)));
    }

    @Test
    void small_straight_should_score_15_in_order() {
        assertEquals(15, Yatzy.scoreSmallStraight(new Roll(ONE, TWO, THREE, FOUR, FIVE)));
    }

    @Test
    void small_straight_should_score_15_in_disorder() {
        assertEquals(15, Yatzy.scoreSmallStraight(new Roll(TWO, THREE, FOUR, FIVE, ONE)));
    }

    @Test
    void small_straight_should_score_0_when_not_a_small_straight() {
        assertEquals(0, Yatzy.scoreSmallStraight(new Roll(ONE, TWO, SIX, FOUR, FIVE)));
    }

    @Test
    void large_straight_should_score_20_in_order() {
        assertEquals(20, Yatzy.scoreLargeStraight(new Roll(TWO, THREE, FOUR, FIVE, SIX)));
    }

    @Test
    void large_straight_should_score_20_in_disorder() {
        assertEquals(20, Yatzy.scoreLargeStraight(new Roll(SIX, TWO, THREE, FOUR, FIVE)));
    }

    @Test
    void large_straight_should_score_0_when_not_a_large_straight() {
        assertEquals(0, Yatzy.scoreLargeStraight(new Roll(ONE, TWO, SIX, FOUR, FIVE)));
    }

    @ParameterizedTest
    @MethodSource
    void full_house_should_score_sum_of_two_groups(Roll roll, int score) {
        assertEquals(score, Yatzy.scoreFullHouse(roll));
    }

    @ParameterizedTest
    @MethodSource
    void full_house_should_score_0_when_not_a_full_house(Roll roll) {
        assertEquals(0, Yatzy.scoreFullHouse(roll));
    }
}