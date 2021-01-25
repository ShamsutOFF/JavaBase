package Lesson07;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final int WIN_WIDTH = 500;
    private static final int WIN_HEIGHT = 555;

    private Settings settingsWindow;
    private GameMap gameMap;

    MainWindow() {
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        setSize (WIN_WIDTH,WIN_HEIGHT);
        setLocationRelativeTo(null);
        setTitle ("Игра \"Крестики-Нолики\"");
        setResizable (false);

        settingsWindow = new Settings (this);
        gameMap = new GameMap ();

        JButton btnStartGame = new JButton ( "Новая игра" );
        btnStartGame.addActionListener (e -> {
            settingsWindow.setVisible (true);
            startNewGame (0,3,3,3);
        });

        JButton btnExit = new JButton ( "Выход" );
        btnExit.addActionListener (e -> System.exit (0));

        JPanel panelBottom = new JPanel ( );
        panelBottom.setLayout (new GridLayout ( 1,2 ));
        add(panelBottom,BorderLayout.SOUTH);
        panelBottom.add (btnStartGame);
        panelBottom.add (btnExit);
        add(gameMap);
        setVisible (true);

    }

    public void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        gameMap.startNewGame(mode,fieldSizeX,fieldSizeY,winLength);
        //System.out.println ("mode = " + mode +
             //   " fieldSizeX = " + fieldSizeX +
             //   " fieldSizeY = " + fieldSizeY +
             //   " winLength = " + winLength);
    }

}
