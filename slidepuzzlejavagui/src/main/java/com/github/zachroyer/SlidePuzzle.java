package com.github.zachroyer;

/**
*
* @author Zachary Royer
*/
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

public class SlidePuzzle implements ActionListener {

    private ArrayList<JButton> buttons;
    private JFrame window;
    private JButton emptyButton;

    public SlidePuzzle() {
        window = new JFrame("Slide Puzzle");
        window.setLayout(new GridLayout(3, 3, 5, 5));
        window.setSize(400, 400);
        window.setLocationRelativeTo(null);

        buttons = new ArrayList<>(9);

        for (int i = 0; i < 9; i++) {
            if (i != 8) {
                buttons.add(i, new JButton(String.valueOf(i + 1)));
                window.add(buttons.get(i));
                buttons.get(i).setFont(new Font("Arial", Font.PLAIN, 40));
                buttons.get(i).addActionListener(this);

            } else {
                emptyButton = new JButton();
                buttons.add(i, emptyButton);
                window.add(emptyButton);

            }
        }

        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) (e.getSource()); // JButton object, type cast of the button source from ActionListener
        int clickedIndex = buttons.indexOf(buttonClicked);  
        int emptyIndex = buttons.indexOf(emptyButton);  //grabbing indexes of clicked and empty buttons

        if (isValidSwap(clickedIndex, emptyIndex)) {
            swap(buttonClicked, emptyButton);
        }

    }

    private boolean isValidSwap(int clickedIndex, int emptyIndex) {
        int difference = Math.abs(clickedIndex - emptyIndex);
        if (difference == 1 || difference == 3) {
            return true;
        } else {
            return false;
        }
    }
    private void swap(JButton buttonOne, JButton buttonTwo) {
        Component temp = buttonOne.getParent();
        Container temp2 = buttonTwo.getParent();
        window.setComponentZOrder(buttonOne, buttons.indexOf(temp2)); // This was tough to figure out
        window.setComponentZOrder(buttonTwo, buttons.indexOf(temp));
        window.repaint();

    }
}
