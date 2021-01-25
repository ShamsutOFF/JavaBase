package Lesson07;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Test{

    public static void main(String[] args) throws MalformedURLException {

        URL url = Test.class.getResource("test.gif");
        ImageIcon imageIcon = new ImageIcon(url);
        JLabel label = new JLabel(imageIcon);

       //URL url = new URL ("https://cdn.dribbble.com/users/205519/screenshots/2040616/tq_tick_cross.gif");
        Icon icon = new ImageIcon(url);
        //JLabel label = new JLabel(icon);

        JFrame f = new JFrame("Animation");
        f.add(label);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}