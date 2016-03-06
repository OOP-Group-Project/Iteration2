package Main;

import Main.View.GamePanel;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("The Unwanted....... maybe");

        frame.add(new GamePanel());

        frame.setResizable(false);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
