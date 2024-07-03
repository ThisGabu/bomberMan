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
    }

    public Texture getTilePicture(int i, int j){
        Texture picture= tile[i][j].getPicture();
        return picture;
    }

    public Texture getBorder(int i, int j){
        Texture picture= border[i][j].getPicture();
        return picture;
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