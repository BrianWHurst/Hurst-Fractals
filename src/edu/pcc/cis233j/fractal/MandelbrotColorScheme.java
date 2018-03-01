package edu.pcc.cis233j.fractal;

import java.awt.Color;

/**
 * MandelbrotColorScheme - a Mandelbrot color scheme
 * 7/2012
 * @author Cara Tang
 */
public abstract class MandelbrotColorScheme {
    private int maxIterations;
    
    public MandelbrotColorScheme(int maxIterations) {
        this.maxIterations = maxIterations;
    }
    
    public int getMaxIterations() {
        return maxIterations;
    }
    
    /**
     * Determine what color to paint a point when drawing a Mandelbrot fractal
     * based on the number of iterations to escape the threshold and/or the final Z value
     * @param numIterations
     * @param finalZ
     * @return the color
     */
    public abstract Color determineColor(int numIterations, Complex finalZ);
 
}
