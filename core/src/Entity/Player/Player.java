package Entity.Player;

import Entity.Bomb.Bomb;
import Entity.Item.Item;
import Utility.Analog.Analog;
import Utility.Analog.Analog1;
import Utility.Analog.Analog2;
import Utility.HitBox;
import Utility.MapGame;
import bomberman.game.BomberMan;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player {

    final float delayFrame=0.25f;
    final float delayBombFrame=0.1f;
    final float speed= BomberMan.heightScreen/MapGame.heightTile/4/3;
    float width=MapGame.widthTile-15;
    float height=MapGame.heightTile-15;

    int capacityBomb = 2;
    int rangeBomb= 2;
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

    boolean upRange=false;
    boolean upCapacity=false;

    boolean alive= true;
    boolean death=false;
    boolean shield= false;
    boolean stun= false;

    float shieldTime= 5;
    float stunTime= 3;
    float shieldTimer= 0;
    float stunTimer= 0;


    int numberPlayer;

    boolean placeBomb=false;

    Analog analog;

    public static Sound soundJalan;
    public static Music music;

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

    private static final int colsStun = 1;
    private static final int rowsStun = 8;
    Texture stunEffect;
    Animation<TextureRegion> animationStun;

    private static final int colsShield = 10;
    private static final int rowsShield = 1;
    Texture shieldEffect;
    Animation<TextureRegion> animationShield;

    float timer = 0;

    Animation<TextureRegion> animation;

    Player(float x, float y, int player) {
        this.x = x;
        this.y = y;
        numberPlayer=player;

        soundJalan = Gdx.audio.newSound(Gdx.files.internal("D:\\Project coding\\bomberMan\\assets\\SoundEffect\\jalan.mp3"));
        stunEffect = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\effect\\stunEffect.png");
        shieldEffect = new Texture("D:\\Project coding\\bomberMan\\assets\\playerAnimation\\effect\\shieldEffect.png");

        TextureRegion[][] tmpStun = TextureRegion.split(stunEffect, stunEffect.getWidth() / colsStun, stunEffect.getHeight() / rowsStun);
        TextureRegion[] frameStun = new TextureRegion[colsStun * rowsStun];
        TextureRegion[][] tmpShield = TextureRegion.split(shieldEffect, shieldEffect.getWidth() / colsShield, shieldEffect.getHeight() / rowsShield);
        TextureRegion[] frameShield = new TextureRegion[colsShield * rowsShield];

        int i1= 0;

        for (int i = 0; i < rowsStun; i++) {
            for (int j = 0; j < colsStun; j++) {
                frameStun[i1++] = tmpStun[i][j];
            }
        }

        i1= 0;

        for (int i = 0; i < rowsShield; i++) {
            for (int j = 0; j < colsShield; j++) {
                frameShield[i1++] = tmpShield[i][j];
            }
        }

        animationShield = new Animation<TextureRegion>(delayFrame, frameShield);
        animationStun = new Animation<TextureRegion>(delayFrame, frameStun);

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
            animationPlaceBomb = new Animation<TextureRegion>(delayBombFrame, frameBomb);

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
            animationPlaceBomb = new Animation<TextureRegion>(delayBombFrame, frameBomb);

            animation=animationIdle;
        }

        bom= new Bomb(x,y,i,j,rangeBomb,numberPlayer);
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
        bom.setRangeExplosion(rangeBomb);
    }

    public boolean getIsBomb(){
        return isBomb;
    }

    public void setIsBomb(boolean isBomb){
        this.isBomb=isBomb;
    }

    public void deadAnimation(float delta){
        if (timer<animationDead.getAnimationDuration()/2){
            timer+=delta;
        } else {
            death=false;
            alive=false;
            timer=0;
        }
    }

    public void update(MapGame map, float delta){

        bombUpdate();
        if (shield) {
            updateShield(delta);
        }
        if (stun) {
            updateStun(delta);
        }
        pergerakan= analog.update();

        if (death){
            animation=animationDead;
            deadAnimation(delta);
        } else {
            if (!stun) {
                if (placeBomb) {
                    if (timer < animationPlaceBomb.getAnimationDuration() / 2) {
                        timer += delta;
                    } else {
                        timer=0;
                        placeBomb = false;
                        isBomb = true;
                    }
                } else {
                    if (pergerakan == "bomb" && capacityBomb > 0) {
                        animation = animationPlaceBomb;
                        timer = 0;
                        placeBomb = true;
                        capacityBomb--;
                    } else if (pergerakan == "up") {
                        if (y + height + 1 < map.border[map.jumlahTileMetal - 1][map.jumlahTileMetal - 1].getyPosition()) {
                            if (up) {
                                animation = animationWalkUp;
                                walkUp();

                            } else {
                                animation = animationIdle;
                            }
                        }
                    } else if (pergerakan == "down") {
                        if (y - 1 > map.border[0][0].getyPosition() + map.heightTile) {
                            if (down) {
                                animation = animationWalkDown;
                                walkDown();
                            } else {
                                animation = animationIdle;
                            }
                        }
                    } else if (pergerakan == "right") {
                        if (x + width + 1 < map.border[map.jumlahTileMetal - 1][map.jumlahTileMetal - 1].getxPosition()) {
                            if (right) {
                                animation = animationWalkRight;
                                walkRight();
                            } else {
                                animation = animationIdle;
                            }
                        } else {
                            animation = animationIdle;
                        }

                    } else if (pergerakan == "left") {
                        if (x - 1 > map.border[0][0].getxPosition() + map.widthTile) {
                            if (left) {
                                animation = animationWalkLeft;
                                walkLeft();
                            } else {
                                animation = animationIdle;
                            }
                        }
                    } else {
                        animation = animationIdle;
                    }
                }
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

    public void setDeath(boolean death) {
        this.death = death;
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

    public void claimItem(String item){

        if (item=="shield"){
            shield= true;
            shieldTimer= 0;
        } else if (item == "stun") {
            stun=true;
            stunTimer= 0;
        } else if (item == "bombCapacity") {
            capacityBomb++;
        } else if (item == "bombRange") {
            rangeBomb++;
        }
    }

    public static Sound getSoundJalan() {
        return soundJalan;
    }

    public void upRangeBomb(){
        bom.upRange();
        upRange=false;
    }

    public void updateShield(float delta){
        if (shieldTimer<shieldTime){
            shieldTimer+=delta;
        } else {
            shield=false;
        }
    }

    public void updateStun(float delta){
        if (stunTimer<stunTime){
            stunTimer+=delta;
        } else {
            stun=false;
        }
    }

    public boolean isShield() {
        return shield;
    }

    public boolean isStun() {
        return stun;
    }

    public Animation<TextureRegion> getAnimationStun() {
        return animationStun;
    }

    public Animation<TextureRegion> getAnimationShield() {
        return animationShield;
    }

    public Texture getStunEffect() {
        return stunEffect;
    }

    public Texture getShieldEffect() {
        return shieldEffect;
    }

    public void bombExplosion(){
        capacityBomb+=1;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWidth(float width) {
        this.width = width;
    }
}
