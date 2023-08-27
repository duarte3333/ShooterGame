package Classes;
import Interface.IColision;
import Interface.IDraw;
import Interface.IUpdate;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Player extends ObjectBase implements KeyListener , IDraw, IUpdate, IColision {
    char direction = 'S';
    boolean alive = true;
    ObjectBase colisionObj;

    //Constructor
    Player(){
        life = 100;
        box.x = 100;
        box.y = 900;
        box.setSize(50, 50);
        System.out.println(life);

    }

    //Interface Methods
    @Override
    public void draw(Graphics g){
        g.setColor(Color.green);
        if (alive)
            g.fillOval(box.x, box.y, box.width, box.height);
    }

    @Override
    public void update() {
        Rectangle a = new Rectangle(box);

            switch(direction) {
                case 'U':
                    box.y = (box.y - box.height);
                    break;
                case 'D':
                    box.y = (box.y + box.height);
                    break;
                case 'L':
                    box.x = (box.x - box.width);
                    break;
                case 'R':
                    box.x = (box.x + box.width);
                    break;
            }
        colisionObj = Scene.main.checkColision(this);
        if (colisionObj != null && colisionObj instanceof WallMap)
            box = a;
    }

    public void colision(ObjectBase colisionObj) {
    }
    //Getters
    public int getX(){
        return this.box.x;
    }

    public int getY(){
        return this.box.y;
    }

    public int getWidth(){
        return this.box.width;
    }

    public int getHeight(){
        return this.box.height;
    }

    //Keys
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                direction = 'L';
                break;
            case KeyEvent.VK_RIGHT:
                direction = 'R';
                break;
            case KeyEvent.VK_UP:
                direction = 'U';
                break;
            case KeyEvent.VK_DOWN:
                direction = 'D';
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        //System.out.println("keyReleased");
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }
}
