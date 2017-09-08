package algorithms;

import javafx.scene.paint.Color;
import nodes.Node;

import java.util.*;

/**
 * Created by mirco on 6/20/2017.
 * pathfinding using AStar
 */
public class Pathfinder {



    public ArrayList<Node> aStar(Node start,Node goal,Node[][] grid){
        //a* initializing
        System.out.println("Start");
        start.notWalkAble = false;
        goal.notWalkAble = false;
        //list of visited nodes
        ArrayList<Node> closedSet = new ArrayList<>();

        //list of unvisited nodes
        ArrayList<Node> openSet = new ArrayList<>();

        //adds the start node to the open set
        openSet.add(start);

        //current node
        Node current;

        //start of the pathfinder
        while(!openSet.isEmpty()){

            //get the node with the lowest f cost
            for (int i = 0; i < openSet.size(); i++) {
                bubbleSort(openSet);
                current =openSet.get(0);
                //check if current is goal
                if (current == goal) {
                    return pathConstruct(current);
                }
                //move current to closedSet
                openSet.remove(current);
                closedSet.add(current);
                //go through neighbours
                current.addNeighbours(grid);
                for (Node N : current.neighbours) {
                    int tempG = current.getG() + N.distanceTo(current);
                    //if it's not in closedSet
                    if (!closedSet.contains(N) && !N.notWalkAble) {
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
        //no target found
        System.out.println("No path found");
        return null;
    }

    // get the lowest Node in a  via sorting the list in bubble sort
    void bubbleSort(ArrayList<Node> list){
            int i,j;
            Node temp;
            for(j = 0;j < list.size();j++){
                for(i = 1;i < list.size() - j;i++){
                    if(list.get(i-1).getF() > list.get(i).getF()){
                        temp = list.get(i);
                        list.set(i,list.get(i-1));
                        list.set(i-1,temp);
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
        return  path;
    }
}