package com.github.zachroyer;

/**
*
* @author Zachary Royer
*/
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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

        String[] initialValues = { "2", "3", "5", "1", "4", "8", "7", "6", "" };

        buttons = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
        JButton button = new JButton(initialValues[i]);
        if (initialValues[i].isEmpty()) {
            emptyButton = button;
        } else {
            button.setFont(new Font("Arial", Font.PLAIN, 40));
            button.addActionListener(this);
        }
        buttons.add(button);
        window.add(button);
    }

        for (JButton jButton : buttons) {
            if (jButton.getText().isEmpty()) {
                emptyButton = jButton;
            }
        }

        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) (e.getSource()); // JButton object, typecast of the button source from
        // ActionListener
        int clickedIndex = buttons.indexOf(buttonClicked);
        int emptyIndex = buttons.indexOf(emptyButton); // grabbing indexes of clickedand empty buttons

        if (isValidSwap(clickedIndex, emptyIndex)) {
            swap(buttonClicked, emptyButton);
            emptyButton = buttonClicked;

            for (JButton jButton : buttons) {
                if (jButton.getText().isEmpty()) {
                    emptyButton = jButton;
                    break;
                }
            }
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
        Container parent = buttonOne.getParent(); // Apparently the window JFrame is not the parent to the JButtons
        int indexOne = parent.getComponentZOrder(buttonOne);
        int indexTwo = parent.getComponentZOrder(buttonTwo);
        parent.setComponentZOrder(buttonOne, indexTwo); // This was tough to research
        parent.setComponentZOrder(buttonTwo, indexOne);
        parent.validate();
        parent.repaint();
        System.out.println("swapped " + buttonOne.getText() + " with " + buttonTwo.getText());

        // Update the buttons Array
        buttons.set(indexOne, buttonTwo);
        buttons.set(indexTwo, buttonOne);
    }
}
