package Part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("ressource/input");
        int currentPosition = 50;
        int zeroCount = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String instruction = scanner.nextLine().trim();
                if (instruction.isEmpty()) continue;
                char direction = instruction.charAt(0);
                int distance = Integer.parseInt(instruction.substring(1));
                if (direction == 'R') {
                    currentPosition = (currentPosition + distance) % 100;
                } else if (direction == 'L') {
                    currentPosition = (currentPosition - (distance % 100) + 100) % 100;
                }
                if (currentPosition == 0) {
                    zeroCount++;
                }
            }
            System.out.println("Le mot de passe du coffre-fort est : " + zeroCount);
        } catch (FileNotFoundException e) {
            System.err.println("Fichier introuvable : " + e.getMessage());
        }
    }
}