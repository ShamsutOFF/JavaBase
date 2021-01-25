package Lesson07;

import javax.swing.*;
import java.awt.*;

public class Settings extends JFrame {
    private static final int WIN_WIDTH = 350;
    private static final int WIN_HEIGHT = 250;

    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_LENGTH = 3;
    private static final int MAX_FIELD_LENGTH = 10;

    private static final String FIELD_SIZE_TEXT_PREFIX = "Размер поля: ";
    private static final String WIN_LENGTH_TEXT_PREFIX = "Выгрышная длинна: ";


    private MainWindow mainWindow;
    private JRadioButton humVsAi;
    private JRadioButton humVsHum;
    private JSlider sliderWinLen;
    private JSlider sliderFieldSize;


    Settings(MainWindow mainWindow) {
        setSize (WIN_WIDTH, WIN_HEIGHT);
        setLocationRelativeTo (null);
        setTitle ("Настройки");
        setResizable (false);

        this.mainWindow = mainWindow;

        addGameModeSettings ( );
        addFieldSizeControl ( );

        setLayout (new GridLayout (10, 1));

        JButton btnStartGame = new JButton ("Начать новую игру");
        btnStartGame.addActionListener (e -> btnStartClick ( ));
        add (btnStartGame);
    }

    private void addGameModeSettings() {
        add (new JLabel ("Выберите режим игры:"));
        humVsAi = new JRadioButton ("Человек Vs Компъютер", true);
        humVsHum = new JRadioButton ("Человек Vs Человек");
        ButtonGroup gameMode = new ButtonGroup ( );
        gameMode.add (humVsAi);
        gameMode.add (humVsHum);
        add (humVsAi);
        add (humVsHum);

    }

    private void addFieldSizeControl() {
        JLabel lbFieldSize = new JLabel (FIELD_SIZE_TEXT_PREFIX + MIN_FIELD_LENGTH);
        JLabel lbWinLength = new JLabel (WIN_LENGTH_TEXT_PREFIX + MIN_WIN_LENGTH);
        sliderFieldSize = new JSlider (MIN_FIELD_LENGTH, MAX_FIELD_LENGTH, MIN_FIELD_LENGTH);
        sliderFieldSize.addChangeListener (e -> {
            int currentValue = sliderFieldSize.getValue ( );
            lbFieldSize.setText (FIELD_SIZE_TEXT_PREFIX + currentValue);
            sliderWinLen.setMaximum (currentValue);
        });
        sliderWinLen = new JSlider (MIN_WIN_LENGTH, MIN_FIELD_LENGTH, MIN_WIN_LENGTH);
        sliderWinLen.addChangeListener (e -> lbWinLength.setText (WIN_LENGTH_TEXT_PREFIX + sliderWinLen.getValue ( )));
        add (lbFieldSize);
        add (sliderFieldSize);
        add (lbWinLength);
        add (sliderWinLen);
    }

    private void btnStartClick() {
        int gameMode;

        if (humVsAi.isSelected ( )) {
            gameMode = GameMap.GAME_MODE_HVA;
        } else if (humVsHum.isSelected ( )) {
            gameMode = GameMap.GAME_MODE_HVH;
        } else {
            throw new RuntimeException ("Неизвестный режим игры");
        }
        int fieldSize = sliderFieldSize.getValue ();
        int winLength = sliderWinLen.getValue ();
        mainWindow.startNewGame (gameMode,fieldSize,fieldSize,winLength);
        setVisible (false);
    }

    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
}
