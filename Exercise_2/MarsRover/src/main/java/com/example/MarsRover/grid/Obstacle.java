package com.example.MarsRover.grid;

import com.example.MarsRover.model.Position;

public class Obstacle implements GridComponent {
    private final Position position;

    public Obstacle(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public void add(GridComponent c) {
        throw new UnsupportedOperationException("Obstacle is a leaf, cannot add children");
    }

    @Override
    public void remove(GridComponent c) {
        throw new UnsupportedOperationException("Obstacle is a leaf, cannot remove children");
    }

    @Override
    public boolean contains(Position p) {
        // ✅ true if this obstacle occupies the same position
        return position.equals(p);
    }
}
