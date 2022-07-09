package edu.uta.CSE1325;

import java.io.IOException;
import java.util.*;

public class Game {

  public static void main(String args[]) throws IOException {
    // players array
    // Player[] players = new Player[1];
    ArrayList<Player> players = new ArrayList<Player>();
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

    // Main Menu
    while (true) {
      switch (menuChoice) {
        case 1:
          startGame();
          for (Player p : players) {
            System.out.println(p.toString());
          }
          GameUtility.clearScreen();
          System.out.println("//TODO\n1. Start Game\n2. Create Charecters\n3.Exit\n\n");
          menuChoice = in.nextInt();
          break;
        case 2:
          GameUtility.clearScreen();
          final Player temp = GameUtility.characterCreationMenu(in, weapons);
          players.add(temp);
          GameUtility.clearScreen();
          System.out.println("1. Start Game\n2. Create Charecters\n3.Exit\n\n");
          menuChoice = in.nextInt();
          break;
        case 3:
          System.out.println("Exit");
          System.exit(0);
          break;
        default:
          GameUtility.clearScreen();
          System.out.println("1. Start Game\n2. Create Charecters\n3.Exit\n\n");
          System.out.println("Invalid Choice\n\n");
          menuChoice = in.nextInt();
          break;
      }
    }
  }

  private static void startGame() {

  }

}