package Utility;

public class Tile {

    public float xPosition;
    public float yPosition;

    boolean perubahan;

    boolean box;
    boolean wall;
    boolean item;
    boolean explosion;
    boolean player;
    boolean bom;

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


    public void boxDesroy(){
        box= false;
        item= true;

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
