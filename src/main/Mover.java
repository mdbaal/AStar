package main;

import javafx.scene.paint.Color;
import nodes.Node;

import java.util.ArrayList;

/**
 * Created by Mirco Baalmans on 7/3/2017.
 */
public class Mover {

    int x;
    int y;

    int index;


    Node currentNode;
    Node[][] grid;
    ArrayList<Node> path;

    Mover(Node[][] grid, ArrayList<Node> path){
        this.grid = grid;
        this.path = path;

        index = path.size()-1;

    }

    void move(){
        currentNode = path.get(index);

        this.x = currentNode.x;
        this.y = currentNode.y;

        currentNode.getRectangle().setFill(Color.RED);
        index --;
        currentNode = path.get(index);

        }
    }
