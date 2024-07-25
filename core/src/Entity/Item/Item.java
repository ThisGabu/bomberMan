package Entity.Item;

import Utility.HitBox;
import Utility.MapGame;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Item {

    public Animation<TextureRegion> animation;

    String nama;
    Texture picture;
    HitBox hitBox;

    float xPosition;
    float yPosition;
    float width= MapGame.widthTile-1;
    float height= MapGame.heightTile-1;
    static final float delayFrame = 0.1f;

    float statetime=0;


    public void setPicture(Texture picture) {
        this.picture = picture;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Texture getPicture() {
        return picture;
    }

    public String getNama() {
        return nama;
    }

    public abstract void setPicture();

    public void setxPosition(float xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(float yPosition) {
        this.yPosition = yPosition;
    }

    public float getxPosition() {
        return xPosition;
    }

    public float getyPosition() {
        return yPosition;
    }

    public Animation getAnimation(){
        return animation;
    }


    public HitBox getHitBox() {
        return hitBox;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public float getStatetime() {
        return statetime;
    }

    public void setStatetime(float statetime) {
        this.statetime = statetime;
    }
}
