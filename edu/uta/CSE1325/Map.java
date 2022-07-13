package edu.uta.CSE1325;

public class Map {

  Player[][] map = new Player[25][25];

  public Map() {
    for (int i = 0; i < 25; i++) {
      for (int j = 0; j < 25; j++) {
        map[i][j] = null;
      }
    }
  }

  public boolean isOccupied(int x, int y) {
    boolean occupied = true;
    if (map[x][y] == null) {
      occupied = false;
    }
    return occupied;
  }

  public void set(int x, int y, Player player) {
    map[x][y] = player;
  }

  public void free(int x, int y) {
    map[x][y] = null;
  }

  @Override
  public String toString() {

    // Create a string of the map
    String mapString = "";
    for (int i = 0; i < 25; i++) {
      for (int j = 0; j < 25; j++) {
        if (map[i][j] == null) {
          mapString += ".";
        } else {
          mapString += map[i][j].getName().charAt(0);
        }
      }
      mapString += "\n";
    }
    return mapString;
  }

}
