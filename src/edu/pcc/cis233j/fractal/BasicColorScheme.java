package edu.pcc.cis233j.fractal;

import java.awt.Color;

/**
 * BasicColorScheme - a basic Mandelbrot color scheme where the color of a point depends on
 * the number of iterations it took to escape the threshold
 * 7/2012
 * @author Cara Tang
 */
public class BasicColorScheme extends MandelbrotColorScheme {
    private float rMin;
    private float rMax;
    private float gMax;
    private float gMin;
    private float bMin;
    private float bMax;

    public BasicColorScheme(int maxIterations) {
        super(maxIterations);
        rMin = 0.0f;
        rMax = getMaxIterations() / 2.0f;
        gMax = getMaxIterations() * 3.0f / 4.0f;
        gMin = getMaxIterations() / 4.0f;
        bMin = getMaxIterations() / 2.0f;
        bMax = getMaxIterations();
    }
    
    @Override
    public Color determineColor(int numIterations, Complex finalZ) {
        float r, g, b;
        if (numIterations > bMax || numIterations < bMin) {
            b = 0;
        }
        else {
            b = (bMax - numIterations) / bMax;
        }
        if (numIterations > gMax || numIterations < gMin) {
            g = 0;
        }
        else {
            g = (numIterations - gMin) / (gMax - gMin);
        }
        if (numIterations > rMax || numIterations < rMin) {
            r = 0;
        }
        else {
            r = (numIterations - rMin) / (rMax - rMin);
        }

        Color color = new Color(r, g, b);
        return color;
    }

}
