package GameScreen;

import bomberman.game.BomberMan;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class ControllerScreen implements Screen {

    public static boolean mainMenu;
    public static boolean play;
    public static boolean exitGame;

    Screen mainMenuScreen;
    Screen playScreen;


    public ControllerScreen(){
        mainMenuScreen = new MainMenuScreen();
        playScreen = new PlayScreen();
        mainMenu = true;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {




        if (mainMenu){
            mainMenuScreen.render(delta);
        } else if (play) {
            playScreen.render(delta);
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

    }
}
