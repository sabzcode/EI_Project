package com.example.MarsRover.command;



import com.example.MarsRover.rover.Rover;

public interface Command {
    void execute(Rover rover);
}


