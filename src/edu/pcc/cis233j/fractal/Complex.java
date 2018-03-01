package edu.pcc.cis233j.fractal;

/**
 * An immutable class representing a complex number.
 * @author Cara Tang
 * Feb 1, 2002
 **/
public class Complex
{
  private double real, imaginary; // the real and imaginary pieces

  /**
   * Creates the complex number 0.0 + 0.0i
   **/
  public Complex() {
      real = imaginary = 0.0;
  }

  /**
   * Creates a complex number with real component real and imaginary component
   * imaginary, i.e., real + (imaginary)i
   * @param real the real component
   * @param imaginary the imaginary component
   **/
  public Complex(double real, double imaginary) {
      this.real = real;
      this.imaginary = imaginary;
  }

  /**
   * @return the real part of this complex number
   **/
  public double getReal() {
      return real;
  }

  /**
   * @return the imaginary part of this complex number
   **/
  public double getImaginary() {
      return imaginary;
  }

  /**
   * Adds two complex numbers.
   * @param other the complex number to add to this one
   * @return the complex number resulting from adding this to other
   **/
  public Complex add(Complex other) {
      return new Complex(real + other.getReal(),
                         imaginary + other.getImaginary());
  }

  /**
   * Multiplies two complex numbers.
   * @param other the complex number to multiply with this one
   * @return the complex number resulting from multiplying this with other
   * Note that the result might be a real number (i.e., the imaginary
   * part could be 0).
   **/
  public Complex multiply(Complex other) {
      double newReal = real * other.getReal() -
                       imaginary * other.getImaginary();
      double newImaginary = imaginary * other.getReal() +
                            real * other.getImaginary();
      return new Complex(newReal, newImaginary);
  }

  /**
   * @return the magnitude of this complex number (its distance from 0)
   **/
  public double magnitude() {
      return Math.sqrt(real*real + imaginary*imaginary);
  }

  /**
   * @return a string representation of this complex number
   **/
  public String toString() {
      return real + "+" + imaginary + "i";
  }
}
