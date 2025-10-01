package com.example.MarsRover.model;



import java.util.Map;
import java.util.function.BiFunction;


public enum Direction {
    N((dx, dy) -> new int[]{0, 1}),
    E((dx, dy) -> new int[]{1, 0}),
    S((dx, dy) -> new int[]{0, -1}),
    W((dx, dy) -> new int[]{-1, 0});


    private final BiFunction<Integer,Integer,int[]> mover;


    Direction(BiFunction<Integer,Integer,int[]> mover) {
        this.mover = mover;
    }


    public int[] moveDelta() { return mover.apply(0, 0); }


    // Left / Right rotation maps (no if-else)
    private static final Map<Direction, Direction> LEFT = Map.of(
            N, W,
            W, S,
            S, E,
            E, N
    );


    private static final Map<Direction, Direction> RIGHT = Map.of(
            N, E,
            E, S,
            S, W,
            W, N
    );


    public Direction left() { return LEFT.get(this); }
    public Direction right() { return RIGHT.get(this); }


    @Override
    public String toString() {
        return name();
    }
}