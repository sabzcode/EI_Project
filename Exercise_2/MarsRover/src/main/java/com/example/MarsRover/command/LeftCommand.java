package com.example.MarsRover.command;

import com.example.MarsRover.rover.Rover;

public class LeftCommand implements Command {
    @Override
    public void execute(Rover rover) {
        rover.turnLeft();
    }
}