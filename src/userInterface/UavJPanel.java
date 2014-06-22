/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import business.Collision;
import business.Edge1;
import business.Graph;
import business.Position;
import business.UAV;
import business.Vertex;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author huyafei
 */
public class UavJPanel extends javax.swing.JPanel {

    /**
     * Creates new form UavJPanel
     */
    private Graph graph;
    //private JLabel aircraft;
    private ArrayList<JLabel> citys = new ArrayList<JLabel>();
    private double flyPosition;
    //private UAV uav;
    //private Timer timerforWeather;
    private int mouseX;
    private int mouseY;
    private ArrayList<JLabel> collisions = new ArrayList<>();
    private ArrayList<JLabel> aircrafts = new ArrayList<>();
    private ArrayList<JLabel> weights = new ArrayList<>();
    private int count = 0;

    public UavJPanel() {
        initComponents();
        this.graph = new Graph();
        for (int i = 0; i < 20; i++) {
            JLabel aircraft = new JLabel();
            aircraft.setSize(8, 8);
            aircraft.setIcon(new ImageIcon("/Users/huyafei/NetBeansProjects/final/src/business/image/flight.png"));
            this.add(aircraft);
            aircrafts.add(aircraft);
        }
        for (int i = 0; i < 20; i++) {
            JLabel collision = new JLabel();
            collisions.add(collision);
            this.add(collision);
        }
        for (int i = 0; i < 20; i++) {
            JLabel weight = new JLabel();
            weights.add(weight);
            this.add(weight);
        }
        create(graph);
        /* for (int i = 0; i < graph.getEdgelist().size(); i++) {
         JLabel city = new JLabel();
         citys.add(city);
         this.add(city);
         }*/
        // uav = new UAV();
        initiate();

    }

    public void initiate() {
        startpoint.removeAllItems();
        destinationpoint.removeAllItems();
        startpoint.addItem("a");
        startpoint.addItem("b");
        startpoint.addItem("c");
        startpoint.addItem("d");
        startpoint.addItem("e");
        startpoint.addItem("f");
        startpoint.addItem("g");
        startpoint.addItem("h");
        destinationpoint.addItem("a");
        destinationpoint.addItem("b");
        destinationpoint.addItem("c");
        destinationpoint.addItem("d");
        destinationpoint.addItem("e");
        destinationpoint.addItem("f");
        destinationpoint.addItem("g");
        destinationpoint.addItem("h");

        startpoint2.removeAllItems();
        destinationpoint2.removeAllItems();
        startpoint2.addItem("a");
        startpoint2.addItem("b");
        startpoint2.addItem("c");
        startpoint2.addItem("d");
        startpoint2.addItem("e");
        startpoint2.addItem("f");
        startpoint2.addItem("g");
        startpoint2.addItem("h");
        destinationpoint2.addItem("a");
        destinationpoint2.addItem("b");
        destinationpoint2.addItem("c");
        destinationpoint2.addItem("d");
        destinationpoint2.addItem("e");
        destinationpoint2.addItem("f");
        destinationpoint2.addItem("g");
        destinationpoint2.addItem("h");

        startpoint1.removeAllItems();
        destinationpoint1.removeAllItems();
        startpoint1.addItem("a");
        startpoint1.addItem("b");
        startpoint1.addItem("c");
        startpoint1.addItem("d");
        startpoint1.addItem("e");
        startpoint1.addItem("f");
        startpoint1.addItem("g");
        startpoint1.addItem("h");
        destinationpoint1.addItem("a");
        destinationpoint1.addItem("b");
        destinationpoint1.addItem("c");
        destinationpoint1.addItem("d");
        destinationpoint1.addItem("e");
        destinationpoint1.addItem("f");
        destinationpoint1.addItem("g");
        destinationpoint1.addItem("h");
    }

    public void create(Graph graph) {
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();
        Vertex v4 = new Vertex();
        v1.setName("a");
        v2.setName("b");
        v3.setName("c");
        v4.setName("d");
        Vertex v11 = new Vertex();
        Vertex v21 = new Vertex();
        Vertex v31 = new Vertex();
        Vertex v41 = new Vertex();
        v11.setName("e");
        v21.setName("f");
        v31.setName("g");
        v41.setName("h");
        Vertex v12 = new Vertex();
        v12.setName("i");
        Vertex v22 = new Vertex();
        v22.setName("j");

        Position p1 = new Position(100, 200);
        Position p2 = new Position(200, 100);
        Position p3 = new Position(250, 300);
        Position p4 = new Position(400, 200);
        v1.setPosition(p1);
        v2.setPosition(p2);
        v3.setPosition(p3);
        v4.setPosition(p4);
        Position p11 = new Position(500, 200);
        Position p21 = new Position(600, 100);
        Position p31 = new Position(600, 300);
        Position p41 = new Position(700, 200);
        v11.setPosition(p11);
        v21.setPosition(p21);
        v31.setPosition(p31);
        v41.setPosition(p41);
        Position p12 = new Position(320, 100);
        v12.setPosition(p12);
        Position p22 = new Position(450, 100);
        v22.setPosition(p22);

        graph.getVertexlist().add(v1);
        graph.getVertexlist().add(v2);
        graph.getVertexlist().add(v3);
        graph.getVertexlist().add(v4);
        graph.getVertexlist().add(v11);
        graph.getVertexlist().add(v21);
        graph.getVertexlist().add(v31);
        graph.getVertexlist().add(v41);
        graph.getVertexlist().add(v12);
        graph.getVertexlist().add(v22);

        Edge1 e1 = new Edge1(v1, v2, graph.calculateWeight(v1, v2), graph.calculateWeight(v1, v2));
        Edge1 e2 = new Edge1(v1, v3, graph.calculateWeight(v1, v3), graph.calculateWeight(v1, v3));
        Edge1 e3 = new Edge1(v1, v4, graph.calculateWeight(v1, v4), graph.calculateWeight(v1, v4));
        Edge1 e4 = new Edge1(v3, v4, graph.calculateWeight(v3, v4), graph.calculateWeight(v3, v4));
        Edge1 e5 = new Edge1(v2, v4, graph.calculateWeight(v2, v4), graph.calculateWeight(v2, v4));
        graph.getEdgelist().add(e1);
        graph.getEdgelist().add(e2);
        graph.getEdgelist().add(e3);
        graph.getEdgelist().add(e4);
        graph.getEdgelist().add(e5);
        Edge1 e11 = new Edge1(v11, v21, graph.calculateWeight(v11, v21), graph.calculateWeight(v11, v21));
        Edge1 e21 = new Edge1(v11, v31, graph.calculateWeight(v11, v31), graph.calculateWeight(v11, v31));
        Edge1 e31 = new Edge1(v11, v41, graph.calculateWeight(v11, v41), graph.calculateWeight(v11, v41));
        Edge1 e41 = new Edge1(v31, v41, graph.calculateWeight(v31, v41), graph.calculateWeight(v31, v41));
        Edge1 e51 = new Edge1(v21, v41, graph.calculateWeight(v21, v41), graph.calculateWeight(v21, v41));
        Edge1 e61 = new Edge1(v4, v11, graph.calculateWeight(v4, v11), graph.calculateWeight(v4, v11));
        graph.getEdgelist().add(e11);
        graph.getEdgelist().add(e21);
        graph.getEdgelist().add(e31);
        graph.getEdgelist().add(e41);
        graph.getEdgelist().add(e51);
        graph.getEdgelist().add(e61);
        Edge1 e12 = new Edge1(v2, v12, graph.calculateWeight(v2, v12), graph.calculateWeight(v2, v12));
        Edge1 e22 = new Edge1(v12, v4, graph.calculateWeight(v12, v4), graph.calculateWeight(v12, v4));
        graph.getEdgelist().add(e12);
        graph.getEdgelist().add(e22);
        Edge1 e23 = new Edge1(v4, v22, graph.calculateWeight(v4, v22), graph.calculateWeight(v4, v22));
        Edge1 e24 = new Edge1(v22, v11, graph.calculateWeight(v22, v11), graph.calculateWeight(v22, v11));
        graph.getEdgelist().add(e23);
        graph.getEdgelist().add(e24);
        Edge1 e25 = new Edge1(v22, v21, graph.calculateWeight(v22, v21), graph.calculateWeight(v22, v21));
        graph.getEdgelist().add(e25);

        for (int i = 0; i < graph.getEdgelist().size(); i++) {
            Edge1 edge = graph.getEdgelist().get(i);
            edge.setOriginalWeight(edge.getWeight());
            int r = 20;
            double f = Math.random();
            BigDecimal b = new BigDecimal(f);
            double factor = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            String s = edge.getStart().getName();
            String d = edge.getDest().getName();
            if (i % 2 == 0) {
                Collision collision = new Collision((int) ((edge.getStart().getPosition().getX() + edge.getDest().getPosition().getX()) / 2), (int) ((edge.getStart().getPosition().getY() + edge.getDest().getPosition().getY()) / 2) + 3, r, factor, s, d);
                graph.getCollisionlist().add(collision);
            } else {
                Collision collision = new Collision((int) ((edge.getStart().getPosition().getX() + edge.getDest().getPosition().getX()) / 2), (int) ((edge.getStart().getPosition().getY() + edge.getDest().getPosition().getY()) / 2), r, factor, s, d);
                graph.getCollisionlist().add(collision);
            }

        }
        for (int i = 0; i < graph.getEdgelist().size(); i++) {
            Edge1 e = graph.getEdgelist().get(i);
            Vertex s = e.getStart();
            Vertex d = e.getDest();
            for (Collision c : graph.getCollisionlist()) {
                if (c.getStart().equals(s.getName()) && c.getEnd().equals(d.getName()) || c.getStart().equals(d.getName()) && c.getEnd().equals(s.getName())) {
                    e.setWeight((int) (e.getOriginalWeight() * (c.getFactor()) + e.getOriginalWeight()));
                }
            }
        }
      /*  for (int i = 0; i < graph.getCollisionlist().size(); i++) {
            // g.draw(new Ellipse2D.Double(c.getX(), c.getY(), c.getRadius(), c.getRadius()));
            Collision c = graph.getCollisionlist().get(i);
            JLabel collision = collisions.get(i);
            collision.setSize(c.getRadius(), c.getRadius());
            collision.setLocation(c.getX(), c.getY());
            // collision.setIcon(new ImageIcon("/Users/huyafei/NetBeansProjects/final/src/business/image/station.png"));
            collision.setBackground(Color.red);
            collision.setOpaque(true);
            collision.setText(String.valueOf(c.getFactor()));
        }*/

    }

    @Override
    public void paintComponent(Graphics graphics
    ) {
        super.paintComponent(graphics);
        graphics.setColor(Color.BLACK);
        try {
            graphics.drawImage(ImageIO.read(new File("/Users/huyafei/NetBeansProjects/final/src/business/image/map.gif")), 0, 0, this);
        } catch (IOException ex) {
            Logger.getLogger(UavJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        Graphics2D graphics2D = (Graphics2D) graphics;
        for (int i = 0; i < graph.getEdgelist().size(); i++) {
            Edge1 e = graph.getEdgelist().get(i);
            Vertex s = e.getStart();
            Vertex d = e.getDest();

            graphics2D.draw(new Ellipse2D.Double(s.getPosition().getX(), s.getPosition().getY(), 3, 3));
            graphics2D.drawString(s.getName(), (int) s.getPosition().getX(), (int) s.getPosition().getY());
            //graphics2D.drawString(String.valueOf(s.getWeather()), (int) s.getPosition().getX()+1, (int) s.getPosition().getY()+1);
            graphics2D.draw(new Ellipse2D.Double(d.getPosition().getX(), d.getPosition().getY(), 3, 3));
            graphics2D.drawString(d.getName(), (int) d.getPosition().getX(), (int) d.getPosition().getY());
            //graphics2D.drawString(String.valueOf(d.getWeather()), (int) s.getPosition().getX()+1, (int) s.getPosition().getY()+1);
            graphics2D.draw(new Line2D.Double(s.getPosition().getX(), s.getPosition().getY(), d.getPosition().getX(), d.getPosition().getY()));
            // graphics2D.drawString(String.valueOf(e.getWeight()), ((float) s.getPosition().getX() + (float) d.getPosition().getX()) / 2, ((float) s.getPosition().getY() + (float) d.getPosition().getY()) / 2);
            //citys.get(i).setLocation(((int) s.getPosition().getX() + (int) d.getPosition().getX()) / 2, ((int) d.getPosition().getY() + (int) d.getPosition().getY()) / 2);
        }
    }

    public void moving(double x, double y, UAV uav, JLabel aircraft) {
        Graphics2D g = (Graphics2D) this.getGraphics();
        for (int i = 0; i < graph.getEdgelist().size(); i++) {
            Edge1 e = graph.getEdgelist().get(i);
            Vertex s = e.getStart();
            Vertex d = e.getDest();
            for (Collision c : graph.getCollisionlist()) {
                if (c.getStart().equals(s.getName()) && c.getEnd().equals(d.getName()) || c.getStart().equals(d.getName()) && c.getEnd().equals(s.getName())) {
                    e.setWeight((int) (e.getOriginalWeight() * (c.getFactor()) + e.getOriginalWeight()));
                }
            }

            JLabel weight = weights.get(i);
            weight.setSize(25, 25);
            weight.setLocation((int) ((s.getPosition().getX() + d.getPosition().getX()) / 2) - 15, (int) ((s.getPosition().getY() + d.getPosition().getY()) / 2) - 15);
            weight.setOpaque(true);
            weight.setText(String.valueOf(e.getWeight()));
            // g.drawString(String.valueOf(e.getWeight()), ((float) s.getPosition().getX() + (float) d.getPosition().getX()) / 2, ((float) s.getPosition().getY() + (float) d.getPosition().getY()) / 2);
        }
        for (int i = 0; i < graph.getCollisionlist().size(); i++) {
            // g.draw(new Ellipse2D.Double(c.getX(), c.getY(), c.getRadius(), c.getRadius()));
            Collision c = graph.getCollisionlist().get(i);
            JLabel collision = collisions.get(i);
            collision.setSize(c.getRadius(), c.getRadius());
            collision.setLocation(c.getX(), c.getY());
            // collision.setIcon(new ImageIcon("/Users/huyafei/NetBeansProjects/final/src/business/image/station.png"));
            collision.setBackground(Color.red);
            collision.setOpaque(true);
            collision.setText(String.valueOf(c.getFactor()));
        }
        Position p = new Position(x, y);
        uav.setPosition(p);
        aircraft.setLocation((int) x, (int) y);
        /* for (int i = 0; i < graph.getEdgelist().size(); i++) {
         citys.get(i).setText(String.valueOf(graph.getEdgelist().get(i).getWeight()));
         }*/
        control.setText("direction:" + String.valueOf(uav.getDirection())
                + "x_position:" + String.valueOf(uav.getPosition().getX())
                + "y_position:" + String.valueOf(uav.getPosition().getY()));
        control.setLineWrap(true);
        control.setWrapStyleWord(true);

    }

    public Vertex makeDecision(UAV uav, String currentPosition, String destPosition, JLabel aircraft, Graph g, int time) {
        //
        Timer timer = new Timer();
        DecisionAgent decisionTask = new DecisionAgent();
        decisionTask.setUav(uav);
        decisionTask.setCurrentPosition(currentPosition);
        decisionTask.setDestPosition(destPosition);
        decisionTask.setAircraft(aircraft);
        decisionTask.setGraphDecision(g);
        timer.schedule(decisionTask, time, time);
        return decisionTask.getVetex();
    }

    public void addDanger() {
        Timer timerforWeather = new Timer();
        WeatherAgent weatherAgent = new WeatherAgent();
        timerforWeather.schedule(weatherAgent, 200, 200);
        // graph = weatherAgent.getChangedGraph();
    }

    /* public void moving(double x, double y) {
     panel.moving(x, y);
     Position p = new Position(x, y);
     uav.setPosition(p);
     }*/
    public class DecisionAgent extends TimerTask {

        // private Graphics graphics;
        private Graph graphDecision;
        private boolean deport = false;
        private Vertex vetex;
        private boolean finish = false;
        private double pathDirection;
        private double pathConstant;
        private UAV uav;
        private String currentPosition;
        private String destPosition;
        private JLabel aircraft;
        ArrayList<Vertex> result = new ArrayList<>();
        boolean up = true;

        @Override
        public void run() {
            if (!arrive()) {
                if (!deport) {
                    Vertex start = graphDecision.getVertex(currentPosition);
                    ArrayList<Edge1> edges = graphDecision.getConnectedEdge(start);
                    ArrayList<Edge1> except = new ArrayList<>();
                    for (Edge1 e : edges) {
                        //Collision c = getCollision(e.getStart().getName(), e.getDest().getName());
                        ArrayList<Collision> cs = getCollision(e.getStart().getName(), e.getDest().getName());
                        for (Collision c : cs) {
                            if (uav.getFactor() < c.getFactor()) {
                                System.out.println(c.getFactor());
                                System.out.println("except" + e.getStart().getName() + uav.getName());
                                System.out.println("except" + e.getDest().getName() + uav.getName());
                                if (!except.contains(e)) {
                                    except.add(e);
                                }

                            }
                        }
                    }
                    result = graphDecision.Dijkstra(currentPosition, destPosition, except, uav.getName());
                    if (result == null) {
                        result = graphDecision.Dijkstra(currentPosition, destPosition);
                    }
                }
                vetex = result.get(0);
                Vertex next = result.get(1);
                System.out.println("vetex" + vetex.getName());
                System.out.println("next" + next.getName());
                double x = next.getPosition().getX() - vetex.getPosition().getX();
                double y = next.getPosition().getY() - vetex.getPosition().getY();
                pathDirection = y / x;
                pathConstant = next.getPosition().getY() - (pathDirection) * next.getPosition().getX();
                if (uav.getPosition().getX() <= next.getPosition().getX()) {
                    double xp = uav.getPosition().getX() + 1;
                    double yp = uav.getPosition().getY() + (y / x);
                    //fly in the path
                    // System.out.println(!Isintersect(xp, yp));
                    // System.out.println("y" + (uav.getPosition().getX() * pathDirection + pathConstant));
                    // System.out.println("yy" + uav.getPosition().getY());
                    // System.out.println("x/y" + pathDirection + "d" + pathConstant);
                    if (!Isintersect(xp, yp) && Math.abs(uav.getPosition().getX() * pathDirection + pathConstant - uav.getPosition().getY()) <= 3) {
                        //  System.out.println("c0");
                        uav.setLastPosition(uav.getPosition());
                        moving(xp, yp, uav, aircraft);
                        uav.setDirection((next.getPosition().getY() - uav.getPosition().getY()) / (next.getPosition().getX() - uav.getPosition().getX()));
                        deport = true;
                    } else {
                        //fly around the first half of the arc,every normal next step will intersect with the danger area
                        if (Isintersect(xp, yp)) {
                            ////////// System.out.println(Isintersect(xp, yp));
                            //Collision c = getCollision(vetex.getName(), next.getName());
                            ArrayList<Collision> cs = getCollision(vetex.getName(), next.getName());
                            System.out.println(vetex.getName() + next.getName());

                            for (Collision c : cs) {
                                System.out.println("#####" + c.getFactor());
                                if (uav.getFactor() < c.getFactor()) {
                                    System.out.println("/////////" + c.getFactor());
                                    int xc = c.getX();
                                    int yc = c.getY();
                                    if (xc * pathDirection + pathConstant >= yc) {
                                        System.out.println("?????" + (xc * pathDirection + pathConstant));
                                        System.out.println("????" + yc);
                                        double xpAfter = uav.getPosition().getX() + 1;
                                        double ypAfter = uav.getPosition().getY() + (y / x) + 2;
                                        uav.setLastPosition(uav.getPosition());
                                        moving(xpAfter, ypAfter, uav, aircraft);
                                        uav.setDirection((next.getPosition().getY() - uav.getPosition().getY()) / (next.getPosition().getX() - uav.getPosition().getX()));
                                        deport = true;
                                        up = false;
                                    } else {
                                        System.out.println("2?????" + xc * pathDirection + pathConstant);
                                        System.out.println("2????" + yc);
                                        double xpAfter = uav.getPosition().getX() + 1;
                                        double ypAfter = uav.getPosition().getY() + (y / x) - 2;
                                        uav.setLastPosition(uav.getPosition());
                                        moving(xpAfter, ypAfter, uav, aircraft);
                                        uav.setDirection((next.getPosition().getY() - uav.getPosition().getY()) / (next.getPosition().getX() - uav.getPosition().getX()));
                                        deport = true;
                                        up = true;
                                    }
                                } else {
                                    // System.out.println("c3");
                                    double xpAfter = uav.getPosition().getX() + 1;
                                    double ypAfter = uav.getPosition().getY() + (y / x);
                                    uav.setLastPosition(uav.getPosition());
                                    moving(xpAfter, ypAfter, uav, aircraft);
                                    uav.setDirection((next.getPosition().getY() - uav.getPosition().getY()) / (next.getPosition().getX() - uav.getPosition().getX()));
                                    deport = true;
                                }
                            }
                        } //fly around the half of the arc,the point is arriving a line that parrel with the path,every next step will not intersect but it doesn't fly in path
                        else {
                            // System.out.println("c4");
                            if (up == false) {
                                double xpAfter = uav.getPosition().getX() + 1;
                                double ypAfter = uav.getPosition().getY() + (y / x) - 2;
                                uav.setLastPosition(uav.getPosition());
                                moving(xpAfter, ypAfter, uav, aircraft);
                                uav.setDirection((next.getPosition().getY() - uav.getPosition().getY()) / (next.getPosition().getX() - uav.getPosition().getX()));
                                deport = true;
                            } else {
                                double xpAfter = uav.getPosition().getX() + 1;
                                double ypAfter = uav.getPosition().getY() + (y / x) + 2;
                                uav.setLastPosition(uav.getPosition());
                                moving(xpAfter, ypAfter, uav, aircraft);
                                uav.setDirection((next.getPosition().getY() - uav.getPosition().getY()) / (next.getPosition().getX() - uav.getPosition().getX()));
                                deport = true;
                            }
                        }
                    }
                } else {
                    currentPosition = result.get(1).getName();
                    flyPosition = 0;
                    deport = false;
                }
            }
        }

        public ArrayList<Collision> getCollision(String s, String d) {
            ArrayList<Collision> collisions = new ArrayList<>();
            for (Collision c : graphDecision.getCollisionlist()) {
                if ((c.getStart().equals(s) && c.getEnd().equals(d)) || (c.getStart().equals(d) && c.getEnd().equals(s))) {
                    //return c;
                    collisions.add(c);
                }
            }
            // return null;
            return collisions;
        }

        public boolean isInline(Position p, double direction, double constant) {
            double x = p.getX();
            double y = p.getY();
            if (Math.abs(x * direction + constant - y) < 0.01) {
                return true;
            }
            return false;
        }

        public boolean finish() {
            double x = uav.getPosition().getX();
            double y = uav.getPosition().getY();
            if ((pathDirection * x + pathConstant - y) <= 0.03) {
                finish = true;
            }
            return finish;
        }

        public boolean Isintersect(double x, double y) {
            for (Collision c : graphDecision.getCollisionlist()) {
                int cx = c.getX();
                int cy = c.getY();
                int cr = c.getRadius();
                if (Math.pow(x - cx, 2) + Math.pow(y - cy, 2) <= Math.pow(cr, 2)) {
                    ///////// System.out.println(x);
                    ///////// System.out.println(y);
                    return true;
                }
            }
            return false;
        }

        public boolean arrive() {
            Vertex x = graphDecision.getVertex(destPosition);
            if ((Math.abs(uav.getPosition().getX() - x.getPosition().getX()) <= 1) && (Math.abs(uav.getPosition().getY() - x.getPosition().getY()) <= 1)) {
                return true;
            }
            return false;
        }

        public Graph getGraphDecision() {
            return graphDecision;
        }

        public void setGraphDecision(Graph graphDecision) {
            this.graphDecision = graphDecision;
        }

        public ArrayList<Vertex> getResult() {
            return result;
        }

        public void setResult(ArrayList<Vertex> result) {
            this.result = result;
        }

        public Vertex getVetex() {
            return vetex;
        }

        public void setVetex(Vertex vetex) {
            this.vetex = vetex;
        }

        public boolean isFinish() {
            return finish;
        }

        public void setFinish(boolean finish) {
            this.finish = finish;
        }

        public double getPathDirection() {
            return pathDirection;
        }

        public void setPathDirection(double pathDirection) {
            this.pathDirection = pathDirection;

        }

        public boolean isDeport() {
            return deport;
        }

        public void setDeport(boolean deport) {
            this.deport = deport;
        }

        public double getPathConstant() {
            return pathConstant;
        }

        public void setPathConstant(double pathConstant) {
            this.pathConstant = pathConstant;
        }

        public UAV getUav() {
            return uav;
        }

        public void setUav(UAV uav) {
            this.uav = uav;
        }

        public String getCurrentPosition() {
            return currentPosition;
        }

        public void setCurrentPosition(String currentPosition) {
            this.currentPosition = currentPosition;
        }

        public String getDestPosition() {
            return destPosition;
        }

        public void setDestPosition(String destPosition) {
            this.destPosition = destPosition;
        }

        public JLabel getAircraft() {
            return aircraft;
        }

        public void setAircraft(JLabel aircraft) {
            this.aircraft = aircraft;
        }

    }

    public class WeatherAgent extends TimerTask {

        private Graph graphWeather;

        public void getData(Graph graph) {
            this.graphWeather = graph;
        }

        public Graph getChangedGraph() {
            return graphWeather;
        }

        @Override
        public void run() {
            //return changed graph
            // deleteWeatherCondition();
            // this.graphWeather = graph;
            System.out.println("************" + count);
            count++;
            if (count == 40) {
                for (Collision c : graph.getCollisionlist()) {
                    double f = Math.random();
                    BigDecimal b = new BigDecimal(f);
                    double factor = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                    c.setFactor(factor);
                }
                count = 0;
                for (int i = 0; i < graph.getCollisionlist().size(); i++) {
                    // g.draw(new Ellipse2D.Double(c.getX(), c.getY(), c.getRadius(), c.getRadius()));
                    Collision c = graph.getCollisionlist().get(i);
                    JLabel collision = collisions.get(i);
                    collision.setSize(c.getRadius(), c.getRadius());
                    collision.setLocation(c.getX(), c.getY());
                    // collision.setIcon(new ImageIcon("/Users/huyafei/NetBeansProjects/final/src/business/image/station.png"));
                    collision.setBackground(Color.red);
                    collision.setOpaque(true);
                    collision.setText(String.valueOf(c.getFactor()));
                }
            }
            //  
        }

        public void changeWeatherCondition() {
            /* for (Edge1 e : graph.getEdgelist()) {
             int r = 10;
             double f = Math.random();
             String s = e.getStart().getName();
             String d = e.getDest().getName();
             Collision collision = new Collision(((int) e.getStart().getPosition().getX() + (int) e.getDest().getPosition().getX()) / 2, ((int) e.getStart().getPosition().getY() + (int) e.getDest().getPosition().getY()) / 2, r, f, s, d);
             e.setWeight((int) (e.getWeight() * (f) + e.getWeight()));
             graph.getCollisionlist().add(collision);
             }*/
            //int num = (int) (Math.random() * graph.getCollisionlist().size());

        }

        public void deleteWeatherCondition() {
            /* Collision collision = new Collision((int) (Math.random() * 300), (int) (Math.random() * 250), (int) (Math.random() * 50));
             graph.getCollisionlist().add(collision);
             int num = (int) (Math.random() * graph.vertexCount());
             System.out.println(num);
             Vertex v = graph.getVertexlist().get(num);
             int weather = (int) (Math.random() * 2) + 1;
             System.out.println(weather);
             for (Edge1 e : graph.getConnectedEdge(v)) {
             e.setWeight(e.getWeight() * weather);
             }*/
            Collision c = graph.getCollisionlist().remove(0);
            for (Edge1 e : graph.getEdgelist()) {
                if (e.getStart().getName().equals(c.getStart()) && e.getDest().getName().equals(c.getEnd()) || e.getStart().getName().equals(c.getEnd()) && e.getDest().getName().equals(c.getStart())) {
                    e.setWeight((int) (e.getWeight() - (e.getWeight() * c.getFactor())));
                }
            }

        }

        public Graph getGraphWeather() {
            return graphWeather;
        }

        public void setGraphWeather(Graph graphWeather) {
            this.graphWeather = graphWeather;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startpoint = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        destinationpoint = new javax.swing.JComboBox();
        addWeather = new javax.swing.JButton();
        begin = new javax.swing.JButton();
        factor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        radius = new javax.swing.JTextField();
        startpoint1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        destinationpoint1 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        destinationpoint2 = new javax.swing.JComboBox();
        startpoint2 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        factor2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        factor1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        control = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        speed1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        speed2 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseClick(evt);
            }
        });
        setLayout(null);

        startpoint.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        startpoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startpointActionPerformed(evt);
            }
        });
        add(startpoint);
        startpoint.setBounds(1000, 20, 80, 27);

        jLabel2.setText("start");
        add(jLabel2);
        jLabel2.setBounds(950, 20, 29, 16);

        jLabel3.setText("dest");
        add(jLabel3);
        jLabel3.setBounds(950, 50, 30, 16);

        destinationpoint.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        destinationpoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationpointActionPerformed(evt);
            }
        });
        add(destinationpoint);
        destinationpoint.setBounds(1000, 50, 80, 27);

        addWeather.setText("add danger");
        addWeather.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWeatherActionPerformed(evt);
            }
        });
        add(addWeather);
        addWeather.setBounds(1130, 190, 114, 30);

        begin.setText("begin");
        begin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beginActionPerformed(evt);
            }
        });
        add(begin);
        begin.setBounds(950, 310, 79, 29);
        add(factor);
        factor.setBounds(1180, 140, 90, 28);

        jLabel1.setText("factor ");
        add(jLabel1);
        jLabel1.setBounds(1130, 140, 50, 16);

        jLabel4.setText("range");
        add(jLabel4);
        jLabel4.setBounds(1130, 100, 35, 16);
        add(radius);
        radius.setBounds(1180, 90, 90, 28);

        startpoint1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        startpoint1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startpoint1ActionPerformed(evt);
            }
        });
        add(startpoint1);
        startpoint1.setBounds(1180, 20, 90, 27);

        jLabel5.setText("start");
        add(jLabel5);
        jLabel5.setBounds(1130, 30, 29, 16);

        jLabel6.setText("dest");
        add(jLabel6);
        jLabel6.setBounds(1130, 60, 30, 16);

        destinationpoint1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        destinationpoint1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationpoint1ActionPerformed(evt);
            }
        });
        add(destinationpoint1);
        destinationpoint1.setBounds(1180, 50, 90, 27);

        jLabel7.setText("dest");
        add(jLabel7);
        jLabel7.setBounds(950, 200, 40, 16);

        destinationpoint2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        destinationpoint2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationpoint2ActionPerformed(evt);
            }
        });
        add(destinationpoint2);
        destinationpoint2.setBounds(1000, 200, 80, 27);

        startpoint2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        startpoint2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startpoint2ActionPerformed(evt);
            }
        });
        add(startpoint2);
        startpoint2.setBounds(1000, 160, 80, 27);

        jLabel8.setText("start");
        add(jLabel8);
        jLabel8.setBounds(950, 160, 29, 16);

        jLabel9.setText("factor");
        add(jLabel9);
        jLabel9.setBounds(950, 230, 50, 16);
        add(factor2);
        factor2.setBounds(1000, 230, 70, 28);

        jLabel10.setText("factor");
        add(jLabel10);
        jLabel10.setBounds(950, 80, 50, 16);
        add(factor1);
        factor1.setBounds(1000, 80, 80, 28);

        control.setColumns(20);
        control.setRows(5);
        jScrollPane1.setViewportView(control);

        add(jScrollPane1);
        jScrollPane1.setBounds(970, 410, 150, 140);

        jLabel11.setText("speed");
        add(jLabel11);
        jLabel11.setBounds(950, 120, 40, 16);
        add(speed1);
        speed1.setBounds(1000, 120, 80, 28);

        jLabel12.setText("speed");
        add(jLabel12);
        jLabel12.setBounds(950, 270, 100, 16);
        add(speed2);
        speed2.setBounds(1000, 270, 70, 28);
    }// </editor-fold>//GEN-END:initComponents

    private void addWeatherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWeatherActionPerformed
        // TODO add your handling code here:
        int r = Integer.valueOf(radius.getText());
        float f = Float.valueOf(factor.getText());
        String s = (String) startpoint1.getSelectedItem();
        String d = (String) destinationpoint1.getSelectedItem();
        Collision collision = new Collision(mouseX, mouseY, r, f, s, d);
        //Collision collision = new Collision(300, 123, 20);
        //Collision collision = new Collision((int) (Math.random() * 300), (int) (Math.random() * 250), (int) (Math.random() * 50));
        for (Edge1 e : graph.getEdgelist()) {
            if (e.getStart().getName().equals(s) && e.getDest().getName().equals(d) || e.getStart().getName().equals(d) && e.getDest().getName().equals(s)) {
                e.setWeight((int) (e.getWeight() * (f) + e.getWeight()));
            }
        }
        graph.getCollisionlist().add(collision);
    }//GEN-LAST:event_addWeatherActionPerformed

    private void startpointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startpointActionPerformed
        // TODO add your handling code here:
        String s = (String) startpoint.getSelectedItem();

    }//GEN-LAST:event_startpointActionPerformed

    private void destinationpointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationpointActionPerformed
        // TODO add your handling code here:
        String d = (String) destinationpoint.getSelectedItem();
    }//GEN-LAST:event_destinationpointActionPerformed

    private void beginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beginActionPerformed
        // TODO add your handling code here:
        if (!factor1.getText().isEmpty()) {
            String currentPosition = (String) startpoint.getSelectedItem();
            String destPosition = (String) destinationpoint.getSelectedItem();
            double factor = Double.valueOf(factor1.getText());
            Vertex start = graph.getVertex(currentPosition);
            UAV uav = new UAV();
            uav.setPosition(start.getPosition());
            uav.setFactor(factor);
            uav.setName("a");
            int speed = Integer.valueOf(speed1.getText());
            makeDecision(uav, currentPosition, destPosition, aircrafts.get(0), graph, speed);
        }

        if (!factor2.getText().isEmpty()) {
            String currentPosition1 = (String) startpoint2.getSelectedItem();
            String destPosition1 = (String) destinationpoint2.getSelectedItem();
            double factor1 = Double.valueOf(factor2.getText());
            Vertex start1 = graph.getVertex(currentPosition1);
            UAV uav1 = new UAV();
            uav1.setPosition(start1.getPosition());
            uav1.setFactor(factor1);
            uav1.setName("b");
            int speed1 = Integer.valueOf(speed2.getText());
            makeDecision(uav1, currentPosition1, destPosition1, aircrafts.get(1), graph, speed1);
        }
        addDanger();
    }//GEN-LAST:event_beginActionPerformed

    private void mouseClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClick
        // TODO add your handling code here:
        mouseX = evt.getX();
        mouseY = evt.getY();
        //System.out.println(mouseX);
        //System.out.println(mouseY);
        evt.getComponent();
    }//GEN-LAST:event_mouseClick

    private void startpoint1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startpoint1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startpoint1ActionPerformed

    private void destinationpoint1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationpoint1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinationpoint1ActionPerformed

    private void destinationpoint2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationpoint2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinationpoint2ActionPerformed

    private void startpoint2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startpoint2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startpoint2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addWeather;
    private javax.swing.JButton begin;
    private javax.swing.JTextArea control;
    private javax.swing.JComboBox destinationpoint;
    private javax.swing.JComboBox destinationpoint1;
    private javax.swing.JComboBox destinationpoint2;
    private javax.swing.JTextField factor;
    private javax.swing.JTextField factor1;
    private javax.swing.JTextField factor2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField radius;
    private javax.swing.JTextField speed1;
    private javax.swing.JTextField speed2;
    private javax.swing.JComboBox startpoint;
    private javax.swing.JComboBox startpoint1;
    private javax.swing.JComboBox startpoint2;
    // End of variables declaration//GEN-END:variables
}
