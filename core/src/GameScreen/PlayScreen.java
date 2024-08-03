package GameScreen;

import Entity.Bomb.Bomb;
import Entity.Bomb.Ledakan;
import Entity.Item.Item;
import Entity.Player.ControllerPlayer;
import Utility.HitBox;
import Utility.MapGame;
import Utility.Update;
import bomberman.game.BomberMan;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.security.PublicKey;
import java.util.Scanner;

public class PlayScreen implements Screen {

    SpriteBatch batch;
    Texture backgorund;
    Screen pauseScreen;
    MapGame map;
    ControllerPlayer player;
    Update update;

    public static Music music;


    private static final float width = BomberMan.widthScreen;
    private static final float height = BomberMan.heightScreen;
    private static final float xBackground = 0;
    private static final float yBackgorund = 0;

    public static boolean pause;
    boolean destroy;
    boolean hitBox=true;

    public static final int jumlahPlayer=2;

    PlayScreen(MapGame map){
        batch = new SpriteBatch();
        backgorund = new Texture("..\\bomberMan\\assets\\MainMenuScreen\\background.png");
        pauseScreen = new PauseScreen();
        this.map= map;
        player= new ControllerPlayer(jumlahPlayer, map.spawnTile);
        update= new Update(player,map);
        music = Gdx.audio.newMusic(Gdx.files.internal("..\\bomberMan\\assets\\Music\\BacksoundPlayGame.mp3"));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        music.setVolume(ControllerScreen.volumeItem);
        music.setLooping(true);
        music.play();

        batch.begin();
        batch.draw(backgorund, xBackground, yBackgorund, width, height);

        if (Gdx.input.isKeyPressed(Input.Keys.M)){
            for (int i=0; i<map.tinggiMap; i++){
                for (int j=0; j<map.panjangMap; j++){
                    if (map.tile[i][j].getBox()){
                        map.tile[i][j].boxDesroy();
                    }
                }
            }

        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.H)){
            if (hitBox){
                hitBox=false;
            } else {
                hitBox=true;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            pause=true;
            music.dispose();
        }

        update.update(delta);

        for (int i=0; i<map.tinggiBorder; i++){
            for (int j=0; j<map.panjangBorder; j++){
                batch.draw(map.getBorder(i,j), map.border[i][j].getxPosition(), map.border[i][j].getyPosition(), map.widthTile, map.heightTile);
            }
        }

        for (int i=0; i<map.tinggiMap; i++){
            for (int j=0; j<map.panjangMap; j++){
                batch.draw(map.getTilePicture(i,j), map.tile[i][j].getxPosition(), map.tile[i][j].getyPosition(), map.widthTile, map.heightTile);
            }
        }

        for (int i=0; i<map.tinggiMap; i++){
            for (int j=0; j<map.panjangMap; j++){
                if (map.tile[i][j].item()){
                    batch.draw(map.drawItem(i,j, delta), map.tile[i][j].xPosition, map.tile[i][j].yPosition, Item.width,Item.height);

                }
            }
        }

        for (int i=0; i<map.getTinggiMap(); i++){
            for (int j=0; j<map.getPanjangMap(); j++){
                if (map.isBox(i,j)){
                    batch.draw(map.getBoxTexture(i,j), map.getxPositionBox(i,j), map.getyPositionBox(i,j), map.getWidthBox(i,j), map.getHeightBox(i,j));
                } else if (map.isWall(i,j)){
                    batch.draw(map.getWallsTexture(i,j), map.getxPosition(i,j), map.getyPosition(i,j), map.widthTile, map.heightTile);
                }
            }
        }

        for (int i=0; i<jumlahPlayer; i++){
            if (player.isAlive(i)) {
                batch.draw(player.drawPlayer(i, delta), player.getXPositionPlayer(i), player.getYPositionPlayer(i), player.getWidthPlayer(i), player.getHeightPlayer(i));

                if (player.isShield(i)){
                    batch.draw(player.drawShield(i,delta),((player.getXPositionPlayer(i)+player.getWidthPlayer(i)/2))-(player.getPictureShield(i).getHeight()/2),player.getYPositionPlayer(i)+(player.getHeightPlayer(i)/2)-(player.getPictureShield(i).getHeight()/2));
                }

                if (player.isStun(i)){
                    batch.draw(player.drawStun(i,delta),((player.getXPositionPlayer(i)+player.getWidthPlayer(i)/2))-(15/2),player.getYPositionPlayer(i)+(player.getHeightPlayer(i)),15,15);
                }
            }
        }

        for (int i=0; i<map.bombs.size(); i++) {
            batch.draw(map.getBombAnimation(i, delta), map.xBomb(i), map.yBomb(i), map.widthBomb(i), map.heightBomb(i));
        }

        for (int i=0; i<map.ledakan.size(); i++){
            Ledakan ledakan= map.getCreateLedakan(i);
            batch.draw(ledakan.drawAnimation(delta), ledakan.getX(), ledakan.getY(), ledakan.getWidth(), ledakan.getHeight());
        }

        if (hitBox) {
            for (int i = 0; i < jumlahPlayer; i++) {
                HitBox hitBox1 = player.getHitbox(i);
                batch.draw(hitBox1.getPicture(), hitBox1.getX(), hitBox1.getY(), hitBox1.getWidth(), hitBox1.getHeight());
            }

            for (int i=0; i<map.ledakan.size(); i++){
                Ledakan ledakan= map.getCreateLedakan(i);
                HitBox hitBox1 = ledakan.getHitBox();
                batch.draw(hitBox1.getPicture(), hitBox1.getX(), hitBox1.getY(), hitBox1.getWidth(), hitBox1.getHeight());
            }
        }


        batch.end();

        System.out.println(player.getI(0));
        System.out.println(player.getJ(0));

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }
}
