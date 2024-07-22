package GameScreen;

import bomberman.game.BomberMan;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class LoadingScreen implements Screen {

    float delayFrame=0.25f;
    float stateTime= 0;

    Texture picture;
    Animation<TextureRegion> animationLoading;
    float width=638;
    float height=155;
    float x= BomberMan.widthScreen/2-width/2;
    float y= BomberMan.heightScreen/2-height/2;
    private final int cols= 1;
    private final int rows= 12;

    Texture black;
    Animation<TextureRegion> animationBlack;
    private final int colsBlack=1;
    private final int rowsBlack=4;

    Texture backgorund;;
    float widthBackground=BomberMan.widthScreen;
    float heightBackground=BomberMan.heightScreen;
    float xBackground=0;
    float yBackground=0;

    SpriteBatch batch;


    LoadingScreen(){
        picture= new Texture("D:\\Project coding\\bomberMan\\assets\\LoadingScreen\\loading.png");
        black = new Texture("D:\\Project coding\\bomberMan\\assets\\LoadingScreen\\blackScreen.png");
        TextureRegion[][] tmpLoading= TextureRegion.split(picture, picture.getWidth()/cols, picture.getHeight()/rows);
        TextureRegion[] frameLoading= new TextureRegion[cols*rows];
        TextureRegion[][] tmpBlack= TextureRegion.split(black, black.getWidth()/colsBlack, black.getHeight()/rowsBlack);
        TextureRegion[] frameBlack= new TextureRegion[colsBlack*rowsBlack];

        int index=0;

        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                frameLoading[index++] = tmpLoading[i][j];
            }
        }

        index=0;

        for (int i=0; i<rowsBlack; i++){
            for (int j=0; j<colsBlack; j++){
                frameBlack[index++] = tmpBlack[i][j];
            }
        }

        animationBlack= new Animation<TextureRegion>(delayFrame,frameBlack);
        animationLoading= new Animation<TextureRegion>(delayFrame,frameLoading);

        backgorund = new Texture("D:\\Project coding\\bomberMan\\assets\\MainMenuScreen\\background.png");
        batch= new SpriteBatch();
    }

    public TextureRegion draw(float delta) {
        stateTime+=delta;
        TextureRegion currentFrame;
        currentFrame = (TextureRegion) animationLoading.getKeyFrame(stateTime, true);

        return currentFrame;
    }

    public TextureRegion blind(float delta) {
        TextureRegion currentFrame;
        currentFrame = (TextureRegion) animationBlack.getKeyFrame(stateTime, false);

        return currentFrame;
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stateTime+=delta;
        batch.begin();
        batch.draw(backgorund,xBackground,yBackground,widthBackground,heightBackground);
        batch.draw(draw(delta),x,y,width,height);
        batch.end();

        if (stateTime>=animationLoading.getAnimationDuration()*3){
            stateTime=0;
            ControllerScreen.loading=false;
        }
    }

    @Override
    public void resize(int i, int i1) {

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
