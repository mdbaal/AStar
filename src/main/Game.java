package main;

import algorithms.Pathfinding;
import nodes.Node;

/**
 * Created by Mirco Baalmans on 6/20/2017.
 */

class Game {

    private int gridSize = 5;

    private final Node[][] grid = new Node[gridSize][gridSize];


  void start() {
      Node node;
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                node = new Node();
                node.setCords(x,y);
                grid[x][y] = node;
            }
        }

        Pathfinding pathfind = new Pathfinding();

        pathfind.aStar(grid[1][4], grid[2][3],grid);
    }
}

