package com.github.zachroyer;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.util.ArrayList;

public class SlidePuzzle implements ActionListener {

    int[] grid;
    JButton[] buttons;

    public SlidePuzzle() {
        JFrame window = new JFrame("Slide Puzzle");
        window.setLayout(new GridLayout(3, 3, 5, 5));
        window.setSize(400, 400);
        window.setLocationRelativeTo(null);

        buttons = new JButton[9];
        grid = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, }; //Represents JButton location in grid
        
        for (int i = 0; i < 9; i++) {
            if (i != 8) {
                buttons[i] = new JButton(String.valueOf(i + 1));
                window.add(buttons[i]);
                buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i].addActionListener(this);
            } else {
                buttons[i] = new JButton();
                window.add(buttons[i]);

            }
        }

        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        System.out.println(grid.toString());
        System.out.println(buttons.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        (e.getSource());
        swap(e.getSource(), )
        // System.out.println("Button" + JButton.indexOf(this) + "clicked");

    }

    private void swap(JButton buttonOne, JButton buttonTwo) {
        Container temp = buttonOne.getParent();
        Container temp2 = buttonTwo.getParent();
        temp.setComponentZOrder(temp, buttonOne.);

    }

    private void swapValues(int index1, int index2) {
        int temp = grid[index1];
        grid[index1] = grid[index2];
        grid[index2] = temp;

    }
}
