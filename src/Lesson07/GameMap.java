package Lesson07;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {

    private MainWindow mainWindow;

    public static final int GAME_MODE_HVA = 0;
    public static final int GAME_MODE_HVH = 1;
    GameMap() {
        setBackground (Color.LIGHT_GRAY);
     
    }

    void startNewGame (int mode, int fieldSizeX, int fieldSizeY, int winLength){
        //mainWindow.setLayout (new GridLayout (fieldSizeX, fieldSizeY));
        //JButton btn11 = new JButton ("11");
        //mainWindow.add(btn11);


        System.out.println ("mode = " + mode +
                " fieldSizeX = " + fieldSizeX +
                " fieldSizeY = " + fieldSizeY +
                " winLength = " + winLength);
    }
}
