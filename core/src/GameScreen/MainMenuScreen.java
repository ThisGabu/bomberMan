package GameScreen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen extends ApplicationAdapter{
    public static final float width = MainGameScreen.widthScreen;
    public static final float height = MainGameScreen.heightScreen;
    public static final float xBackground = 0;
    public static final float yBackgorund = 0;



    Texture backgorund;
    SpriteBatch batch;


    @Override
    public void create () {
        batch = new SpriteBatch();
        backgorund = new Texture("D:\\Downloads\\BomberMan\\assets\\MainMenuScreen\\background.png");
    }

    @Override
    public void render () {

        batch.begin();
        batch.draw(backgorund, xBackground, yBackgorund, width, height);
        batch.end();

    }


    @Override
    public void dispose () {
        batch.dispose();
        backgorund.dispose();
    }
}

