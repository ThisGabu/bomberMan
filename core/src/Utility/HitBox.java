package Utility;

import com.badlogic.gdx.graphics.Texture;

public class HitBox {

    Texture picture;

    //ukuran object yang memiliki hitbox
    float width;
    float height;

    //koordinat dari object yang memiliki hitbox
    float x;
    float y;

    //nomor tile object
    int i;
    int j;

    //A adalah sudut sebelah kiri atas
    //B adalah sudut sebelah kanan atas
    //C adalah sudut sebelah kiri bawah;
    //D adalah sudut sebelah kanan bawah
    float XASudut;
    float XBSudut;
    float XCSudut;
    float XDSudut;

    float YASudut;
    float YBSudut;
    float YCSudut;
    float YDSudut;

    //X dan Y center adalah titik tengah dari hit box
    float xCenter;
    float yCenter;

    public HitBox(float width, float height, float x, float y){
        picture= new Texture("..\\bomberMan\\assets\\utility\\hitbox.png");
        this.width=width;
        this.height=height;
        this.x=x;
        this.y=y;
        setXCenter(x);
        setYCenter(y);
    }

    public void update(float x, float y){
        setX(x);
        setY(y);
        setXCenter(getX());
        setYCenter(getY());
        setTile();
    }

    public void setX(float x) {
        this.x = x;
        setXCenter(this.x);
    }

    public void setY(float y) {
        this.y = y;
        setYCenter(this.y);
    }

    public void setXCenter(float x) {
        xCenter= (width/2)+x;
    }

    public void setYCenter(float y) {
        yCenter= (height/2)+y;
    }

    //menghitung berada ditile keberapa
    public void setTile() {
        i= (int) ((yCenter-MapGame.yPosition)/MapGame.heightTile);
        j= (int) ((xCenter-MapGame.xPosition)/MapGame.widthTile);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getxCenter() {
        return xCenter;
    }

    public float getyCenter() {
        return yCenter;
    }

    public void setYDSudut(float y) {
        YDSudut= y;
    }

    public void setYCSudut(float y) {
        YCSudut= y;
    }

    public void setYBSudut(float y) {
        YBSudut= y+height;
    }

    public void setYASudut(float y) {
        YASudut= y+height;
    }

    public void setXDSudut(float x) {
        XASudut= x+width;
    }

    public void setXCSudut(float x) {
        XCSudut= x;
    }

    public void setXBSudut(float x) {
        XBSudut= x+width;
    }

    public void setXASudut(float x) {
        XASudut= x;
    }

    public float getYDSudut() {
        return YDSudut;
    }

    public float getYCSudut() {
        return YCSudut;
    }

    public float getYBSudut() {
        return YBSudut;
    }

    public float getYASudut() {
        return YASudut;
    }

    public float getXDSudut() {
        return XDSudut;
    }

    public float getXCSudut() {
        return XCSudut;
    }

    public float getXBSudut() {
        return XBSudut;
    }

    public float getXASudut() {
        return XASudut;
    }

    public Texture getPicture() {
        return picture;
    }

    public int getJ() {
        return j;
    }

    public int getI() {
        return i;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
