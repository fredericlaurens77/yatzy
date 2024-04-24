package org.codingdojo;

import java.util.stream.Stream;

public record Combination(Stream<Face> combination) {
    static final int NULL_SCORE = 0;
    static final int YATZY_SCORE = 50;

    int sumFaces() {
        return combination.map(Face::intValue).reduce(NULL_SCORE, Integer::sum);
    }

    int sumFacesWithMultiplier(int times) {
        return combination
            .map(face -> face.intValue() * times)
            .reduce(NULL_SCORE, Integer::sum);
    }
}
