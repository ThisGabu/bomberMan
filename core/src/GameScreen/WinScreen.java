package GameScreen;

import Entity.Bomb.Bomb;
import bomberman.game.BomberMan;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
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

    public static Music music;

    //Ukuran dan Penempatan Background
    private static final float width = BomberMan.widthScreen;
    private static final float height = BomberMan.heightScreen;
    private static final float xBackground = 0;
    private static final float yBackgorund = 0;

    //Ukuran dan Penempatan Restart
    private static final float widthRestart=736/2;
    private static final float heightRestart=164/2;
    private static final float xRestart= width/2-widthRestart/2;
    private static final float yRestart= height/2.8f-heightRestart/2;

    //Ukuran dan Penempatan Exit
    private static final float widthExit=432/2;
    private static final float heightExit=204/2;
    private static final float xExit= width/2-widthExit/2;
    private static final float yExit= height/5-heightExit/2;

    //Ukuran dan Penempatan Win Player
    private static final float widthWin = 1060/3;
    private static final float heightWin = 624/3;
    private static final float xWin = width/2 - widthWin/2;
    private static final float yWin = height/1.9f + heightWin/2;

    //Ukuran dan Penempatan WinText
    private static final float widthWinText = 864/4;
    private static final float heightWinText = 312/4;
    private static final float xWinText = width/2 - widthWinText/2;
    private static final float yWinText = height/2.1f + heightWinText/2;


    WinScreen(int winPlayer){
        batch= new SpriteBatch();
        this.winPlayer= winPlayer;
        winPlayer1= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\Win1.png");
        winPlayer2= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\Win2.png");
        Background = new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\background.png");
        Restart= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\restart.png");
        RestartHover= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\restartHover.png");
        Exit= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\exit2.png");
        ExitHover= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\exit2Hover.png");
        WinText= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\winText.png");
        music= Gdx.audio.newMusic(Gdx.files.internal("D:\\Project coding\\bomberMan\\assets\\Music\\BacksoundWin.mp3"));
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        PlayScreen.music.dispose();
        Bomb.soundMeledak.dispose();

        music.setVolume(0.3f);
        music.setLooping(true);
        music.play();

        batch.begin();

        //Mengecek Player yang win
        if (winPlayer==1){
            WinPlayer= winPlayer1;

        } else {
            WinPlayer= winPlayer2;
        }
        batch.draw(Background, xBackground, yBackgorund, width, height);
        batch.draw(WinPlayer, xWin, yWin, widthWin, heightWin);
        batch.draw(Restart, xRestart, yRestart, widthRestart, heightRestart);
        batch.draw(Exit, xExit, yExit, widthExit, heightExit);
        batch.draw(WinText, xWinText, yWinText, widthWinText, heightWinText);

        //Restart Hover
        if (Gdx.input.getX()>xRestart&&Gdx.input.getX()<xRestart+widthRestart&&Gdx.input.getY()<height-yRestart&&Gdx.input.getY()>height-yRestart-heightRestart){
            if (Gdx.input.justTouched()){
                ControllerScreen.play=true;
                ControllerScreen.restartMap=true;
                ControllerScreen.win=false;
                music.dispose();
            } else {
                batch.draw(RestartHover, xRestart, yRestart, widthRestart, heightRestart);
            }
        }

        //Exit Hover
        if (Gdx.input.getX()>xExit&&Gdx.input.getX()<xExit+widthExit&&Gdx.input.getY()<height-yExit&&Gdx.input.getY()>height-yExit-heightExit){
            if (Gdx.input.justTouched()){
                ControllerScreen.mainMenu=true;
                ControllerScreen.restartMap=true;
                ControllerScreen.win=false;
                music.dispose();
            } else {
                batch.draw(ExitHover, xExit, yExit, widthExit, heightExit);
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
