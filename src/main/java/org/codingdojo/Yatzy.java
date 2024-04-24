package org.codingdojo;

import static org.codingdojo.Face.*;

public class Yatzy {

    public static int scoreChance(Roll roll) {
        return roll.fullRoll().score();
    }

    public static int scoreOnes(Roll roll) {
        return roll.filteredRollForOnly(ONE).score();
    }

    public static int scoreTwos(Roll roll) {
        return roll.filteredRollForOnly(TWO).score();
    }

    public static int scoreThrees(Roll roll) {
        return roll.filteredRollForOnly(THREE).score();
    }

    public static int scoreFours(Roll roll) {
        return roll.filteredRollForOnly(FOUR).score();
    }

    public static int scoreFives(Roll roll) {
        return roll.filteredRollForOnly(FIVE).score();
    }

    public static int scoreSixes(Roll roll) {
        return roll.filteredRollForOnly(SIX).score();
    }

    public static int scoreSmallStraight(Roll roll) {
        return scoreStraight(roll);
    }

    public static int scoreLargeStraight(Roll roll) {
        return scoreStraight(roll);
    }

    private static int scoreStraight(Roll roll) {
        return roll.findStraight().score();
    }

    public static int scoreYatzy(Roll roll) {
        return roll.findYatzy().score();
    }

    public static int scorePair(Roll roll) {
        return roll.findHighestPair().score();
    }

    public static int scoreTwoPairs(Roll roll) {
        return roll.findTwoPairs().score();
    }

    public static int scoreFourOfAKind(Roll roll) {
        return roll.findFourOfAKind().score();
    }

    public static int scoreThreeOfAKind(Roll roll) {
        return roll.findThreeOfAKind().score();
    }


    public static int scoreFullHouse(Roll roll) {
        return roll.findFullHouse().score();
    }
}
