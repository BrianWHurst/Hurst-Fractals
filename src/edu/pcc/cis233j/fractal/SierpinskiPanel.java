package edu.pcc.cis233j.fractal;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Sierpinski triangle fractal
 * Created: 1/2002
 * Updated: 7/2012
 * @author Cara Tang
 */
@SuppressWarnings("serial")
public class SierpinskiPanel extends JPanel {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private int numLevels;

    public SierpinskiPanel(int numLevels) {
        super();
        this.numLevels = numLevels;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public int getNumLevels() {
        return this.numLevels;
    }
    
    public void setNumLevels(int numLevels) {
        if (numLevels >= 0) {
            this.numLevels = numLevels;
        }
    }

    // ----------------------------------------------------------------------
    // Draws a Sierpinski triangle of the given level.
    // For visualization purposes, p1 is the top point, p2 is the left
    // point, p3 is the right point.
    // ----------------------------------------------------------------------
    protected void drawTriangle(Graphics2D g2, int level, Point2D.Double p1,
                                Point2D.Double p2, Point2D.Double p3) {
        g2.draw(new Line2D.Double(p1, p2));
        g2.draw(new Line2D.Double(p2, p3));
        g2.draw(new Line2D.Double(p1, p3));

        if (level > 0) {
            Point2D.Double m12 = getMidpoint(p1, p2);
            Point2D.Double m13 = getMidpoint(p1, p3);
            Point2D.Double m23 = getMidpoint(p2, p3);
            drawTriangle(g2, level - 1, p1, m12, m13);
            drawTriangle(g2, level - 1, m12, p2, m23);
            drawTriangle(g2, level - 1, m23, m13, p3);
        }
    }

    // ----------------------------------------------------------------------
    private Point2D.Double getMidpoint(Point2D.Double p1, Point2D.Double p2) {
        return new Point2D.Double((p1.getX() + p2.getX()) / 2,
                (p1.getY() + p2.getY()) / 2);
    }

    // ----------------------------------------------------------------------
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(1.0f));
        GradientPaint bluegold = new GradientPaint(0, 0, Color.blue, WIDTH, HEIGHT, Color.yellow);
        g2.setPaint(bluegold);
        g2.fill(new Rectangle2D.Double(0, 0, WIDTH, HEIGHT));

        g2.setPaint(Color.black);
        drawTriangle(g2, numLevels,
                new Point2D.Double(WIDTH / 2.0, HEIGHT / 2.0 - 200),
                new Point2D.Double(WIDTH / 2.0 - 200, HEIGHT / 2.0 + 160),
                new Point2D.Double(WIDTH / 2.0 + 200, HEIGHT / 2.0 + 160));
    }
}
