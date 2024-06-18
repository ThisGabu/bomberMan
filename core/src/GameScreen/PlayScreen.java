package GameScreen;

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


    private static final float width = BomberMan.widthScreen;
    private static final float height = BomberMan.heightScreen;
    private static final float xBackground = 0;
    private static final float yBackgorund = 0;

    public static boolean pause;



    PlayScreen(){
        batch = new SpriteBatch();
        backgorund = new Texture("D:\\Project coding\\bomberMan\\assets\\MainMenuScreen\\background.png");
        pauseScreen = new PauseScreen();
        map= new MapGame();
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {


        batch.begin();
        batch.draw(backgorund, xBackground, yBackgorund, width, height);

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            pause=true;
        }

        for (int i=0; i<map.jumlahTileMetal; i++){
            for (int j=0; j<map.jumlahTileMetal; j++){
                batch.draw(map.borderTile[i][j], map.xMetal[i][j], map.yMetal[i][j], map.widthTile, map.heightTile);
            }
        }

        for (int i=0; i<map.jumlahTileRumput; i++){
            for (int j=0; j<map.jumlahTileRumput; j++){
                batch.draw(map.tilePicture[i][j], map.tile[i][j].getxPosition(), map.tile[i][j].getyPosition(), map.widthTile, map.heightTile);
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
