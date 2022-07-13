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
          GameUtility.clearScreen();
          if (players.size() < 2) {
            System.out.println("Not enough players created. Please create players.");
            System.out.println("1. Start Game\n2. Create Charecters\n3.Exit\n\n");
            menuChoice = in.nextInt();
            break;
          }
          startGame(players, in);
          break;
        case 2:
          GameUtility.clearScreen();
          createCharecters(in, players, weapons);
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

  private static void createCharecters(Scanner in, ArrayList<Player> players, ArrayList<Weapon> weapons) {
    Player temp = null;
    boolean conf = false;
    while (players.size() < 2) {
      temp = GameUtility.characterCreationMenu(in, weapons);
      conf = GameUtility.confirm(in);
      if (conf) {
        players.add(temp);
      }
    }
  }

  private static void startGame(ArrayList<Player> players, Scanner in) {
    boolean endgame = false;
    GameUtility.clearScreen();
    Map map = new Map();
    System.out.println(map.toString());
    while (!endgame) {
      GameUtility.movePlayer(map, players.get(0), in);
      GameUtility.movePlayer(map, players.get(1), in);
    }
  }

}