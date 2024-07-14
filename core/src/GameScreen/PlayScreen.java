package GameScreen;

import Entity.Bomb.Ledakan;
import Entity.Player.ControllerPlayer;
import Utility.HitBox;
import Utility.MapGame;
import Utility.Update;
import bomberman.game.BomberMan;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class PlayScreen implements Screen {

    SpriteBatch batch;
    Texture backgorund;
    Screen pauseScreen;
    MapGame map;
    ControllerPlayer player;
    Update update;


    private static final float width = BomberMan.widthScreen;
    private static final float height = BomberMan.heightScreen;
    private static final float xBackground = 0;
    private static final float yBackgorund = 0;

    public static boolean pause;
    boolean destroy;
    boolean hitBox=true;

    final int jumlahPlayer=2;

    PlayScreen(MapGame map){
        batch = new SpriteBatch();
        backgorund = new Texture("D:\\Project coding\\bomberMan\\assets\\MainMenuScreen\\background.png");
        pauseScreen = new PauseScreen();
        this.map= map;
        player= new ControllerPlayer(jumlahPlayer, map.spawnTile);
        update= new Update(player,map);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {


        batch.begin();
        batch.draw(backgorund, xBackground, yBackgorund, width, height);

        if (Gdx.input.isKeyPressed(Input.Keys.M)){
            for (int i=0; i<map.jumlahTileRumput; i++){
                for (int j=0; j<map.jumlahTileRumput; j++){
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
        }

        update.update(delta);

        for (int i=0; i<map.jumlahTileMetal; i++){
            for (int j=0; j<map.jumlahTileMetal; j++){
                batch.draw(map.getBorder(i,j), map.border[i][j].getxPosition(), map.border[i][j].getyPosition(), map.widthTile, map.heightTile);
            }
        }

        for (int i=0; i<map.jumlahTileRumput; i++){
            for (int j=0; j<map.jumlahTileRumput; j++){
                batch.draw(map.getTilePicture(i,j), map.tile[i][j].getxPosition(), map.tile[i][j].getyPosition(), map.widthTile, map.heightTile);
            }
        }

        for (int i=0; i<map.jumlahTileRumput; i++){
            for (int j=0; j<map.jumlahTileRumput; j++){
                if (map.tile[i][j].item()){
                    batch.draw(map.drawItem(i,j, delta), map.tile[i][j].xPosition, map.tile[i][j].yPosition);

                }
            }
        }

        for (int i=0; i<map.jumlahTileRumput; i++){
            for (int j=0; j<map.jumlahTileRumput; j++){
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
            }
        }

        int index=0;
        for (int i=0; i<map.jumlahTileRumput; i++){
            for (int j=0; j<map.jumlahTileRumput; j++){

                    if ((player.getXPositionPlayer(index)>=map.tile[i][j].getxPosition()&&player.getXPositionPlayer(index)<=map.tile[i][j].getxPosition()+map.widthTile&&player.getYPositionPlayer(index)>=map.tile[i][j].getyPosition()&&player.getYPositionPlayer(index)<=map.tile[i][j].getyPosition()+map.heightTile)||(player.getXPositionPlayer(index)+player.getWidthPlayer(index)>=map.tile[i][j].getxPosition()&&player.getXPositionPlayer(index)+player.getWidthPlayer(index)<=map.tile[i][j].getxPosition()+map.widthTile&&player.getYPositionPlayer(index)+player.getHeightPlayer(index)>=map.tile[i][j].getyPosition()&&player.getYPositionPlayer(index)+player.getHeightPlayer(index)<=map.tile[i][j].getyPosition()+map.heightTile)){
                        map.setPlayer(i,j,true);
                    } else if ((player.getXPositionPlayer(1)>=map.tile[i][j].getxPosition()&&player.getXPositionPlayer(index+1)<=map.tile[i][j].getxPosition()+map.widthTile&&player.getYPositionPlayer(index+1)>=map.tile[i][j].getyPosition()&&player.getYPositionPlayer(index+1)<=map.tile[i][j].getyPosition()+map.heightTile)||(player.getXPositionPlayer(index+1)+player.getWidthPlayer(index+1)>=map.tile[i][j].getxPosition()&&player.getXPositionPlayer(index+1)+player.getWidthPlayer(index+1)<=map.tile[i][j].getxPosition()+map.widthTile&&player.getYPositionPlayer(index+1)+player.getHeightPlayer(index+1)>=map.tile[i][j].getyPosition()&&player.getYPositionPlayer(index+1)+player.getHeightPlayer(index+1)<=map.tile[i][j].getyPosition()+map.heightTile)) {
                        map.setPlayer(i,j,true);
                    } else {
                        map.setPlayer(i,j,false);
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

        System.out.println(player.getI(0)+" "+player.getJ(0));
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
