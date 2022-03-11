import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.*;


public class CalculatorGUI {
    private static int width;
    private static int height;
    private static JFrame frame;

    public CalculatorGUI(int width, int height) {
        this.width = width;
        this.height = height;

        JFrame frame = new JFrame("Calculator");

        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.frame = frame;
    }

    public static void GUIInit(){
        CalculatorGUI calc = new CalculatorGUI(300, 500);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel northPanel2 = new JPanel(new FlowLayout());
        JPanel centerPanel2 = new JPanel(new GridLayout(4, 4, 10, 25));
        JPanel southPanel2 = new JPanel(new BorderLayout());

        northPanel2.setBackground(Color.black);
        northPanel2.setBorder(new EmptyBorder(35, 20, 10, 20));
        northPanel2.setPreferredSize(new Dimension(width, 100));

        centerPanel2.setBackground(Color.BLACK);
        centerPanel2.setPreferredSize(new Dimension(width, 200));
        centerPanel2.setBorder(new EmptyBorder(5, 5, 10, 5));

        southPanel2.setBackground(Color.BLACK);
        southPanel2.setPreferredSize(new Dimension(width, 100));

        JPanel radioPanel = new JPanel(new FlowLayout());
        radioPanel.setBackground(Color.BLACK);
        radioPanel.setPreferredSize(new Dimension(40, 40));

        JPanel southEastPanel3 = new JPanel(new FlowLayout());

        southEastPanel3.setPreferredSize(new Dimension(70, 90));
        southEastPanel3.setBackground(Color.BLACK);

        JPanel southWestPanel3 = new JPanel(new BorderLayout());

        southWestPanel3.setPreferredSize(new Dimension(230, 90));
        southWestPanel3.setBackground(Color.BLACK);

        JPanel swNorthPanel4 = new JPanel(new GridLayout(1, 3, 10, 5));

        swNorthPanel4.setBackground(Color.BLACK);
        swNorthPanel4.setPreferredSize(new Dimension(230, 50));
        swNorthPanel4.setBorder(new EmptyBorder(5, 5, 5, 5));

        JPanel swSouthPanel4 = new JPanel(new BorderLayout());

        swSouthPanel4.setBackground(Color.BLACK);
        swSouthPanel4.setPreferredSize(new Dimension(230, 50));
        swSouthPanel4.setBorder(new EmptyBorder(0, 5, 5, 5));

        JPanel swsWestPanel5 = new JPanel(new FlowLayout());

        swsWestPanel5.setPreferredSize(new Dimension(145, 50));
        swsWestPanel5.setBackground(Color.BLACK);

        JPanel swsEastPanel5 = new JPanel(new FlowLayout());

        swsEastPanel5.setPreferredSize(new Dimension(75, 50));
        swsEastPanel5.setBackground(Color.BLACK);


        /*
        Creating Components
         */
        /*
        Components for North panel
         */
        JTextField display = new JTextField(25);
        display.setPreferredSize(new Dimension(100, 40));

        /*
        Components for Central panel
         */
        ButtonGroup group = new ButtonGroup();

        JRadioButton calcPowerON = new JRadioButton("on");
        calcPowerON.setBackground(Color.black);
        calcPowerON.setForeground(Color.WHITE);
        JRadioButton calcPowerOFF = new JRadioButton("off");
        calcPowerOFF.setBackground(Color.black);
        calcPowerOFF.setForeground(Color.WHITE);

        String[] calcOperationArray = {"C", "DEL", "/", "\u221A", "x\u00B2", "1/x", "-",
                "7", "8", "9", "x", "4", "5", "6", "+"};

        JButton[] calcButtonArray = {new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
                new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
                new JButton()};

        calcButtonArray[0].setBackground(Color.RED);
        calcButtonArray[0].setForeground(Color.WHITE);
        calcButtonArray[1].setBackground(Color.RED);
        calcButtonArray[1].setForeground(Color.WHITE);
        calcButtonArray[2].setBackground(Color.ORANGE);
        calcButtonArray[6].setBackground(Color.ORANGE);
        calcButtonArray[10].setBackground(Color.ORANGE);
        calcButtonArray[14].setBackground(Color.ORANGE);

        group.add(calcPowerOFF);
        group.add(calcPowerON);

        /*
        Components for South panel
         */
        JButton eqButton = new JButton("=");
        eqButton.setBackground(Color.ORANGE);
        eqButton.setPreferredSize(new Dimension(60, 90));

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");

        JButton zeroButton = new JButton("0");

        zeroButton.setPreferredSize(new Dimension(140, 50));

        JButton decimalButton = new JButton(".");

        decimalButton.setPreferredSize(new Dimension(65, 50));

        /*
        Adding components to panels
         */
        /*
        North Panel
         */
        northPanel2.add(display);

        /*
        Center panel
         */
        radioPanel.add(calcPowerON);
        radioPanel.add(calcPowerOFF);
        centerPanel2.add(radioPanel);

        for(int i = 0; i < calcButtonArray.length; i++){
            calcButtonArray[i].setText("" + calcOperationArray[i]);
            calcButtonArray[i].setFont(new Font("Arial", Font.BOLD, 14));
            centerPanel2.add(calcButtonArray[i]);
        }

        /*
        South Panel
         */
        southEastPanel3.add(eqButton);
        swNorthPanel4.add(button1);
        swNorthPanel4.add(button2);
        swNorthPanel4.add(button3);
        swsWestPanel5.add(zeroButton);
        swsEastPanel5.add(decimalButton);

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
        GUIInit();
    }
}
