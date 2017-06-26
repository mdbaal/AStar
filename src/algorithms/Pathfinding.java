package algorithms;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.scene.paint.Color;
import nodes.Node;

import java.util.*;

/**
 * Created by mirco on 6/20/2017.
 * pathfinding using AStar
 */
public class Pathfinding {



    public void aStar(Node start,Node goal,Node[][] grid){
        //a* initializing
        System.out.println("Start");
        //list of visited nodes
        ArrayList<Node> closedSet = new ArrayList<>();

        //list of unvisited nodes
        ArrayList<Node> openSet = new ArrayList<>();

        //adds the start node to the open set
        openSet.add(start);

        //current node
        Node current;
        //target found y/n
        boolean targetFound = false;
        //lowest fScore index in openset
        int lowest = 0;

        //start of the pathfinder
        while(!openSet.isEmpty() || !targetFound){

            //get the node with the lowest f cost
            for (int i = 0; i < openSet.size(); i++) {
                Node n = openSet.get(i);

                if (n.getF() < openSet.get(lowest).getF()) {
                    lowest = openSet.indexOf(n);
                }
                current = openSet.get(lowest);
                //check if current is goal
                if (current == goal) {
                    pathConstruct(current);
                    openSet.clear();
                    targetFound = true;
                    break;
                }

                //move current to closedSet
                openSet.remove(current);
                closedSet.add(current);
                //go through neighbours
                current.addNeighbours(grid);

                for (Node N : current.neighbours) {
                    int tempG = current.getG();
                    //if it's not in closedSet
                    if (!closedSet.contains(N)) {
                        //if openSet contains
                        Boolean newPath = false;
                        if (openSet.contains(N)) {
                            //if the tempG is lower than node g set the node g to tempG
                            if (tempG < N.getG()) {
                                N.setG(tempG);
                                newPath = true;
                            }
                            //else set if it isn't in open set assign tempG to node g and add it to openSet
                        } else {
                            N.setG(tempG);
                            openSet.add(N);
                            newPath = true;
                        }
                        if(newPath) {
                            //set the cameFrom, heuristic to the goal and the fScore
                            N.setCameFrom(current);
                            N.setH(goal);
                            N.setF();
                        }
                    }
                }
            }
        }
    }

    //construct the path
    private ArrayList<Node> pathConstruct(Node current){

        ArrayList<Node> path = new ArrayList<>();
        Node temp = current;
        path.add(temp);
        //create the path
        while (temp.getCameFrom()!= null){
            path.add(temp.getCameFrom());
            temp = temp.getCameFrom();

        }
        for(Node n : path){
            n.getRectangle().setFill(Color.BLUE);
        }
        System.out.println("Done");
        return path;
    }
}