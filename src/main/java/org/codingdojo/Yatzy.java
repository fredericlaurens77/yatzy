package org.codingdojo;

import java.util.Set;
import java.util.stream.Stream;

import static org.codingdojo.Face.*;

public class Yatzy {

    private static int sum(Stream<Face> roll) {
        return roll.map(Face::intValue).reduce(0, Integer::sum);
    }

    public static int scoreChance(Roll roll) {
        return sum(roll.fullRoll());
    }

    public static int ScoreOnes(Roll roll) {
        return sum(roll.rollOf(ONE));
    }

    public static int ScoreTwos(Roll roll) {
        return sum(roll.rollOf(TWO));
    }

    public static int ScoreThrees(Roll roll) {
        return sum(roll.rollOf(THREE));
    }

    public static int ScoreFours(Roll roll) {
        return sum(roll.rollOf(FOUR));
    }

    public static int ScoreFives(Roll roll) {
        return sum(roll.rollOf(FIVE));
    }

    public static int ScoreSixes(Roll roll) {
        return sum(roll.rollOf(SIX));
    }

    public static int scoreSmallStraight(Roll roll) {
        return scoreStraight(roll);
    }

    public static int scoreLargeStraight(Roll roll) {
        return scoreStraight(roll);
    }

    private static int scoreStraight(Roll roll) {
        if(roll.isStraight()){
            return sum(roll.fullRoll());
        }
        return 0;
    }

    public static int scoreYatzy(Roll roll) {
        if (roll.isYatzy()) {
            return 50;
        }
        return 0;
    }

    public static int ScorePair(Roll roll) {
        if (roll.pairs().isEmpty()) {
            return 0;
        }
        return roll.highestPair()
            .stream()
            .findFirst()
            .map(it -> it.intValue() * 2)
            .orElse(0);
    }

    public static int ScoreTwoPairs(Roll roll) {
        Set<Face> pairs = roll.pairs();
        if (pairs.size() != 2) {
            return 0;
        }
        return sum(pairs.stream()) * 2;
    }

    public static int ScoreFourOfAKind(Roll roll) {
        return findGroupOfAGivenNumberOfOccurrencesAndSum(roll, 4);
    }

    public static int ScoreThreeOfAKind(Roll roll) {
        return findGroupOfAGivenNumberOfOccurrencesAndSum(roll, 3);
    }

    private static int findGroupOfAGivenNumberOfOccurrencesAndSum(Roll roll, int times) {
        Set<Face> facesFound = roll.facesOccurringAtLeast(times);
        return facesFound.stream()
            .findFirst()
            .map(face -> face.intValue() * times)
            .orElse(0);
    }

    public static int scoreFullHouse(Roll roll) {
        if (roll.facesOccurringAtLeast(3).stream().findFirst().isEmpty()) {
            return 0;
        }
        if (roll.facesOccurringAtLeast(2).size() != 2) {
            return 0;
        }

        return roll.facesOccurringAtLeast(3).stream().findFirst().get().intValue() + roll.facesOccurringAtLeast(2).stream().map(Face::intValue).reduce(0, Integer::sum) * 2;
    }
}
