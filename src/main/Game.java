package main;

import algorithms.Pathfinding;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import nodes.Node;

/**
 * Created by Mirco Baalmans on 6/20/2017.
 */

@SuppressWarnings("ALL")
class Game {

    private int gridSize = 80;

    private final Node[][] grid = new Node[gridSize][gridSize];
    GridPane gridPane = new GridPane();


  void start() {

      gridPane.setVgap(1);
      gridPane.setHgap(1);
      gridPane.setGridLinesVisible(true);

      Node node;
        for (int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize; y++) {
                javafx.scene.shape.Rectangle rect = new javafx.scene.shape.Rectangle();
                rect.setStroke(Color.BLACK);
                rect.setHeight(10);
                rect.setWidth(10);
                rect.setFill(Color.GREEN);

                gridPane.add(rect, x, y);

                node = new Node();
                node.setCords(x,y);
                node.setRect(rect);
                grid[x][y] = node;
            }
        }

        Pathfinding pathfind = new Pathfinding();

        pathfind.aStar(grid[0][0], grid[70][70],grid);
    }

    public GridPane getGridPane() {
        return gridPane;
    }
}

