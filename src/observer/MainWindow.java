package observer;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    public static ButtonClickSubject subject = new ButtonClickSubject();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana Observer con AspectJ");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton redButton = new JButton("Rojo");
        JButton greenButton = new JButton("Verde");
        JButton blueButton = new JButton("Azul");

        frame.add(redButton);
        frame.add(greenButton);
        frame.add(blueButton);

        redButton.addActionListener(e -> frame.getContentPane().setBackground(Color.RED));
        greenButton.addActionListener(e -> frame.getContentPane().setBackground(Color.GREEN));
        blueButton.addActionListener(e -> frame.getContentPane().setBackground(Color.BLUE));

        subject.register(new ColorObserver("Logger"));
        subject.register(new ColorObserver("Auditor"));

        frame.setVisible(true);
    }
}
