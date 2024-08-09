package GameScreen;

import bomberman.game.BomberMan;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PauseScreen implements Screen {

    private final float widthBackground= BomberMan.widthScreen/2;
    private final float heightBackground= BomberMan.heightScreen/2;
    private final float xBackground= BomberMan.widthScreen/2-widthBackground/2;
    private final float yBackgorund= BomberMan.heightScreen/2-heightBackground/2;

    private final float widthContinue= widthBackground/2;
    private final float heightContinue= heightBackground/5;
    private final float xContinue= BomberMan.widthScreen/2-widthContinue/2;
    private final float yContinue= yBackgorund+heightBackground-heightContinue-heightContinue/2;

    private final float widthRestart= heightContinue/1.5f/25*120;
    private final float heightRestart= heightContinue/1.5f;
    private final float xRestart= BomberMan.widthScreen/2-widthRestart/2;
    private final float yRestart= BomberMan.heightScreen/2-heightRestart/2;

    private final float widthExit= widthBackground/4;
    private final float heightExit= heightBackground/5;
    private final float xExit= BomberMan.widthScreen/2-widthExit/2;
    private final float yExit= yBackgorund+heightExit/2;

    private final float widthPaused=widthBackground/2f;
    private final float heightPaused= heightBackground/4;
    private final float xPaused= BomberMan.widthScreen/2-widthPaused/2;
    private final float yPaused= yBackgorund+heightBackground;



    SpriteBatch batch;
    Texture pause;
    Texture Continue;
    Texture exit;
    Texture continueHover;
    Texture exitHover;
    Texture backgroundPause;
    Texture restart;
    Texture restartHover;

    PauseScreen(){
        batch = new SpriteBatch();

        pause = new Texture("..\\bomberMan\\assets\\PauseScreen\\paused.png");
        Continue = new Texture("..\\bomberMan\\assets\\PauseScreen\\continue.png");
        continueHover = new Texture("..\\bomberMan\\assets\\PauseScreen\\continueHover.png");
        exit = new Texture("..\\bomberMan\\assets\\PauseScreen\\exit2.png");
        exitHover = new Texture("..\\bomberMan\\assets\\PauseScreen\\exit2Hover.png");
        backgroundPause = new Texture("..\\bomberMan\\assets\\PauseScreen\\backgroundPause5.png");
        restart = new Texture("..\\bomberMan\\assets\\PauseScreen\\restart.png");
        restartHover = new Texture("..\\bomberMan\\assets\\PauseScreen\\restartHover.png");
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        MainMenuScreen.music.play();

        batch.begin();
        batch.draw(backgroundPause, xBackground, yBackgorund, widthBackground, heightBackground);
        batch.draw(exit, xExit, yExit, widthExit, heightExit);
        batch.draw(Continue, xContinue, yContinue, widthContinue, heightContinue);
        batch.draw(pause, xPaused, yPaused, widthPaused, heightPaused);
        batch.draw(restart, xRestart, yRestart, widthRestart, heightRestart);

        if (Gdx.input.getX()>xExit&&Gdx.input.getX()<xExit+widthExit&&Gdx.input.getY()<BomberMan.heightScreen-yExit&&Gdx.input.getY()>BomberMan.heightScreen-yExit-heightExit){
            if (Gdx.input.isTouched()){
                ControllerScreen.play=false;
                ControllerScreen.mainMenu=true;
                PlayScreen.pause=false;
                ControllerScreen.restartMap=true;
                MainMenuScreen.music.dispose();
            } else {
                batch.draw(exitHover, xExit, yExit, widthExit, heightExit);
            }
        } else if (Gdx.input.getX()>xContinue&&Gdx.input.getX()<xContinue+widthContinue&&Gdx.input.getY()<BomberMan.heightScreen-yContinue&&Gdx.input.getY()>BomberMan.heightScreen-yContinue-heightContinue){
            if (Gdx.input.isTouched()){
                pause.dispose();
                PlayScreen.pause=false;
                MainMenuScreen.music.dispose();
            } else {

                batch.draw(continueHover, xContinue, yContinue, widthContinue, heightContinue);
            }

        } else if (Gdx.input.getX()>xRestart&&Gdx.input.getX()<xRestart+widthRestart&&Gdx.input.getY()<BomberMan.heightScreen-yRestart&&Gdx.input.getY()>BomberMan.heightScreen-yRestart-heightRestart) {
            if (Gdx.input.isTouched()){
                PlayScreen.pause=false;
                ControllerScreen.restartMap=true;
                ControllerScreen.loading=true;
                MainMenuScreen.music.dispose();
            } else {
                batch.draw(restartHover, xRestart, yRestart, widthRestart, heightRestart);
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
