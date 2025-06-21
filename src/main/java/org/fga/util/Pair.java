package org.fga.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pair<T, R> {
    private T first;
    private R second;

    public Pair(T first, R second) {
        this.first = first;
        this.second = second;
    }
}

