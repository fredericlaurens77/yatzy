package org.codingdojo;

import java.util.stream.Stream;

public record Roll(int dice1, int dice2, int dice3, int dice4, int dice5){

    private Stream<Integer> toStream(){
        return Stream.of(dice1, dice2, dice3, dice4, dice5);
    }

    public int sum(){
        return toStream().reduce(0, Integer::sum);
    }
}