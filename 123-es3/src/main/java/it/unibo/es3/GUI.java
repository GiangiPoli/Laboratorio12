package it.unibo.es3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI for the game.
 */
public final class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final List<JButton> cells = new ArrayList<>();
    private final transient Logics logics;

    /**
     * Constructor.
     *
     * @param width the size of the grid
     */
    public GUI(final int width) {
        this.logics = new LogicsImpl(width);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Create a panel with a grid layout
        final JPanel panel = new JPanel(new GridLayout(width, width));
        this.getContentPane().add(panel);
        // Create buttons and add them to the panel
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                final var pos = new Pair<>(j, i);
                final JButton button = new JButton(logics.startRandomly(pos));
                this.cells.add(button);
                button.addActionListener(e -> {
                    if ("*".equals(button.getText())) {
                        expandCells(pos, width);
                        if (logics.toQuit()) {
                            dispose();
                        }
                    }
                });
                panel.add(button);
            }
        }
        pack();
        this.setVisible(true);
    }

    //Class Method

    /**
     * In this method i set the near button of the pressed button. 
     * 
     * @param pos indicate the position of the pressed button to set ther near one
     * @param tableWidth to know the limit of the table
     */
    private void expandCells(final Pair<Integer, Integer> pos, final int tableWidth) {
        final List<List<Boolean>> newPos = logics.changeNearCells(pos);
        int counter = 0;
        for (int i = 0; i < tableWidth; i++) {
            for (int j = 0; j < tableWidth; j++) {
                if (newPos.get(j).get(i)) {
                    cells.get(counter).setText("*");
                }
                counter++;
            }
        }
    }
}



