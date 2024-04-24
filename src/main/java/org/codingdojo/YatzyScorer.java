package org.codingdojo;

import java.util.stream.Stream;

public record YatzyScorer(Stream<Face> combination) implements Scorer {

    static final int YATZY_SCORE = 50;

    public int score() {
        if (combination.findAny().isPresent()) {
            return YATZY_SCORE;
        }
        return NULL_SCORE;
    }
}
