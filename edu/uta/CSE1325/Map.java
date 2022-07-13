package edu.uta.CSE1325;

public class Map {

  Player[][] map = new Player[25][25];

  Map() {

  }

  public boolean isOccupied(int x, int y) {
    if (map[x][y] == null) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        if (map[i][j] == null) {
          sb.append("-");
        } else {
          sb.append(map[i][j].getName());
        }
      }
      sb.append("\n");
    }
    return sb.toString();
  }

}
