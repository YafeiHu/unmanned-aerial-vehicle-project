/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

import java.util.ArrayList;

/**
 *
 * @author huyafei
 */
public class Edge1 {
    private Vertex start;
    private Vertex dest;
    private int weight;
    private int originalWeight;
    private int distance;
    private ArrayList<Block> blocks=new ArrayList<>();

    public Edge1(Vertex start, Vertex dest, int weight,int distance) {
        this.start = start;
        this.dest = dest;
        this.weight = weight;
        this.distance=distance;
    }

    public Vertex getStart() {
        return start;
    }

    public void setStart(Vertex start) {
        this.start = start;
    }

    public Vertex getDest() {
        return dest;
    }

    public void setDest(Vertex dest) {
        this.dest = dest;
    }

    

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getOriginalWeight() {
        return originalWeight;
    }

    public void setOriginalWeight(int originalWeight) {
        this.originalWeight = originalWeight;
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }

    
    
}
