package GameScreen;

import Utility.MapGame;
import bomberman.game.BomberMan;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import java.util.Map;

public class ControllerScreen implements Screen {

    public static boolean restartMap;

    public static boolean mainMenu;
    public static boolean play;
    public static boolean exitGame;

    Screen mainMenuScreen;
    Screen playScreen;
    Screen pauseScreen;

    MapGame map;

    public ControllerScreen(){
        map= new MapGame();
        mainMenuScreen = new MainMenuScreen();
        playScreen = new PlayScreen(map);
        pauseScreen = new PauseScreen();
        mainMenu = true;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        if (restartMap){
            map= new MapGame();
            playScreen = new PlayScreen(map);
            restartMap=false;
        }

        if (mainMenu){
            mainMenuScreen.render(delta);
        } else if (play) {
            if (PlayScreen.pause){
                pauseScreen.render(delta);
            } else {
                playScreen.render(delta);
            }
        }

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
        playScreen.dispose();
    }
}
