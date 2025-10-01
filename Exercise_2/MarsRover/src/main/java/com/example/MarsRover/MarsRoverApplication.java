package com.example.MarsRover;

import com.example.MarsRover.grid.GridComposite;
import com.example.MarsRover.model.Direction;
import com.example.MarsRover.model.Position;
import com.example.MarsRover.rover.Rover;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.MarsRover.grid.*;
import com.example.MarsRover.command.*;

@SpringBootApplication
public class MarsRoverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarsRoverApplication.class, args);
	}

	@Bean
	CommandLineRunner runRover() {
		return args -> {
			System.out.println("🚀 Running Mars Rover simulation...");

					// 1. Grid size
					int width = 5;
					int height = 5;
					GridComposite grid = new GridComposite(width, height);
					// 2. Obstacles
					grid.add(new Obstacle(new Position(1, 2)));
					grid.add(new Obstacle(new Position(3, 3)));
					grid.add(new Obstacle(new Position(0, 4)));

					// 3. Starting position
					int startX = 0;
					int startY = 0;
					Direction dir = Direction.N;
					Rover rover = new Rover(new Position(startX, startY), dir, grid);

					// 4. Commands
					String[] commands = {"M", "M", "R", "M", "M", "L", "M", "M"};

					StringBuilder statusBuilder = new StringBuilder();

					// 5️. Execute commands
					for (String c : commands) {
						try {
							Command cmd = CommandFactory.getCommand(c);
							cmd.execute(rover);
						} catch (Exception ex) {
							System.out.println("⚠ " + ex.getMessage());
							statusBuilder.append(ex.getMessage()).append("; ");
						}
					}

					// 6. Show final result
					System.out.println("\n✅ Final Rover Position: (" + rover.getPosition().getX() + ", " +
							rover.getPosition().getY() + ", " + rover.getDirection() + ")");
					String status = statusBuilder.length() == 0 ? "Rover finished successfully." : statusBuilder.toString();
					System.out.println("Status: " + status);

			System.out.println("✅ Rover finished simulation");
		};
	}
}
