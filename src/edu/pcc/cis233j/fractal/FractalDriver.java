package edu.pcc.cis233j.fractal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A program that displays one of a selection of fractals, and allows the user
 * to select which fractal is displayed.
 *
 * @author Cara Tang & Brian Hurst
 * @version 2013.03.01
 * <p>
 * Changes since last version:
 * - Added fractals to allFractals Array field
 * - Added fractals to constructor
 * - Modified the constructor to create and set up a combo box for the fractals
 * - Modified actionPerformed to get the fractal a user selects and display it
 */
public class FractalDriver {
    private static final int WIDTH = 350;
    private static final int HEIGHT = 300;
    private static final String CANTOR = "Cantor";
    private static final String CIRCLE = "Circle";
    private static final String MANDELBROT = "Mandelbrot";
    private static final String SIERPINSKI = "Sierpinski";
    private static final String[] allFractals = {CANTOR, CIRCLE, MANDELBROT, SIERPINSKI};

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel fractalCards;
    private JComboBox<String> fractalChooser;

    /**
     * Create a FractalDriver
     */
    public FractalDriver() {
        makeFrame();
    }

    /**
     * Create the FractalDriver GUI
     */
    private void makeFrame() {
        frame = new JFrame("Fractals!");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createContents();
        frame.setVisible(true);
    }

    /**
     * Create the contents of the main window
     * A combo box at the top controls selection of which fractal panel is displayed
     */
    private void createContents() {
        // Create circle, mandelbrot, and sierpinski panels in a scroll pane
        JScrollPane cantorPane = new JScrollPane(new CantorPanel(6));
        JScrollPane circlePane = new JScrollPane(new CirclesPanel(6));
        JScrollPane mandelbrotPane = new JScrollPane(new MandelbrotPanel(6));
        JScrollPane sierpinskiPane = new JScrollPane(new SierpinskiPanel(6));

        // Create cardLayout
        cardLayout = new CardLayout();

        // fractalCards panel and set its layout to cardLayout
        fractalCards = new JPanel();

        // Set the card layout
        fractalCards.setLayout(cardLayout);

        // Add the fractals to fractalCards
        fractalCards.add(cantorPane, CANTOR);
        fractalCards.add(circlePane, CIRCLE);
        fractalCards.add(mandelbrotPane, MANDELBROT);
        fractalCards.add(sierpinskiPane, SIERPINSKI);

        // Creates fractalChooser combo box
        fractalChooser = new JComboBox<String>(allFractals);

        // adds ComboListener to the fractalChooser combo box
        fractalChooser.addActionListener(new ComboListener());

        // combo box is at NORTH
        frame.add(fractalChooser, BorderLayout.NORTH);

        // fractalCards panel is at CENTER
        frame.add(fractalCards, BorderLayout.CENTER);
    }

    /**
     * Listen to the combo box and switch the displayed fractal when the selection changes
     */
    private class ComboListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            // Get the String of the selected card from the combo box
            String name = (String) fractalChooser.getSelectedItem();

            // Adjust the card layout to show the selected card
            // If the name of the card is not null, show that card
            if (name != null) {
                cardLayout.show(fractalCards, name);
            }
        }
    }

    public static void main(String[] args) {
        new FractalDriver();
    }

}