import javax.swing.*;
import java.awt.*;

public class CalcMenu {
    public static void main(String[] args) {
        basicFrame();
    }

    public static void calcMenu(Container pane){
        JTabbedPane mainGUI = new JTabbedPane();

        mainGUI.setPreferredSize(new Dimension(300, 500));

        JPanel intPanel = IntCalculatorGUI.GUIInit();
        intPanel.setPreferredSize(new Dimension(300, 500));
        JPanel floatPanel = FloatCalculatorGUI.GUIInit();
        floatPanel.setPreferredSize(new Dimension(300, 500));

        mainGUI.addTab("Int Calculator", intPanel);
        mainGUI.addTab("Float Calculator", floatPanel);

        pane.add(mainGUI, BorderLayout.CENTER);
    }

    public static void basicFrame(){
        int width = 300;
        int height = 500;

        JFrame frame = new JFrame("Calculator");

        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CalcMenu.calcMenu(frame.getContentPane());

        frame.setVisible(true);
        frame.pack();
    }
}
