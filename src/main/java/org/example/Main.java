package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PQList queue = new PQList();

        try {
            // Create File Reader
            FileReader fr = new FileReader("players.txt");
            Scanner infile = new Scanner(fr);
            String line;

            while (infile.hasNextLine()) {
                String name = infile.nextLine(); // Read the name
                if (!infile.hasNextLine()) break; // If no more lines, stop

                int score = Integer.parseInt(infile.nextLine()); // Read the score

                Player p = new Player(name, score);
                queue.add(p); // Add player to PQList
            }

            infile.close(); // Close the scanner
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e); // Exception handling
        }


        // **Testing All Required Methods**
        System.out.println("\nTotal Players Loaded: " + queue.getSize());

        // **Testing Copy Constructor**
        PQList copiedQueue = new PQList(queue);
        System.out.println("Copy Constructor Test - Size of copied queue: " + copiedQueue.getSize());

        // **Testing createClone()**
        PQList clonedQueue = queue.createClone();
        System.out.println("Create Clone Test - Size of cloned queue: " + clonedQueue.getSize());

        // **Displaying Players from Priority Queue (Highest to Lowest)**
        System.out.println("\nRemoving players in highest-score order:");
        while (!queue.isEmpty()) {
            Player highest = queue.getHighestScorePlayer();
            System.out.println(highest.getName() + " " + highest.getScore());
        }

        // **Checking if the queue is empty after removal**
        System.out.println("\nIs the queue empty? " + queue.isEmpty());

        // **Clearing copiedQueue and checking if it is empty**
        copiedQueue.clear();
        System.out.println("After clearing copied queue, is it empty? " + copiedQueue.isEmpty());


        while (!queue.isEmpty()) {
            Player highest = queue.getHighestScorePlayer();
            System.out.println(highest.getName() + " " + highest.getScore());
        }


    }


        }


