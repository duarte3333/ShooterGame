package Classes;
import Interface.IDraw;
import Interface.IUpdate;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends ObjectBase implements KeyListener , IDraw, IUpdate {
    char direction = 'R';

    Player(){
        box.x = 100;
        box.y = 900;
        box.setSize(50, 50);
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.green);
        g.fillOval(box.x, box.y, box.width, box.height);
    }

    public void move() {
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
    //Setters

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

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
            case KeyEvent.VK_SPACE:
                //Shoot a = new Shoot(getX(), getY(), GameUnits);
                //shots.add(a);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        System.out.println("keyReleased");
    }

    @Override
    public void update() {
        move();
    }
}
