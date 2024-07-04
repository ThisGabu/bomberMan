package Entity.Map;

import com.badlogic.gdx.graphics.Texture;

public class Wall {
    private float xPosition;
    private float yPosition;
    Texture picture;

    public Wall(float x, float y){
        xPosition=x;
        yPosition=y;
        picture= new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\wall.png");
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
}
