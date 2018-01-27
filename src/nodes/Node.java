package nodes;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

/**
 * Created by Mirco Baalmans on 6/20/2017.
 */


public class Node {

    public int x;
    public int y;

    private int g;
    private int h;
    private int f;

    public Boolean notWalkAble = false;

    private javafx.scene.shape.Rectangle rectangle;

    public ArrayList<Node> neighbours;

    //most efficient previous node
    private Node cameFrom;
    public Node(Boolean notWalkAble){
        this.notWalkAble = notWalkAble;
    }
    //add the neighbours of this node to an array
    public void addNeighbours(Node [][] grid) {
        neighbours = new ArrayList<>();
        //left
        if (this.x != 0) {
            if (grid[x - 1][y] != null) {
                neighbours.add(grid[x - 1][y]);
            }
        }
        //right
        if (this.x != grid.length -1) {
            if (grid[x + 1][y] != null) {
                neighbours.add(grid[x + 1][y]);
            }

        }
        //up
        if (this.y != 0) {
            if (grid[x][y - 1] != null) {
                neighbours.add(grid[x][y - 1]);
            }
        }

        //down
        if (this.y != grid.length -1) {
            if (grid[x][y + 1] != null) {
                neighbours.add(grid[x][y + 1]);
            }
        }
        //down left
        if (this.y != grid.length -1 && this.x != 0) {
            if (grid[x - 1][y + 1] != null) {
                neighbours.add(grid[x- 1][y + 1]);
            }
        }
        //down right
        if (this.y != grid.length -1  && this.x != grid.length-1) {
            if (grid[x + 1][y + 1] != null) {
                neighbours.add(grid[x+ 1][y + 1]);
            }
        }
        //up left
        if (this.y != 0 && this.x != 0) {
            if (grid[x - 1][y - 1] != null) {
                neighbours.add(grid[x- 1][y - 1]);
            }
        }
        //up right
        if (this.y != 0 && this.x != grid.length-1) {
            if (grid[x + 1][y - 1] != null) {
                neighbours.add(grid[x + 1][y - 1]);
            }
        }
    }

    //calculate the distance to another node
    public int distanceTo(Node node) {
        int distance;
        int nY;
        int nX;



         nX = Math.abs(this.x - node.x);
         nY =  Math.abs( this.y - node.y);

        distance = (int) Math.sqrt(nX * nX + nY * nY);


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
