import javax.swing.*;

public class CalcMenu {
    public static void main(String[] args) {
        calcMenu();
    }

    public static JFrame calcMenu(){
        JFrame intFrame = basicFrame();

        JMenuBar menuBar = new JMenuBar();

        JMenu intMenu = new JMenu("Int Calculator");
        JMenu floatMenu = new JMenu("Float Calculator");

        intMenu.addSeparator();
        //intMenu.addActionListener(e -> GUIInit());

        menuBar.add(intMenu);
        menuBar.add(floatMenu);

        intFrame.setJMenuBar(menuBar);

        return intFrame;
    }

    public static JFrame basicFrame(){
        int width = 300;
        int height = 500;

        JFrame frame = new JFrame("Calculator");

        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();

        return frame;
    }
}
