package com.example.MarsRover.controller;

import com.example.MarsRover.dto.RoverRequest;
import com.example.MarsRover.exception.ObstacleDetectedException;
import com.example.MarsRover.exception.OutOfBoundsException;
import com.example.MarsRover.grid.GridComposite;
import com.example.MarsRover.grid.Obstacle;
import com.example.MarsRover.model.Direction;
import com.example.MarsRover.model.Position;
import com.example.MarsRover.rover.Rover;
import com.example.MarsRover.command.Command;
import com.example.MarsRover.command.CommandFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class RoverController {
    @RequestMapping("/welcome")
    public String hello(){
        return "Mars Rover roaming....";
    }

    @PostMapping("/commands")
    public ResponseEntity<Map<String,Object>> runCommands(@RequestBody RoverRequest request) {

        // Initialize grid
        GridComposite grid = new GridComposite(request.getGridWidth(), request.getGridHeight());
        for (var obs : request.getObstacles()) {
            grid.add(new Obstacle(new Position(obs.get(0), obs.get(1))));
        }

        // Initialize Rover
        Position start = new Position(request.getStartX(), request.getStartY());
        Direction dir = Direction.valueOf(request.getStartDirection().toUpperCase());
        Rover rover = new Rover(start, dir, grid);

        StringBuilder statusBuilder = new StringBuilder();

        // Execute commands
        for (String c : request.getCommands()) {
            try {
                Command cmd = CommandFactory.getCommand(c);
                cmd.execute(rover);
            } catch (ObstacleDetectedException | OutOfBoundsException ex) {
                // Log and continue with next command
                statusBuilder.append(ex.getMessage()).append("; ");
                System.out.println(ex.getMessage());
            }
        }

        // Prepare response
        Map<String,Object> result = new HashMap<>();
        result.put("finalX", rover.getPosition().getX());
        result.put("finalY", rover.getPosition().getY());
        result.put("finalDirection", rover.getDirection().name());

        String status = statusBuilder.length() == 0
                ? "Rover finished successfully."
                : statusBuilder.toString();
        result.put("status", status);

        return ResponseEntity.ok(result);
    }

}
