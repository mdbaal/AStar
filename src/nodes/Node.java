package nodes;

import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Mirco Baalmans on 6/20/2017.
 */
@SuppressWarnings("ALL")
public class Node {

    private int x;
    private int y;

    private int g;
    private int h;
    private int f;

    private javafx.scene.shape.Rectangle rectangle;

    public ArrayList<Node> neighbours = new ArrayList<>();

    //most efficient previous node
    private Node cameFrom;


    //add the neighbours of this node to an array
    public void addNeighbours(Node [][] grid) {
        neighbours = new ArrayList<>();

        if (this.x != 0) {
            if (grid[x - 1][y] != null) {
                neighbours.add(grid[x - 1][y]);
            }
        }

        if (this.x != grid.length -1) {
            if (grid[x + 1][y] != null) {
                neighbours.add(grid[x + 1][y]);
            }

        }
        if (this.y != 0) {
            if (grid[x][y - 1] != null) {
                neighbours.add(grid[x][y - 1]);
            }
        }
        if (this.y != grid.length -1) {
            if (grid[x][y + 1] != null) {
                neighbours.add(grid[x][y + 1]);
            }
        }
    }

    //calculate the distance to another node
    private int distanceTo(Node node){
        int distance;

        int nX = this.x + node.x;
        int nY =  this.y + node.y;

        distance = (int) Math.sqrt( nX*2 +nY*2);

        return distance;
    }

    // calculate or set the g, h, f and previous of this node
    public void setG(int g){
        this.g = g;
    }
    public void setH(Node goal){
        this.h = distanceTo(goal);
    }
    public void setF(){
        this.f = this.g +  this.h;
    }
    public void setCameFrom(Node cameFrom){
        this.cameFrom = cameFrom;
    }
    public void setCords(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setRect(Rectangle rect){
        this.rectangle = rect;
    }

    //get the g, h, f, Camefrom and previous node of this node
    public int getG() {
        return g;
    }
    public int getH() {
        return h;
    }
    public int getF() {
        return f;
    }
    public Node getCameFrom(){
        return cameFrom;}
    public Rectangle getRectangle(){
          return this.rectangle;
        }



}
