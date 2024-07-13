package Entity.Player;

import Entity.Bomb.Bomb;
import Utility.Analog.Analog;
import Utility.Analog.Analog1;
import Utility.Analog.Analog2;
import Utility.HitBox;
import Utility.MapGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player {

    final float delayFrame=0.25f;
    final float speed=1;
    final float width=20;
    final float height=20;

    int capacityBomb = 2;
    int capacityBombBefore;

    Bomb bom;
    HitBox hitBox;
    boolean isBomb = false;

    float x;
    float y;
    int i;
    int j;

    String pergerakan;
    String pergerakanBefore;
    boolean up= true;
    boolean down= true;
    boolean right= true;
    boolean left= true;

    boolean alive= true;

    int numberPlayer = 0;

    boolean placeBomb=false;

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

    private static final int colsBomb = 1;
    private static final int rowsBomb = 6;
    float placeBombDelay = (colsBomb*rowsBomb/2) * delayFrame;
    Texture playerPlaceBomb;
    Animation<TextureRegion> animationPlaceBomb;

    float timer = 0;

    Animation<TextureRegion> animation;

    Player(float x, float y, int player) {
        this.x = x;
        this.y = y;
        numberPlayer=player;

        if (player == 0) {
            analog= new Analog1();
            playerDead = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player1\\playerDead.png");
            playerIdle = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player1\\playerIdle.png");
            playerWalkDown = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player1\\playerWalkDown.png");
            playerWalkUp = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player1\\playerWalkUp.png");
            playerWalkLeft = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player1\\playerWalkLeft.png");
            playerWalkRight = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player1\\playerWalkRight.png");
            playerPlaceBomb = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player1\\playerPlaceBomb.png");

            TextureRegion[][] tmpDead = TextureRegion.split(playerDead, playerDead.getWidth() / colsDead, playerDead.getHeight() / rowsDead);
            TextureRegion[][] tmpIdle = TextureRegion.split(playerIdle, playerIdle.getWidth() / colsIdle, playerIdle.getHeight() / rowsIdle);
            TextureRegion[][] tmpDown = TextureRegion.split(playerWalkDown, playerWalkDown.getWidth() / colsDown, playerWalkDown.getHeight() / rowsDown);
            TextureRegion[][] tmpUp = TextureRegion.split(playerWalkUp, playerWalkUp.getWidth() / colsUp, playerWalkUp.getHeight() / rowsUp);
            TextureRegion[][] tmpLeft = TextureRegion.split(playerWalkLeft, playerWalkLeft.getWidth() / colsLeft, playerWalkLeft.getHeight() / rowsLeft);
            TextureRegion[][] tmpRight = TextureRegion.split(playerWalkRight, playerWalkRight.getWidth() / colsRight, playerWalkRight.getHeight() / rowsRight);
            TextureRegion[][] tmpBomb = TextureRegion.split(playerPlaceBomb, playerPlaceBomb.getWidth() / colsBomb, playerPlaceBomb.getHeight() / rowsBomb);

            TextureRegion[] frameIdle = new TextureRegion[colsIdle * rowsIdle];
            TextureRegion[] frameDead = new TextureRegion[colsDead * rowsDead];
            TextureRegion[] frameDown = new TextureRegion[colsDown * rowsDown];
            TextureRegion[] frameUp = new TextureRegion[colsUp * rowsUp];
            TextureRegion[] frameLeft = new TextureRegion[colsLeft * rowsLeft];
            TextureRegion[] frameRight = new TextureRegion[colsRight * rowsRight];
            TextureRegion[] frameBomb = new TextureRegion[colsBomb * rowsBomb];

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

            index = 0;
            for (int i = 0; i < rowsBomb; i++) {
                for (int j = 0; j < colsBomb; j++) {
                    frameBomb[index++] = tmpBomb[i][j];
                }
            }

            animationIdle = new Animation<TextureRegion>(delayFrame, frameIdle);
            animationDead = new Animation<TextureRegion>(delayFrame, frameDead);
            animationWalkDown = new Animation<TextureRegion>(delayFrame, frameDown);
            animationWalkUp = new Animation<TextureRegion>(delayFrame, frameUp);
            animationWalkLeft = new Animation<TextureRegion>(delayFrame, frameLeft);
            animationWalkRight = new Animation<TextureRegion>(delayFrame, frameRight);
            animationPlaceBomb = new Animation<TextureRegion>(delayFrame, frameBomb);

            animation=animationIdle;
        } else {
            analog= new Analog2();
            playerDead = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player2\\playerDead.png");
            playerIdle = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player2\\playerIdle.png");
            playerWalkDown = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player2\\playerWalkDown.png");
            playerWalkUp = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player2\\playerWalkUp.png");
            playerWalkLeft = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player2\\playerWalkLeft.png");
            playerWalkRight = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player2\\playerWalkRight.png");
            playerPlaceBomb = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\player2\\playerPlaceBomb.png");

            TextureRegion[][] tmpDead = TextureRegion.split(playerDead, playerDead.getWidth() / colsDead, playerDead.getHeight() / rowsDead);
            TextureRegion[][] tmpIdle = TextureRegion.split(playerIdle, playerIdle.getWidth() / colsIdle, playerIdle.getHeight() / rowsIdle);
            TextureRegion[][] tmpDown = TextureRegion.split(playerWalkDown, playerWalkDown.getWidth() / colsDown, playerWalkDown.getHeight() / rowsDown);
            TextureRegion[][] tmpUp = TextureRegion.split(playerWalkUp, playerWalkUp.getWidth() / colsUp, playerWalkUp.getHeight() / rowsUp);
            TextureRegion[][] tmpLeft = TextureRegion.split(playerWalkLeft, playerWalkLeft.getWidth() / colsLeft, playerWalkLeft.getHeight() / rowsLeft);
            TextureRegion[][] tmpRight = TextureRegion.split(playerWalkRight, playerWalkRight.getWidth() / colsRight, playerWalkRight.getHeight() / rowsRight);
            TextureRegion[][] tmpBomb = TextureRegion.split(playerPlaceBomb, playerPlaceBomb.getWidth() / colsBomb, playerPlaceBomb.getHeight() / rowsBomb);

            TextureRegion[] frameIdle = new TextureRegion[colsIdle * rowsIdle];
            TextureRegion[] frameDead = new TextureRegion[colsDead * rowsDead];
            TextureRegion[] frameDown = new TextureRegion[colsDown * rowsDown];
            TextureRegion[] frameUp = new TextureRegion[colsUp * rowsUp];
            TextureRegion[] frameLeft = new TextureRegion[colsLeft * rowsLeft];
            TextureRegion[] frameRight = new TextureRegion[colsRight * rowsRight];
            TextureRegion[] frameBomb = new TextureRegion[colsBomb * rowsBomb];



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

            index = 0;

            for (int i = 0; i < rowsBomb; i++) {
                for (int j = 0; j < colsBomb; j++) {
                    frameBomb[index++] = tmpBomb[i][j];
                }
            }

            animationIdle = new Animation<TextureRegion>(delayFrame, frameIdle);
            animationDead = new Animation<TextureRegion>(delayFrame, frameDead);
            animationWalkDown = new Animation<TextureRegion>(delayFrame, frameDown);
            animationWalkUp = new Animation<TextureRegion>(delayFrame, frameUp);
            animationWalkLeft = new Animation<TextureRegion>(delayFrame, frameLeft);
            animationWalkRight = new Animation<TextureRegion>(delayFrame, frameRight);
            animationPlaceBomb = new Animation<TextureRegion>(delayFrame, frameBomb);

            animation=animationIdle;
        }

        bom= new Bomb(x,y,i,j);
        capacityBombBefore=capacityBomb;
        hitBox= new HitBox(getWidth(),getHeight(),getX(),getY());
    }

    public HitBox getHitBox(){
        return hitBox;
    }

    public Bomb getBomb(){
        capacityBomb--;
        return bom;
    }

    public void setCapacityBomb(int capacityBomb) {
        this.capacityBomb=capacityBomb;
    }

    public void bombUpdate() {

        capacityBombBefore = capacityBomb;

        bom.setX(x);
        bom.setY(y);
        bom.setI(i);
        bom.setJ(j);
        bom.setPlayer(numberPlayer);

    }

    public boolean getIsBomb(){
        return isBomb;
    }

    public void setIsBomb(boolean isBomb){
        this.isBomb=isBomb;
    }

    public void update(MapGame map, float delta){

        bombUpdate();
        pergerakan= analog.update();

        if (placeBomb){
            Animation<TextureRegion> animation1;
            animation1=bom.getAnimation();
            if (timer>=animation1.getAnimationDuration()/2){
                placeBomb=false;
                capacityBomb++;
                isBomb=true;
            } else {
                timer+=delta;
            }
        } else {
            if (pergerakan=="bomb"&&capacityBomb>0){
                animation=animationPlaceBomb;
                timer=0;
                placeBomb=true;
                capacityBomb--;
            } else if (pergerakan=="up"){
                if (y+height+1<map.border[map.jumlahTileMetal-1][map.jumlahTileMetal-1].getyPosition()){
                    if (up){
                        animation=animationWalkUp;
                        walkUp();
                    } else {
                        animation = animationIdle;
                    }
                }
            } else if (pergerakan=="down") {
                if (y-1>map.border[0][0].getyPosition()+map.heightTile){
                    if (down){
                        animation=animationWalkDown;
                        walkDown();
                    } else {
                        animation = animationIdle;
                    }
                }
            } else if (pergerakan=="right") {
                if (x+width+1<map.border[map.jumlahTileMetal-1][map.jumlahTileMetal-1].getxPosition()) {
                    if (right){
                        animation = animationWalkRight;
                        walkRight();
                    } else {
                        animation = animationIdle;
                    }
                } else {
                    animation = animationIdle;
                }

            } else if (pergerakan=="left") {
                if (x-1>map.border[0][0].getxPosition()+map.widthTile){
                    if (left){
                        animation=animationWalkLeft;
                        walkLeft();
                    } else {
                        animation=animationIdle;
                    }
                }
            } else {
                animation=animationIdle;
            }
        }

        hitBox.update(getX(),getY());
        setTile();
    }

    public void setTile(){
        setI(hitBox.getI());
        setJ(hitBox.getJ());
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isLeft() {
        return left;
    }

    public String getPergerakan(){
        return pergerakan;
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

    public boolean getPlaceBomb(){
        return placeBomb;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getPergerakanBefore() {
        return pergerakanBefore;
    }

    public void setPergerakanBefore(String pergerakanBefore) {
        this.pergerakanBefore = pergerakanBefore;
    }

    public int getCapacityBomb() {
        return capacityBomb;
    }
}
