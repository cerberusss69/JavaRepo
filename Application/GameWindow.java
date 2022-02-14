package Application;

import javax.swing.*;  //добавляем новый метод из библиотеки
import java.awt.*;

public class GameWindow extends JFrame { //метод

    private int width = 1024;  //задали высоту и ширину окна в пикселях,
    private int height = 768;  // вывели его на середину экрана, так как начальная точка у него 0.0 в верхнем левом углу
    private int posX = 300;
    private int posY = 150;

    private JButton btnStart; //создаем кнопки
    private JButton btnExit;

    private JPanel mainToolsPanel; //условный контейнер
    private JPanel settingPanel;  //условный контейнер

    private Map map; //даём знать,что есть МАП

    GameWindow () {

        prepareWindow();
        prepareToolsPanel(); //вызов метода
        prepareButtons();
        prepareSettingsPanel();

//        btnStart = new JButton("Start game");  //перемещаем кнопки в метод
//        btnExit = new JButton("End game");
        map = new Map();

        mainToolsPanel.add(settingPanel, BorderLayout.NORTH);
        add(mainToolsPanel, BorderLayout.EAST);

        add(map);

//        add(btnStart, BorderLayout.NORTH);  //добавляем кнопки в окно
//        add(btnExit, BorderLayout.SOUTH);  // BorderLayout это менеджер компановки, который помогает с расположением
//
//        setLayout(new GridLayout(3,5)); //Менеджер компановки GridLayout
//        for (int i = 0; i < 15; i++){
//            add(new JButton("Text" + i));
//        }

//        setSize(width,height);
//        setLocation(posX,posY);
//        setTitle("Application");
//        setResizable(false); //запрещает изменять размер окна.
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //класс помогает закрыть окно, описывает поведение.
        //выносим верхнюю часть в метод.

        setVisible(true);  //видимость нашего окна.
    }
    private void prepareWindow() {
        setSize(width, height);
        setLocation(posX, posY);
        setTitle("Application");
        setResizable(false); //запрещает изменять размер окна.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //класс помогает закрыть окно, описывает поведение.
    }
    private void prepareToolsPanel() {
        mainToolsPanel = new JPanel();
        mainToolsPanel.setBackground(Color.ORANGE);
        mainToolsPanel.setLayout(new GridLayout(2,1)); //разделяем панель на окно и столбец
    }
    private void prepareButtons(){  // метод будет отвечать за кнопки
        btnStart = new JButton("Start game");
        btnExit = new JButton("End game");
    }
    private void prepareSettingsPanel(){
        settingPanel = new JPanel();
        mainToolsPanel.setBackground(Color.BLUE);
        settingPanel.setLayout(new GridLayout(4,1));

        settingPanel.add(btnStart);
        settingPanel.add(btnExit);
    }
}
