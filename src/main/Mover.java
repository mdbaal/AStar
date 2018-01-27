package main;

import javafx.scene.paint.Color;
import nodes.Node;
import timer.Timer;

import java.util.ArrayList;


/**
 * Created by Mirco Baalmans on 7/3/2017.
 */

class Mover {

    int x;
    int y;

    private int index;


    Node currentNode;
    private final Node[][] grid;
    private final ArrayList<Node> path;
    private final Timer timer = new Timer();


    Mover(Node[][] grid, ArrayList<Node> path){
        this.grid = grid;
        this.path = path;

        index = path.size()-1;
    }

    public void move() {
            currentNode = path.get(index);

            this.x = currentNode.x;
            this.y = currentNode.y;

            currentNode.getRectangle().setFill(Color.RED);


            index --;

            if(index > -1){
                move();
            }
    }

    void moving(){
        System.out.println("works");
    }
}
