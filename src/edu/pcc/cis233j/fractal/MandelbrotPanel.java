package edu.pcc.cis233j.fractal;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Mandelbrot set fractal
 * Created: 2/2002
 * Updated: 7/2012
 * @author Cara Tang
 */
@SuppressWarnings("serial")
public class MandelbrotPanel extends JPanel {
    private class TestCResult {
        public int numIterations;
        public Complex finalZ;
        public TestCResult(int numIterations, Complex finalZ) {
            this.numIterations = numIterations;
            this.finalZ = finalZ;
        }
    }
    
    private static final int SIZE = 500;
    private static final double START_R = -2.05;
    private static final double END_R = 0.95;
    private static final double START_I = -1.4;
    private static final double END_I = 1.6;
    private static final double RANGE_R = END_R - START_R;
    private static final double RANGE_I = END_I - START_I;

    private int maxIterations;
    private MandelbrotColorScheme colorScheme;

    public MandelbrotPanel(int maxIterations) {
        super();
        this.maxIterations = maxIterations;
        colorScheme = new BasicColorScheme(maxIterations);
        setPreferredSize(new Dimension(SIZE, SIZE));
    }

    public int getMaxIterations() {
        return this.maxIterations;
    }
    
    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
    }
    
    public MandelbrotColorScheme getColorScheme() {
        return this.colorScheme;
    }
    
    public void setColorScheme(MandelbrotColorScheme colorScheme) {
        this.colorScheme = colorScheme;
    }
    
    // ----------------------------------------------------------------------
    // Plot the Mandelbrot set
    // ----------------------------------------------------------------------
    protected void plotMandelbrot(Graphics2D g2) {
            for (int x = 0; x < SIZE; x++) {
                for (int y = 0; y < SIZE; y++) {
                    Complex c = new Complex(START_R + ((double) x * RANGE_R / SIZE),
                                            START_I + ((double) y * RANGE_I / SIZE));
                    TestCResult result = testC(c, maxIterations);
                    Color color = colorScheme.determineColor(result.numIterations, result.finalZ);
                    drawPixel(g2, x, y, color);
                }
            }
    }

    // ----------------------------------------------------------------------
    private void drawPixel(Graphics2D g2, int x, int y, Color color) {
        g2.setPaint(color);
        Point2D.Double point = new Point2D.Double(x, y);
        Point2D.Double point2 = new Point2D.Double(x, y + 1);
        g2.draw(new Line2D.Double(point, point2));
    }

    // ----------------------------------------------------------------------
    // Test the complex number C to see if it is in the Mandelbrot set.
    // Return the number of iterations it took for the magnitude to pass 2
    // (or maxIterations if 2 was never passed) and the final Z
    // ----------------------------------------------------------------------
    private TestCResult testC(Complex c, int maxIterations) {
        Complex z = new Complex();
        int ind = 0;

        for (ind = 0; ind < maxIterations; ind++) {
            z = z.multiply(z).add(c);
            if (z.magnitude() >= 2)
                break;
        }
        return new TestCResult(ind, z);
    }

    // ----------------------------------------------------------------------
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        plotMandelbrot(g2);
    }
}
