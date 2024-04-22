package org.codingdojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Test
    public void chance_score_should_be_the_sum_of_all_dice() {
        assertEquals(15, Yatzy.scoreChance(2,3,4,5,1));
        assertEquals(16, Yatzy.scoreChance(3,3,4,5,1));
        assertEquals(14, Yatzy.scoreChance(1,1,3,3,6));
        assertEquals(21, Yatzy.scoreChance(4,5,5,6,1));
    }

    @Test
    public void yatzy_score_should_be_50() {
        assertEquals(50, Yatzy.scoreYatzy(4,4,4,4,4));
        assertEquals(50, Yatzy.scoreYatzy(6,6,6,6,6));
        assertEquals(50, Yatzy.scoreYatzy(1,1,1,1,1));

    }

    @Test
    public void yatzy_score_should_be_0_when_not_a_yatzy() {
        assertEquals(0, Yatzy.scoreYatzy(6,6,6,6,3));
        assertEquals(0, Yatzy.scoreYatzy(1,1,1,2,1));
    }



    @Test public void ones_score_should_be_the_sum_of_ones() {
        assertEquals(1, Yatzy.ScoreOnes(1,2,3,4,5));
        assertEquals(2, Yatzy.ScoreOnes(1,2,1,4,5));
        assertEquals(0, Yatzy.ScoreOnes(6,2,2,4,5));
        assertEquals(4, Yatzy.ScoreOnes(1,2,1,1,1));
        assertEquals(0, Yatzy.ScoreOnes(3,3,3,4,5));
    }

    @Test
    public void twos_score_should_be_the_sum_of_twos() {
        assertEquals(4, Yatzy.ScoreTwos(1,2,3,2,6));
        assertEquals(10, Yatzy.ScoreTwos(2,2,2,2,2));
        assertEquals(4, Yatzy.ScoreTwos(2,3,2,5,1));
    }

    @Test
    public void threes_score_should_be_the_sum_of_threes() {
        assertEquals(6, Yatzy.ScoreThrees(1,2,3,2,3));
        assertEquals(12, Yatzy.ScoreThrees(2,3,3,3,3));
    }

    @Test
    public void fours_score_should_be_the_sum_of_fours() {
        assertEquals(12, Yatzy.ScoreFours(4,4,4,5,5));
        assertEquals(8, Yatzy.ScoreFours(4,4,5,5,5));
        assertEquals(4, Yatzy.ScoreFours(4,5,5,5,5));
        assertEquals(8, Yatzy.ScoreFours(1,1,2,4,4));
    }

    @Test
    public void fives_score_should_be_the_sum_of_fives() {
        assertEquals(10, Yatzy.ScoreFives(4,4,4,5,5));
        assertEquals(15, Yatzy.ScoreFives(4,4,5,5,5));
        assertEquals(20, Yatzy.ScoreFives(4,5,5,5,5));
    }

    @Test
    public void sixes_score_should_be_the_sum_of_sixes() {
        assertEquals(0, Yatzy.ScoreSixes(4,4,4,5,5));
        assertEquals(6, Yatzy.ScoreSixes(4,4,6,5,5));
        assertEquals(18, Yatzy.ScoreSixes(6,5,6,6,5));
    }

    @Test
    public void one_pair_score_should_be_zero_when_there_is_no_pair(){
        assertEquals(0, Yatzy.ScorePair(1,2,3,4,5));
    }

    @Test
    public void one_pair_score_should_be_the_sum_of_highest_pair() {
        assertEquals(6, Yatzy.ScorePair(3,4,3,5,6));
        assertEquals(10, Yatzy.ScorePair(5,3,3,3,5));
        assertEquals(12, Yatzy.ScorePair(5,3,6,6,5));
        assertEquals(8, Yatzy.ScorePair(3,3,3,4,4));
        assertEquals(12, Yatzy.ScorePair(1,1,6,2,6));
        assertEquals(6, Yatzy.ScorePair(3,3,3,4,1));
        assertEquals(6, Yatzy.ScorePair(3,3,3,3,1));
    }

    @Test
    public void two_pair_score_should_be_zero_when_there_is_only_one_pair() {
        assertEquals(0, Yatzy.ScoreTwoPairs(1,1,2,3,4));
    }

    @Test
    public void two_pair_score_should_be_zero_when_it_is_a_four_of_a_kind() {
        assertEquals(0, Yatzy.ScoreTwoPairs(3,3,3,3,1));
    }

    @Test
    public void two_pair_score_should_be_the_sum_of_the_two_pairs() {
        assertEquals(16, Yatzy.ScoreTwoPairs(3,3,5,4,5));
        assertEquals(8, Yatzy.ScoreTwoPairs(1,1,2,3,3));
    }

    @Test
    public void two_pair_score_should_be_ignore_a_third_occurrence() {
        assertEquals(16, Yatzy.ScoreTwoPairs(3,3,5,5,5));
        assertEquals(6, Yatzy.ScoreTwoPairs(1,1,2,2,2));
    }

    @Test
    public void three_of_a_kind_score_should_be_zero() {
        assertEquals(0, Yatzy.ScoreThreeOfAKind(3,3,4,5,6));
    }

    @Test
    public void three_of_a_kind_score_should_be_the_sum() {
        assertEquals(9, Yatzy.ScoreThreeOfAKind(3,3,3,4,5));
        assertEquals(15, Yatzy.ScoreThreeOfAKind(5,3,5,4,5));
    }
    @Test
    public void three_of_a_kind_score_should_ignore_a_fourth_occurrence() {
        assertEquals(9, Yatzy.ScoreThreeOfAKind(3, 3, 3, 3, 1));
    }

    @Test
    public void three_of_a_kind_score_should_ignore_a_fourth_and_fifth_occurrence() {
        assertEquals(9, Yatzy.ScoreThreeOfAKind(3,3,3,3,3));
    }

    @Test
    public void four_of_a_kind_score_should_be_zero() {
        assertEquals(0, Yatzy.ScoreFourOfAKind(2,2,2,5,5));
    }

    @Test
    public void four_of_a_kind_score_should_be_the_sum() {
        assertEquals(12, Yatzy.ScoreFourOfAKind(3,3,3,3,5));
        assertEquals(20, Yatzy.ScoreFourOfAKind(5,5,5,4,5));
    }

    @Test
    public void four_of_a_kind_score_should_ignore_a_fifth_occurrence() {
        assertEquals(8, Yatzy.ScoreFourOfAKind(2,2,2,2,2));
    }

    @Test
    public void small_straight_should_score_15_in_order() {
        assertEquals(15, Yatzy.scoreSmallStraight(1,2,3,4,5));
    }

    @Test
    public void small_straight_should_score_15_in_disorder() {
        assertEquals(15, Yatzy.scoreSmallStraight(2,3,4,5,1));
    }

    @Test
    public void small_straight_should_score_0_when_not_a_small_straight() {
        assertEquals(0, Yatzy.scoreSmallStraight(1,2,2,4,5));
    }

    @Test
    public void large_straight_should_score_20_in_order() {
        assertEquals(20, Yatzy.scoreLargeStraight(2,3,4,5,6));
    }

    @Test
    public void large_straight_should_score_20_in_disorder() {
        assertEquals(20, Yatzy.scoreLargeStraight(6,2,3,4,5));
    }

    @Test
    public void large_straight_should_score_0_when_not_a_large_straight() {
        assertEquals(0, Yatzy.scoreLargeStraight(1,2,2,4,5));
    }

    @Test
    public void full_house_should_score_sum_of_two_groups() {
        assertEquals(18, Yatzy.scoreFullHouse(6,2,2,2,6));
        assertEquals(8, Yatzy.scoreFullHouse(1,1,2,2,2));
    }

    @Test
    public void full_house_should_score_0_when_not_a_full_house() {
        assertEquals(0, Yatzy.scoreFullHouse(2,3,4,5,6));
        assertEquals(0,Yatzy.scoreFullHouse(2,2,3,3,4));
        assertEquals(0,Yatzy.scoreFullHouse(4,4,4,4,4));
    }
}