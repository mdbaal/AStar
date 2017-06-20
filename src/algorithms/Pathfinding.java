package algorithms;

import nodes.Node;

import java.util.*;

/**
 * Created by mirco on 6/20/2017.
 * pathfinding using AStar
 */
public class Pathfinding {


    public void aStar(Node start,Node goal){

        //list of visited nodes
        ArrayList<Node> closedSet = new ArrayList<>();

        //list of unvisited nodes
        ArrayList<Node> openSet = new ArrayList<>();

        //adds the start node to the open set
        openSet.add(start);

        //most efficient previous node
        Node CameFrom;
        //current node
        Node current = null;
        //target found y/n
        boolean targetFound = false;


        while(!openSet.isEmpty() || !targetFound){

            int lowest = 0;


            for (Node n: openSet) {
                if(n.getF() < openSet.indexOf(lowest)){
                    lowest = openSet.indexOf(n);
                    current = openSet.get(lowest);
                }

                if(current == goal){
                    pathConstruct();
                    break;
                }

                openSet.remove(current);
                closedSet.add(current);


            }

        }


    }

    void pathConstruct(){


    }
}
