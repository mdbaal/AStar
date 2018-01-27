package main;

import algorithms.Pathfinder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import nodes.Node;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mirco Baalmans on 6/20/2017.
 */

@SuppressWarnings("ALL")
class Game {

    private int gridSize = 80;

    private final Node[][] grid = new Node[gridSize][gridSize];
    GridPane gridPane = new GridPane();
    Pathfinder pathfind = new Pathfinder();
    Button go = new Button("go");
    Button move = new Button("move");
    ArrayList<Node> path;
    Mover mover;

    Game(){
        go.autosize();
        go.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startGame();
            }
        });
        move.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                movePlayer();
            }
        });

    }



  void makeGrid() {

      gridPane.setVgap(1);
      gridPane.setHgap(1);
      gridPane.setGridLinesVisible(true);

      Node node;
      Random random = new Random();
        for (int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize; y++) {
                Rectangle rect = new javafx.scene.shape.Rectangle();
                rect.setHeight(10);
                rect.setWidth(10);

                if(random.nextDouble() <.4) {
                    node = new Node(true);
                    rect.setFill(Color.CHOCOLATE);
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

    }

    public void startGame(){

        makeGrid();
        path = pathfind.aStar(grid[0][0], grid[5][5],grid);
        if(path != null) {
            mover = new Mover(grid, path);
        }
    }

    void movePlayer(){
        mover.move();
    }

    public GridPane getGridPane() {
        return gridPane;
    }
    public Button getButton(){return go;}
    public Button getMove(){return move;}
}

