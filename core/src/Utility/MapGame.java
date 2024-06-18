package Utility;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MapGame {

    public static final int jumlahTileRumput = 25;
    public static final int jumlahTileMetal = 27;
    public static float xPosition = 390;
    public static float yPosition = 110;
    public static float widthTile = 20;
    public static float heightTile = 20;

    public static float xBorder= xPosition-20;
    public static float yBorder= yPosition-20;

    static SpriteBatch batch;
    public Tile[][] tile;
    public Texture[][] grassTile;
    public float[][] xTile;
    public float[][] yTile;

    public Texture[][] borderTile;
    public float[][] xMetal;
    public float[][] yMetal;

    public MapGame() {
        tile= new Tile[jumlahTileRumput][jumlahTileRumput];
        xTile= new float[jumlahTileRumput][jumlahTileRumput];
        yTile= new float[jumlahTileRumput][jumlahTileRumput];
        grassTile= new Texture[jumlahTileRumput][jumlahTileRumput];

        borderTile= new Texture[jumlahTileMetal][jumlahTileMetal];
        xMetal= new float[jumlahTileMetal][jumlahTileMetal];
        yMetal= new float[jumlahTileMetal][jumlahTileMetal];

        for (int i=0; i<jumlahTileRumput; i++){
            for (int j=0; j<jumlahTileRumput; j++){
                tile[i][j]= new Tile();
            }
        }
        for (int i = 0; i < jumlahTileRumput; i++) {
            if (i%2==0){
                for (int j = 0; j < jumlahTileRumput; j++) {
                    if (j % 2 == 0) {
                        grassTile[i][j]= new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\tile2.png");
                    } else {
                        grassTile[i][j] = new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\tile1.png");
                    }
                }
            } else {
                for (int j = 0; j < tile.length; j++) {
                    if (j % 2 == 0) {
                        grassTile[i][j] = new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\tile1.png");
                    } else {
                        grassTile[i][j] = new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\tile2.png");
                    }
                }
            }

        }

        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile.length; j++) {
                    xTile[i][j]= xPosition+20*j;
                    yTile[i][j]= yPosition+20*i;
            }
        }

        for (int i = 0; i < jumlahTileRumput; i++) {
            for (int j = 0; j < jumlahTileRumput; j++) {
                tile[i][j].width= widthTile;
                tile[i][j].height= heightTile;
            }
        }

        for (int i=0; i<jumlahTileMetal; i++){
            for (int j=0; j<jumlahTileMetal; j++){
                borderTile[i][j]= new Texture("D:\\Project coding\\bomberMan\\assets\\MapGame\\metalwall.png");
            }
        }

        for (int i=0; i<jumlahTileMetal; i++){
            for (int j=0; j<jumlahTileMetal; j++){
                xMetal[i][j]= xBorder+20*j;
                yMetal[i][j]= yBorder+20*i;
            }
        }
    }

}