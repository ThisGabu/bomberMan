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
    public static boolean loading;
    public static boolean win= false;
    public static int playerWin = 0;

    Screen mainMenuScreen;
    Screen playScreen;
    Screen pauseScreen;
    Screen winScreen;
    Screen loadingScreen;
    Screen settingScreen;

    MapGame map;

    public ControllerScreen(){
        map= new MapGame(2);
        loadingScreen= new LoadingScreen();
        mainMenuScreen = new MainMenuScreen();
        playScreen = new PlayScreen(map);
        pauseScreen = new PauseScreen();
        mainMenu = true;
        loading=false;
        settingScreen= new SettingScreen();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        if (false) {


            if (loading){
                if (restartMap) {
                    map = new MapGame(2);
                    playScreen = new PlayScreen(map);
                    winScreen = null;
                    restartMap = false;
                }
                loadingScreen.render(delta);
            } else if (mainMenu) {
                mainMenuScreen.render(delta);
            } else if (play) {
                playerWin = 0;
                if (PlayScreen.pause) {
                    pauseScreen.render(delta);
                } else {
                    playScreen.render(delta);
                }
            } else if (win) {

                if (winScreen == null) {
                    winScreen = new WinScreen(playerWin);
                }

                winScreen.render(delta);
            }
        } else {
            settingScreen.render(delta);
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
