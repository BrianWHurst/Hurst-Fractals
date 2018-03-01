package edu.pcc.cis233j.fractal;

import java.awt.*;

import javax.swing.*;
import java.awt.geom.*;

/**
 * Circle fractal
 * Created: 2/2002
 * Updated: 7/2012
 * @author Cara Tang
 */
@SuppressWarnings("serial")
public class CirclesPanel extends JPanel {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 320;

    private int numLevels;
    
    public CirclesPanel(int numLevels) {
        super();
        this.numLevels = numLevels;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    //-------------------------------------------------------------------
    // Draw a Circle fractal to the level given
    //-------------------------------------------------------------------
    public void drawCircles(Graphics2D g2, int x, int y, int diam, int level) {
        g2.draw(new Ellipse2D.Double(x, y, diam, diam));

        if (level > 1) {
            drawCircles(g2, x + diam / 4, y, diam / 2, level - 1);
            drawCircles(g2, x + diam / 4, y + diam / 2, diam / 2, level - 1);
        }
    }

    //-------------------------------------------------------------------
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint redblue = new GradientPaint(0, 0, Color.red, WIDTH, HEIGHT, Color.blue);
        g2.setPaint(redblue);
        g2.fill(new Rectangle2D.Double(0, 0, WIDTH, HEIGHT));

        g2.setPaint(Color.white);
        g2.setStroke(new BasicStroke(1.0f));
        drawCircles(g2, 20, 20, WIDTH - 40, numLevels);
    }
}
