package Utility;

import com.badlogic.gdx.graphics.Texture;

public class Border {

    float xPosition;
    float yPosition;
    Texture picture;

    public Texture getPicture() {
        return picture;
    }

    public float getxPosition() {
        return xPosition;
    }

    public float getyPosition() {
        return yPosition;
    }

    public void setPicture() {
        picture= new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\metalwall.png");
    }

    public void setxPosition(float xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(float yPosition) {
        this.yPosition = yPosition;
    }
}
