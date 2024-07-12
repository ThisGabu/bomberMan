package Entity.Bomb;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


import java.awt.*;

public class Bomb {

    boolean meledak=false;
    boolean ledakan=false;
    int player;
    float x;
    float y;
    int i;
    int j;
    public int rangeExplosion = 5;

    private final float width = 26.6f;
    private final float height = 26.6f;
    private final int cols = 1;
    private final int rows = 6;
    private final float delayFrame = 0.25f;
    private float timer = 0;

    Texture picture;
    public Animation<TextureRegion> animation;

    public int getI(){
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getJ() {
        return j;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    public boolean isMeledak() {
        return meledak;
    }

    public void setMeledak(boolean remove) {
        this.meledak = remove;
    }

    public Bomb(float x, float y, int i, int j){
        setX(x);
        setY(y);
        setI(i);
        setJ(j);

        picture = new Texture("D:\\Project coding\\bomberMan\\assets\\BombAnimation\\bombMeledak.png");

        TextureRegion[][] tmpBomb = TextureRegion.split(picture, picture.getWidth() / cols, picture.getHeight() / rows);
        TextureRegion[] frameBomb = new TextureRegion[cols * rows];

        int index = 0;
        for (int l = 0; l < rows; l++) {
            for (int k = 0; k < cols; k++) {
                frameBomb[index++] = tmpBomb[l][k];
            }
        }

        animation = new Animation<TextureRegion>(delayFrame, frameBomb);

    }

    public void setY(float y) {
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }



    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public Animation<TextureRegion> getAnimation() {
        return animation;
    }

    public float getY() {
        return y;
    }

    public float getX() {
        return x;
    }

    public void setTimer(float timer) {
        this.timer = timer;
    }


    public float getDelayFrame() {
        return delayFrame;
    }

    public float getTimer() {
        return timer;
    }


    public void update(float delta){
        setTimer(timer+delta);
        removeBomb();
    }

    public void removeBomb() {

        //check bom apakah sudah meledak
        if (getTimer() >= animation.getAnimationDuration()) {
            setMeledak(true);
        }
    }

    public boolean isLedakan() {
        return ledakan;
    }

    public void setLedakan(boolean ledakan) {
        this.ledakan = ledakan;
    }

    public void setRangeExplosion(int rangeExplosion) {
        this.rangeExplosion = rangeExplosion;
    }
}
