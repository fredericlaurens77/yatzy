package org.codingdojo;

import java.util.stream.Stream;

public record Roll(Face dice1, Face dice2, Face dice3, Face dice4, Face dice5){

    private Stream<Integer> toStream(){
        return Stream.of(dice1, dice2, dice3, dice4, dice5).map(Face::intValue);
    }

    public int sum(){
        return toStream().reduce(0, Integer::sum);
    }
}