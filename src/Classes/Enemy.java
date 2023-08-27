package Classes;
import Interface.IColision;
import Interface.IDraw;
import Interface.IUpdate;

import java.awt.*;
import java.util.ArrayList;

public class Enemy extends ObjectBase implements IDraw, IColision, IUpdate {
    //Constructor
    Enemy(int x, int y, int playerY, int pLayerX){
        box.x = x;
        box.y = y;
        box.setSize(30, 30);
    }

    //Interface methods
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillRect(box.x, box.y, box.width, box.height);
    }

    @Override
    public void colision(ObjectBase colisionObj ) {
    }

    @Override
    public void update(){
        Scene.addObject(new Shoot(getX(), getY(), getWidth(), getHeight(), 'D', Color.red));
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
}
