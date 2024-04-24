package org.codingdojo;

import java.util.stream.Stream;

public class Scorer {
    static final int NULL_SCORE = 0;
    static final int YATZY_SCORE = 50;

    static int sumFaces(Stream<Face> roll) {
        return roll.map(Face::intValue).reduce(NULL_SCORE, Integer::sum);
    }

    static Integer sumFacesWithMultiplier(Stream<Face> facesFound, int times) {
        return facesFound
            .map(face -> face.intValue() * times)
            .reduce(NULL_SCORE, Integer::sum);
    }
}
