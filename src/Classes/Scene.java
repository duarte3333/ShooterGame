package Classes;

import Interface.IColision;
import Interface.IDraw;
import Interface.IUpdate;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import static Classes.GamePanel.*;

public class Scene implements IDraw, IUpdate, KeyListener {
    private ArrayList<IUpdate> updateObj = new ArrayList<>();
    private ArrayList<IDraw> drawObj = new ArrayList<>();
    private ArrayList<IColision> colisionObj = new ArrayList<>();
    public static Scene main;
    private ArrayList<ObjectBase> action = new ArrayList<>();
    Player player1 = new Player();

    Scene(){
        add(player1);
        Enemy enemy1 = new Enemy(100, 100, player1.getX(), player1.getY());
        add(enemy1);
        add(new WallMap(0, 0, WALL_THICKNESS,SCREEN_HEIGHT));
        add(new WallMap(SCREEN_WIDTH-WALL_THICKNESS, 0,SCREEN_WIDTH-WALL_THICKNESS,SCREEN_HEIGHT));
        add(new WallMap(WALL_THICKNESS, SCREEN_HEIGHT-WALL_THICKNESS,SCREEN_WIDTH, SCREEN_HEIGHT));

    }

    public void add(ObjectBase base){
        if (base instanceof IUpdate)
            updateObj.add((IUpdate) base);
        if (base instanceof IDraw)
            drawObj.add((IDraw) base);
        if (base instanceof IColision)
            colisionObj.add((IColision) base);
    }

    public static void addObject(ObjectBase base){
        main.action.add(base);
    }

    public void remove(ObjectBase base){
        if (base instanceof IUpdate)
            updateObj.remove((IUpdate) base);
        if (base instanceof IDraw)
            drawObj.remove((IDraw) base);
        if (base instanceof IColision)
            colisionObj.remove((IColision) base);
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(50, 700, 950, 700);
        drawObj.forEach(obj -> obj.draw(g));
    }

    @Override
    public void update() {
        action.forEach(this::add);
        action.clear();
        for (IColision obj1 : colisionObj) {
            ObjectBase s1 = (ObjectBase) obj1;
            ObjectBase s2 = checkColision(s1);
            if (s2 != null)
                obj1.colision(s2);
        }
        updateObj.forEach(IUpdate::update);
        //shots.removeIf(Shoot::isOffScreen);
    }

    public ObjectBase checkColision(ObjectBase s1){
        for (IColision obj2 : colisionObj) {
            ObjectBase s2 = (ObjectBase) obj2;
            if (s1 != s2 && s1.box.intersects(s2.box)){
                return (s2);
            }
        }
        return null;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                add(new Shoot(player1.getX(), player1.getY(), player1.getWidth(), player1.getHeight(), 'U', Color.green));
                break;
        }
        player1.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
