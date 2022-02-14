package Application;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 03.02.2022
 */

public class GameWindow extends JFrame {

    private int width = 1024;
    private int height = 768;
    private int posX = 300;
    private int posY = 150;

    private JButton btnStart;
    private JButton btnExit;
    private JButton btnClearLog;

    private final int MIN_SIZE_MAP = 3;
    private final int MAX_SIZE_MAP = 10;
    private final int MIN_WIN_LENGTH = 3;

    private JPanel mainToolsPanel;
    private JPanel settingPanel;

    private JSlider setupMapSize;
    private JLabel labelMapSize;

    private JSlider setupWinLength;
    private JLabel labelWinLength;

    private JTextArea log;
    private JScrollPane scrollLog;

    private Map map;

    GameWindow() {
        prepareWindow();
        prepareToolsPanel();
        prepareButtons();
        prepareSettingsPanel();
        prepareGameLog();


        map = new Map(this);

        mainToolsPanel.add(settingPanel,BorderLayout.NORTH);
        mainToolsPanel.add(scrollLog, BorderLayout.SOUTH);

        add(mainToolsPanel, BorderLayout.EAST);
        add(map);

        setVisible(true);

    }

    private void prepareWindow() {
        setSize(width, height);
        setLocation(posX, posY);
        setTitle("Application");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void prepareToolsPanel() {
        mainToolsPanel = new JPanel();
        mainToolsPanel.setLayout(new GridLayout(2,1));
    }

    private void prepareButtons() {
        btnStart = new JButton("Start game");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collectSettings();
            }
        });

        btnExit = new JButton("End game");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        btnClearLog = new JButton("Clear");
        btnClearLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.setText("");
            }
        });
    }

    private void prepareSettingsPanel() {
        settingPanel = new JPanel();
        settingPanel.setLayout(new GridLayout(7,1));

        labelMapSize = new JLabel("Map size " + MIN_SIZE_MAP + "x" + MIN_SIZE_MAP);
        setupMapSize = new JSlider(MIN_SIZE_MAP, MAX_SIZE_MAP, MIN_SIZE_MAP);
        setupMapSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentPosition = setupMapSize.getValue();
                labelMapSize.setText("Map size " + currentPosition + "x" + currentPosition);
                setupWinLength.setMaximum(currentPosition);
            }
        });

        labelWinLength = new JLabel("Win length " + MIN_WIN_LENGTH);
        setupWinLength = new JSlider(MIN_WIN_LENGTH, MIN_SIZE_MAP, MIN_WIN_LENGTH);
        setupWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelWinLength.setText("Win length " + setupWinLength.getValue());
            }
        });

        settingPanel.add(btnStart);
        settingPanel.add(btnExit);
        settingPanel.add(btnClearLog);
        settingPanel.add(labelMapSize);
        settingPanel.add(setupMapSize);
        settingPanel.add(labelWinLength);
        settingPanel.add(setupWinLength);
    }

    private void prepareGameLog() {
        log = new JTextArea();
        scrollLog = new JScrollPane(log);
        log.setEditable(false);
        log.setLineWrap(true);
    }

    void sendToLog(String text) {
        log.append(text + "\n");
    }

    private void collectSettings() {
        int mapSize = setupMapSize.getValue();
        int winLen = setupWinLength.getValue();
        log.setText("");
        sendToLog("== Start New Game ===");
        sendToLog("Map Size is " + mapSize + "x" + mapSize);
        sendToLog("Win Length is " + winLen);
        map.startGame(mapSize, mapSize, winLen);
    }


}
