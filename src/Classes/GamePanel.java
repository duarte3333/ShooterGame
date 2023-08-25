package Classes;

import Interface.IColision;
import Interface.IDraw;
import Interface.IUpdate;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

//implements- interface
public class GamePanel extends JPanel implements ActionListener{
    final int SCREEN_WIDTH = 1000;
    final int SCREEN_HEIGHT = 1000;
    static final int DELAY = 150  ;
    boolean running = false;
    Player player1;
    Timer timer;
    private ArrayList<IUpdate> updateObj = new ArrayList<>();
    private ArrayList<IDraw> drawObj = new ArrayList<>();
    private ArrayList<IColision> colisionObj = new ArrayList<>();

    //Constructor
    GamePanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);

        startGame();
        player1 = new Player();
        this.addKeyListener(player1);
        add(player1);
    }
    public void startGame() {
        running = true;
        // For actionPerformed() method is called periodically
        // to update the game state and repaint the screen.
        timer = new Timer(DELAY,this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(running) {
            g.fillRect(0, 0, 50, 1000);
            g.fillRect(950, 0, 950, 1000);
            g.fillRect(50, 950, 1000, 1000);
            g.drawLine(50, 700, 950, 700);
            drawObj.forEach(obj -> obj.draw(g));
        }
    }

    public void add(ObjectBase base){
        if (base instanceof IUpdate)
            updateObj.add((IUpdate) base);
        if (base instanceof IDraw)
            drawObj.add((IDraw) base);
        if (base instanceof IColision)
            colisionObj.add((IColision) base);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(running) {
            updateObj.forEach(IUpdate::update);
            //shots.removeIf(Shoot::isOffScreen);
            repaint();
        }
    }
}
