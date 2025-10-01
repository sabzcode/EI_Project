package com.example.MarsRover.rover;

import com.example.MarsRover.model.Direction;
import com.example.MarsRover.model.Position;
import com.example.MarsRover.exception.ObstacleDetectedException;
import com.example.MarsRover.exception.OutOfBoundsException;
import com.example.MarsRover.grid.GridComposite;

import java.util.Objects;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Rover {
    private static final Logger logger = LoggerFactory.getLogger(Rover.class);


    private Position position;
    private Direction direction;
    private final GridComposite grid;


    public Rover(Position start, Direction dir, GridComposite grid) {
        this.position = Objects.requireNonNull(start);
        this.direction = Objects.requireNonNull(dir);
        this.grid = Objects.requireNonNull(grid);
    }


    public Position getPosition() { return position; }
    public Direction getDirection() { return direction; }


    public void turnLeft() { direction = direction.left(); logger.info("Turned left -> {}", direction); }
    public void turnRight() { direction = direction.right(); logger.info("Turned right -> {}", direction); }


    public void move()throws ObstacleDetectedException, OutOfBoundsException {
        int[] delta = direction.moveDelta();
        Position next = position.translate(delta[0], delta[1]);

        if (!grid.withinBounds(next)) {
            throw new OutOfBoundsException("Out of bounds: " + next);
        }

        if (grid.hasObstacleAt(next)) {
            throw new ObstacleDetectedException("Obstacle at " + next);
        }

        position = next;
        logger.info("Moved to {}", position);


// Validate bounds and obstacles using Optional pipeline (no if/else)
        Optional.of(next)
                .filter(grid::withinBounds)
                .filter(p -> !grid.hasObstacleAt(p))
                .map(p -> {
                    position = p;
                    logger.info("Moved to {}", position);
                    return p;
                })
                .orElseThrow(() -> grid.withinBounds(next)
                        ? new ObstacleDetectedException("Obstacle at " + next)
                        : new OutOfBoundsException("Out of bounds: " + next));
    }
}