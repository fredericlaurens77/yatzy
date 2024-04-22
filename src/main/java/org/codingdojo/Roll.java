package org.codingdojo;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Roll(Face dice1, Face dice2, Face dice3, Face dice4, Face dice5){

    private Stream<Face> toStream(){
        return Stream.of(dice1, dice2, dice3, dice4, dice5);
    }

    public int sum(){
        return toStream().map(Face::intValue).reduce(0, Integer::sum);
    }

    public int sumOfAll(Face face){
        return toStream().map(Face::intValue).filter(it -> it == face.intValue()).reduce(0, Integer::sum);
    }

    public Set<Face> facesOccurring(int times){
        return countFaceOccurrences()
            .entrySet()
            .stream()
            .filter(entry -> times == entry.getValue())
            .map(Map.Entry::getKey)
            .collect(Collectors.toSet());
    }

    private Map<Face, Long> countFaceOccurrences() {
        return toStream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}