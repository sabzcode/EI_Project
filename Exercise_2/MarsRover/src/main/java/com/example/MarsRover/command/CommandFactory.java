package com.example.MarsRover.command;

import com.example.MarsRover.rover.Rover;

public class CommandFactory {
    public static Command getCommand(String cmd) {
        return switch(cmd.toUpperCase()) {
            case "M" -> Rover::move;
            case "L" -> Rover::turnLeft;
            case "R" -> Rover::turnRight;
            default -> throw new IllegalArgumentException("Invalid command: " + cmd);
        };
    }

}
