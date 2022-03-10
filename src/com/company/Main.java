package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setTitle("calculator");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelTop = new JPanel(new GridLayout(2, 1));
        JPanel panel1 = new JPanel(new GridLayout(1, 1));
        JPanel panel2 = new JPanel(new GridLayout(4, 4));
        panel2.setBackground(Color.BLACK);

        panelTop.add(panel1);
        panelTop.add(panel2);

        frame.add(panelTop);

        JTextField text1 = new JTextField(100);

        JButton button1 = new JButton("0");
        JButton button2 = new JButton("1");
        JButton button3 = new JButton("2");
        JButton button4 = new JButton("3");
        JButton button5 = new JButton("4");
        JButton button6 = new JButton("5");
        JButton button7 = new JButton("6");
        JButton button8 = new JButton("7");
        JButton button9 = new JButton("8");
        JButton button10 = new JButton("9");
        JButton button11 = new JButton("+");
        JButton button12 = new JButton("-");
        JButton button13 = new JButton("*");
        JButton button14 = new JButton("/");
        JButton button15 = new JButton("=");
        JButton button16 = new JButton("C");

        panel1.add(text1);

        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(button4);
        panel2.add(button5);
        panel2.add(button6);
        panel2.add(button7);
        panel2.add(button8);
        panel2.add(button9);
        panel2.add(button10);
        panel2.add(button11);
        panel2.add(button12);
        panel2.add(button13);
        panel2.add(button14);
        panel2.add(button15);
        panel2.add(button16);

        frame.setVisible(true);
    }
}
