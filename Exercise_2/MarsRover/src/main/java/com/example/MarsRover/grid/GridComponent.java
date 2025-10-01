package com.example.MarsRover.grid;

import com.example.MarsRover.model.Position;

public interface GridComponent {
    void add(GridComponent c);
    void remove(GridComponent c);
    boolean contains(Position p);
}