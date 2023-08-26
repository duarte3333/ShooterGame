package Interface;
import Classes.ObjectBase;
import java.awt.*;
import java.util.ArrayList;

public interface IColision {
    Rectangle getBoundingBox();
    void colision(ArrayList<IColision> colisionObj);
}
