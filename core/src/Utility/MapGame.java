package Utility;

import bomberman.game.BomberMan;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Map;

public class MapGame {

    public static final int jumlahTileRumput = 25;
    public static final int jumlahTileMetal = 27;
    public static final int jumlahSpawnTile = 2;
    public int jumlahBox=0;
    public int jumlahWall=0;

    public static float widthTile = 26.5f;
    public static float heightTile = 26.5f;
    public static float xPosition = (BomberMan.widthScreen - widthTile * jumlahTileMetal) / 2 + widthTile;
    public static float yPosition = heightTile;


    public static float xBorder = xPosition - widthTile;
    public static float yBorder = yPosition - heightTile;

    public static Tile[][] tile;
    public Border[][] border;
    public SpawnTile[] spawnTile;

    float stateTime = 0f;


    public MapGame() {
        tile = new Tile[jumlahTileRumput][jumlahTileRumput];
        border = new Border[jumlahTileMetal][jumlahTileMetal];
        spawnTile = new SpawnTile[jumlahSpawnTile];

        for (int i = 0; i < jumlahTileRumput; i++) {
            for (int j = 0; j < jumlahTileRumput; j++) {
                tile[i][j] = new Tile();
            }
        }

        for (int i = 0; i < jumlahTileMetal; i++) {
            for (int j = 0; j < jumlahTileMetal; j++) {
                border[i][j]= new Border();
            }
        }

        for (int i=0; i<jumlahSpawnTile; i++){
            spawnTile[i]= new SpawnTile();
        }


        for (int i = 0; i < jumlahTileRumput; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < jumlahTileRumput; j++) {
                    if (i == 0 && j == 0) {
                        tile[i][j].box = false;
                    } else if (i == jumlahTileRumput - 1 && j == 0) {
                        tile[i][j].box = false;
                    } else if (i == 0 && j == jumlahTileRumput - 1) {
                        tile[i][j].box = false;
                    } else if (i == jumlahTileRumput - 1 && j == jumlahTileRumput - 1) {
                        tile[i][j].box = false;
                    } else if (j % 2 == 0) {
                        tile[i][j].box = true;
                        jumlahBox++;
                    } else {
                        tile[i][j].box = false;
                    }
                }
            } else {
                for (int j = 0; j < jumlahTileRumput; j++) {
                    if (i == 0 && j == 0) {
                        tile[i][j].box = false;
                    } else if (i == jumlahTileRumput - 1 && j == 0) {
                        tile[i][j].box = false;
                    } else if (i == 0 && j == jumlahTileRumput - 1) {
                        tile[i][j].box = false;
                    } else if (i == jumlahTileRumput - 1 && j == jumlahTileRumput - 1) {
                        tile[i][j].box = false;
                    } else if (j % 2 == 0) {
                        tile[i][j].box = false;
                    } else {
                        tile[i][j].wall = true;
                        jumlahWall++;
                    }
                }
            }

        }

        for (int i=0; i<jumlahTileRumput; i++){
            for (int j=0; j<jumlahTileRumput; j++){
                tile[i][j].setPicture(i,j);
            }
        }

        for (int i = 0; i < jumlahTileRumput; i++) {
            for (int j = 0; j < jumlahTileRumput; j++) {
                tile[i][j].setxPosition(xPosition + widthTile * j);
                tile[i][j].setyPosition(yPosition + heightTile * i);
            }
        }

        for (int i = 0; i < jumlahTileMetal; i++) {
            for (int j = 0; j < jumlahTileMetal; j++) {
                border[i][j].setPicture();
            }
        }

        for (int i = 0; i < jumlahTileMetal; i++) {
            for (int j = 0; j < jumlahTileMetal; j++) {
                border[i][j].setxPosition(xBorder + widthTile * j);
                border[i][j].setyPosition(yBorder + heightTile * i);
            }
        }

        int index=0;
       for (int i=0; i<jumlahTileRumput; i++){
           for (int j=0; j<jumlahTileRumput; j++){
               if (i==jumlahTileRumput-1&&j==jumlahTileRumput-1){
                   spawnTile[index].setxPosition(tile[i][j].getxPosition());
                   spawnTile[index].setyPosition(tile[i][j].getyPosition());
                   index++;
               } else if (i==0&&j==0) {
                   spawnTile[index].setyPosition(tile[i][j].getyPosition());
                   spawnTile[index].setxPosition(tile[i][j].getxPosition());
                   index++;
               }
           }
       }

       for (int i=0; i<jumlahTileRumput; i++){
           for (int j=0; j<jumlahTileRumput; j++){
               tile[i][j].create();
           }
       }
    }

    public boolean isBox(int i, int j){
        return tile[i][j].isBox();
    }

    public boolean isWall(int i, int j){
        return tile[i][j].isWall();
    }

    public Texture getBoxTexture(int i, int j){
        return tile[i][j].getBoxTexture();
    }

    public float getWidthBox(int i, int j){
        return tile[i][j].getWidthBox();
    }

    public float getHeightBox(int i, int j){
        return tile[i][j].getHeightBox();
    }

    public float getxPositionBox(int i, int j){
        return tile[i][j].getXBox();
    }

    public float getyPositionBox(int i, int j){
        return tile[i][j].getYBox();
    }

    public Texture getWallsTexture(int i, int j){
        return tile[i][j].getWallTexture();
    }

    public float getxPosition(int i, int j){
        return tile[i][j].getxPosition();
    }

    public float getyPosition(int i, int j){
        return tile[i][j].getyPosition();
    }

    public void destroyBox(int i, int j){
        jumlahBox--;
        tile[i][j].boxDesroy();
    }

    public Texture getTilePicture(int i, int j){
        Texture picture= tile[i][j].getPicture();
        return picture;
    }

    public Texture getBorder(int i, int j){
        Texture picture= border[i][j].getPicture();
        return picture;
    }

    public void setPlayer(int i, int j, boolean kondisi){
        tile[i][j].setPlayer(kondisi);
    }

    public boolean getPlayer(int i, int j){
        return tile[i][j].getPlayer();
    }

    public void update() {

        for (int i = 0; i < jumlahTileRumput; i++) {
            for (int j = 0; j < jumlahTileRumput; j++) {
                tile[i][j].update(i,j);
            }
        }

    }

    public void setBox(int i, int j) {
        tile[i][j].boxDesroy();
    }

    public TextureRegion drawItem(int i, int j, float delta) {
        stateTime += delta;
        TextureRegion currentFrame = (TextureRegion) tile[i][j].items.getAnimation().getKeyFrame(stateTime, true);

        return currentFrame;
    }
}