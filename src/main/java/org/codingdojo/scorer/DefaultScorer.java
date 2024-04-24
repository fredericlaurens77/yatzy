package org.codingdojo.scorer;

import org.codingdojo.Face;

import java.util.stream.Stream;

public record DefaultScorer(Stream<Face> combination, int multiplier) implements Scorer {

    private final static int NEUTRAL_MULTIPLIER = 1;

    public DefaultScorer(Stream<Face> combination) {
        this(combination, NEUTRAL_MULTIPLIER);
    }

    public int score() {
        return combination
            .map(face -> face.intValue() * multiplier)
            .reduce(NULL_SCORE, Integer::sum);
    }
}
