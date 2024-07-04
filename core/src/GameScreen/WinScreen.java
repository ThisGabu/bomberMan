package GameScreen;

import bomberman.game.BomberMan;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WinScreen implements Screen {

    private final float widthBackground= BomberMan.widthScreen/2;
    private final float heightBackground= BomberMan.heightScreen/2;
    private final float xBackground= BomberMan.widthScreen/2-widthBackground/2;
    private final float yBackgorund= BomberMan.heightScreen/2-heightBackground/2;

    private final float widthPlayer= 10;
    private final float heightPlayer = 10;
    private final float xPlayer = 0;
    private final float yPlayer = 0;

    private final float widthTextPlayer= 10;
    private final float heightTextPlayer = 10;
    private final float xTextPlayer = 0;
    private final float yTextPlayer = 0;

    private final float widthTextWin= 10;
    private final float heightTextWin = 10;
    private final float xTextWin = 0;
    private final float yTextWin = 0;

    private final float widthExit= widthBackground/4;
    private final float heightExit= heightBackground/5;
    private final float xExit= BomberMan.widthScreen/2-widthExit/2;
    private final float yExit= yBackgorund+heightExit*0.85f;

    private final float widthRestart= 600/2;
    private final float heightRestart= 124/2;
    private final float xRestart= BomberMan.widthScreen/2-widthRestart/2;
    private final float yRestart= BomberMan.heightScreen/2-heightRestart/2;

    public int winPlayer;
    SpriteBatch batch;
    Texture Player1;
    Texture Player2;
    Texture textPlayer1;
    Texture textPlayer2;
    Texture textWin;

    Texture Player;
    Texture TextPlayer;
    Texture restart;
    Texture exit;
    Texture restartHover;
    Texture exitHover;

    WinScreen(int playerWin){
        winPlayer=playerWin;
        batch= new SpriteBatch();
        Player1= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\player.png");
        Player2= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\player2.png");
        textPlayer1= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\player1Text.png");
        textPlayer2= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\player2Text.png");
        textWin= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\winText.png");
        restart= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\restart.png");
        restartHover= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\restartHover.png");
        exit= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\exit.png");
        exitHover= new Texture("D:\\Project coding\\bomberMan\\assets\\WinScreen\\exitHover.png");
    }

    public void winCreate(){
        this.winPlayer=winPlayer;
        if (winPlayer==1){
            Player=Player1;
            TextPlayer=textPlayer1;
        } else {
            Player=Player2;
            TextPlayer=textPlayer2;
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        winCreate();
        batch.begin();
        batch.draw(Player,xPlayer,yPlayer,widthPlayer,heightPlayer);
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
