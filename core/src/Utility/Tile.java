package Utility;

import Entity.Item.*;
import Entity.Map.Box;
import Entity.Map.Wall;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import java.util.Random;

public class Tile {

    Random rand = new Random();

    Texture picture;

    public float xPosition;
    public float yPosition;

    boolean perubahan;

    boolean box;
    boolean wall;
    boolean item;
    boolean explosion;
    public boolean player;
    boolean bom;

    Item items;
    Box boxs;
    Wall walls;

    int number;

    public void create(){
        if (box){
            boxs= new Box(xPosition, yPosition);
        } else if (wall) {
            walls= new Wall(xPosition, yPosition);
        }
    }

    public Texture getBoxTexture(){
        return boxs.getPicture();
    }

    public float getXBox(){
        return boxs.getxPosition();
    }

    public float getYBox(){
        return boxs.getyPosition();
    }

    public float getWidthBox(){
        return boxs.getWidth();
    }

    public float getHeightBox(){
        return boxs.getHeight();
    }

    public Texture getWallTexture(){
        return walls.getPicture();
    }

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

    public void setPicture(int i, int j) {
        if (i % 2 == 0) {
            if (j % 2 == 0) {
                picture = new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\tile2.png");
            } else {
                picture = new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\tile1.png");
            }


        } else {
            if (j % 2 == 0) {
                picture = new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\tile1.png");
            } else {
                picture = new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\tile2.png");
            }
        }
    }

    public Texture getPicture() {
        return picture;
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

    public void terimaItem(){
        item=false;
        perubahan=true;
    }

    public void update(int i, int j){
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
                terimaItem();
            }
        }

        if (perubahan) {
            setPicture(i,j);
            perubahan = false;
        }
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }

    public boolean getPlayer(){
        return player;
    }

    public boolean isBox() {
        return box;
    }

    public boolean isWall() {
        return wall;
    }

    public boolean isBom() {
        return bom;
    }
}
