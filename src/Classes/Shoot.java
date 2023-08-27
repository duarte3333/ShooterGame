package Classes;

import Interface.IColision;
import Interface.IDraw;
import Interface.IUpdate;

import java.awt.*;
import java.util.ArrayList;

public class Shoot extends ObjectBase implements IDraw, IUpdate, IColision {
    char direction;
    int deltaY;
    int deltaX;
    Color color;
    Shoot(int x, int y, int width, int height, char direction, Color color){
        box.x = x + width/2;
        box.y = y;
        box.setSize(1, 10);
        deltaX = 5;
        deltaY = 10;
        this.color = color;
        this.direction = direction;
    }

    @Override
    public void draw(Graphics g){
        g.setColor(this.color);
        g.drawRect(box.x, box.y, box.width, box.height);
    }

    @Override
    public void update(){
        if (box.y >= -10){
            switch (direction){
                case('U'):
                    box.y = box.y - deltaY;
                    break;
                case('D'):
                    box.y = box.y + deltaY;
                    box.x = box.x + deltaX;
                    break;
            }
        }
    }

    @Override
    public void colision(ObjectBase colisionObj) {
        if (this.color == Color.RED)
            colisionObj.life -= 10;
        if (colisionObj instanceof WallMap)
            Scene.main.remove(this);
    }

    public Rectangle getBoundingBox() {
        return box;
    }

}
