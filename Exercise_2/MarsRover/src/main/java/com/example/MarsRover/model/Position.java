package com.example.MarsRover.model;



import java.util.Objects;


public final class Position {
    private final int x;
    private final int y;


    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() { return x; }
    public int getY() { return y; }


    public Position translate(int dx, int dy) {
        return new Position(x + dx, y + dy);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }


    @Override
    public int hashCode() { return Objects.hash(x, y); }


    @Override
    public String toString() { return "(" + x + ", " + y + ")"; }
}