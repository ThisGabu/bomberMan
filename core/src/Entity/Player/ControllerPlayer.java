package Entity.Player;

import Entity.Bomb.Bomb;
import Entity.Item.Item;
import Utility.HitBox;
import Utility.MapGame;
import Utility.SpawnTile;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;

public class ControllerPlayer {

    int jumlahPlayer;
    Player[] player;
    float stateTime;
    Random random= new Random();

    public ControllerPlayer(int jumlahPlayer, SpawnTile[] spawnTile) {
        this.jumlahPlayer = jumlahPlayer;
        player = new Player[jumlahPlayer];


        for (int i = 0; i < jumlahPlayer; i++) {
            player[i] = new Player(spawnTile[i].getxPosition(), spawnTile[i].getyPosition(), i);
        }
    }

    public int getCapacityBomb(int index) {
        return player[index].getCapacityBomb();
    }


    public void playerDead(int i) {
        player[i].setDeath(true);
    }

    public boolean isAlive(int i) {
        return player[i].isAlive();
    }

    public String getPergerakan(int i) {
        return player[i].getPergerakan();
    }

    public void setUp(boolean up, int index) {
        player[index].setUp(up);
    }

    public void setRight(boolean right, int index) {
        player[index].setRight(right);
    }

    public void setLeft(boolean left, int index) {
        player[index].setLeft(left);
    }

    public void setDown(boolean down, int index) {
        player[index].setDown(down);
    }

    public boolean isUp(int index) {
        return player[index].isUp();
    }

    public HitBox getHitbox(int index) {
        return player[index].getHitBox();
    }

    public boolean isRight(int index) {
        return player[index].isRight();
    }

    public boolean isDown(int index) {
        return player[index].isDown();
    }

    public boolean isLeft(int index) {
        return player[index].left;
    }

    public String getPergerakanBefore(int index) {
        return player[index].pergerakanBefore;
    }

    public void setPergerakanBefore(int index, String pergerakan) {
        player[index].setPergerakanBefore(pergerakan);
    }

    public void setJ(int index, int J) {
        player[index].setJ(J);
    }

    public void setI(int index, int I) {
        player[index].setI(I);
    }

    public int getJ(int index) {
        return player[index].getJ();
    }

    public int getI(int index) {
        return player[index].getI();
    }

    public float getXPositionPlayer(int i) {
        return player[i].getX();
    }

    public float getYPositionPlayer(int i) {
        return player[i].getY();
    }

    public int getJumlahPlayer() {
        return jumlahPlayer;
    }

    public boolean getPlaceBomb(int i) {
        return player[i].getPlaceBomb();
    }

    public Bomb getBomb(int i) {
        return player[i].getBomb();
    }

    public void setCapacityBomb(int i, int capacityBomb) {
        player[i].setCapacityBomb(capacityBomb);
    }

    public boolean getIsBomb(int i) {
        return player[i].getIsBomb();
    }

    public void setIsBomb(int i, boolean isBomb) {
        player[i].setIsBomb(isBomb);
    }

    public TextureRegion drawPlayer(int i, float delta) {
        stateTime += delta;
        TextureRegion currentFrame;
        currentFrame = (TextureRegion) player[i].getAnimation().getKeyFrame(stateTime, true);

        return currentFrame;
    }

    public float getWidthPlayer(int i) {
        return player[i].getWidth();
    }

    public float getHeightPlayer(int i) {
        return player[i].getHeight();
    }

    public void update(int i, MapGame map, float delta) {
        player[i].update(map, delta);
    }

    public void claimItem(String item, int index) {
        if (item == "stun") {
            int number= random.nextInt(100);
            if (number<75){
                for (int i = 0; i < getJumlahPlayer(); i++) {
                    if (i != index) {
                        System.out.println("stun");
                        player[i].claimItem(item);
                    }
                }
            } else {
                for (int i = 0; i < getJumlahPlayer(); i++) {
                    if (i == index) {
                        System.out.println("stun");
                        player[i].claimItem(item);
                    }
                }
            }

        } else {
            player[index].claimItem(item);
        }
    }

    public Sound getSound(int index) {
        return player[index].getSoundJalan();
    }

    public boolean isShield(int index) {
        return player[index].isShield();
    }

    public int getRangeExplosion(int index) {
        return player[index].rangeBomb;
    }

    public boolean isStun(int index) {
        return player[index].isStun();
    }

    public TextureRegion drawStun(int i, float delta) {
        stateTime += delta;
        TextureRegion currentFrame;
        currentFrame = (TextureRegion) player[i].getAnimationStun().getKeyFrame(stateTime, true);
        return currentFrame;
    }

    public TextureRegion drawShield(int i, float delta) {
        stateTime += delta;
        TextureRegion currentFrame;
        currentFrame = (TextureRegion) player[i].getAnimationShield().getKeyFrame(stateTime, true);
        return currentFrame;
    }

    public Texture getPictureShield(int index) {
        return player[index].getShieldEffect();
    }

    public Texture getPictureStun(int index) {
        return player[index].getStunEffect();
    }

    public void bombExplosion(int index){
        player[index].bombExplosion();
    }

    public void setWidth(float width, int index){
        player[index].setWidth(width);
    }

    public void setHeight(float height, int index){
        player[index].setHeight(height);
    }

    public void setX(int index, float x){
        player[index].setX(x);
    }

    public void setY(int index,float y){
        player[index].setY(y);
    }
}
