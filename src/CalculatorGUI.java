import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class CalculatorGUI {
    public CalculatorGUI(int width, int height) {
        JFrame frame = new JFrame("Calculator");

        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel northPanel2 = new JPanel(new FlowLayout());
        JPanel centerPanel2 = new JPanel(new GridLayout(4, 4, 10, 20));

        JPanel southPanel2 = new JPanel(new BorderLayout());

        northPanel2.setBackground(Color.black);
        northPanel2.setBorder(new EmptyBorder(35, 20, 5, 20));
        northPanel2.setPreferredSize(new Dimension(width, 100));
        centerPanel2.setBackground(Color.BLUE);
        centerPanel2.setPreferredSize(new Dimension(width, 300));
        southPanel2.setBackground(Color.CYAN);
        southPanel2.setPreferredSize(new Dimension(width, 100));

        JPanel radioPanel = new JPanel(new FlowLayout());
        radioPanel.setBackground(Color.ORANGE);

        JPanel southEastPanel3 = new JPanel(new FlowLayout());
        JPanel southWestPanel3 = new JPanel(new BorderLayout());

        JPanel swNorthPanel4 = new JPanel(new FlowLayout());
        JPanel swSouthPanel4 = new JPanel(new BorderLayout());

        JPanel swsWestPanel5 = new JPanel(new FlowLayout());
        JPanel swsEastPanel5 = new JPanel(new FlowLayout());

        /*
        Creating Components
         */
        JTextField display = new JTextField(25);
        display.setPreferredSize(new Dimension(100, 40));

        JRadioButton calcPowerON = new JRadioButton("On");
        JRadioButton calcPowerOFF = new JRadioButton("Off");
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        JButton button3 = new JButton();
        JButton button4 = new JButton();
        JButton button5 = new JButton();
        JButton button6 = new JButton();
        JButton button7 = new JButton();
        JButton button8 = new JButton();
        JButton button9 = new JButton();
        JButton button10 = new JButton();
        JButton button11 = new JButton();
        JButton button12 = new JButton();
        JButton button13 = new JButton();
        JButton button14 = new JButton();
        JButton button15 = new JButton();



        /*
        Adding components to panels
         */
        northPanel2.add(display);

        radioPanel.add(calcPowerON);
        radioPanel.add(calcPowerOFF);
        centerPanel2.add(radioPanel);
        centerPanel2.add(button1);
        centerPanel2.add(button2);
        centerPanel2.add(button3);
        centerPanel2.add(button4);
        centerPanel2.add(button5);
        centerPanel2.add(button6);
        centerPanel2.add(button7);
        centerPanel2.add(button8);
        centerPanel2.add(button9);
        centerPanel2.add(button10);
        centerPanel2.add(button11);
        centerPanel2.add(button12);
        centerPanel2.add(button13);
        centerPanel2.add(button14);
        centerPanel2.add(button15);


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
        frame.pack();

    }

    public static void main(String[] args) {
        CalculatorGUI calc = new CalculatorGUI(300, 500);
    }
}
