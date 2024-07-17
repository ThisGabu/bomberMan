package Entity.Item;

import Utility.HitBox;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Shield extends Item{

    private static final int cols = 8;
    private static final int rows = 1;
    private static final float delayFrame = Item.delayFrame;
    float stateTime;

    HitBox hitBox;
    Texture sheet;


    public Shield(float x, float y){
        setNama("shield");
        setPicture();
        setyPosition(y);
        setxPosition(x);
        sheet= new Texture("D:\\Project coding\\bomberMan\\assets\\Item\\shield.png");

        TextureRegion[][] tmp= TextureRegion.split(sheet, sheet.getWidth()/cols, sheet.getHeight()/rows);
        TextureRegion[] frame = new TextureRegion[cols*rows];
        int index=0;

        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                frame[index++] = tmp[i][j];
            }
        }

        animation= new Animation<TextureRegion>(delayFrame, frame);
        hitBox= new HitBox(width,height,xPosition,yPosition);
    }


    public HitBox getHitBox() {
        return hitBox;
    }

    public Animation getAnimation(){
        return animation;
    }

    @Override
    public void setNama(String nama) {
        super.setNama(nama);
    }

    @Override
    public void setPicture() {

    }
}
