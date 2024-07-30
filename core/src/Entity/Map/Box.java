package Entity.Map;

import Utility.HitBox;
import Utility.MapGame;
import com.badlogic.gdx.graphics.Texture;

public class Box {
    private float xPosition;
    private float yPosition;
    private final float width=MapGame.widthTile;
    private final float height=MapGame.heightTile;
    Texture picture;

    HitBox hitBox;

    public Box(float x, float y){
        xPosition= (width+x)-width;
        yPosition= (height+y)-height;
        picture= new Texture("..\\bomberMan\\assets\\MapGame\\box.png");
        hitBox= new HitBox(getWidth(),getHeight(),getxPosition(),getyPosition());
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

    public HitBox getHitBox() {
        return hitBox;
    }
}
