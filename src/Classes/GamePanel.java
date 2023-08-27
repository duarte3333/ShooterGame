package Classes;

import Interface.IColision;
import Interface.IDraw;
import Interface.IUpdate;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

//implements- interface
//extends - permite usar os metodos dessa classe
public class GamePanel extends JPanel implements ActionListener {
    //Variables
    //Scene
    public static final int SCREEN_WIDTH = 1000;
    public static final int SCREEN_HEIGHT = 1000;
    public static final int WALL_THICKNESS = 50  ;
    static final int DELAY = 150  ;
    boolean running = false;
    Timer timer;
    //Scene
    Scene scene1 = new Scene();
    private long lastEnemyShootTime = System.currentTimeMillis();

    //Constructor
    GamePanel(){
        Scene.main = scene1;
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        running = true;
        timer = new Timer(DELAY,this);// For actionPerformed() method is called periodically
        timer.start();// to update the game state and repaint the screen.
        this.addKeyListener(scene1);
    }

    //Chamado por repaint
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(running) {
            scene1.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastEnemyShootTime >= 1500) { // 2000 milliseconds = 2 seconds
                lastEnemyShootTime = currentTime;
            }
            scene1.update();
            repaint();

        }
    }

//    public void enemyShoots(){
//        add(new Shoot(enemy1.getX(), enemy1.getY(), enemy1.getWidth(), enemy1.getHeight(), 'D', Color.red));
//    }
}
