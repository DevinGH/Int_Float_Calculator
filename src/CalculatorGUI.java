import java.awt.*;
import javax.swing.*;

public class CalculatorGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");

        frame.setSize(300, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel northPanel2 = new JPanel(new FlowLayout());
        JPanel centerPanel2 = new JPanel(new GridLayout(4, 4));
        JPanel southPanel2 = new JPanel(new BorderLayout());

        northPanel2.setSize(300, 100);
        northPanel2.setBackground(Color.black);
        centerPanel2.setSize(300, 300);
        centerPanel2.setBackground(Color.BLUE);
        southPanel2.setSize(300, 100);
        southPanel2.setBackground(Color.CYAN);

        JPanel southEastPanel3 = new JPanel(new FlowLayout());
        JPanel southWestPanel3 = new JPanel(new BorderLayout());

        JPanel swNorthPanel4 = new JPanel(new FlowLayout());
        JPanel swSouthPanel4 = new JPanel(new BorderLayout());

        JPanel swsWestPanel5 = new JPanel(new FlowLayout());
        JPanel swsEastPanel5 = new JPanel(new FlowLayout());

        /*
        Adding Panels and Sub-panels to frame
         */
        swSouthPanel4.add(swsWestPanel5, BorderLayout.WEST);
        swSouthPanel4.add(swsEastPanel5, BorderLayout.EAST);

        southWestPanel3.add(swNorthPanel4, BorderLayout.NORTH);
        southWestPanel3.add(swSouthPanel4, BorderLayout.SOUTH);

        southPanel2.add(southWestPanel3, BorderLayout.WEST);
        southPanel2.add(southEastPanel3, BorderLayout.EAST);

        mainPanel.add(northPanel2, BorderLayout.NORTH);
        mainPanel.add(centerPanel2, BorderLayout.CENTER);
        mainPanel.add(southPanel2, BorderLayout.SOUTH);

        frame.add(mainPanel);


    }
}
