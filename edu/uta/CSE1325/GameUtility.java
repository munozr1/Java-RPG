package edu.uta.CSE1325;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Contains usefull utility functions the the main game.
 * This class only provides static methods
 */
public class GameUtility {

    /**
     * Rolls a virtual dice an x amount of times and returns the value
     * 
     * @param input A string value with format [NUMDICE]d[DICETYPE]
     * @return An integer which represents the sum of the die rolled
     */
    public static int rollDice(String input) {
        String[] tokens = input.split("d");
        Random generator = new Random();
        int numDice = Integer.parseInt(tokens[0]);
        int diceType = Integer.parseInt(tokens[0]);
        int result = 0;
        for (int i = 0; i < numDice; i++) {
            result += generator.nextInt(diceType) + 1;
        }
        return result;
    }

    public static Player characterCreationMenu(Scanner in, Weapon[] weapons) {
        Player player = null;
        System.out.println("\n\n1. Manual Stats\n2. Random Stats\n3");
        // Get the user's menu choice
        int menuChoice = in.nextInt();
        while (player != null) {
            switch (menuChoice) {
                case 1:
                    player = manualStats(in);
                    break;
                case 2:
                    player = randomStats(in, weapons);
                    break;
                default:
                    System.out.println("Invalid Choice\n");
                    // Get the user's menu choice again if invalid
                    menuChoice = in.nextInt();
                    break;
            }
        }

        return player;
    }

    /**
     * Creates a new player object manually
     * 
     * @param in scanner object
     * @return Player object
     */
    public static Player manualStats(Scanner in) {
        String name;
        int str = 0;
        int dex = 0;
        int con = 0;
        int points = 10;
        Weapon weapon = null;
        int menuChoice;
        System.out.println("Enter Character Name: ");
        name = in.nextLine();
        while (points > 0) {
            printPlayerCreationStatState(dex, con, str, points);
            menuChoice = in.nextInt();
            switch (menuChoice) {
                case 1:
                    str++;
                    points--;
                    break;
                case 2:
                    dex++;
                    points--;
                    break;
                case 3:
                    con++;
                    points--;
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
        return new Player(weapon, name, str, dex, con);
    }

    /**
     * Creates a weapons array
     */
    public static Weapon[] createWeapons(String filename) throws IOException {
        // TODO
        String delimiter = ",";
        Weapon[] weapons = new Weapon[1];
        Scanner in = new Scanner(Path.of(filename));
        int weaponCount = 0;
        while (in.hasNextLine()) {
            // Read the first line and split it into tokens
            String line = in.nextLine();
            String[] tokens = line.split(delimiter);
            // Create a new weapon object and add it to the array
            weapons[weaponCount] = new Weapon(tokens[0], tokens[1], Integer.parseInt(tokens[2])); // create infinite
                                                                                                  // weapons
            weapons = Arrays.copyOf(weapons, weapons.length + 1);
            weaponCount++;
        }
        weapons = Arrays.copyOf(weapons, weaponCount); // remove the last weapon because it is null
        return weapons;
    }

    /**
     * Prints the current state of the player creation process
     * 
     * @param dex int
     * @param con int
     * @param str int
     * @param rem int
     */
    private static void printPlayerCreationStatState(int dex, int con, int str, int rem) {
        System.out.println("STR: " + str + "\nDEX: " + dex + "\nCON: " + con + "\nRemaining: " + rem
                + "\n\n1. Add STR" + "\n2. Add DEX" + "\n3. Add CON" + "\n4. Reset" + "\n5. Finish");
    }

    /**
     * Creates a new player object randomly
     * 
     * @param in Scanner object
     * @return Player object
     */
    private static Player randomStats(Scanner in, Weapon[] weapons) {
        String name;
        System.out.println("Enter Character Name: ");
        name = in.nextLine();
        Random generator = new Random();
        Weapon weapon = weapons[generator.nextInt(weapons.length)];
        return new Player(name, weapon);
    }
}
