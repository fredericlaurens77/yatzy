package org.codingdojo;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Roll(Face dice1, Face dice2, Face dice3, Face dice4, Face dice5) {

    public Stream<Face> fullRoll() {
        return Stream.of(dice1, dice2, dice3, dice4, dice5);
    }

    public Stream<Face> filteredRollForOnly(Face face) {
        return fullRoll().filter(it -> it == face);
    }

    public boolean isStraight() {
        return findFacesOccurringAtLeast(1).size() == 5;
    }

    public boolean doesNotHaveThreeOfAKind(){
        return findFacesOccurringAtLeast(3).isEmpty();
    }

    public boolean isYatzy() {
        return findFacesOccurringAtLeast(5).size() == 1;
    }

    public Set<Face> findPairs() {
        return findFacesOccurringAtLeast(2);
    }

    public Set<Face> findThreeOfAKind(){
        return findFacesOccurringAtLeast(3);
    }

    public Set<Face> findFourOfAKind(){
        return findFacesOccurringAtLeast(4);
    }

    public Optional<Face> findHighestPair() {
        return findPairs()
            .stream()
            .max(Comparator.comparing(Face::intValue));
    }

    public Set<Face> findFacesOccurringAtLeast(int times) {
        return countFaceOccurrences()
            .entrySet()
            .stream()
            .filter(entry -> times <= entry.getValue())
            .map(Map.Entry::getKey)
            .collect(Collectors.toSet());
    }

    private Map<Face, Long> countFaceOccurrences() {
        return fullRoll()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}