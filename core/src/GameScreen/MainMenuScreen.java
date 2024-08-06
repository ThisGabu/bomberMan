package GameScreen;

import bomberman.game.BomberMan;
import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
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
    private static final float yLogo= height-heightLogo-heightLogo;

    private static final float widthStart=305;
    private static final float heightStart=79;
    private static final float xStart= width/2-widthStart/2;
    private static final float yStart= height/2;

    private static final float widthSetting=467-130;
    private static final float heightSetting=119-40;
    private static final float xSetting= width/2-widthSetting/2;
    private static final float ySetting= yStart-heightSetting-heightStart/2;

    private static final float widthInstruction=493-45;
    private static final float heightInstruction=94-15;
    private static final float xInstruction= width/2-widthInstruction/2;
    private static final float yInstruction= ySetting-heightInstruction-heightStart/2;

    private static final float widthExit=202;
    private static final float heightExit=79;
    private static final float xExit= width/2-widthExit/2;
    private static final float yExit= yInstruction-heightExit-heightStart/2;


    SpriteBatch batch;

    Texture backgorund;
    Texture logo;
    Texture start;
    Texture exit;
    Texture startPress;
    Texture exitPress;
    Texture exitHover;
    Texture startHover;
    Texture setting;
    Texture settingHover;
    Texture instruction;
    Texture instructionHover;

    public static Music music;


    public MainMenuScreen(){
        batch = new SpriteBatch();
        logo = new Texture("..\\bomberMan\\assets\\MainMenuScreen\\logo.png");
        backgorund = new Texture("..\\bomberMan\\assets\\MainMenuScreen\\background.png");
        start = new Texture("..\\bomberMan\\assets\\MainMenuScreen\\Start.png");
        startHover = new Texture("..\\bomberMan\\assets\\MainMenuScreen\\startHover.png");
        startPress = new Texture("..\\bomberMan\\assets\\MainMenuScreen\\StartPress.png");
        exit = new Texture("..\\bomberMan\\assets\\MainMenuScreen\\Exit.png");
        exitHover = new Texture("..\\bomberMan\\assets\\MainMenuScreen\\exitHover.png");
        exitPress = new Texture("..\\bomberMan\\assets\\MainMenuScreen\\exitPress.png");
        setting= new Texture("..\\bomberMan\\assets\\MainMenuScreen\\Setting.png");
        settingHover= new Texture("..\\bomberMan\\assets\\MainMenuScreen\\settingHover.png");
        instruction= new Texture("..\\bomberMan\\assets\\MainMenuScreen\\instruction.png");
        instructionHover= new Texture("..\\bomberMan\\assets\\MainMenuScreen\\instructionHover.png");
        music = Gdx.audio.newMusic(Gdx.files.internal("..\\bomberMan\\assets\\Music\\BacksoundMainMenu.mp3"));
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
        batch.draw(setting,xSetting,ySetting,widthSetting,heightSetting);
        batch.draw(instruction,xInstruction,yInstruction,widthInstruction,heightInstruction);

        music.setVolume(ControllerScreen.volumeScreen);
        music.setLooping(true);
        music.play();

        if (Gdx.input.getX()>=xStart&&Gdx.input.getX()<=xStart+widthStart&&Gdx.input.getY()<=height-yStart-heightStart/4&&Gdx.input.getY()>=height-yStart-heightStart-heightStart/2){
            if (Gdx.input.justTouched()){
                batch.draw(startPress, xStart, yStart, widthStart, heightStart);
                ControllerScreen.mainMenu=false;
                ControllerScreen.play=true;
                ControllerScreen.loading=true;
                ControllerScreen.restartMap=true;
                music.dispose();
            } else {
                batch.draw(startHover, xStart, yStart, widthStart, heightStart);
            }
        }
        else if (Gdx.input.getX()>=xExit&&Gdx.input.getX()<=xExit+widthExit&&Gdx.input.getY()<=height-yExit-heightExit/4&&Gdx.input.getY()>=height-yExit-heightExit-heightExit/2){
            if (Gdx.input.justTouched()){
                batch.draw(exitPress, xExit, yExit, widthExit, heightExit);
                ControllerScreen.exitGame=true;
            } else {
                batch.draw(exitHover, xExit, yExit, widthExit, heightExit);
            }
        } else if (Gdx.input.getX()>=xSetting&&Gdx.input.getX()<=xSetting+widthSetting&&Gdx.input.getY()<=height-ySetting-heightSetting/4&&Gdx.input.getY()>=height-ySetting-heightSetting-heightSetting/2) {
            if (Gdx.input.justTouched()){
                ControllerScreen.setting=true;
                ControllerScreen.restartMap=true;
            } else {
                batch.draw(settingHover,xSetting,ySetting,widthSetting,heightSetting);
            }
        } else if (Gdx.input.getX()>=xInstruction&&Gdx.input.getX()<=xInstruction+widthInstruction&&Gdx.input.getY()<=height-yInstruction-heightInstruction/4&&Gdx.input.getY()>=height-yInstruction-heightInstruction-heightInstruction/2) {
            if (Gdx.input.justTouched()){
                ControllerScreen.mainMenu=false;
                ControllerScreen.instruction=true;
            } else {
                batch.draw(instructionHover,xInstruction,yInstruction,widthInstruction,heightInstruction);
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

