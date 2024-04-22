package org.codingdojo;

import org.junit.jupiter.api.Test;

import static org.codingdojo.Face.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Test
    public void chance_score_should_be_the_sum_of_all_dice() {
        assertEquals(15, Yatzy.scoreChance(new Roll(TWO,THREE,FOUR,FIVE,ONE)));
        assertEquals(16, Yatzy.scoreChance(new Roll(THREE,THREE,FOUR,FIVE,ONE)));
        assertEquals(14, Yatzy.scoreChance(new Roll(ONE,ONE,THREE,THREE,SIX)));
        assertEquals(21, Yatzy.scoreChance(new Roll(FOUR,FIVE,FIVE,SIX,ONE)));
    }

    @Test
    public void yatzy_score_should_be_50() {
        assertEquals(50, Yatzy.scoreYatzy(new Roll(FOUR,FOUR,FOUR,FOUR,FOUR)));
        assertEquals(50, Yatzy.scoreYatzy(new Roll(SIX,SIX,SIX,SIX,SIX)));
        assertEquals(50, Yatzy.scoreYatzy(new Roll(ONE,ONE,ONE,ONE,ONE)));

    }

    @Test
    public void yatzy_score_should_be_0_when_not_a_yatzy() {
        assertEquals(0, Yatzy.scoreYatzy(new Roll(SIX,SIX,SIX,SIX,THREE)));
        assertEquals(0, Yatzy.scoreYatzy(new Roll(ONE,ONE,ONE,TWO,ONE)));
    }



    @Test public void ones_score_should_be_the_sum_of_ones() {
        assertEquals(1, Yatzy.ScoreOnes(new Roll(ONE,TWO,THREE,FOUR,FIVE)));
        assertEquals(2, Yatzy.ScoreOnes(new Roll(ONE,TWO,ONE,FOUR,FIVE)));
        assertEquals(0, Yatzy.ScoreOnes(new Roll(SIX,TWO,TWO,FOUR,FIVE)));
        assertEquals(4, Yatzy.ScoreOnes(new Roll(ONE,TWO,ONE,ONE,ONE)));
        assertEquals(0, Yatzy.ScoreOnes(new Roll(THREE,THREE,THREE,FOUR,FIVE)));
    }

    @Test
    public void twos_score_should_be_the_sum_of_twos() {
        assertEquals(4, Yatzy.ScoreTwos(new Roll(ONE,TWO,THREE,TWO,SIX)));
        assertEquals(10, Yatzy.ScoreTwos(new Roll(TWO,TWO,TWO,TWO,TWO)));
        assertEquals(4, Yatzy.ScoreTwos(new Roll(TWO,THREE,TWO,FIVE,ONE)));
    }

    @Test
    public void threes_score_should_be_the_sum_of_threes() {
        assertEquals(6, Yatzy.ScoreThrees(new Roll(ONE,TWO,THREE,TWO,THREE)));
        assertEquals(12, Yatzy.ScoreThrees(new Roll(TWO,THREE,THREE,THREE,THREE)));
    }

    @Test
    public void fours_score_should_be_the_sum_of_fours() {
        assertEquals(12, Yatzy.ScoreFours(new Roll(FOUR,FOUR,FOUR,FIVE,FIVE)));
        assertEquals(8, Yatzy.ScoreFours(new Roll(FOUR,FOUR,FIVE,FIVE,FIVE)));
        assertEquals(4, Yatzy.ScoreFours(new Roll(FOUR,FIVE,FIVE,FIVE,FIVE)));
        assertEquals(8, Yatzy.ScoreFours(new Roll(ONE,ONE,TWO,FOUR,FOUR)));
    }

    @Test
    public void fives_score_should_be_the_sum_of_fives() {
        assertEquals(10, Yatzy.ScoreFives(new Roll(FOUR,FOUR,FOUR,FIVE,FIVE)));
        assertEquals(15, Yatzy.ScoreFives(new Roll(FOUR,FOUR,FIVE,FIVE,FIVE)));
        assertEquals(20, Yatzy.ScoreFives(new Roll(FOUR,FIVE,FIVE,FIVE,FIVE)));
    }

    @Test
    public void sixes_score_should_be_the_sum_of_sixes() {
        assertEquals(0, Yatzy.ScoreSixes(new Roll(FOUR,FOUR,FOUR,FIVE,FIVE)));
        assertEquals(6, Yatzy.ScoreSixes(new Roll(FOUR,FOUR,SIX,FIVE,FIVE)));
        assertEquals(18, Yatzy.ScoreSixes(new Roll(SIX,FIVE,SIX,SIX,FIVE)));
    }

    @Test
    public void one_pair_score_should_be_zero_when_there_is_no_pair(){
        assertEquals(0, Yatzy.ScorePair(new Roll(ONE,TWO,THREE,FOUR,FIVE)));
    }

    @Test
    public void one_pair_score_should_be_the_sum_of_highest_pair() {
        assertEquals(6, Yatzy.ScorePair(new Roll(THREE,FOUR,THREE,FIVE,SIX)));
        assertEquals(10, Yatzy.ScorePair(new Roll(FIVE,THREE,THREE,THREE,FIVE)));
        assertEquals(12, Yatzy.ScorePair(new Roll(FIVE,THREE,SIX,SIX,FIVE)));
        assertEquals(8, Yatzy.ScorePair(new Roll(THREE,THREE,THREE,FOUR,FOUR)));
        assertEquals(12, Yatzy.ScorePair(new Roll(ONE,ONE,SIX,TWO,SIX)));
        assertEquals(6, Yatzy.ScorePair(new Roll(THREE,THREE,THREE,FOUR,ONE)));
        assertEquals(6, Yatzy.ScorePair(new Roll(THREE,THREE,THREE,THREE,ONE)));
    }

    @Test
    public void two_pair_score_should_be_zero_when_there_is_only_one_pair() {
        assertEquals(0, Yatzy.ScoreTwoPairs(new Roll(ONE,ONE,TWO,THREE,FOUR)));
    }

    @Test
    public void two_pair_score_should_be_zero_when_it_is_a_four_of_a_kind() {
        assertEquals(0, Yatzy.ScoreTwoPairs(new Roll(THREE,THREE,THREE,THREE,ONE)));
    }

    @Test
    public void two_pair_score_should_be_the_sum_of_the_two_pairs() {
        assertEquals(16, Yatzy.ScoreTwoPairs(new Roll(THREE,THREE,FIVE,FOUR,FIVE)));
        assertEquals(8, Yatzy.ScoreTwoPairs(new Roll(ONE,ONE,TWO,THREE,THREE)));
    }

    @Test
    public void two_pair_score_should_be_ignore_a_third_occurrence() {
        assertEquals(16, Yatzy.ScoreTwoPairs(new Roll(THREE,THREE,FIVE,FIVE,FIVE)));
        assertEquals(6, Yatzy.ScoreTwoPairs(new Roll(ONE,ONE,TWO,TWO,TWO)));
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