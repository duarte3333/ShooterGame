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
public class GamePanel extends JPanel implements KeyListener, ActionListener {
    //Variables
    //Scene
    static final int SCREEN_WIDTH = 1000;
    static final int SCREEN_HEIGHT = 1000;
    static final int DELAY = 150  ;
    static final int WALL_THICKNESS = 50  ;
    boolean running = false;
    Timer timer;
    //Player
    Player player1;
    //Enemy
    Enemy enemy1;
    private long lastEnemyShootTime = System.currentTimeMillis();
    private ArrayList<IUpdate> updateObj = new ArrayList<>();
    private ArrayList<IDraw> drawObj = new ArrayList<>();
    private ArrayList<IColision> colisionObj = new ArrayList<>();

    //Constructor
    GamePanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        startGame();
        this.addKeyListener(this);
        player1 = new Player();
        this.addKeyListener(player1);
        add(player1);
        enemy1 = new Enemy(100, 100, player1.getX(), player1.getY());
        add(enemy1);
        add(new WallMap(0, 0, WALL_THICKNESS,SCREEN_HEIGHT));
        add(new WallMap(SCREEN_WIDTH-WALL_THICKNESS, 0,SCREEN_WIDTH-WALL_THICKNESS,SCREEN_HEIGHT));
        add(new WallMap(WALL_THICKNESS, SCREEN_HEIGHT-WALL_THICKNESS,SCREEN_WIDTH, SCREEN_HEIGHT));
    }

    public void startGame() {
        running = true;
        timer = new Timer(DELAY,this);// For actionPerformed() method is called periodically
        timer.start();// to update the game state and repaint the screen.
    }

    public void add(ObjectBase base){
        if (base instanceof IUpdate)
            updateObj.add((IUpdate) base);
        if (base instanceof IDraw)
            drawObj.add((IDraw) base);
        if (base instanceof IColision)
            colisionObj.add((IColision) base);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(running) {
            g.drawLine(50, 700, 950, 700);
            drawObj.forEach(obj -> obj.draw(g));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastEnemyShootTime >= 1500) { // 2000 milliseconds = 2 seconds
                enemyShoots();
                lastEnemyShootTime = currentTime;
            }
            colisionObj.forEach(obj -> obj.colision(colisionObj));
            updateObj.forEach(IUpdate::update);
            //shots.removeIf(Shoot::isOffScreen);
            repaint();
        }
    }

    public void enemyShoots(){
        add(new Shoot(enemy1.getX(), enemy1.getY(), enemy1.getWidth(), enemy1.getHeight(), 'D', Color.red));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                add(new Shoot(player1.getX(), player1.getY(), player1.getWidth(), player1.getHeight(), 'U', Color.green));
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {}

    @Override
    public void keyTyped(KeyEvent keyEvent) {}
}
