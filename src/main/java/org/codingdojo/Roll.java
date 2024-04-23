package org.codingdojo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Roll(Face dice1, Face dice2, Face dice3, Face dice4, Face dice5) {

    public Stream<Face> fullRoll() {
        return Stream.of(dice1, dice2, dice3, dice4, dice5);
    }
    public Stream<Face> rollOf(Face face){ return fullRoll().filter(it -> it == face); }

    public boolean isStraight(){
        return facesOccurringAtLeast(1).size() == 5;
    }

    public boolean isYatzy(){
        return facesOccurringAtLeast(5).size() == 1;
    }

    public Set<Face> pairs(){
        return facesOccurringAtLeast(2);
    }

    public Optional<Face> highestPair(){
        return pairs()
            .stream()
            .max(Comparator.comparing(Face::intValue));
    }

    public Set<Face> facesOccurringAtLeast(int times) {
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