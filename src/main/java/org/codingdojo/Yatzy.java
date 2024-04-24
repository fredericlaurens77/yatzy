package org.codingdojo;

import java.util.Set;

import static org.codingdojo.Face.*;
import static org.codingdojo.Scorer.*;

public class Yatzy {

    static final int PAIR_MULTIPLIER = 2;
    static final int THREE_OF_A_KIND_MULTIPLIER = 3;
    static final int FOUR_OF_A_KIND_MULTIPLIER = 4;

    public static int scoreChance(Roll roll) {
        return sumFaces(roll.fullRoll());
    }

    public static int scoreOnes(Roll roll) {
        return sumFaces(roll.filteredRollForOnly(ONE));
    }

    public static int scoreTwos(Roll roll) {
        return sumFaces(roll.filteredRollForOnly(TWO));
    }

    public static int scoreThrees(Roll roll) {
        return sumFaces(roll.filteredRollForOnly(THREE));
    }

    public static int scoreFours(Roll roll) {
        return sumFaces(roll.filteredRollForOnly(FOUR));
    }

    public static int scoreFives(Roll roll) {
        return sumFaces(roll.filteredRollForOnly(FIVE));
    }

    public static int scoreSixes(Roll roll) {
        return sumFaces(roll.filteredRollForOnly(SIX));
    }

    public static int scoreSmallStraight(Roll roll) {
        return scoreStraight(roll);
    }

    public static int scoreLargeStraight(Roll roll) {
        return scoreStraight(roll);
    }

    private static int scoreStraight(Roll roll) {
        if (roll.isStraight()) {
            return sumFaces(roll.fullRoll());
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
        if (roll.findPairs().isEmpty()) {
            return NULL_SCORE;
        }
        return sumFacesWithMultiplier(roll.findHighestPair().stream(), PAIR_MULTIPLIER);
    }

    public static int scoreTwoPairs(Roll roll) {
        Set<Face> allPairs = roll.findPairs();
        if (allPairs.size() != 2) {
            return NULL_SCORE;
        }
        return sumFacesWithMultiplier(allPairs.stream(), PAIR_MULTIPLIER);
    }

    public static int scoreFourOfAKind(Roll roll) {
        Set<Face> facesFound = roll.findFourOfAKind();
        return sumFacesWithMultiplier(facesFound.stream(), FOUR_OF_A_KIND_MULTIPLIER);
    }

    public static int scoreThreeOfAKind(Roll roll) {
        Set<Face> facesFound = roll.findThreeOfAKind();
        return sumFacesWithMultiplier(facesFound.stream(), THREE_OF_A_KIND_MULTIPLIER);
    }


    public static int scoreFullHouse(Roll roll) {
        if (roll.doesNotHaveThreeOfAKind()) {
            return NULL_SCORE;
        }
        int twoPairScore = scoreTwoPairs(roll);
        if (twoPairScore == NULL_SCORE) {
            return NULL_SCORE;
        }
        return twoPairScore +
            sumFacesWithMultiplier(roll.findThreeOfAKind().stream(), 1);
    }
}
