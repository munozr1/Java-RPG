package edu.uta.CSE1325;

import java.io.IOException;
import java.util.*;

public class Game {

  public static void main(String args[]) throws IOException {
    // players array
    Player[] players = new Player[1];
    // scanner to get user input
    Scanner in = new Scanner(System.in);
    // user input for menu`
    int menuChoice;
    // weapons file name or path
    String weaponsFileName = args[0];

    System.out.println("1. Start Game\n2. Create Charecters\n3.Exit\n\n");
    menuChoice = in.nextInt();

    // create weapons from file
    ArrayList<Weapon> weapons = GameUtility.createWeapons(weaponsFileName);

    // number of players created
    int charecters = 0;

    // Main Menu
    while (true) {
      switch (menuChoice) {
        case 1:
          startGame();
          break;
        case 2:
          players[charecters] = GameUtility.characterCreationMenu(in, weapons);
          charecters++;
          players = Arrays.copyOf(players, players.length + 1); // Can create an infinite number of players
          break;
        case 3:
          System.out.println("Exit");
          System.exit(0);
          break;
        default:
          System.out.println("Invalid Choice");
          break;
      }
    }
  }

  private static void startGame() {

  }

}