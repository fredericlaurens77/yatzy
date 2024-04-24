package org.codingdojo.scorer;

import org.codingdojo.Face;

import java.util.stream.Stream;

public interface Scorer {
    int NULL_SCORE = 0;

    int score();

    Stream<Face> combination();
}
