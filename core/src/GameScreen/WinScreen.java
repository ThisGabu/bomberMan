package GameScreen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.time.temporal.Temporal;

public class WinScreen implements Screen {

    public int winPlayer;
    SpriteBatch batch;
    Texture winPlayer1;
    Texture winPlayer2;


    WinScreen(SpriteBatch batch, int winPlayer){
        this.batch= batch;
        this.winPlayer= winPlayer;
        winPlayer1= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\Win1.png");
        winPlayer2= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\Win2.png");
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        if (winPlayer==1){

        } else if (winPlayer==2) {

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
