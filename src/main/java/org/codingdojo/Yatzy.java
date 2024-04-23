package org.codingdojo;

import java.util.Set;

import static org.codingdojo.Face.*;

public class Yatzy {

    public static int scoreChance(Roll roll) {
        return roll.sum();
    }

    public static int scoreYatzy(Roll roll) {
        if (roll.facesOccurringAtLeast(5).isEmpty()) {
            return 0;
        }
        return 50;
    }

    public static int ScoreOnes(Roll roll) {
        return roll.sumOfAll(ONE);
    }

    public static int ScoreTwos(Roll roll) {
        return roll.sumOfAll(TWO);
    }

    public static int ScoreThrees(Roll roll) {
        return roll.sumOfAll(THREE);
    }

    public static int ScoreFours(Roll roll) {
        return roll.sumOfAll(FOUR);
    }

    public static int ScoreFives(Roll roll) {
        return roll.sumOfAll(FIVE);
    }

    public static int ScoreSixes(Roll roll) {
        return roll.sumOfAll(SIX);
    }

    public static int ScorePair(Roll roll) {
        Set<Face> facesFound = roll.facesOccurringAtLeast(2);
        if (facesFound.isEmpty()) {
            return 0;
        }

        int highestPair = facesFound.stream().mapToInt(Face::intValue).max().getAsInt();
        return highestPair * 2;
    }

    public static int ScoreTwoPairs(Roll roll) {
        Set<Face> facesFound = roll.facesOccurringAtLeast(2);
        if (facesFound.size() != 2) {
            return 0;
        }
        return facesFound.stream().map(Face::intValue).reduce(0, Integer::sum) * 2;
    }

    public static int ScoreFourOfAKind(Roll roll) {
        return findGroupOfAGivenNumberOfOccurrencesAndSum(roll, 4);
    }

    public static int ScoreThreeOfAKind(Roll roll) {
        return findGroupOfAGivenNumberOfOccurrencesAndSum(roll, 3);
    }

    private static int findGroupOfAGivenNumberOfOccurrencesAndSum(Roll roll, int times) {
        Set<Face> facesFound = roll.facesOccurringAtLeast(times);
        if (facesFound.stream().findFirst().isPresent()) {
            return facesFound.stream().findFirst().get().intValue() * times;
        }
        return 0;
    }

    public static int scoreSmallStraight(Roll roll) {
        return scoreStraight(roll);
    }

    public static int scoreLargeStraight(Roll roll) {
        return scoreStraight(roll);
    }

    private static int scoreStraight(Roll roll) {
        if (roll.facesOccurringAtLeast(1).size() != 5) {
            return 0;
        }

        return roll.sum();
    }

    public static int scoreFullHouse(Roll roll) {
        if(!roll.facesOccurringAtLeast(3).stream().findFirst().isPresent()){
            return 0;
        }
        if(roll.facesOccurringAtLeast(2).size() != 2){
            return 0;
        }

        return roll.facesOccurringAtLeast(3).stream().findFirst().get().intValue()
            + roll.facesOccurringAtLeast(2).stream().map(Face::intValue).reduce(0, Integer::sum) * 2;
    }
}
