package GameScreen;

import bomberman.game.BomberMan;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenuScreen implements Screen {

    private static final float width = BomberMan.widthScreen;
    private static final float height = BomberMan.heightScreen;
    private static final float xBackground = 0;
    private static final float yBackgorund = 0;

    private static final float widthLogo=852;
    private static final float heightLogo=114;
    private static final float xLogo= (width/2)-(widthLogo/2);
    private static final float yLogo= (height*0.7f);

    private static final float widthStart=305;
    private static final float heightStart=79;
    private static final float xStart= width/2-widthStart/2;
    private static final float yStart= height/2-heightStart;

    private static final float widthExit=200;
    private static final float heightExit=77;
    private static final float xExit= width/2-widthExit/2;
    private static final float yExit= yStart/2;




    SpriteBatch batch;

    Texture backgorund;
    Texture logo;
    Texture start;
    Texture exit;
    Texture startPress;
    Texture exitPress;
    Texture exitHover;
    Texture startHover;


    public MainMenuScreen(){
        batch = new SpriteBatch();
        logo = new Texture("D:\\Project coding\\bomberMan\\assets\\MainMenuScreen\\logo.png");
        backgorund = new Texture("D:\\Project coding\\bomberMan\\assets\\MainMenuScreen\\background.png");
        start = new Texture("D:\\Project coding\\bomberMan\\assets\\MainMenuScreen\\Start.png");
        startHover = new Texture("D:\\Project coding\\bomberMan\\assets\\MainMenuScreen\\startHover.png");
        startPress = new Texture("D:\\Project coding\\bomberMan\\assets\\MainMenuScreen\\StartPress.png");
        exit = new Texture("D:\\Project coding\\bomberMan\\assets\\MainMenuScreen\\Exit.png");
        exitHover = new Texture("D:\\Project coding\\bomberMan\\assets\\MainMenuScreen\\exitHover.png");
        exitPress = new Texture("D:\\Project coding\\bomberMan\\assets\\MainMenuScreen\\exitPress.png");

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(backgorund, xBackground, yBackgorund, width, height);
        batch.draw(logo, xLogo, yLogo, widthLogo, heightLogo);
        batch.draw(start, xStart, yStart, widthStart, heightStart);
        batch.draw(exit, xExit, yExit, widthExit, heightExit);
        if (Gdx.input.getX()>xStart&&Gdx.input.getX()<xStart+widthStart&&Gdx.input.getY()<height-yStart&&Gdx.input.getY()>height-yStart-heightStart){
            if (Gdx.input.isTouched()){
                batch.draw(startPress, xStart, yStart, widthStart, heightStart);
                ControllerScreen.mainMenu=false;
                ControllerScreen.play=true;
            } else {
                batch.draw(startHover, xStart, yStart, widthStart, heightStart);
            }
        }
        else if (Gdx.input.getX()>xExit&&Gdx.input.getX()<xExit+widthExit&&Gdx.input.getY()<height-yExit&&Gdx.input.getY()>height-yExit-heightExit){
            if (Gdx.input.isTouched()){
                batch.draw(exitPress, xExit, yExit, widthExit, heightExit);
                ControllerScreen.exitGame=true;
            } else {
                batch.draw(exitHover, xExit, yExit, widthExit, heightExit);
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

