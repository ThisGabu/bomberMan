package GameScreen;

import Entity.Player.ControllerPlayer;
import Utility.MapGame;
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


    private static final float width = BomberMan.widthScreen;
    private static final float height = BomberMan.heightScreen;
    private static final float xBackground = 0;
    private static final float yBackgorund = 0;

    public static boolean pause;
    boolean destroy;

    final int jumlahPlayer=2;

    PlayScreen(MapGame map){
        batch = new SpriteBatch();
        backgorund = new Texture("D:\\Project coding\\bomberMan\\assets\\MainMenuScreen\\background.png");
        pauseScreen = new PauseScreen();
        this.map= map;
        player= new ControllerPlayer(jumlahPlayer, map.spawnTile);
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

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            pause=true;
        }

        map.update();

        for (int i=0; i<jumlahPlayer; i++){
            player.update(i);
        }

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

        for (int i=0; i<jumlahPlayer; i++){
            batch.draw(player.drawPlayer(i, delta), player.getXPositionPlayer(i), player.getYPositionPlayer(i), player.getWidthPlayer(i), player.getHeightPlayer(i));
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

        batch.end();
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
