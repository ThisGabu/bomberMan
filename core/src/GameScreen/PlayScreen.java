package GameScreen;

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


    private static final float width = BomberMan.widthScreen;
    private static final float height = BomberMan.heightScreen;
    private static final float xBackground = 0;
    private static final float yBackgorund = 0;



    PlayScreen(){
        batch = new SpriteBatch();
        backgorund = new Texture("D:\\Project coding\\bomberMan\\assets\\MainMenuScreen\\background.png");

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {


        batch.begin();
        batch.draw(backgorund, xBackground, yBackgorund, width, height);
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
