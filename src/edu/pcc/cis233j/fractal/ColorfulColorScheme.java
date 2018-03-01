package edu.pcc.cis233j.fractal;

import java.awt.Color;

/**
 * ColorfulColorScheme - a Mandelbrot color scheme that depends on the number of iterations
 * to escape the threshold as well as the final Z value
 * 7/2012
 * @author Cara Tang
 */
public class ColorfulColorScheme extends MandelbrotColorScheme {

    public ColorfulColorScheme(int maxIterations) {
        super(maxIterations);
    }

    @Override
    public Color determineColor(int numIterations, Complex finalZ) {
        float nsmooth = numIterations + 1 
                - (float) (Math.log(Math.log(finalZ.magnitude())) / Math.log(2));
        return new Color(Color.HSBtoRGB(0.95f + 10 * nsmooth, 0.6f, 1.0f));
    }

}
