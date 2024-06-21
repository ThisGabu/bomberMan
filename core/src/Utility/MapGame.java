package Utility;

import bomberman.game.BomberMan;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MapGame {

    public static final int jumlahTileRumput = 25;
    public static final int jumlahTileMetal = 27;
    public static float widthTile = 26.5f;
    public static float heightTile = 26.5f;
    public static float xPosition = (BomberMan.widthScreen-widthTile*jumlahTileMetal)/2+widthTile;
    public static float yPosition = heightTile;


    public static float xBorder= xPosition-widthTile;
    public static float yBorder= yPosition-heightTile;

    static SpriteBatch batch;
    public Tile[][] tile;
    public float[][] xTile;
    public float[][] yTile;
    public Texture[][] tilePicture;

    public Texture[][] borderTile;
    public float[][] xMetal;
    public float[][] yMetal;



    public MapGame() {
        tile= new Tile[jumlahTileRumput][jumlahTileRumput];
        xTile= new float[jumlahTileRumput][jumlahTileRumput];
        yTile= new float[jumlahTileRumput][jumlahTileRumput];
        tilePicture= new Texture[jumlahTileRumput][jumlahTileRumput];

        borderTile= new Texture[jumlahTileMetal][jumlahTileMetal];
        xMetal= new float[jumlahTileMetal][jumlahTileMetal];
        yMetal= new float[jumlahTileMetal][jumlahTileMetal];

        for (int i=0; i<jumlahTileRumput; i++){
            for (int j=0; j<jumlahTileRumput; j++){
                tile[i][j]= new Tile();
            }
        }


        for (int i=0; i<jumlahTileRumput; i++){
            if (i%2==0){
                for (int j=0; j<jumlahTileRumput; j++){
                    if (i==0 && j==0){
                        tile[i][j].box=false;
                    } else if (i==jumlahTileRumput-1&&j==0){
                        tile[i][j].box=false;
                    } else if (i==0&&j==jumlahTileRumput-1) {
                        tile[i][j].box=false;
                    } else if (i==jumlahTileRumput-1&&j==jumlahTileRumput-1) {
                        tile[i][j].box=false;
                    }
                    else if (j%2==0){
                        tile[i][j].box=true;
                    } else {
                        tile[i][j].box=false;
                    }
                }
            } else {
                for (int j=0; j<jumlahTileRumput; j++){
                    if (i==0 && j==0){
                        tile[i][j].box=false;
                    } else if (i==jumlahTileRumput-1&&j==0){
                        tile[i][j].box=false;
                    } else if (i==0&&j==jumlahTileRumput-1) {
                        tile[i][j].box=false;
                    } else if (i==jumlahTileRumput-1&&j==jumlahTileRumput-1) {
                        tile[i][j].box=false;
                    } else if (j%2==0){
                        tile[i][j].box=false;
                    } else {
                        tile[i][j].wall=true;
                    }
                }
            }

        }

        for (int i=0; i<jumlahTileRumput; i++){
            if (i%2==0){
                for (int j=0; j<jumlahTileRumput; j++){
                    if (tile[i][j].wall){
                        tilePicture[i][j]= new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\wall.png");
                    } else if (tile[i][j].box) {
                        tilePicture[i][j]= new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\box.png");
                    } else {
                        if (j % 2 == 0) {
                            tilePicture[i][j] = new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\tile2.png");
                        } else {
                            tilePicture[i][j] = new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\tile1.png");
                        }
                    }
                }
            } else {
                for (int j = 0; j < jumlahTileRumput; j++) {
                    if (tile[i][j].wall){
                        tilePicture[i][j]= new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\wall.png");
                    } else if (tile[i][j].box) {
                        tilePicture[i][j]= new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\box.png");
                    } else {
                        if (j % 2 == 0) {
                            tilePicture[i][j] = new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\tile1.png");
                        } else {
                            tilePicture[i][j] = new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\tile2.png");
                        }
                    }
                }
            }
        }




        for (int i = 0; i < jumlahTileRumput; i++) {
            for (int j = 0; j < jumlahTileRumput; j++) {
                tile[i][j].setxPosition(xPosition+widthTile*j);
                tile[i][j].setyPosition(yPosition+heightTile*i);
            }
        }

        for (int i=0; i<jumlahTileMetal; i++){
            for (int j=0; j<jumlahTileMetal; j++){
                borderTile[i][j]= new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\metalwall.png");
            }
        }

        for (int i=0; i<jumlahTileMetal; i++){
            for (int j=0; j<jumlahTileMetal; j++){
                xMetal[i][j]= xBorder+widthTile*j;
                yMetal[i][j]= yBorder+heightTile*i;
            }
        }
    }

    public void update(){

        for (int i=0; i<jumlahTileRumput; i++) {
            for (int j = 0; j < jumlahTileRumput; j++) {
                if (tile[i][j].perubahan) {

                    if (i % 2 == 0) {
                        if (tile[i][j].wall) {
                            tilePicture[i][j] = new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\wall.png");
                        } else if (tile[i][j].box) {
                            tilePicture[i][j] = new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\box.png");
                        } else {
                            if (j % 2 == 0) {
                                tilePicture[i][j] = new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\tile2.png");
                            } else {
                                tilePicture[i][j] = new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\tile1.png");
                            }
                        }
                    } else {

                        if (tile[i][j].wall) {
                            tilePicture[i][j] = new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\wall.png");
                        } else if (tile[i][j].box) {
                            tilePicture[i][j] = new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\box.png");
                        } else {
                            if (j % 2 == 0) {
                                tilePicture[i][j] = new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\tile1.png");
                            } else {
                                tilePicture[i][j] = new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\tile2.png");
                            }
                        }
                    }

                    tile[i][j].perubahan=false;
                }
            }
        }

    }



}