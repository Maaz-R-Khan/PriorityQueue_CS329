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

            while (infile.hasNextLine()) { // Corrected condition
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

        while (!queue.isEmpty()) {
            Player highest = queue.getHighestScorePlayer();
            System.out.println(highest.getName() + " " + highest.getScore());
        }
    }



        }


