package org.codingdojo;

import org.junit.jupiter.api.Test;

import static org.codingdojo.Face.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Test
    public void chance_score_should_be_the_sum_of_all_dice() {
        assertEquals(15, Yatzy.scoreChance(new Roll(TWO, THREE, FOUR, FIVE, ONE)));
        assertEquals(16, Yatzy.scoreChance(new Roll(THREE, THREE, FOUR, FIVE, ONE)));
        assertEquals(14, Yatzy.scoreChance(new Roll(ONE, ONE, THREE, THREE, SIX)));
        assertEquals(21, Yatzy.scoreChance(new Roll(FOUR, FIVE, FIVE, SIX, ONE)));
    }

    @Test
    public void yatzy_score_should_be_50() {
        assertEquals(50, Yatzy.scoreYatzy(new Roll(FOUR, FOUR, FOUR, FOUR, FOUR)));
        assertEquals(50, Yatzy.scoreYatzy(new Roll(SIX, SIX, SIX, SIX, SIX)));
        assertEquals(50, Yatzy.scoreYatzy(new Roll(ONE, ONE, ONE, ONE, ONE)));
    }

    @Test
    public void yatzy_score_should_be_0_when_not_a_yatzy() {
        assertEquals(0, Yatzy.scoreYatzy(new Roll(SIX, SIX, SIX, SIX, THREE)));
        assertEquals(0, Yatzy.scoreYatzy(new Roll(ONE, ONE, ONE, TWO, ONE)));
    }


    @Test
    public void ones_score_should_be_the_sum_of_ones() {
        assertEquals(1, Yatzy.scoreOnes(new Roll(ONE, TWO, THREE, FOUR, FIVE)));
        assertEquals(2, Yatzy.scoreOnes(new Roll(ONE, TWO, ONE, FOUR, FIVE)));
        assertEquals(0, Yatzy.scoreOnes(new Roll(SIX, TWO, TWO, FOUR, FIVE)));
        assertEquals(4, Yatzy.scoreOnes(new Roll(ONE, TWO, ONE, ONE, ONE)));
        assertEquals(0, Yatzy.scoreOnes(new Roll(THREE, THREE, THREE, FOUR, FIVE)));
    }

    @Test
    public void twos_score_should_be_the_sum_of_twos() {
        assertEquals(4, Yatzy.scoreTwos(new Roll(ONE, TWO, THREE, TWO, SIX)));
        assertEquals(10, Yatzy.scoreTwos(new Roll(TWO, TWO, TWO, TWO, TWO)));
        assertEquals(4, Yatzy.scoreTwos(new Roll(TWO, THREE, TWO, FIVE, ONE)));
    }

    @Test
    public void threes_score_should_be_the_sum_of_threes() {
        assertEquals(6, Yatzy.scoreThrees(new Roll(ONE, TWO, THREE, TWO, THREE)));
        assertEquals(12, Yatzy.scoreThrees(new Roll(TWO, THREE, THREE, THREE, THREE)));
    }

    @Test
    public void fours_score_should_be_the_sum_of_fours() {
        assertEquals(12, Yatzy.scoreFours(new Roll(FOUR, FOUR, FOUR, FIVE, FIVE)));
        assertEquals(8, Yatzy.scoreFours(new Roll(FOUR, FOUR, FIVE, FIVE, FIVE)));
        assertEquals(4, Yatzy.scoreFours(new Roll(FOUR, FIVE, FIVE, FIVE, FIVE)));
        assertEquals(8, Yatzy.scoreFours(new Roll(ONE, ONE, TWO, FOUR, FOUR)));
    }

    @Test
    public void fives_score_should_be_the_sum_of_fives() {
        assertEquals(10, Yatzy.scoreFives(new Roll(FOUR, FOUR, FOUR, FIVE, FIVE)));
        assertEquals(15, Yatzy.scoreFives(new Roll(FOUR, FOUR, FIVE, FIVE, FIVE)));
        assertEquals(20, Yatzy.scoreFives(new Roll(FOUR, FIVE, FIVE, FIVE, FIVE)));
    }

    @Test
    public void sixes_score_should_be_the_sum_of_sixes() {
        assertEquals(0, Yatzy.scoreSixes(new Roll(FOUR, FOUR, FOUR, FIVE, FIVE)));
        assertEquals(6, Yatzy.scoreSixes(new Roll(FOUR, FOUR, SIX, FIVE, FIVE)));
        assertEquals(18, Yatzy.scoreSixes(new Roll(SIX, FIVE, SIX, SIX, FIVE)));
    }

    @Test
    public void one_pair_score_should_be_zero_when_there_is_no_pair() {
        assertEquals(0, Yatzy.scorePair(new Roll(ONE, TWO, THREE, FOUR, FIVE)));
    }

    @Test
    public void one_pair_score_should_be_the_sum_of_highest_pair() {
        assertEquals(6, Yatzy.scorePair(new Roll(THREE, FOUR, THREE, FIVE, SIX)));
        assertEquals(10, Yatzy.scorePair(new Roll(FIVE, THREE, THREE, THREE, FIVE)));
        assertEquals(12, Yatzy.scorePair(new Roll(FIVE, THREE, SIX, SIX, FIVE)));
        assertEquals(8, Yatzy.scorePair(new Roll(THREE, THREE, THREE, FOUR, FOUR)));
        assertEquals(12, Yatzy.scorePair(new Roll(ONE, ONE, SIX, TWO, SIX)));
        assertEquals(6, Yatzy.scorePair(new Roll(THREE, THREE, THREE, FOUR, ONE)));
        assertEquals(6, Yatzy.scorePair(new Roll(THREE, THREE, THREE, THREE, ONE)));
    }

    @Test
    public void two_pair_score_should_be_zero_when_there_is_only_one_pair() {
        assertEquals(0, Yatzy.scoreTwoPairs(new Roll(ONE, ONE, TWO, THREE, FOUR)));
    }

    @Test
    public void two_pair_score_should_be_zero_when_it_is_a_four_of_a_kind() {
        assertEquals(0, Yatzy.scoreTwoPairs(new Roll(THREE, THREE, THREE, THREE, ONE)));
    }

    @Test
    public void two_pair_score_should_be_the_sum_of_the_two_pairs() {
        assertEquals(16, Yatzy.scoreTwoPairs(new Roll(THREE, THREE, FIVE, FOUR, FIVE)));
        assertEquals(8, Yatzy.scoreTwoPairs(new Roll(ONE, ONE, TWO, THREE, THREE)));
    }

    @Test
    public void two_pair_score_should_be_ignore_a_third_occurrence() {
        assertEquals(16, Yatzy.scoreTwoPairs(new Roll(THREE, THREE, FIVE, FIVE, FIVE)));
        assertEquals(6, Yatzy.scoreTwoPairs(new Roll(ONE, ONE, TWO, TWO, TWO)));
    }

    @Test
    public void three_of_a_kind_score_should_be_zero() {
        assertEquals(0, Yatzy.scoreThreeOfAKind(new Roll(THREE, THREE, FOUR, FIVE, SIX)));
    }

    @Test
    public void three_of_a_kind_score_should_be_the_sum() {
        assertEquals(9, Yatzy.scoreThreeOfAKind(new Roll(THREE, THREE, THREE, FOUR, FIVE)));
        assertEquals(15, Yatzy.scoreThreeOfAKind(new Roll(FIVE, THREE, FIVE, FOUR, FIVE)));
    }

    @Test
    public void three_of_a_kind_score_should_ignore_a_fourth_occurrence() {
        assertEquals(9, Yatzy.scoreThreeOfAKind(new Roll(THREE, THREE, THREE, THREE, ONE)));
    }

    @Test
    public void three_of_a_kind_score_should_ignore_a_fourth_and_fifth_occurrence() {
        assertEquals(9, Yatzy.scoreThreeOfAKind(new Roll(THREE, THREE, THREE, THREE, THREE)));
    }

    @Test
    public void four_of_a_kind_score_should_be_zero() {
        assertEquals(0, Yatzy.scoreFourOfAKind(new Roll(TWO, TWO, TWO, FIVE, FIVE)));
    }

    @Test
    public void four_of_a_kind_score_should_be_the_sum() {
        assertEquals(12, Yatzy.scoreFourOfAKind(new Roll(THREE, THREE, THREE, THREE, FIVE)));
        assertEquals(20, Yatzy.scoreFourOfAKind(new Roll(FIVE, FIVE, FIVE, FOUR, FIVE)));
    }

    @Test
    public void four_of_a_kind_score_should_ignore_a_fifth_occurrence() {
        assertEquals(8, Yatzy.scoreFourOfAKind(new Roll(TWO, TWO, TWO, TWO, TWO)));
    }

    @Test
    public void small_straight_should_score_15_in_order() {
        assertEquals(15, Yatzy.scoreSmallStraight(new Roll(ONE, TWO, THREE, FOUR, FIVE)));
    }

    @Test
    public void small_straight_should_score_15_in_disorder() {
        assertEquals(15, Yatzy.scoreSmallStraight(new Roll(TWO, THREE, FOUR, FIVE, ONE)));
    }

    @Test
    public void small_straight_should_score_0_when_not_a_small_straight() {
        assertEquals(0, Yatzy.scoreSmallStraight(new Roll(ONE, TWO, TWO, FOUR, FIVE)));
    }

    @Test
    public void large_straight_should_score_20_in_order() {
        assertEquals(20, Yatzy.scoreLargeStraight(new Roll(TWO, THREE, FOUR, FIVE, SIX)));
    }

    @Test
    public void large_straight_should_score_20_in_disorder() {
        assertEquals(20, Yatzy.scoreLargeStraight(new Roll(SIX, TWO, THREE, FOUR, FIVE)));
    }

    @Test
    public void large_straight_should_score_0_when_not_a_large_straight() {
        assertEquals(0, Yatzy.scoreLargeStraight(new Roll(ONE, TWO, TWO, FOUR, FIVE)));
    }

    @Test
    public void full_house_should_score_sum_of_two_groups() {
        assertEquals(18, Yatzy.scoreFullHouse(new Roll(SIX, TWO, TWO, TWO, SIX)));
        assertEquals(8, Yatzy.scoreFullHouse(new Roll(ONE, ONE, TWO, TWO, TWO)));
    }

    @Test
    public void full_house_should_score_0_when_not_a_full_house() {
        assertEquals(0, Yatzy.scoreFullHouse(new Roll(TWO, THREE, FOUR, FIVE, SIX)));
        assertEquals(0, Yatzy.scoreFullHouse(new Roll(TWO, TWO, THREE, THREE, FOUR)));
        assertEquals(0, Yatzy.scoreFullHouse(new Roll(FOUR, FOUR, FOUR, FOUR, FOUR)));
    }
}