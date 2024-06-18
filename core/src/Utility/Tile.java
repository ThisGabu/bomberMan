package Utility;

public class Tile {

    public float xPosition;
    public float yPosition;
    boolean box;
    boolean wall;

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
}
