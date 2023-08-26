package Classes;
import Interface.IColision;
import Interface.IDraw;
import Interface.IUpdate;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Player extends ObjectBase implements KeyListener , IDraw, IUpdate, IColision {
    char direction = 'R';
    boolean alive = true;

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
        switch(direction) {
            case 'U':
                if ((box.y >= 750) && box.y <= 900)
                    box.y = (box.y - box.height);
                break;
            case 'D':
                if ((box.y >= 700) && box.y <= 850 )
                    box.y = (box.y + box.height);
                break;
            case 'L':
                if (box.x >= 100 && box.x <= 900)
                    box.x = (box.x - box.width);
                break;
            case 'R':
                if (box.x >= 50 && (box.x <= 850))
                    box.x = (box.x + box.width);
                break;
        }
    }

    @Override
    public Rectangle getBoundingBox() {
        return null;
    }

    public void colision(ArrayList<IColision> colisionObj) {
        for (IColision obj : colisionObj) {
            if (obj != this) {
                if (box.intersects(obj.getBoundingBox())) {
                    life -= 10;
                    System.out.println(life);
                    if (life == 0)
                        alive = false;
                }
            }
        }
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
