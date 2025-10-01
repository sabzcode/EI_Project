package com.example.MarsRover.grid;

import com.example.MarsRover.model.Position;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GridComposite implements GridComponent {
    private final int width;
    private final int height;
    private final Set<Position> obstacles = new HashSet<>();

    public GridComposite(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void add(GridComponent c) {
        // Only supports obstacle leaves for now
        if (c instanceof Obstacle o) {
            obstacles.add(o.getPosition());
        }
    }

    @Override
    public void remove(GridComponent c) {
        if (c instanceof Obstacle o) {
            obstacles.remove(o.getPosition());
        }
    }

    @Override
    public boolean contains(Position p) {
        return obstacles.contains(p) ;
    }

    public boolean hasObstacleAt(Position p) {
        return obstacles.contains(p);
    }

    public boolean withinBounds(Position p) {
        return p.getX() >= 0 && p.getX() < width
                && p.getY() >= 0 && p.getY() < height;
    }

    public Set<Position> getObstacles() {
        return Collections.unmodifiableSet(obstacles);
    }
}
