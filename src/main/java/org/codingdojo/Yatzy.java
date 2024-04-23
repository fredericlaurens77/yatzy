package org.codingdojo;

import java.util.Set;
import java.util.stream.Stream;

import static org.codingdojo.Face.*;

public class Yatzy {

    private static final int NULL_SCORE = 0;

    private static int sum(Stream<Face> roll) {
        return roll.map(Face::intValue).reduce(0, Integer::sum);
    }

    public static int scoreChance(Roll roll) {
        return sum(roll.fullRoll());
    }

    public static int scoreOnes(Roll roll) {
        return sum(roll.rollOf(ONE));
    }

    public static int scoreTwos(Roll roll) {
        return sum(roll.rollOf(TWO));
    }

    public static int scoreThrees(Roll roll) {
        return sum(roll.rollOf(THREE));
    }

    public static int scoreFours(Roll roll) {
        return sum(roll.rollOf(FOUR));
    }

    public static int scoreFives(Roll roll) {
        return sum(roll.rollOf(FIVE));
    }

    public static int scoreSixes(Roll roll) {
        return sum(roll.rollOf(SIX));
    }

    public static int scoreSmallStraight(Roll roll) {
        return scoreStraight(roll);
    }

    public static int scoreLargeStraight(Roll roll) {
        return scoreStraight(roll);
    }

    private static int scoreStraight(Roll roll) {
        if (roll.isStraight()) {
            return sum(roll.fullRoll());
        }
        return NULL_SCORE;
    }

    public static int scoreYatzy(Roll roll) {
        if (roll.isYatzy()) {
            return 50;
        }
        return NULL_SCORE;
    }

    public static int scorePair(Roll roll) {
        if (roll.pairs().isEmpty()) {
            return NULL_SCORE;
        }
        return roll.highestPair()
            .stream()
            .findFirst()
            .map(it -> it.intValue() * 2)
            .orElse(NULL_SCORE);
    }

    public static int scoreTwoPairs(Roll roll) {
        Set<Face> pairs = roll.pairs();
        if (pairs.size() != 2) {
            return NULL_SCORE;
        }
        return sum(pairs.stream()) * 2;
    }

    public static int scoreFourOfAKind(Roll roll) {
        return findGroupOfAGivenNumberOfOccurrencesAndSum(roll, 4);
    }

    public static int scoreThreeOfAKind(Roll roll) {
        return findGroupOfAGivenNumberOfOccurrencesAndSum(roll, 3);
    }

    private static int findGroupOfAGivenNumberOfOccurrencesAndSum(Roll roll, int times) {
        Set<Face> facesFound = roll.facesOccurringAtLeast(times);
        return facesFound.stream()
            .findFirst()
            .map(face -> face.intValue() * times)
            .orElse(NULL_SCORE);
    }

    public static int scoreFullHouse(Roll roll) {
        if (roll.facesOccurringAtLeast(3).isEmpty()) {
            return NULL_SCORE;
        }
        int twoPairScore = scoreTwoPairs(roll);
        if (twoPairScore == NULL_SCORE) {
            return NULL_SCORE;
        }
        return twoPairScore +
            roll.facesOccurringAtLeast(3).stream().findFirst().map(Face::intValue).orElse(NULL_SCORE);
    }
}
