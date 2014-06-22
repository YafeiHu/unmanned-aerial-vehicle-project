/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author huyafei
 */
public class WeatherAgent extends TimerTask {

    private Graph graph;
    
    public void getData(Graph graph) {
         this.graph=graph;
    } 
    
    public Graph getChangedGraph() {
         return graph;
    } 
    @Override
    public void run() {
         //return changed graph
        this.graph=graph;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
}
