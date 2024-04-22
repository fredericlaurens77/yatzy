package org.codingdojo;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Roll(Face dice1, Face dice2, Face dice3, Face dice4, Face dice5) {

    public Combination fullRoll() {
        return new Combination(Stream.of(dice1, dice2, dice3, dice4, dice5));
    }

    public Combination filteredRollForOnly(Face face) {
        return new Combination(Stream.of(dice1, dice2, dice3, dice4, dice5).filter(it -> it == face));
    }

    public boolean isStraight() {
        return findFacesOccurringAtLeast(1).size() == 5
            && (fullRoll().sumFaces() == 15 || fullRoll().sumFaces() == 20);
    }

    public boolean doesNotHaveThreeOfAKind(){
        return findFacesOccurringAtLeast(3).isEmpty();
    }

    public boolean doesNotHaveAPair(){
        return findFacesOccurringAtLeast(2).isEmpty();
    }

    public boolean doesNotHaveTwoPairs(){
        return findFacesOccurringAtLeast(2).size() != 2;
    }

    public boolean isYatzy() {
        return findFacesOccurringAtLeast(5).size() == 1;
    }

    public Combination findPairs() {
        return new Combination(findFacesOccurringAtLeast(2).stream());
    }

    public Combination findThreeOfAKind(){
        return new Combination(findFacesOccurringAtLeast(3).stream());
    }

    public Combination findFourOfAKind(){
        return new Combination(findFacesOccurringAtLeast(4).stream());
    }

    public Combination findHighestPair() {
        return new Combination(findPairs()
            .combination()
            .max(Comparator.comparing(Face::intValue)).stream());
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