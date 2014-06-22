/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Timer;

/**
 *
 * @author huyafei
 */
public class Graph {

    protected ArrayList<Vertex> vertexlist;
    protected ArrayList<Edge1> edgelist;
    protected ArrayList<Collision> collisionlist;
    private final int MAX_DEGREE = 5;
    private final int MAX_WEIGHT = 10000;
    boolean hasCycle = false;
    boolean[] marked;

    public Graph() {
        this.vertexlist = new ArrayList<>();
        this.edgelist = new ArrayList<>();
        this.collisionlist = new ArrayList<>();
    }

    public ArrayList<Vertex> getVertexlist() {
        return vertexlist;
    }

    public void setVertexlist(ArrayList<Vertex> vertexlist) {
        this.vertexlist = vertexlist;
    }

    public ArrayList<Edge1> getEdgelist() {
        return edgelist;
    }

    public void setEdgelist(ArrayList<Edge1> edgelist) {
        this.edgelist = edgelist;
    }

    public ArrayList<Collision> getCollisionlist() {
        return collisionlist;
    }

    public void setCollisionlist(ArrayList<Collision> collisionlist) {
        this.collisionlist = collisionlist;
    }

    public boolean isHasCycle() {
        return hasCycle;
    }

    public void setHasCycle(boolean hasCycle) {
        this.hasCycle = hasCycle;
    }

    public boolean[] getMarked() {
        return marked;
    }

    public void setMarked(boolean[] marked) {
        this.marked = marked;
    }

    public int vertexCount() {
        return this.vertexlist.size();
    }

    public void insertVertex(Vertex vertex) {
        if (!vertexlist.contains(vertex)) {
            this.vertexlist.add(vertex);
        }
    }
    /*
     public boolean insertEdge(Edge1 edge) {
     boolean st = false;
     boolean de = false;
     if (edge != null) {
     String start = edge.getStart().getName();
     String Dest = edge.getDest().getName();
     if (start.equals(Dest)) {
     return false;
     } else {
     String s;
     String d;
     for (int e = 0; e < edgelist.size(); e++) {
     s = edgelist.get(e).getStart().getName();
     d = edgelist.get(e).getDest().getName();
     if (s.equals(start) && d.equals(Dest)) {
     return false;
     } else if (getDegree(s) > MAX_DEGREE && getDegree(d) > MAX_DEGREE) {
     return false;
     }
     }
     edgelist.add(edge);
     if (isCycle()) {
     return false;
     }
     }
     }
     return true;
     }*/

    public int getInDegree(Vertex v) {
        int degree = 0;
        for (int i = 0; i < edgelist.size(); i++) {
            if (v.getName().equals(edgelist.get(i).getDest().getName())) {
                degree = degree + 1;
            }
        }
        return degree;
    }

    public int getInDegree(Vertex v, ArrayList<Vertex> vs, ArrayList<Edge1> es) {
        int degree = 0;
        for (int i = 0; i < es.size(); i++) {
            if (v.getName().equals(es.get(i).getDest().getName())) {
                degree++;
            }
        }
        return degree;
    }

    public int getOutDegree(Vertex v) {
        int degree = 0;
        for (int i = 0; i < edgelist.size(); i++) {
            if (v.getName().equals(edgelist.get(i).getStart().getName())) {
                degree++;
            }
        }
        return degree;
    }

    public int getDegree(Vertex v) {
        int degree = 0;
        for (int i = 0; i < edgelist.size(); i++) {
            if (v.getName().equals(edgelist.get(i).getStart().getName()) || v.equals(edgelist.get(i).getDest().getName())) {
                degree++;
            }
        }
        return degree;
    }

    public boolean removeVertex(Vertex v) {
        this.vertexlist.remove(v);
        return true;
    }

    public Vertex getVertex(String name) {
        for (Vertex v : this.vertexlist) {
            if (v.getName().equals(name)) {
                return v;
            }
        }
        return null;
    }

    public ArrayList<Vertex> getNextNeighbor(Vertex v) {
        ArrayList<Vertex> vertexs = new ArrayList<>();
        if (vertexlist.contains(v)) {
            for (Edge1 e : edgelist) {
                if (v.getName().equals(e.getStart().getName()) && !vertexs.contains(e.getDest())) {
                    vertexs.add(e.getDest());
                }
            }
        }
        return vertexs;
    }

    public ArrayList<Vertex> getNextNeighbor(Vertex v, ArrayList<Vertex> vs, ArrayList<Edge1> es) {
        ArrayList<Vertex> vertexs = new ArrayList<>();
        if (vs.contains(v)) {
            for (Edge1 e : es) {
                if (v.getName().equals(e.getStart().getName()) && !vertexs.contains(e.getDest())) {
                    vertexs.add(e.getDest());
                }
            }
        }
        return vertexs;
    }

    public int getIndex(Vertex vetex, ArrayList<Vertex> vs) {
        int r = 0;
        for (int i = 0; i < vs.size(); i++) {
            if (vetex.getName().equals(vs.get(i).getName())) {
                r = i;
            }
        }
        return r;
    }

    public int getIndex(String vetex) {
        int r = 0;
        for (int i = 0; i < vertexlist.size(); i++) {
            if (vetex.equals(vertexlist.get(i).getName())) {
                r = i;
            }
        }
        return r;
    }

    public int cycle(int[] indegree) {
        int count = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                ++count;
            }
        }
        return count;
    }

    public boolean topologicalSort() {
        Stack mystack = new Stack();
        int[] indegree = new int[vertexCount()];
        ArrayList<Vertex> vertexs = new ArrayList<>();
        for (int i = 0; i < vertexlist.size(); i++) {
            int a = getInDegree(vertexlist.get(i));
            indegree[i] = a;
        }
        String route = "  start：";
        int count = 0;
        for (Vertex v : vertexlist) {
            if (getInDegree(v) == 0) {
                mystack.push(v);
            }
        }
        while (!mystack.empty()) {
            Vertex v = (Vertex) mystack.pop();
            vertexs.add(v);
            route = route + "->" + v;
            ++count;
            for (Vertex ve : getNextNeighbor(v)) {
                int w = getIndex(ve.getName());
                indegree[w] -= 1;
                if (indegree[w] == 0) {
                    mystack.push(ve);
                }
            }
        }
        if (count < vertexCount()) {
            for (Vertex s : vertexlist) {
                if (!vertexs.contains(s)) {
                    vertexs.add(s);
                    route += "->" + s;
                }
            }
        }
        System.out.println("topological sort" + route);
        return false;
    }

    public void topological(ArrayList<Vertex> vs) {
        ArrayList<Vertex> vertexs = vs;
        ArrayList<Edge1> edges = new ArrayList<>();
        for (Edge1 e : edgelist) {
            if (vs.contains(e.getStart()) && vs.contains(e.getDest())) {
                edges.add(e);
            }
        }
        Stack mystack = new Stack();
        int[] indegree = new int[vertexs.size()];
        for (int i = 0; i < vertexs.size(); i++) {
            indegree[i] = getInDegree(vertexs.get(i), vertexs, edges);
        }
        String route = "";
        int count = 0;
        for (Vertex v : vertexs) {
            if (getInDegree(v, vertexs, edges) == 0) {
                mystack.push(v);
            }
        }
        while (!mystack.empty()) {
            Vertex v = (Vertex) mystack.pop();
            route += "->" + v;
            ++count;
            for (Vertex ve : getNextNeighbor(v, vertexs, edges)) {
                int w = getIndex(ve, vertexs);
                indegree[w] = indegree[w] - 1;
                if (indegree[w] == 0) {
                    mystack.push(ve);
                }
            }
        }
        System.out.println("topological" + route);
    }

    public ArrayList<Vertex> Dijkstra(String start, String end, ArrayList<Edge1> except, String uav) {
        ArrayList<Vertex> result = new ArrayList<>();
        ArrayList<Edge1> edgelist1 = removeEdge(edgelist, except, uav);
        int n = this.vertexCount();
        int minweight = MAX_WEIGHT;
        int minUn = 0;
        int dis = MAX_WEIGHT;
        String[] route = new String[n];
        int[] minmatrix = new int[n];
        boolean[] isVisited = new boolean[n];
        boolean Noresult = true;
        for (int i = 0; i < n; i++) {
            isVisited[i] = false;
            route[i] = vertexlist.get(i).getName();
            minmatrix[i] = MAX_WEIGHT;
        }
        int num = getIndex(start);
        isVisited[num] = true;
        for (Edge1 e : edgelist1) {
            boolean access = true;
            if (start.equals(e.getStart().getName())) {
                System.out.println("cccccc"+e.getBlocks().size());
                if (e.getBlocks().size()!=0) {
                    for (Block b : e.getBlocks()) {
                        System.out.println("aaaaaaa"+b);
                        if (uav.equals(b.getUav())) {
                            access = false;
                        }
                    }
                }
                if (access == true) {
                    int j = getIndex(e.getDest().getName());
                    minmatrix[j] = e.getWeight();
                    Noresult = false;
                    System.out.println("minmatrix[j]" + j);
                    System.out.println("minmatrix[j]" + minmatrix[j]);
                }
            }
        }
        if (Noresult == true) {
            return null;
        }
        int count = 0;
        while (count < n) {
            for (int k = 0; k < n; k++) {
                // System.out.println(isVisited[k]);
                if (!isVisited[k]) {
                    //   System.out.println(minmatrix[k]);
                    if (minmatrix[k] < minweight) {
                        minweight = minmatrix[k];
                        minUn = k;
                    }
                }
            }
            isVisited[minUn] = true;
            for (Edge1 e : edgelist1) {
                System.out.println("start" + e.getStart().getName());
                System.out.println("des" + e.getDest().getName());
                System.out.println("minUn" + vertexlist.get(minUn).getName());
                int j = getIndex(e.getDest().getName());
                if (e.getStart().getName().equals(vertexlist.get(minUn).getName()) && !isVisited[j]) {
                     System.out.println(minweight + e.getWeight() );
                     System.out.println(minmatrix[j]);
                    //dis = e.getWeight();
                    if (minweight + e.getWeight() < minmatrix[j]) {
                        minmatrix[j] = minweight + e.getWeight();
                        route[j] = route[minUn] + vertexlist.get(j).getName();
                        System.out.println(route[j]);
                    }
                }
                // System.out.println("b" + minweight + e.getWeight());
                // System.out.println("c" + minmatrix[j]);
            }
            minweight = MAX_WEIGHT;
            //dis = MAX_WEIGHT;
            ++count;
        }
        int m = getIndex(end);
        //System.out.println("from " + start + " to " + vertexlist.get(m).getName());
        //System.out.println("shortest path：" + route[m]);
        result.add(vertexlist.get(getIndex(start)));
        for (int i = 0; i < route[m].length(); i++) {
            int index = getIndex(Character.toString(route[m].charAt(i)));
            result.add(vertexlist.get(index));
            System.out.println("????" + vertexlist.get(index).getName());
        }

        return result;
    }
    
    public ArrayList<Vertex> Dijkstra(String start,String end) {
        ArrayList<Vertex> result = new ArrayList<>();
        int n = this.vertexCount();
        int minweight = MAX_WEIGHT;
        int minUn = 0;
        int dis = MAX_WEIGHT;
        String[] route = new String[n];
        int[] minmatrix = new int[n];
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            isVisited[i] = false;
            route[i] = vertexlist.get(i).getName();
            minmatrix[i] = MAX_WEIGHT;
        }
        int num = getIndex(start);
        isVisited[num] = true;
        for (Edge1 e : edgelist) {
            boolean access = true;
            if (start.equals(e.getStart().getName())) {
                    int j = getIndex(e.getDest().getName());
                    minmatrix[j] = e.getWeight();
                    System.out.println("minmatrix[j]" + j);
                    System.out.println("minmatrix[j]" + minmatrix[j]);
            }
        }
        int count = 0;
        while (count < n) {
            for (int k = 0; k < n; k++) {
                // System.out.println(isVisited[k]);
                if (!isVisited[k]) {
                    //   System.out.println(minmatrix[k]);
                    if (minmatrix[k] < minweight) {
                        minweight = minmatrix[k];
                        minUn = k;
                    }
                }
            }
            isVisited[minUn] = true;
            for (Edge1 e : edgelist) {
                //System.out.println("start" + e.getStart().getName());
                //System.out.println("des" + e.getDest().getName());
                //System.out.println("minUn" + vertexlist.get(minUn).getName());
                int j = getIndex(e.getDest().getName());
                if (e.getStart().getName().equals(vertexlist.get(minUn).getName()) && !isVisited[j]) {
                    // System.out.println(vertexlist.get(minUn).getName());
                    //dis = e.getWeight();
                    if (minweight + e.getWeight() < minmatrix[j]) {
                        minmatrix[j] = minweight + e.getWeight();
                        route[j] = route[minUn] + vertexlist.get(j).getName();
                        //  System.out.println(route[j]);
                    }
                }
                // System.out.println("b" + minweight + e.getWeight());
                // System.out.println("c" + minmatrix[j]);
            }
            minweight = MAX_WEIGHT;
            //dis = MAX_WEIGHT;
            ++count;
        }
        int m = getIndex(end);
        //System.out.println("from " + start + " to " + vertexlist.get(m).getName());
        //System.out.println("shortest path：" + route[m]);
        result.add(vertexlist.get(getIndex(start)));
        for (int i = 0; i < route[m].length(); i++) {
            int index = getIndex(Character.toString(route[m].charAt(i)));
            result.add(vertexlist.get(index));
            System.out.println("????" + vertexlist.get(index).getName());
        }

        return result;
    }

    /* public boolean sequence() {
     boolean c = false;
     String route = null;
     ArrayList<String> node = new ArrayList<>();
     for (int s = 0; s < vertexCount(); s++) {
     if (getInDegree(vertexlist.get(s)) == 0) {
     route = "start：" + vertexlist.get(s);
     node.add(vertexlist.get(s));
     marked = new boolean[vertexCount()];
     c = dfs(vertexlist.get(s), vertexlist.get(s), route, node);
     }
     }
     return c;

     }*/

    /*  private boolean dfs(String v, String u, String route, ArrayList<String> node) {
     marked[getIndex(v)] = true;
     for (String w : getNextNeighbor(v)) {
     route = route + "->" + w;
     node.add(w);
     if (!marked[getIndex(w)]) {
     dfs(w, v, route, node);
     } else if (w.equals(u)) {
     hasCycle = true;
     }
     }
     System.out.println(route);
     System.out.println("it is a topological sequence");
     return hasCycle;
     }

     public boolean isCycle() {
     boolean c = false;
     String route = null;
     for (int s = 0; s < vertexCount(); s++) {
     marked = new boolean[vertexCount()];
     c = dfs(vertexlist.get(s), vertexlist.get(s));
     }
     return c;

     }

     private boolean dfs(String v, String u) {
     marked[getIndex(v)] = true;
     for (String w : getNextNeighbor(v)) {
     if (!marked[getIndex(w)]) {
     dfs(w, v);
     } else if (w.equals(u)) {
     hasCycle = true;
     }
     }
     return hasCycle;
     }

     public void DFStraverse() {
     int n = this.vertexCount();
     boolean[] visited = new boolean[n];
     for (int i = 1; i < n; i++) {
     visited[i] = false;
     }
     for (int j = 0; j < n; j++) {
     if (!visited[j]) {
     System.out.println("start" + j + "tranverse：");
     this.DFS(j, visited);
     }
     }
     }

     public void DFS(int v, boolean[] visited2) {
     boolean[] visited = visited2;
     visited[v] = true;
     System.out.println("start" + v);
     for (int w = 0; w < getNextNeighbor(vertexlist.get(v)).size(); w++) {
     if (!visited[w]) {
     visited[w] = true;
     DFS(w, visited);
     }
     }
     }

     public boolean hasCycle() {
     return hasCycle;
     }

     public void createSequence(String v) {
     System.out.println("---------sequence:");
     sequence();
     }*/
    public String generator() {
        String s = null;
        char c = 'a';
        char r = (char) (c + (int) (Math.random() * 3));
        s = String.valueOf(r);
        return s;
    }

    public int calculateWeight(Vertex start, Vertex end) {
        double x = Math.pow(start.getPosition().getX() - end.getPosition().getX(), 2);
        double y = Math.pow(start.getPosition().getY() - end.getPosition().getY(), 2);
        double result = Math.sqrt(x + y);
        return (int) result;
    }

    public ArrayList<Edge1> getConnectedEdge(Vertex v) {
        ArrayList<Edge1> result = new ArrayList<>();
        for (Edge1 e : edgelist) {
            if (e.getStart().equals(v) || e.getDest().equals(v)) {
                result.add(e);
            }
        }
        return result;
    }

    public ArrayList<Edge1> removeEdge(ArrayList<Edge1> edgelist, ArrayList<Edge1> except, String uav) {
        if (except != null) {
            //Edge1 ee = null;
            for (Edge1 ex : except) {
                for (Edge1 e : edgelist) {
                    if (e.getStart().getName().equals(ex.getStart().getName()) && e.getDest().getName().equals(ex.getDest().getName())) {
                        // ee = e;
                        Block b = new Block(uav);
                        e.getBlocks().add(b);
                        System.out.println("bbbbbbbb"+b);
                        System.out.println("bbbbbbbb"+b.getUav());
                    }
                }
            }
        }
        return edgelist;
    }
}
