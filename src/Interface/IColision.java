package Interface;
import Classes.ObjectBase;
import java.awt.*;
import java.util.ArrayList;

public interface IColision {
    void colision(ObjectBase colisionObj);
    Object getBoundingBox();
}
