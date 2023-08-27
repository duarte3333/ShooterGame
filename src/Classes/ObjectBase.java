package Classes;
import java.awt.*;

public abstract class ObjectBase {
    float life;
    Rectangle box = new Rectangle();

    public Rectangle getBoundingBox() {
        return box;
    }
}

