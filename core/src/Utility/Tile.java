package Utility;

import Entity.Item.*;
import com.badlogic.gdx.graphics.g2d.Animation;
import java.util.Random;

public class Tile {

    Random rand = new Random();

    public float xPosition;
    public float yPosition;

    boolean perubahan;

    boolean box;
    boolean wall;
    boolean item;
    boolean explosion;
    boolean player;
    boolean bom;

    Item items;

    int number;

    public boolean getBox(){
        return box;
    }

    public void setBox(boolean box) {
        this.box = box;
    }

    public void setWall(boolean wall) {
        this.wall = wall;
    }

    public void setxPosition(float xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(float yPosition) {
        this.yPosition = yPosition;
    }

    public float getxPosition() {
        return xPosition;
    }

    public float getyPosition() {
        return yPosition;
    }

    public void explosion(){
        explosion=true;
    }

    public Animation picture(){
        return items.getAnimation();
    }

    public boolean item(){
        return item;
    }

    void setItems(){
        number=rand.nextInt(100);
        System.out.println(number);
        if (number<70){
            item=true;
            number=rand.nextInt(100);
            System.out.println(number);
            if (number<65){
                number=rand.nextInt(100);
                System.out.println(number);
                if (number<40){
                    items= new BombCapacity();
                } else if (number<80) {
                    items= new BombRange();
                } else {
                    items= new Shield();
                }
            } else {
                items= new Stun();
            }
        } else {
            item= false;
        }
    }

    public void boxDesroy(){
        setItems();
        box=false;
        perubahan=true;
    }

    public void update(){
        if (bom){
            //fitur explosion
        }
        else if (explosion){
            if (box){
                boxDesroy();
            } else if (player) {
                //fitur bunuh player
            }
        } else if (player) {
            if (item){
                //fitur player terima item
            }
        }
    }
}
