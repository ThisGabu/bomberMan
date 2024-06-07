package GameScreen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen extends Game {
    public static final float width = MainGameScreen.widthScreen;
    public static final float height = MainGameScreen.heightScreen;
    public static final float xBackground = 0;
    public static final float yBackgorund = 0;

    public static final float widthLogo=852;
    public static final float heightLogo=114;
    public static final float xLogo= (width/2)-(widthLogo/2);
    public static final float yLogo= (height*0.7f);

    public static final float widthStart=305;
    public static final float heightStart=79;
    public static final float xStart= width/2-widthStart/2;
    public static final float yStart= height/2-heightStart;

    public static final float widthExit=200;
    public static final float heightExit=77;
    public static final float xExit= width/2-widthExit/2;
    public static final float yExit= yStart/2;

    public static boolean mainMenu=true;
    public static boolean play=true;

    Texture backgorund;
    Texture logo;
    Texture start;
    Texture exit;
    Texture startPress;
    Texture exitPress;
    SpriteBatch batch;



    @Override
    public void create () {
        batch = new SpriteBatch();
        logo = new Texture("D:\\Downloads\\BomberMan\\assets\\MainMenuScreen\\Logo.png");
        backgorund = new Texture("D:\\Downloads\\BomberMan\\assets\\MainMenuScreen\\background.png");
        start = new Texture("D:\\Downloads\\BomberMan\\assets\\MainMenuScreen\\Start.png");
        startPress = new Texture("D:\\Downloads\\BomberMan\\assets\\MainMenuScreen\\StartPress.png");
        exit = new Texture("D:\\Downloads\\BomberMan\\assets\\MainMenuScreen\\Exit.png");
        exitPress = new Texture("D:\\Downloads\\BomberMan\\assets\\MainMenuScreen\\exitPress.png");
    }

    @Override
    public void render () {

        batch.begin();
        batch.draw(backgorund, xBackground, yBackgorund, width, height);
        batch.end();
        if (mainMenu){
            batch.begin();
            batch.draw(logo, xLogo, yLogo, widthLogo, heightLogo);
            batch.draw(start, xStart, yStart, widthStart, heightStart);
            batch.draw(exit, xExit, yExit, widthExit, heightExit);
            if (Gdx.input.getX()>xStart&&Gdx.input.getX()<xStart+widthStart&&Gdx.input.getY()<height-yStart&&Gdx.input.getY()>height-yStart-heightStart){
                if (Gdx.input.isTouched()){
                    batch.draw(startPress, xStart, yStart, widthStart, heightStart);
                    mainMenu=false;
                }
            }
            else if (Gdx.input.getX()>xExit&&Gdx.input.getX()<xExit+widthExit&&Gdx.input.getY()<height-yExit&&Gdx.input.getY()>height-yExit-heightExit){
                if (Gdx.input.isTouched()){
                    batch.draw(exitPress, xExit, yExit, widthExit, heightExit);
                    dispose();
                }
            }
            batch.end();
        } else if (play) {
            PlayScreen.playScreen(batch);
        }

    }


    @Override
    public void dispose () {
        batch.dispose();
        backgorund.dispose();
        logo.dispose();
    }
}

