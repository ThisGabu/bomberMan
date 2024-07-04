package Entity.Player;

import Utility.Analog.Analog;
import Utility.Analog.Analog1;
import Utility.Analog.Analog2;
import Utility.MapGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player {

    final float delayFrame=0.25f;
    final float speed=1;
    final float width=23;
    final float height=23;

    float x;
    float y;

    int widthSpace=7;
    int heightSpace=11;

    Analog analog;

    private static final int colsIdle = 1;
    private static final int rowsIdle = 12;
    Texture playerIdle;
    Animation<TextureRegion> animationIdle;

    private static final int colsDead = 1;
    private static final int rowsDead = 7;
    Texture playerDead;
    Animation<TextureRegion> animationDead;

    private static final int colsDown = 1;
    private static final int rowsDown = 8;
    Texture playerWalkDown;
    Animation<TextureRegion> animationWalkDown;

    private static final int colsUp = 1;
    private static final int rowsUp = 8;
    Texture playerWalkUp;
    Animation<TextureRegion> animationWalkUp;

    private static final int colsLeft = 1;
    private static final int rowsLeft = 8;
    Texture playerWalkLeft;
    Animation<TextureRegion> animationWalkLeft;

    private static final int colsRight = 1;
    private static final int rowsRight = 8;
    Texture playerWalkRight;
    Animation<TextureRegion> animationWalkRight;

    Animation<TextureRegion> animation;

    Player(float x, float y, int player) {
        this.x = x;
        this.y = y;

        if (player == 0) {
            analog= new Analog1();
            playerDead = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player1\\playerDead.png");
            playerIdle = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player1\\playerIdle.png");
            playerWalkDown = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player1\\playerWalkDown.png");
            playerWalkUp = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player1\\playerWalkUp.png");
            playerWalkLeft = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player1\\playerWalkLeft.png");
            playerWalkRight = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player1\\playerWalkRight.png");

            TextureRegion[][] tmpDead = TextureRegion.split(playerDead, playerDead.getWidth() / colsDead, playerDead.getHeight() / rowsDead);
            TextureRegion[][] tmpIdle = TextureRegion.split(playerIdle, playerIdle.getWidth() / colsIdle, playerIdle.getHeight() / rowsIdle);
            TextureRegion[][] tmpDown = TextureRegion.split(playerWalkDown, playerWalkDown.getWidth() / colsDown, playerWalkDown.getHeight() / rowsDown);
            TextureRegion[][] tmpUp = TextureRegion.split(playerWalkUp, playerWalkUp.getWidth() / colsUp, playerWalkUp.getHeight() / rowsUp);
            TextureRegion[][] tmpLeft = TextureRegion.split(playerWalkLeft, playerWalkLeft.getWidth() / colsLeft, playerWalkLeft.getHeight() / rowsLeft);
            TextureRegion[][] tmpRight = TextureRegion.split(playerWalkRight, playerWalkRight.getWidth() / colsRight, playerWalkRight.getHeight() / rowsRight);

            TextureRegion[] frameIdle = new TextureRegion[colsIdle * rowsIdle];
            TextureRegion[] frameDead = new TextureRegion[colsDead * rowsDead];
            TextureRegion[] frameDown = new TextureRegion[colsDown * rowsDown];
            TextureRegion[] frameUp = new TextureRegion[colsUp * rowsUp];
            TextureRegion[] frameLeft = new TextureRegion[colsLeft * rowsLeft];
            TextureRegion[] frameRight = new TextureRegion[colsRight * rowsRight];

            int index = 0;

            for (int i = 0; i < rowsIdle; i++) {
                for (int j = 0; j < colsIdle; j++) {
                    frameIdle[index++] = tmpIdle[i][j];
                }
            }

            index = 0;

            for (int i = 0; i < rowsDead; i++) {
                for (int j = 0; j < colsDead; j++) {
                    frameDead[index++] = tmpDead[i][j];
                }
            }

            index = 0;

            for (int i = 0; i < rowsDown; i++) {
                for (int j = 0; j < colsDown; j++) {
                    frameDown[index++] = tmpDown[i][j];
                }
            }

            index = 0;

            for (int i = 0; i < rowsUp; i++) {
                for (int j = 0; j < colsUp; j++) {
                    frameUp[index++] = tmpUp[i][j];
                }
            }

            index = 0;

            for (int i = 0; i < rowsRight; i++) {
                for (int j = 0; j < colsRight; j++) {
                    frameRight[index++] = tmpRight[i][j];
                }
            }

            index = 0;

            for (int i = 0; i < rowsLeft; i++) {
                for (int j = 0; j < colsLeft; j++) {
                    frameLeft[index++] = tmpLeft[i][j];
                }
            }

            animationIdle = new Animation<TextureRegion>(delayFrame, frameIdle);
            animationDead = new Animation<TextureRegion>(delayFrame, frameDead);
            animationWalkDown = new Animation<TextureRegion>(delayFrame, frameDown);
            animationWalkUp = new Animation<TextureRegion>(delayFrame, frameUp);
            animationWalkLeft = new Animation<TextureRegion>(delayFrame, frameLeft);
            animationWalkRight = new Animation<TextureRegion>(delayFrame, frameRight);

            animation=animationIdle;
        } else {
            analog= new Analog2();
            playerDead = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player2\\playerDead.png");
            playerIdle = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player2\\playerIdle.png");
            playerWalkDown = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player2\\playerWalkDown.png");
            playerWalkUp = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player2\\playerWalkUp.png");
            playerWalkLeft = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player2\\playerWalkLeft.png");
            playerWalkRight = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player2\\playerWalkRight.png");

            TextureRegion[][] tmpDead = TextureRegion.split(playerDead, playerDead.getWidth() / colsDead, playerDead.getHeight() / rowsDead);
            TextureRegion[][] tmpIdle = TextureRegion.split(playerIdle, playerIdle.getWidth() / colsIdle, playerIdle.getHeight() / rowsIdle);
            TextureRegion[][] tmpDown = TextureRegion.split(playerWalkDown, playerWalkDown.getWidth() / colsDown, playerWalkDown.getHeight() / rowsDown);
            TextureRegion[][] tmpUp = TextureRegion.split(playerWalkUp, playerWalkUp.getWidth() / colsUp, playerWalkUp.getHeight() / rowsUp);
            TextureRegion[][] tmpLeft = TextureRegion.split(playerWalkLeft, playerWalkLeft.getWidth() / colsLeft, playerWalkLeft.getHeight() / rowsLeft);
            TextureRegion[][] tmpRight = TextureRegion.split(playerWalkRight, playerWalkRight.getWidth() / colsRight, playerWalkRight.getHeight() / rowsRight);

            TextureRegion[] frameIdle = new TextureRegion[colsIdle * rowsIdle];
            TextureRegion[] frameDead = new TextureRegion[colsDead * rowsDead];
            TextureRegion[] frameDown = new TextureRegion[colsDown * rowsDown];
            TextureRegion[] frameUp = new TextureRegion[colsUp * rowsUp];
            TextureRegion[] frameLeft = new TextureRegion[colsLeft * rowsLeft];
            TextureRegion[] frameRight = new TextureRegion[colsRight * rowsRight];

            int index = 0;

            for (int i = 0; i < rowsIdle; i++) {
                for (int j = 0; j < colsIdle; j++) {
                    frameIdle[index++] = tmpIdle[i][j];
                }
            }

            index = 0;

            for (int i = 0; i < rowsDead; i++) {
                for (int j = 0; j < colsDead; j++) {
                    frameDead[index++] = tmpDead[i][j];
                }
            }

            index = 0;

            for (int i = 0; i < rowsDown; i++) {
                for (int j = 0; j < colsDown; j++) {
                    frameDown[index++] = tmpDown[i][j];
                }
            }

            index = 0;

            for (int i = 0; i < rowsUp; i++) {
                for (int j = 0; j < colsUp; j++) {
                    frameUp[index++] = tmpUp[i][j];
                }
            }

            index = 0;

            for (int i = 0; i < rowsRight; i++) {
                for (int j = 0; j < colsRight; j++) {
                    frameRight[index++] = tmpRight[i][j];
                }
            }

            index = 0;

            for (int i = 0; i < rowsLeft; i++) {
                for (int j = 0; j < colsLeft; j++) {
                    frameLeft[index++] = tmpLeft[i][j];
                }
            }

            animationIdle = new Animation<TextureRegion>(delayFrame, frameIdle);
            animationDead = new Animation<TextureRegion>(delayFrame, frameDead);
            animationWalkDown = new Animation<TextureRegion>(delayFrame, frameDown);
            animationWalkUp = new Animation<TextureRegion>(delayFrame, frameUp);
            animationWalkLeft = new Animation<TextureRegion>(delayFrame, frameLeft);
            animationWalkRight = new Animation<TextureRegion>(delayFrame, frameRight);

            animation=animationIdle;
        }
    }

    public void update(MapGame map){
        String pergerakan;

        pergerakan= analog.update();

        if (pergerakan=="up"){
            if (y+height+1<map.border[map.jumlahTileMetal-1][map.jumlahTileMetal-1].getyPosition()){
                animation=animationWalkUp;
                walkUp();
            }
        } else if (pergerakan=="down") {
            if (y-1>map.border[0][0].getyPosition()+map.heightTile){
                animation=animationWalkDown;
                walkDown();
            }
        } else if (pergerakan=="right") {

        } else if (pergerakan=="left") {
            if (x-1>map.border[0][0].getxPosition()+map.widthTile){
                animation=animationWalkLeft;
                walkLeft();
            }
        } else {
            animation=animationIdle;
        }
    }

    public void walkUp(){
        y+=speed;
    }

    public void walkDown(){
        y-=speed;
    }

    public void walkLeft(){
        x-=speed;
    }

    public void walkRight(){
        x+=speed;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Animation<TextureRegion> getAnimation() {
        return animation;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }
}
