package GameScreen;

import Utility.MapGame;
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

        if (ControllerScreen.numberMap==1){
            //tampilkan angka 01
        } else if (ControllerScreen.numberMap==2){
            //tampilkan angka 02
        }

        if (false){
            //nambah nomor angka map
            if (ControllerScreen.numberMap==MapGame.jumlahMap){
                ControllerScreen.numberMap=1;
            } else {
                ControllerScreen.numberMap++;
            }
        }

        if (false){
            //nambah panjang dan tinggi map
            MapGame.jumlahTileRumput+=2;
            MapGame.jumlahTileMetal+=2;
        } else if (false) {
            //kurangi panjang dan tinggi map
            MapGame.jumlahTileRumput-=2;
            MapGame.jumlahTileMetal-=2;
        }


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
