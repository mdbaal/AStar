package main;

import algorithms.Pathfinder;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import nodes.Node;

import java.util.Random;

/**
 * Created by Mirco Baalmans on 6/20/2017.
 */

@SuppressWarnings("ALL")
class Game {

    private int gridSize = 80;

    private final Node[][] grid = new Node[gridSize][gridSize];
    GridPane gridPane = new GridPane();


  void start() {

      gridPane.setVgap(0);
      gridPane.setHgap(0);
      gridPane.setGridLinesVisible(true);

      Node node;
      Random random = new Random();
        for (int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize; y++) {
                javafx.scene.shape.Rectangle rect = new javafx.scene.shape.Rectangle();
                rect.setHeight(10);
                rect.setWidth(10);

                if(random.nextDouble() <.3) {
                    node = new Node(true);
                    rect.setFill(Color.BLACK);
                }else{
                    node = new Node(false);
                    rect.setFill(Color.GREEN);
                }
                gridPane.add(rect, x, y);

                node.setCords(x,y);
                node.setRect(rect);
                grid[x][y] = node;
            }
        }

        Pathfinder pathfind = new Pathfinder();

        pathfind.aStar(grid[0][0], grid[79][79],grid);

    }

    public GridPane getGridPane() {
        return gridPane;
    }
}

