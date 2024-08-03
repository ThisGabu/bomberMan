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
    public static boolean instruction= false;
    public static boolean setting=false;
    public static boolean win= false;
    public static int playerWin = 0;

    public static int numberMap=1;
    public static int jumlahMap=2;
    public static int jumlahTileRumput=21;
    public static int jumlahTileMetal=jumlahTileRumput+2;
    public static int panjangMap= 21;
    public static int tinggiMap= 21;
    public static float volumeScreen=0.5f;
    public static float volumeItem=0.25f;

    Screen mainMenuScreen;
    Screen playScreen;
    Screen pauseScreen;
    Screen winScreen;
    Screen loadingScreen;
    Screen settingScreen;
    Screen instructionScreen;

    MapGame map;

    public ControllerScreen(){
        loadingScreen= new LoadingScreen();
        mainMenuScreen = new MainMenuScreen();
        pauseScreen = new PauseScreen();
        mainMenu = true;
        loading=false;
        settingScreen= new SettingScreen();
        instructionScreen= new InstructionScreen();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        if (true) {


            if (loading){
                loadingScreen.render(delta);
                if (restartMap) {
                    map = new MapGame(numberMap,jumlahTileRumput,jumlahTileRumput,jumlahTileMetal,jumlahTileMetal);
                    playScreen = new PlayScreen(map);
                    winScreen = null;
                    restartMap = false;
                }
            } else if (instruction) {
                instructionScreen.render(delta);
            } else if (setting) {
                settingScreen.render(delta);
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
            } else if (mainMenu) {
                mainMenuScreen.render(delta);
            }
        } else {
            instructionScreen.render(delta);
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
