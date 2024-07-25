package GameScreen;

import bomberman.game.BomberMan;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SettingScreen implements Screen {

    SpriteBatch batch;

    Texture backgorund;;
    float widthBackground=BomberMan.widthScreen;
    float heightBackground=BomberMan.heightScreen;
    float xBackground=0;
    float yBackground=0;

    Texture settingBackground;
    private final float widthSettingBackground=1038;
    private final float heghtSettingBackground=614;
    private final float xSettingBackground= BomberMan.widthScreen/2-widthSettingBackground/2;
    private final float ySettingBackground= BomberMan.heightScreen/2-heghtSettingBackground/2;


    SettingScreen(){
        batch= new SpriteBatch();
        backgorund = new Texture("D:\\Project coding\\bomberMan\\assets\\MainMenuScreen\\background.png");
        settingBackground= new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\settingBackground.png");
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(backgorund,xBackground,yBackground,widthBackground,heightBackground);
        batch.draw(settingBackground,xSettingBackground,ySettingBackground,widthSettingBackground,heghtSettingBackground);

        batch.end();
    }

    @Override
    public void resize(int i, int i1) {

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
