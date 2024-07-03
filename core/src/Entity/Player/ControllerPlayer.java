package Entity.Player;

import Utility.SpawnTile;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ControllerPlayer {

    int jumlahPlayer;
    Player[] player;
    float stateTime;

    public ControllerPlayer(int jumlahPlayer, SpawnTile[] spawnTile){
        this.jumlahPlayer=jumlahPlayer;
        player= new Player[jumlahPlayer];


        for (int i=0; i<jumlahPlayer; i++){
            player[i]= new Player(spawnTile[i].getxPosition(), spawnTile[i].getyPosition(), i);
        }
    }

    public float getXPositionPlayer(int i){
        return player[i].getX();
    }

    public float getYPositionPlayer(int i){
        return  player[i].getY();
    }

    public TextureRegion drawPlayer(int i, float delta) {
        stateTime += delta;
        TextureRegion currentFrame = (TextureRegion) player[i].getAnimation().getKeyFrame(stateTime, true);

        return currentFrame;
    }

    public float getWidthPlayer(int i){
        return player[i].getWidth();
    }

    public float getHeightPlayer(int i){
        return player[i].getHeight();
    }

    public void update(int i){
        player[i].update();
    }

}
