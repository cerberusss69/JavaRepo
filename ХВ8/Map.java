package Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 03.02.2022
 */

public class Map extends JPanel {

    private final int HUMAN = 1;
    private final int AI = 2;
    private final int EMPTY_FIELD = 0;

    private final int HUMAN_WIN = 1;
    private final String HUMAN_WIN_MSG = "Человек выиграл!!!";
    private final int AI_WIN = 2;
    private final String AI_WIN_MSG = "Компьютер выиграл!!!";
    private final int DRAW = 0;
    private final String DRAW_MSG = "Ничья!!!";

    private int mapSizeX;
    private int mapSizeY;

    private int winLength;
    private int[][] map;

    private int cellW;
    private int cellH;

    private boolean isPressStartButton;
    private boolean isGameOver;

    private GameWindow gameWindow;

    private Random random = new Random();

    Map(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.WHITE);
        isPressStartButton = false;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent mouse) {
                super.mouseReleased(mouse);
                gameLogic(mouse);
            }
        });
    }

    void startGame(int sizeX, int sizeY, int wLen) {
        this.mapSizeX = sizeX;
        this.mapSizeY = sizeY;
        this.winLength = wLen;
        isPressStartButton = true;
        isGameOver = false;
        map = new int[mapSizeY][mapSizeX];
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderGame(g);
    }

    private void gameLogic(MouseEvent mouse) {

        if (!isPressStartButton) {
            return;
        }

        if (isGameOver) {
            return;
        }

        int cellX = mouse.getX() / cellW;
        int cellY = mouse.getY() / cellH;

        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) {
            gameWindow.sendToLog("Invalid move to [" + (cellX + 1) + ":" + (cellY + 1) + "]");
            return;
        }

        map[cellY][cellX] = HUMAN;
        gameWindow.sendToLog("Human turn to [" + (cellX + 1) + ":" + (cellY + 1) + "]");

        if (checkWin(HUMAN)) {
            calcGameOver(HUMAN_WIN);
            return;
        }

        if (isFullMap()) {
            calcGameOver(DRAW);
            return;
        }

        aiTurn();
        repaint();

        if (checkWin(AI)) {
            calcGameOver(AI);
            return;
        }

        if (isFullMap()) {
            calcGameOver(DRAW);
            return;
        }
    }

    private void calcGameOver(int stateGameOver) {
        repaint();
        isGameOver = true;

        switch (stateGameOver) {
            case HUMAN_WIN:
                gameWindow.sendToLog(HUMAN_WIN_MSG);
                JOptionPane.showMessageDialog(this, HUMAN_WIN_MSG);
                break;
            case AI_WIN:
                gameWindow.sendToLog(AI_WIN_MSG);
                JOptionPane.showMessageDialog(this, AI_WIN_MSG);
                break;
            case DRAW:
                gameWindow.sendToLog(DRAW_MSG);
                JOptionPane.showMessageDialog(this, DRAW_MSG);
                break;
        }

    }

    private void renderGame(Graphics g) {

        if (!isPressStartButton) {
            return;
        }

        createMap(g);

        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {

                if (isEmptyCell(x,y)) {
                    continue;
                }

                if (map[y][x] == HUMAN) {
                    g.setColor(Color.ORANGE);
                    g.fillOval(x * cellW + 5, y * cellH + 5, cellW - 10, cellH - 10);
                }

                if (map[y][x] == AI) {
                    g.setColor(Color.RED);
                    g.fillOval(x * cellW + 5, y * cellH + 5, cellW - 10, cellH - 10);
                }
            }
        }

        if (isGameOver) {
            return;
        }

    }

    private void createMap(Graphics g) {
        int widthMe = getWidth();
        int heightMe = getHeight();

        cellW = widthMe / mapSizeX;
        cellH = heightMe / mapSizeY;

        g.setColor(Color.BLACK);

        for (int i = 0; i <= mapSizeY; i++) {
            int y = i * cellH;
            g.drawLine(0, y, widthMe, y);
        }

        for (int i = 0; i <= mapSizeX; i++) {
            int x = i * cellW;
            g.drawLine(x, 0, x, heightMe);
        }

    }

    private void aiTurn() {
        if (turnAIWinCell()) {
            return;
        }
        if (turnHumanWinCell()) {
            return;
        }
        int x;
        int y;
        do {
            x = random.nextInt(mapSizeX);
            y = random.nextInt(mapSizeY);
        } while (!isEmptyCell(x, y));
        map[y][x] = AI;
        gameWindow.sendToLog("AI turn to [" + (x + 1) + ":" + (y + 1) + "]");
    }

    private boolean turnAIWinCell() {
        for (int i = 0; i < mapSizeY; i++) {
            for (int j = 0; j < mapSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    map[i][j] = AI;
                    if (checkWin(AI)) {
                        gameWindow.sendToLog("AI turn to [" + (j + 1) + ":" + (i + 1) + "]");
                        return true;
                    }
                    map[i][j] = EMPTY_FIELD;
                }
            }
        }
        return false;
    }

    private boolean turnHumanWinCell() {
        for (int i = 0; i < mapSizeY; i++) {
            for (int j = 0; j < mapSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    map[i][j] = HUMAN;
                    if (checkWin(HUMAN)) {
                        map[i][j] = AI;
                        gameWindow.sendToLog("AI turn to [" + (j + 1) + ":" + (i + 1) + "]");
                        return true;
                    }
                    map[i][j] = EMPTY_FIELD;
                }
            }
        }
        return false;
    }

    // проверка на победу
    private boolean checkWin(int checkChar) {
        for (int i = 0; i < mapSizeX; i++) {
            for (int j = 0; j < mapSizeY; j++) {
                if (checkVector(i, j, 1, 0, winLength, checkChar)) {
                    return true;
                }
                if (checkVector(i, j, 1, 1, winLength, checkChar)) {
                    return true;
                }
                if (checkVector(i, j, 0, 1, winLength, checkChar)) {
                    return true;
                }
                if (checkVector(i, j, 1, -1, winLength, checkChar)) {
                    return true;
                }
            }
        }
        return false;
    }

    // проверка линии
    private boolean checkVector(int x, int y, int vx, int vy, int len, int checkChar) {
        int farX = x + (len - 1) * vx;
        int farY = y + (len - 1) * vy;

        if (!isValidCell(farX, farY)) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            if (map[y + i * vy][x + i * vx] != checkChar) {
                return false;
            }
        }
        return true;
    }

    private boolean isFullMap() {
        for (int i = 0; i < mapSizeY; i++) {
            for (int j = 0; j < mapSizeX; j++) {
                if (map[i][j] == EMPTY_FIELD) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < mapSizeX && y >= 0 && y < mapSizeY;
    }

    private boolean isEmptyCell(int x, int y) {
        return map[y][x] == EMPTY_FIELD;
    }
}
