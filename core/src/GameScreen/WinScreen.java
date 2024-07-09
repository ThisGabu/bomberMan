package GameScreen;

import bomberman.game.BomberMan;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.time.temporal.Temporal;

public class WinScreen implements Screen {

    public int winPlayer;
    SpriteBatch batch;
    Texture winPlayer1;
    Texture winPlayer2;
    Texture Background;
    Texture Restart;
    Texture RestartHover;
    Texture Exit;
    Texture ExitHover;
    Texture WinText;
    Texture WinPlayer;

    private static final float width = BomberMan.widthScreen;
    private static final float height = BomberMan.heightScreen;
    private static final float xBackground = 0;
    private static final float yBackgorund = 0;

    private static final float widthRestart=184;
    private static final float heightRestart=41;
    private static final float xRestart= width/2-widthRestart/2;
    private static final float yRestart= height/2-heightRestart;

    private static final float widthExit=108;
    private static final float heightExit=51;
    private static final float xExit= width/2-widthExit/2;
    private static final float yExit= height/2-heightExit/2;

    private static final float widthWin = 530;
    private static final float heightWin = 312;
    private static final float xWin = width/4 - widthWin/2;
    private static final float yWin = height/2 - heightWin/2;


    WinScreen(int winPlayer){
        batch= new SpriteBatch();
        this.winPlayer= winPlayer;
        winPlayer1= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\Win1.png");
        winPlayer2= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\Win2.png");
        Background = new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\background1.png");
        Restart= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\restart.png");
        RestartHover= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\restartHover.png");
        Exit= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\exit2.png");
        ExitHover= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\exit2Hover.png");
        WinText= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\winText.png");
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        if (winPlayer==1){
            WinPlayer= winPlayer1;

        } else if (winPlayer==2) {
            WinPlayer= winPlayer2;
        }
       batch.draw(WinPlayer, widthWin, heightWin, xWin, yWin);
        batch.draw(Restart, widthRestart, heightRestart, xRestart, yRestart);
        batch.draw(Exit, widthExit, heightExit, xExit, yExit);

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
