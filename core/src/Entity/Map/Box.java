package Entity.Map;

import Utility.MapGame;
import com.badlogic.gdx.graphics.Texture;

public class Box {
    private float xPosition;
    private float yPosition;
    private final float width=26.5f;
    private final float height=26.5f;
    Texture picture;

    public Box(float x, float y){
        xPosition= (26.5f+x)-width;
        yPosition= (26.5f+y)-height;
        picture= new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\box.png");
    }

    public float getyPosition() {
        return yPosition;
    }

    public float getxPosition() {
        return xPosition;
    }

    public Texture getPicture() {
        return picture;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
