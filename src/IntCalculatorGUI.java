/**
 * Group Members: Brianna Andres, Thomas Tien, Devin Hanson
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Class that sets up basic Calculator GUI
 */
public class IntCalculatorGUI extends IntCalculatorBehavior {
    /*
    Local Variables
     */
    private static int width;
    private static int height;
    private static JFrame frame;
    public static JTextField display;

    public static void main(String[] args) {
        GUIInit();
    }

    /**
     * Constructor for GUI frame
     */
    public IntCalculatorGUI() {
        this.width = 300;
        this.height = 500;

        JFrame frame = new JFrame("Calculator");

        frame.setSize(width, height);
        frame.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.frame = frame;
    }

    /**
     * Initializes and sets up calculator GUI
     */
    protected static JPanel GUIInit(){
        IntCalculatorGUI calc = new IntCalculatorGUI();

        JPanel mainPanel = new JPanel(new BorderLayout());

        mainPanel.add(northPanel(), BorderLayout.NORTH);
        mainPanel.add(centerPanel(), BorderLayout.CENTER);
        mainPanel.add(southPanel(), BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.pack();

        return mainPanel;
    }

    /**
     * Creates the North Panel containing the text display
     * @return
     */
    public static JPanel northPanel(){
        /*
        Creating North Panel
         */
        JPanel northPanel2 = new JPanel(new FlowLayout());

        northPanel2.setBackground(Color.BLACK);
        northPanel2.setBorder(new EmptyBorder(35, 20, 10, 20));
        northPanel2.setPreferredSize(new Dimension(width, height/5));

        /*
        Components for panel
         */
        display = new JTextField(25);
        display.setPreferredSize(new Dimension(100, 40));
        display.setEditable(false);

        /*
        Adding Components to panel
         */
        northPanel2.add(display);

        return northPanel2;
    }

    /**
     * Creates Radio Button Panel in order to contain to Radio buttons on the same block
     * @return
     */
    public static JPanel radioPanel(){
        /*
        Creating Radio Panel
         */
        JPanel radioPanel = new JPanel(new GridLayout(2, 1));
        radioPanel.setBackground(Color.BLACK);

         /*
        Components for panel
         */
        ButtonGroup group = new ButtonGroup();

        JRadioButton calcPowerON = new JRadioButton("on");
        calcPowerON.setBackground(Color.black);
        calcPowerON.setForeground(Color.WHITE);
        calcPowerON.addActionListener(e -> {
            display.setText(takeIntAction(e));
        });

        JRadioButton calcPowerOFF = new JRadioButton("off");
        calcPowerOFF.setBackground(Color.black);
        calcPowerOFF.setForeground(Color.WHITE);
        calcPowerOFF.addActionListener(e -> {
            display.setText(takeIntAction(e));
        });

        group.add(calcPowerOFF);
        group.add(calcPowerON);

        /*
        Adding Components to panel
         */
        radioPanel.add(calcPowerON);
        radioPanel.add(calcPowerOFF);

        return radioPanel;
    }

    /**
     * Creates the Center Panel containing most of the buttons on the calculator
     * @return
     */
    public static JPanel centerPanel(){
        /*
        Creating Center Panel
         */
        JPanel centerPanel2 = new JPanel(new GridLayout(4, 4, 10, 25));

        centerPanel2.setBackground(Color.BLACK);
        centerPanel2.setPreferredSize(new Dimension(width, height - 250));
        centerPanel2.setBorder(new EmptyBorder(5, 5, 10, 5));

        /*
        Components for panel
         */
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

        /*
        Adding Components to panel
         */

        centerPanel2.add(radioPanel());

        for(int i = 0; i < calcButtonArray.length; i++){
            calcButtonArray[i].setText("" + calcOperationArray[i]);
            calcButtonArray[i].setFont(new Font("Arial", Font.BOLD, 14));
            calcButtonArray[i].addActionListener(e -> {
                display.setText(takeIntAction(e));
            });
            centerPanel2.add(calcButtonArray[i]);
        }

        return centerPanel2;
    }

    /**
     * Creates the most bottom left of the calculator containing the zero button
     * @return
     */
    public static JPanel swsWestPanel(){
        /*
        Creating South West South West Panel
         */
        JPanel swsWestPanel5 = new JPanel(new FlowLayout());

        swsWestPanel5.setPreferredSize(new Dimension(145, 50));
        swsWestPanel5.setBackground(Color.BLACK);

        /*
        Components for panel
         */
        JButton zeroButton = new JButton("0");

        zeroButton.setPreferredSize(new Dimension(140, 50));
        zeroButton.addActionListener(e -> {
            display.setText(takeIntAction(e));
        });

        /*
        Adding Components to panel
         */
        swsWestPanel5.add(zeroButton);

        return swsWestPanel5;
    }

    /**
     * Creates the right of the bottom left of the calculator containing the decimal button
     * @return
     */
    public static JPanel swsEastPanel(){
        /*
        Creating South West South East Panel
         */
        JPanel swsEastPanel5 = new JPanel(new FlowLayout());

        swsEastPanel5.setPreferredSize(new Dimension(80, 50));
        swsEastPanel5.setBorder(new EmptyBorder(0, 15,5 ,0));
        swsEastPanel5.setBackground(Color.BLACK);

        /*
        Components for panel
         */
        JButton decimalButton = new JButton(".");

        decimalButton.setPreferredSize(new Dimension(65, 50));
        decimalButton.addActionListener(e -> {
            display.setText(takeIntAction(e));
        });

        /*
        Adding Components to panel
         */
        swsEastPanel5.add(decimalButton);

        return swsEastPanel5;
    }

    /**
     * Creates the entire bottom left of the calculator
     * @return
     */
    public static JPanel swSouthPanel(){
        /*
        Creating South West South Panel
         */
        JPanel swSouthPanel4 = new JPanel(new BorderLayout());

        swSouthPanel4.setBackground(Color.BLACK);
        swSouthPanel4.setPreferredSize(new Dimension(250, 50));
        swSouthPanel4.setBorder(new EmptyBorder(0, 1, 5, 5));

        /*
        Adding Components to panel
         */
        swSouthPanel4.add(swsWestPanel(), BorderLayout.WEST);
        swSouthPanel4.add(swsEastPanel(), BorderLayout.EAST);

        return swSouthPanel4;
    }

    /**
     * Creates the top of the bottom left of the calculator containing the 1, 2, and 3 buttons
     * @return
     */
    public static JPanel swNorthPanel(){
        /*
        Creating South West North Panel
         */
        JPanel swNorthPanel4 = new JPanel(new GridLayout(1, 3, 10, 5));

        swNorthPanel4.setBackground(Color.BLACK);
        swNorthPanel4.setPreferredSize(new Dimension(230, 50));
        swNorthPanel4.setBorder(new EmptyBorder(5, 5, 5, 5));

        /*
        Components for panel
         */
        JButton button1 = new JButton("1");
        button1.addActionListener(e -> {
            display.setText(takeIntAction(e));
        });
        JButton button2 = new JButton("2");
        button2.addActionListener(e -> {
            display.setText(takeIntAction(e));
        });
        JButton button3 = new JButton("3");
        button3.addActionListener(e -> {
            display.setText(takeIntAction(e));
        });

        /*
        Adding Components to panel
        */
        swNorthPanel4.add(button1);
        swNorthPanel4.add(button2);
        swNorthPanel4.add(button3);

        return swNorthPanel4;
    }

    /**
     * Creates the left of the bottom third of the calculator
     * @return
     */
    public static JPanel southWestPanel(){
        /*
        Creating South West Panel
         */
        JPanel southWestPanel3 = new JPanel(new BorderLayout());

        southWestPanel3.setPreferredSize(new Dimension(225, 90));
        southWestPanel3.setBackground(Color.BLACK);

        /*
        Adding Components to panel
        */
        southWestPanel3.add(swNorthPanel(), BorderLayout.NORTH);
        southWestPanel3.add(swSouthPanel(), BorderLayout.SOUTH);

        return southWestPanel3;
    }

    /**
     * Creates the bottom right of the calculator containing the equals button
     * @return
     */
    public static JPanel southEastPanel(){
        /*
        Creating South East Panel
         */
        JPanel southEastPanel3 = new JPanel(new FlowLayout());

        southEastPanel3.setPreferredSize(new Dimension(70, 90));
        southEastPanel3.setBorder(new EmptyBorder(0, 0, 5,10));
        southEastPanel3.setBackground(Color.BLACK);

        /*
        Components for panel
         */
        JButton eqButton = new JButton("=");
        eqButton.setBackground(Color.ORANGE);
        eqButton.setPreferredSize(new Dimension(70, 90));
        eqButton.addActionListener(e -> {
            display.setText(takeIntAction(e));
        });

        /*
        Adding Components to panel
        */
        southEastPanel3.add(eqButton);

        return southEastPanel3;
    }

    /**
     * Creates the South Panel containing the section of the calculator with the longer buttons
     * @return
     */
    public static JPanel southPanel(){
        /*
        Creating South Panel
         */
        JPanel southPanel2 = new JPanel(new BorderLayout());

        southPanel2.setBackground(Color.BLACK);
        southPanel2.setPreferredSize(new Dimension(width, 100));

        /*
        Adding Components to panel
        */
        southPanel2.add(southWestPanel(), BorderLayout.WEST);
        southPanel2.add(southEastPanel(), BorderLayout.EAST);

        return southPanel2;
    }

}
