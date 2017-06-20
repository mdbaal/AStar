package nodes;

/**
 * Created by Mirco Baalmans on 6/20/2017.
 */
public class Node {

    private int x;
    private int y;

    private int g;
    private int h;
    private int f;

    private Node[] Neighbours;


    //add the neighbours of this node to an array
    void addNeighbours(){
        //
    }

    //calculate the distance to another node
    public int distanceTo(Node node){
        int distance;

        int nX = this.x + node.x;
        int nY =  this.y + node.y;

        distance = (int) Math.sqrt( nX*2 +nY*2);

        return distance;
    }


    // calculate or set the g,h and f of this node
    public void setG(Node g){
        this.g = distanceTo(g);
    }
    public void setH(Node goal){
        this.h = distanceTo(goal);
    }
    public void setF(){
       this.f = this.g +  this.h;
    }

    //get the g,h and f of this node
    public int getG() {
        return g;
    }
    public int getH() {
        return h;
    }
    public int getF() {
        return f;
    }
}
