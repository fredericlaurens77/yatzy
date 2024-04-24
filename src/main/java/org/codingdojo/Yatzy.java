package org.codingdojo;

import static org.codingdojo.Face.*;
import static org.codingdojo.Combination.*;

public class Yatzy {

    static final int PAIR_MULTIPLIER = 2;
    static final int THREE_OF_A_KIND_MULTIPLIER = 3;
    static final int FOUR_OF_A_KIND_MULTIPLIER = 4;

    public static int scoreChance(Roll roll) {
        return roll.fullRoll().sumFaces();
    }

    public static int scoreOnes(Roll roll) {
        return roll.filteredRollForOnly(ONE).sumFaces();
    }

    public static int scoreTwos(Roll roll) {
        return roll.filteredRollForOnly(TWO).sumFaces();
    }

    public static int scoreThrees(Roll roll) {
        return roll.filteredRollForOnly(THREE).sumFaces();
    }

    public static int scoreFours(Roll roll) {
        return roll.filteredRollForOnly(FOUR).sumFaces();
    }

    public static int scoreFives(Roll roll) {
        return roll.filteredRollForOnly(FIVE).sumFaces();
    }

    public static int scoreSixes(Roll roll) {
        return roll.filteredRollForOnly(SIX).sumFaces();
    }

    public static int scoreSmallStraight(Roll roll) {
        return scoreStraight(roll);
    }

    public static int scoreLargeStraight(Roll roll) {
        return scoreStraight(roll);
    }

    private static int scoreStraight(Roll roll) {
        if (roll.isStraight()) {
            return roll.fullRoll().sumFaces();
        }
        return NULL_SCORE;
    }

    public static int scoreYatzy(Roll roll) {
        if (roll.isYatzy()) {
            return YATZY_SCORE;
        }
        return NULL_SCORE;
    }

    public static int scorePair(Roll roll) {
        if (roll.doesNotHaveAPair()) {
            return NULL_SCORE;
        }
        return roll.findHighestPair().sumFacesWithMultiplier(PAIR_MULTIPLIER);
    }

    public static int scoreTwoPairs(Roll roll) {
        if (roll.doesNotHaveTwoPairs()) {
            return NULL_SCORE;
        }
        return roll.findPairs().sumFacesWithMultiplier(PAIR_MULTIPLIER);
    }

    public static int scoreFourOfAKind(Roll roll) {
        return roll.findFourOfAKind().sumFacesWithMultiplier(FOUR_OF_A_KIND_MULTIPLIER);
    }

    public static int scoreThreeOfAKind(Roll roll) {
        return roll.findThreeOfAKind().sumFacesWithMultiplier(THREE_OF_A_KIND_MULTIPLIER);
    }


    public static int scoreFullHouse(Roll roll) {
        if (roll.doesNotHaveThreeOfAKind()) {
            return NULL_SCORE;
        }
        int twoPairScore = scoreTwoPairs(roll);
        if (twoPairScore == NULL_SCORE) {
            return NULL_SCORE;
        }
        return twoPairScore + roll.findThreeOfAKind().sumFacesWithMultiplier(1);
    }
}
