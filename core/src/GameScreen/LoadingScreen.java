package GameScreen;

import Entity.Item.*;
import bomberman.game.BomberMan;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Align;

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

    Texture backgorund;
    float widthBackground=BomberMan.widthScreen;
    float heightBackground=BomberMan.heightScreen;
    float xBackground=0;
    float yBackground=0;

    Texture backgroundElement;
    float widthBackgroundElement=width+width/2;
    float heightBackgroundElement=widthBackgroundElement/3;
    float xBackgroundElement=widthBackground/2-widthBackgroundElement/2;
    float yBackgroundElement=y-heightBackgroundElement;

    float widthFrame1=heightBackgroundElement/3;
    float heightFrame1=heightBackgroundElement/3;

    SpriteBatch batch;
    BitmapFont font;
    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    Item bombCapacity;
    Item bombRange;
    Item shield;
    Item stun;

    LoadingScreen(){
        picture= new Texture("..\\bomberMan\\assets\\LoadingScreen\\loading.png");
        backgroundElement= new Texture("..\\bomberMan\\assets\\LoadingScreen\\backgroundElement.png");
        TextureRegion[][] tmpLoading= TextureRegion.split(picture, picture.getWidth()/cols, picture.getHeight()/rows);
        TextureRegion[] frameLoading= new TextureRegion[cols*rows];

        int index=0;

        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                frameLoading[index++] = tmpLoading[i][j];
            }
        }

        animationLoading= new Animation<TextureRegion>(delayFrame,frameLoading);

        backgorund = new Texture("..\\bomberMan\\assets\\MainMenuScreen\\background.png");
        batch= new SpriteBatch();
        font= new BitmapFont();
        generator = new FreeTypeFontGenerator(Gdx.files.internal("..\\bomberMan\\assets\\font\\Poppins-Bold.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 12;
        font = generator.generateFont(parameter);
        font.setColor(Color.BLACK);

        bombCapacity = new BombCapacity(xBackgroundElement+widthFrame1,yBackgroundElement+heightFrame1+heightFrame1);
        bombRange = new BombRange(xBackgroundElement+widthFrame1,bombCapacity.getyPosition()- bombCapacity.getHeight());
        stun = new Stun(xBackgroundElement+widthFrame1,bombRange.getyPosition()- bombRange.getHeight());
        shield = new Shield(xBackgroundElement+widthFrame1,stun.getyPosition()- stun.getHeight());
    }

    public TextureRegion draw(float delta) {
        stateTime+=delta;
        TextureRegion currentFrame;
        currentFrame = (TextureRegion) animationLoading.getKeyFrame(stateTime, true);

        return currentFrame;
    }

    public TextureRegion drawCapacity(float delta) {
        bombCapacity.setStatetime(bombCapacity.getStatetime()+delta);
        TextureRegion currentFrame;
        currentFrame = (TextureRegion) bombCapacity.getAnimation().getKeyFrame(bombCapacity.getStatetime(), true);

        return currentFrame;
    }

    public TextureRegion drawRange(float delta) {
        bombRange.setStatetime(bombRange.getStatetime()+delta);
        TextureRegion currentFrame;
        currentFrame = (TextureRegion) bombRange.getAnimation().getKeyFrame(bombRange.getStatetime(), true);

        return currentFrame;
    }

    public TextureRegion drawShield(float delta) {
        shield.setStatetime(shield.getStatetime()+delta);
        TextureRegion currentFrame;
        currentFrame = (TextureRegion) shield.getAnimation().getKeyFrame(shield.getStatetime(), true);

        return currentFrame;
    }

    public TextureRegion drawStun(float delta) {
        stun.setStatetime(stun.getStatetime()+delta);
        TextureRegion currentFrame;
        currentFrame = (TextureRegion) stun.getAnimation().getKeyFrame(stun.getStatetime(), true);

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
        batch.draw(backgroundElement,xBackgroundElement,yBackgroundElement,widthBackgroundElement,heightBackgroundElement);
        batch.draw(draw(delta),x,y,width,height);
        batch.draw(drawCapacity(delta),bombCapacity.getxPosition(),bombCapacity.getyPosition(),bombCapacity.getWidth(),bombCapacity.getHeight());
        font.draw(batch,"(Bomb Capacity) menambahkan jumlah capacity bomb yang dimiliki",bombCapacity.getxPosition()+ bombCapacity.getWidth()+ bombCapacity.getWidth()/2,bombCapacity.getyPosition()+bombCapacity.getHeight()/2,200, Align.left,false);
        batch.draw(drawRange(delta),bombRange.getxPosition(),bombRange.getyPosition(),bombRange.getWidth(),bombRange.getHeight());
        font.draw(batch,"(Bomb Range) Menambahkan jarak ledakan",bombRange.getxPosition()+ bombRange.getWidth()+ bombRange.getWidth()/2,bombRange.getyPosition()+bombRange.getHeight()/2,200, Align.left,false);
        batch.draw(drawStun(delta),stun.getxPosition(),stun.getyPosition(),stun.getWidth(),stun.getHeight());
        font.draw(batch,"(Stun) Dapat menyebabkan efek stun selama 5 detik. (DAPAT MENGENAI DIRI SENDIRI)",stun.getxPosition()+ stun.getWidth()+ stun.getWidth()/2,stun.getyPosition()+stun.getHeight()/2,200, Align.left,false);
        batch.draw(drawShield(delta),shield.getxPosition(),shield.getyPosition(),shield.getWidth(),shield.getHeight());
        font.draw(batch,"(Shield) Kebal terhadap ledakan bom selama 3 detik",shield.getxPosition()+ shield.getWidth()+ shield.getWidth()/2,shield.getyPosition()+shield.getHeight()/2,200, Align.left,false);
        batch.end();

        if (stateTime>=animationLoading.getAnimationDuration()*10){
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
