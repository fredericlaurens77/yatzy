package org.codingdojo;

import org.codingdojo.scorer.DefaultScorer;
import org.codingdojo.scorer.Scorer;
import org.codingdojo.scorer.YatzyScorer;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Roll(Face dice1, Face dice2, Face dice3, Face dice4, Face dice5) {

    static final int PAIR_MULTIPLIER = 2;
    static final int THREE_OF_A_KIND_MULTIPLIER = 3;
    static final int FOUR_OF_A_KIND_MULTIPLIER = 4;

    public Scorer fullRoll() {
        return new DefaultScorer(Stream.of(dice1, dice2, dice3, dice4, dice5));
    }

    public Scorer filteredRollForOnly(Face face) {
        return new DefaultScorer(Stream.of(dice1, dice2, dice3, dice4, dice5).filter(it -> it == face));
    }

    private boolean isStraight() {
        return findFacesOccurringAtLeast(1).size() == 5
            && (fullRoll().score() == 15 || fullRoll().score() == 20);
    }

    public Scorer findStraight() {
        if (isStraight()) {
            return fullRoll();
        }
        return new DefaultScorer(Stream.empty());
    }

    private boolean doesNotHaveThreeOfAKind() {
        return findFacesOccurringAtLeast(3).isEmpty();
    }

    private boolean doesNotHaveTwoPairs() {
        return findFacesOccurringAtLeast(2).size() != 2;
    }

    public Scorer findYatzy() {
        return new YatzyScorer(findFacesOccurringAtLeast(5).stream());
    }

    public Scorer findPairs() {
        return new DefaultScorer(findFacesOccurringAtLeast(2).stream(), PAIR_MULTIPLIER);
    }

    public Scorer findTwoPairs() {
        if (doesNotHaveTwoPairs()) {
            return new DefaultScorer(Stream.empty());
        }
        return new DefaultScorer(findFacesOccurringAtLeast(2).stream(), PAIR_MULTIPLIER);
    }

    public Scorer findFullHouse() {
        if (doesNotHaveThreeOfAKind() || doesNotHaveTwoPairs()) {
            return new DefaultScorer(Stream.empty());
        }
        return fullRoll();
    }

    public Scorer findThreeOfAKind() {
        return new DefaultScorer(findFacesOccurringAtLeast(3).stream(), THREE_OF_A_KIND_MULTIPLIER);
    }

    public Scorer findFourOfAKind() {
        return new DefaultScorer(findFacesOccurringAtLeast(4).stream(), FOUR_OF_A_KIND_MULTIPLIER);
    }

    public Scorer findHighestPair() {
        return new DefaultScorer(findPairs()
            .combination()
            .max(Comparator.comparing(Face::intValue)).stream(), PAIR_MULTIPLIER);
    }

    private Set<Face> findFacesOccurringAtLeast(int times) {
        return countFaceOccurrences()
            .entrySet()
            .stream()
            .filter(entry -> times <= entry.getValue())
            .map(Map.Entry::getKey)
            .collect(Collectors.toSet());
    }

    private Map<Face, Long> countFaceOccurrences() {
        return Stream.of(dice1, dice2, dice3, dice4, dice5)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}