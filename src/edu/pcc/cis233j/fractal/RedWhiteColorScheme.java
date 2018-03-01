package edu.pcc.cis233j.fractal;

import java.awt.Color;

/**
 * RedWhiteColorScheme - a Mandelbrot color scheme in reds and whites
 * 7/2012
 * @author Cara Tang
 */
public class RedWhiteColorScheme extends MandelbrotColorScheme {
    public RedWhiteColorScheme(int maxIterations) {
        super(maxIterations);
    }

    @Override
    public Color determineColor(int numIterations, Complex finalZ) {
         float rgb = (getMaxIterations() - numIterations)/(float)getMaxIterations();
         return new Color((int)(rgb*(Math.pow(2, 24)-1)));
    }

}
