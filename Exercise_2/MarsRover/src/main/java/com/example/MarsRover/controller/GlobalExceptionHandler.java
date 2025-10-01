package com.example.MarsRover.controller;

import com.example.MarsRover.exception.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObstacleDetectedException.class)
    public ResponseEntity<Map<String,Object>> handleObstacle(ObstacleDetectedException ex) {
        Map<String,Object> response = new HashMap<>();
        response.put("finalX", null);
        response.put("finalY", null);
        response.put("finalDirection", null);
        response.put("status", ex.getMessage());
        return ResponseEntity.status(HttpStatus.OK).body(response); // 200 OK so UI can display message
    }

    @ExceptionHandler(OutOfBoundsException.class)
    public ResponseEntity<Map<String,Object>> handleOutOfBounds(OutOfBoundsException ex) {
        Map<String,Object> response = new HashMap<>();
        response.put("finalX", null);
        response.put("finalY", null);
        response.put("finalDirection", null);
        response.put("status", ex.getMessage());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> handleOther(Exception ex) {
        Map<String,Object> response = new HashMap<>();
        response.put("finalX", null);
        response.put("finalY", null);
        response.put("finalDirection", null);
        response.put("status", "Error: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
