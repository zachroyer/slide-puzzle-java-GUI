package com.github.zachroyer;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.util.ArrayList;

public class SlidePuzzle implements ActionListener {

    public SlidePuzzle() {

        JFrame window = new JFrame("Slide Puzzle");
        window.setLayout(new GridLayout(3, 3, 5, 5));
        window.setSize(400, 400);
        window.setLocationRelativeTo(null);

        JButton[] buttons = new JButton[9];
        ArrayList<Integer> grid = new ArrayList(9);
        for (int i = 0; i < 9; i++) {
            if (i != 8) {
                buttons[i] = new JButton(String.valueOf(i + 1));
                window.add(buttons[i]);
                buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
                grid.add(i);
            } else {
                buttons[i] = new JButton();
                window.add(buttons[i]);

            }
        }

        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        System.out.println(grid.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
