package Entity.Item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BombCapacity extends Item{

    private static final int cols = 8;
    private static final int rows = 1;
    private static final float delayFrame = Item.delayFrame;
    float stateTime;

    Texture sheet;


    public BombCapacity(){
        setNama("bombCapacity");
        setPicture();
        sheet= new Texture("D:\\Project coding\\bomberMan\\assets\\Item\\bombCapacity.png");

        TextureRegion[][] tmp= TextureRegion.split(sheet, sheet.getWidth()/cols, sheet.getHeight()/rows);
        TextureRegion[] frame = new TextureRegion[cols*rows];
        int index=0;

        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                frame[index++] = tmp[i][j];
            }
        }

        animation= new Animation<TextureRegion>(delayFrame, frame);
    }

    public Animation getAnimation(){
        return animation;
    }


    @Override
    public void setPicture() {

    }
}
