package edu.uta.CSE1325;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Contains usefull utility functions the the main game.
 * This class only provides static methods
 */
public class GameUtility {
    /**
     * Checks if the player can move to the given location. If the location is not
     * occupied, the player can move to the
     * location. If the location is occupied, cannot move to the location.
     * 
     * Does not return until player has moved to a location.
     */
    public static void movePlayer(Map map, Player player, Scanner in) {
        int x = 0, y = 0;
        char move;
        int moves = 0;
        boolean validMove = true;
        while (moves < 5) {
            GameUtility.clearScreen();
            System.out.println(map.toString());
            if (!validMove) {
                System.out.println("Invalid move. Please try again.");
            }
            System.out.println(
                    player.getName() + ", where would you like to move? (up: u, down: d, left: l, right: r ): ");
            move = in.next().charAt(0);
            switch (move) {
                case 'u':
                    x = player.getX() - 1;
                    y = player.getY();
                    break;
                case 'd':
                    x = player.getX() + 1;
                    y = player.getY();
                    break;
                case 'l':
                    x = player.getX();
                    y = player.getY() - 1;
                    break;
                case 'r':
                    x = player.getX();
                    y = player.getY() + 1;
                    break;
                default:
                    System.out.println("Invalid move");
                    break;
            }

            if (x < 0 || y < 0 || x > 25 || y > 25 || map.isOccupied(x, y)) {
                validMove = false;
            } else {
                map.free(player.getX(), player.getY());
                map.set(x, y, player);
                player.move(x, y);
                moves++;
                validMove = true;
            }
        }
    }

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

    public static Player characterCreationMenu(Scanner in, ArrayList<Weapon> weapons) {
        Player player = null;
        clearScreen();
        System.out.println("\n\n1. Manual Stats\n2. Random Stats\n3");
        // Get the user's menu choice
        int menuChoice = in.nextInt();

        switch (menuChoice) {
            case 1:
                clearScreen();
                player = manualStats(in, weapons);
                clearScreen();
                System.out.println(player.toString());
                break;
            case 2:
                clearScreen();
                player = randomStats(in, weapons);
                clearScreen();
                System.out.println(player.toString());
                break;
            default:
                System.out.println("Invalid Choice\n");
                // Get the user's menu choice again if invalid
                menuChoice = in.nextInt();
                break;
        }

        return player;
    }

    public static boolean confirm(Scanner in) {
        System.out.println("Confirm? (y/n)");
        String confirmStr = in.next();
        if (confirmStr.equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Creates a new player object manually
     * 
     * @param in scanner object
     * @return Player object
     */
    private static Player manualStats(Scanner in, ArrayList<Weapon> weapons) {
        String name;
        int str = 0;
        int dex = 0;
        int con = 0;
        int points = 10;
        Weapon weapon = null;
        int menuChoice;
        System.out.println("Enter Character Name: ");
        in.nextLine();
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
        in.nextLine();
        System.out.println("\nSelect a weapon\n");
        int i = 0;
        for (Weapon w : weapons) {
            System.out.println(i + ". " + w.toString() + '\n');
            i++;
        }
        weapon = weapons.get(in.nextInt());
        return new Player(weapon, name, str, dex, con);
    }

    /**
     * Creates a weapons array
     */
    public static ArrayList<Weapon> createWeapons(String filename) throws IOException {
        // TODO
        String delimiter = ",";
        ArrayList<Weapon> weapons = new ArrayList<Weapon>();
        Scanner in = new Scanner(Path.of(filename));
        while (in.hasNextLine()) {
            // Read the first line and split it into tokens
            String line = in.nextLine();
            String[] tokens = line.split(delimiter);
            // Create a new weapon object and add it to the array
            weapons.add(new Weapon(tokens[0], tokens[1], Integer.parseInt(tokens[2]))); // create infinite
        }
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
        clearScreen();
        System.out.println("STR: " + str + "\nDEX: " + dex + "\nCON: " + con + "\nRemaining: " + rem
                + "\n\n1. Add STR" + "\n2. Add DEX" + "\n3. Add CON" + "\n4. Reset" + "\n5. Finish");
    }

    /**
     * Creates a new player object randomly
     * 
     * @param in Scanner object
     * @return Player object
     */
    private static Player randomStats(Scanner in, ArrayList<Weapon> weapons) {
        String name;
        System.out.println("Enter Character Name: ");
        in.nextLine();
        name = in.nextLine();
        name.replace('\n', ' ');
        Random generator = new Random();
        Weapon weapon = weapons.get(generator.nextInt(weapons.size()));
        return new Player(name, weapon);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
