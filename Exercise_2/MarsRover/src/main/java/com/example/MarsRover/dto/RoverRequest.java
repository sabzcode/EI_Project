package com.example.MarsRover.dto;

import java.util.List;

public class RoverRequest {
    private int gridWidth;
    private int gridHeight;
    private int startX;
    private int startY;
    private String startDirection;  // N, S, E, W
    private List<List<Integer>> obstacles;
    private List<String> commands;

    // Getters and Setters
    public int getGridWidth() { return gridWidth; }
    public void setGridWidth(int gridWidth) { this.gridWidth = gridWidth; }

    public int getGridHeight() { return gridHeight; }
    public void setGridHeight(int gridHeight) { this.gridHeight = gridHeight; }

    public int getStartX() { return startX; }
    public void setStartX(int startX) { this.startX = startX; }

    public int getStartY() { return startY; }
    public void setStartY(int startY) { this.startY = startY; }

    public String getStartDirection() { return startDirection; }
    public void setStartDirection(String startDirection) { this.startDirection = startDirection; }

    public List<List<Integer>> getObstacles() { return obstacles; }
    public void setObstacles(List<List<Integer>> obstacles) { this.obstacles = obstacles; }

    public List<String> getCommands() { return commands; }
    public void setCommands(List<String> commands) { this.commands = commands; }
}
