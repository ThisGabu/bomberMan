package Entity.Item;

import Utility.HitBox;
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
    float width= 25;
    float height= 25;
    static final float delayFrame = 0.15f;

    public Item(){
        hitBox=new HitBox(getWidth(),getHeight(),getxPosition(),getyPosition());
    }

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
}
