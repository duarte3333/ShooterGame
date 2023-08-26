package Classes;
import Interface.IColision;
import Interface.IDraw;

import java.awt.*;
import java.util.ArrayList;

public class Enemy extends ObjectBase implements IDraw, IColision {
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
    public Rectangle getBoundingBox() {
        return box;
    }

    @Override
    public void colision(ArrayList<IColision> colisionObj) {
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
