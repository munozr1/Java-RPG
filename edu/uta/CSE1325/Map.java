package edu.uta.CSE1325;

import java.util.*;

public class Map {

  Player[][] map = new Player[25][25];

  Map()
  {

  }

  public boolean isOccupied(int x, int y)
  {
    if(map[x][y] == null)
    {
      return false;
    }
    return true;
  }
  
}
