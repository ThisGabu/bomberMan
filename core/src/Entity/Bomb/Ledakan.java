package Entity.Bomb;

import Utility.HitBox;
import Utility.MapGame;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Ledakan {

    float x;
    float y;
    String arahLedakan;

    boolean padam= false;
    boolean right= true;
    boolean left= true;
    boolean up= true;
    boolean down= true;

    private float width;
    private float height;
    private final int cols = 1;
    private final int rows = 8;
    private final float delayFrame = 0.1f;
    Texture picture;
    Animation<TextureRegion> animation;

    HitBox hitBox;

    float stateTime=0f;

    public Ledakan(String arah, float x, float y, float width, float height){
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);

        arahLedakan=arah;
        if (arahLedakan=="center"){
            picture= new Texture("D:\\Project coding\\bomberMan\\assets\\effectLedakan\\center.png");

            TextureRegion[][] tmpLedakan = TextureRegion.split(picture, picture.getWidth() / cols, picture.getHeight() / rows);
            TextureRegion[] frameLedakan = new TextureRegion[cols * rows];

            int index = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    frameLedakan[index++] = tmpLedakan[i][j];
                }
            }

            animation = new Animation<TextureRegion>(delayFrame, frameLedakan);
        } else if (arahLedakan=="up") {
            picture= new Texture("D:\\Project coding\\bomberMan\\assets\\effectLedakan\\up.png");

            TextureRegion[][] tmpLedakan = TextureRegion.split(picture, picture.getWidth() / cols, picture.getHeight() / rows);
            TextureRegion[] frameLedakan = new TextureRegion[cols * rows];

            int index = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    frameLedakan[index++] = tmpLedakan[i][j];
                }
            }

            animation = new Animation<TextureRegion>(delayFrame, frameLedakan);
        } else if (arahLedakan=="down") {
            picture= new Texture("D:\\Project coding\\bomberMan\\assets\\effectLedakan\\down.png");

            TextureRegion[][] tmpLedakan = TextureRegion.split(picture, picture.getWidth() / cols, picture.getHeight() / rows);
            TextureRegion[] frameLedakan = new TextureRegion[cols * rows];

            int index = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    frameLedakan[index++] = tmpLedakan[i][j];
                }
            }

            animation = new Animation<TextureRegion>(delayFrame, frameLedakan);
        } else if (arahLedakan=="right") {
            picture= new Texture("D:\\Project coding\\bomberMan\\assets\\effectLedakan\\right.png");

            TextureRegion[][] tmpLedakan = TextureRegion.split(picture, picture.getWidth() / cols, picture.getHeight() / rows);
            TextureRegion[] frameLedakan = new TextureRegion[cols * rows];

            int index = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    frameLedakan[index++] = tmpLedakan[i][j];
                }
            }

            animation = new Animation<TextureRegion>(delayFrame, frameLedakan);
        } else if (arahLedakan=="left") {
            picture= new Texture("D:\\Project coding\\bomberMan\\assets\\effectLedakan\\left.png");

            TextureRegion[][] tmpLedakan = TextureRegion.split(picture, picture.getWidth() / cols, picture.getHeight() / rows);
            TextureRegion[] frameLedakan = new TextureRegion[cols * rows];

            int index = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    frameLedakan[index++] = tmpLedakan[i][j];
                }
            }

            animation = new Animation<TextureRegion>(delayFrame, frameLedakan);
        } else if (arahLedakan=="endUp") {
            picture= new Texture("D:\\Project coding\\bomberMan\\assets\\effectLedakan\\endUp.png");

            TextureRegion[][] tmpLedakan = TextureRegion.split(picture, picture.getWidth() / cols, picture.getHeight() / rows);
            TextureRegion[] frameLedakan = new TextureRegion[cols * rows];

            int index = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    frameLedakan[index++] = tmpLedakan[i][j];
                }
            }

            animation = new Animation<TextureRegion>(delayFrame, frameLedakan);
        } else if (arahLedakan=="endDown") {
            picture= new Texture("D:\\Project coding\\bomberMan\\assets\\effectLedakan\\endDown.png");

            TextureRegion[][] tmpLedakan = TextureRegion.split(picture, picture.getWidth() / cols, picture.getHeight() / rows);
            TextureRegion[] frameLedakan = new TextureRegion[cols * rows];

            int index = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    frameLedakan[index++] = tmpLedakan[i][j];
                }
            }

            animation = new Animation<TextureRegion>(delayFrame, frameLedakan);
        } else if (arahLedakan=="endRight") {
            picture= new Texture("D:\\Project coding\\bomberMan\\assets\\effectLedakan\\endRight.png");

            TextureRegion[][] tmpLedakan = TextureRegion.split(picture, picture.getWidth() / cols, picture.getHeight() / rows);
            TextureRegion[] frameLedakan = new TextureRegion[cols * rows];

            int index = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    frameLedakan[index++] = tmpLedakan[i][j];
                }
            }

            animation = new Animation<TextureRegion>(delayFrame, frameLedakan);
        } else if (arahLedakan=="endLeft") {
            picture= new Texture("D:\\Project coding\\bomberMan\\assets\\effectLedakan\\endLeft.png");

            TextureRegion[][] tmpLedakan = TextureRegion.split(picture, picture.getWidth() / cols, picture.getHeight() / rows);
            TextureRegion[] frameLedakan = new TextureRegion[cols * rows];

            int index = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    frameLedakan[index++] = tmpLedakan[i][j];
                }
            }

            animation = new Animation<TextureRegion>(delayFrame, frameLedakan);
        }

        hitBox= new HitBox(getWidth(),getHeight(),getX(),getY());
    }

    public HitBox getHitBox() {
        return hitBox;
    }

    public Animation<TextureRegion> getAnimation() {
        return animation;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public TextureRegion drawAnimation(float delta){
        stateTime+=delta;
        TextureRegion currentFrame = (TextureRegion) getAnimation().getKeyFrame(stateTime, true);

        return currentFrame;
    }

    public void setPadam(boolean padam) {
        this.padam = padam;
    }

    public boolean isPadam() {
        return padam;
    }

    public void update(){
        if (stateTime>animation.getAnimationDuration()){
            setPadam(true);
        }
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isUp() {
        return up;
    }
}
