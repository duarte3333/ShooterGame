package Classes;

import Interface.IColision;
import Interface.IDraw;
import Interface.IUpdate;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WallMap extends ObjectBase implements IDraw, IColision
{
    char direction = 'R';
    WallMap(int x, int y, int width, int height){
        box.x = x;
        box.y = y;
        box.setSize(width, height);
    }

    //Interface Methods
    @Override
    public void draw(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(box.x, box.y, box.width, box.height);
    }

    @Override
    public void colision(ObjectBase colisionObj) {

    }
}
