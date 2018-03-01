package edu.pcc.cis233j.fractal;

import java.awt.*;

import javax.swing.*;
import java.awt.geom.*;

/**
 * Cantor set fractal
 * Created: 2/2002
 * Updated: 7/2012
 * @author Cara Tang
 */
@SuppressWarnings("serial")
public class CantorPanel extends JPanel {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 200;
    private static final int INC = 10;

    private int numLevels;

    public CantorPanel(int numLevels) {
        super();
        this.numLevels = numLevels;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
    // -------------------------------------------------------------------
    // Draw the Cantor set to the level given
    // -------------------------------------------------------------------
    public void drawCantor(Graphics2D g2, int x1, int x2, int y, int level) {
        Point2D.Double p1 = new Point2D.Double(x1, y);
        Point2D.Double p2 = new Point2D.Double(x2, y);

        g2.draw(new Line2D.Double(p1, p2));

        if (level > 1) {
            drawCantor(g2, x1, x1 + (x2 - x1) / 3, y + INC, level - 1);
            drawCantor(g2, x2 - (x2 - x1) / 3, x2, y + INC, level - 1);
        }
    }

    // -------------------------------------------------------------------
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint graycyan = new GradientPaint(0, 0, Color.gray, WIDTH, HEIGHT, Color.cyan);
        g2.setPaint(graycyan);
        g2.fill(new Rectangle2D.Double(0, 0, WIDTH, HEIGHT));

        g2.setPaint(Color.black);
        g2.setStroke(new BasicStroke(2.0f));
        drawCantor(g2, 20, WIDTH - 20, 50, numLevels);
    }
}
