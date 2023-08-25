package Classes;

import java.awt.*;

public class Shoot extends ObjectBase{
    private int shootY;
    private int shootX;
    int GameUnits;

    Shoot(int xPlayer,int yPlayer, int Units){
        this.GameUnits = Units;
        box.x = xPlayer;
        box.y = yPlayer;
        setShootY(yPlayer - 25);
    }
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.drawLine(getShootX() + GameUnits/2, getShootY(), getShootX() + + GameUnits/2, getShootY() - 10);
        if (getShootY() > 0)
            setShootY(getShootY() - 20);
    }

    public boolean isOffScreen() {
        return getShootY() <= 0;
    }
    //Setters
    public void setShootY(int shoot){
        this.shootY = shoot;
    }

    public void setShootX(int shoot){
        this.shootX = shoot;
    }

    public int getShootX(){
        return (this.shootX);
    }

    public int getShootY(){
        return (this.shootY);
    }
}
