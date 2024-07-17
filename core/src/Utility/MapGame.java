package Utility;

import Entity.Bomb.Bomb;
import Entity.Bomb.Ledakan;
import Entity.Item.Item;
import Entity.Map.Box;
import Entity.Map.Wall;
import bomberman.game.BomberMan;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Map;

public class MapGame {

    public static final int jumlahTileRumput = 25;
    public static final int jumlahTileMetal = 27;
    public static final int jumlahSpawnTile = 2;
    public int jumlahBox = 0;
    public int jumlahWall = 0;

    public static float widthTile = 26.5f;
    public static float heightTile = 26.5f;
    public static float xPosition = (BomberMan.widthScreen - widthTile * jumlahTileMetal) / 2 + widthTile;
    public static float yPosition = heightTile;

    public static float xBorder = xPosition - widthTile;
    public static float yBorder = yPosition - heightTile;

    public Tile[][] tile;
    public Border[][] border;
    public SpawnTile[] spawnTile;

    public int bombCreate = 0;
    public int bombCreateBefore = bombCreate;
    Bomb bomb;
    public ArrayList<Bomb> bombs = new ArrayList<Bomb>();
    public ArrayList<Bomb> bombsMeledak = new ArrayList<Bomb>();
    Ledakan createLedakan;
    public ArrayList<Ledakan> ledakan = new ArrayList<Ledakan>();

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
                border[i][j] = new Border();
            }
        }

        for (int i = 0; i < jumlahSpawnTile; i++) {
            spawnTile[i] = new SpawnTile();
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

        for (int i = 0; i < jumlahTileRumput; i++) {
            for (int j = 0; j < jumlahTileRumput; j++) {
                tile[i][j].setPicture(i, j);
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

        int index = 0;
        for (int i = 0; i < jumlahTileRumput; i++) {
            for (int j = 0; j < jumlahTileRumput; j++) {
                if (i == jumlahTileRumput - 1 && j == jumlahTileRumput - 1) {
                    spawnTile[index].setxPosition(tile[i][j].getxPosition());
                    spawnTile[index].setyPosition(tile[i][j].getyPosition());
                    index++;
                } else if (i == 0 && j == 0) {
                    spawnTile[index].setyPosition(tile[i][j].getyPosition());
                    spawnTile[index].setxPosition(tile[i][j].getxPosition());
                    index++;
                }
            }
        }

        for (int i = 0; i < jumlahTileRumput; i++) {
            for (int j = 0; j < jumlahTileRumput; j++) {
                tile[i][j].create();
            }
        }
    }

    public boolean isBox(int i, int j) {
        return tile[i][j].isBox();
    }

    public boolean isWall(int i, int j) {
        return tile[i][j].isWall();
    }

    public Texture getBoxTexture(int i, int j) {
        return tile[i][j].getBoxTexture();
    }

    public float getWidthBox(int i, int j) {
        return tile[i][j].getWidthBox();
    }

    public float getHeightBox(int i, int j) {
        return tile[i][j].getHeightBox();
    }

    public float getxPositionBox(int i, int j) {
        return tile[i][j].getXBox();
    }

    public float getyPositionBox(int i, int j) {
        return tile[i][j].getYBox();
    }

    public Texture getWallsTexture(int i, int j) {
        return tile[i][j].getWallTexture();
    }

    public float getxPosition(int i, int j) {
        return tile[i][j].getxPosition();
    }

    public float getyPosition(int i, int j) {
        return tile[i][j].getyPosition();
    }

    public void destroyBox(int i, int j) {
        jumlahBox--;
        tile[i][j].boxDesroy();
    }

    public Texture getTilePicture(int i, int j) {
        Texture picture = tile[i][j].getPicture();
        return picture;
    }

    public Texture getBorder(int i, int j) {
        Texture picture = border[i][j].getPicture();
        return picture;
    }

    public void setPlayer(int i, int j, boolean kondisi) {
        tile[i][j].setPlayer(kondisi);
    }

    public boolean getPlayer(int i, int j) {
        return tile[i][j].getPlayer();
    }

    public void update(float delta) {

        for (int i = 0; i < bombs.size(); i++) {
            bomb=bombs.getFirst();
            bombs.removeFirst();
            bomb.update(delta);
            bombs.add(bomb);
        }

        for (int i=0; i<ledakan.size(); i++){
            createLedakan= ledakan.get(i);
            ledakan.remove(i);
            createLedakan.update();
            ledakan.add(createLedakan);
        }

        if (ledakan.size()>0) {
            checkExplosion();
        }

        checkBomb();

        for (int i = 0; i < jumlahTileRumput; i++) {
            for (int j = 0; j < jumlahTileRumput; j++) {
                tile[i][j].update(i, j);
            }
        }

    }

    public int getBombPlayer(int i) {
        bomb=bombs.get(i);
        return bomb.getPlayer();
    }

    public void createBomb(Bomb bomb) {
        this.bomb=bomb;
        bombs.add(this.bomb);
    }

    public Bomb getBomb(int i){
        return bombs.get(i);
    }

    public int getBombCreate() {
        return bombCreate;
    }

    public TextureRegion getBombAnimation(int i, float delta) {
        bomb=bombs.get(i);
        TextureRegion currentFrame = (TextureRegion) bomb.getAnimation().getKeyFrame(bomb.getTimer(), true);

        return currentFrame;
    }

    public float xBomb(int i) {
        bomb=bombs.get(i);
        return bomb.getX();
    }

    public float yBomb(int i) {
        bomb=bombs.get(i);
        return bomb.getY();
    }

    public float widthBomb(int i) {
        bomb=bombs.get(i);
        return bomb.getWidth();
    }

    public float heightBomb(int i) {
        bomb=bombs.get(i);
        return bomb.getHeight();
    }

    public void DestroyBox(int i, int j) {
        tile[i][j].boxDesroy();
    }

    public TextureRegion drawItem(int i, int j, float delta) {
        Item items=tile[i][j].getItems();
        items.setStatetime(delta+items.getStatetime());
        TextureRegion currentFrame = (TextureRegion) tile[i][j].items.getAnimation().getKeyFrame(items.getStatetime(), true);

        return currentFrame;
    }

    public Bomb getBombsMeledak() {
        Bomb bomb1= bombsMeledak.getFirst();
        bombsMeledak.removeFirst();
        return bomb1;
    }

    public void checkBomb() {
        for (int i = 0; i < bombs.size(); i++) {
            bomb=bombs.get(i);
            if (bomb.getTimer()>bomb.animation.getAnimationDuration()) {
                bombsMeledak.add(bomb);
                bombs.remove(i);
                createLedakan(bomb);
            }
        }
    }

    public void createLedakan(Bomb bomb) {


        createLedakan = new Ledakan("center", bomb.getX(), bomb.getY(), bomb.getWidth(), bomb.getHeight());
        ledakan.add(createLedakan);

        boolean right=true;
        boolean left=true;
        boolean up=true;
        boolean down=true;

        for (int i = 0; i < bomb.getRangeExplosion(); i++) {
            if (i < bomb.rangeExplosion - 1) {
                createLedakan = new Ledakan("up", bomb.getX(), bomb.getY() + bomb.getHeight() * (i + 1), bomb.getWidth(), bomb.getHeight());
                ledakan.add(createLedakan);
                createLedakan = null;
                createLedakan = new Ledakan("down", bomb.getX(), bomb.getY() - bomb.getHeight() * (i + 1), bomb.getWidth(), bomb.getHeight());
                ledakan.add(createLedakan);
                createLedakan = null;
                createLedakan = new Ledakan("right", bomb.getX() + bomb.getWidth() * (i + 1), bomb.getY(), bomb.getWidth(), bomb.getHeight());
                ledakan.add(createLedakan);
                createLedakan = null;
                createLedakan = new Ledakan("left", bomb.getX() - bomb.getWidth() * (i + 1), bomb.getY(), bomb.getWidth(), bomb.getHeight());
                ledakan.add(createLedakan);
            } else {
                createLedakan = new Ledakan("endUp", bomb.getX(), bomb.getY() + bomb.getHeight() * (i + 1), bomb.getWidth(), bomb.getHeight());
                ledakan.add(createLedakan);
                createLedakan = null;
                createLedakan = new Ledakan("endDown", bomb.getX(), bomb.getY() - bomb.getHeight() * (i + 1), bomb.getWidth(), bomb.getHeight());
                ledakan.add(createLedakan);
                createLedakan = null;
                createLedakan = new Ledakan("endRight", bomb.getX() + bomb.getWidth() * (i + 1), bomb.getY(), bomb.getWidth(), bomb.getHeight());
                ledakan.add(createLedakan);
                createLedakan = null;
                createLedakan = new Ledakan("endLeft", bomb.getX() - bomb.getWidth() * (i + 1), bomb.getY(), bomb.getWidth(), bomb.getHeight());
                ledakan.add(createLedakan);
            }
        }
    }

    public void checkExplosion(){
        for (int i=0; i<ledakan.size(); i++){
            createLedakan= ledakan.get(i);
            if (createLedakan.isPadam()){
                ledakan.remove(i);
            }
        }
    }

    public Ledakan getCreateLedakan(int i) {
        createLedakan= ledakan.get(i);
        return createLedakan;
    }

    public int getJumlahTileRumput(){
        return jumlahTileRumput;
    }

    public static float getHeightTile() {
        return heightTile;
    }

    public static float getWidthTile() {
        return widthTile;
    }

    public Item getItem(int i,int j){
        return tile[i][j].getItems();
    }

    public Box getBox(int i, int j){
        return tile[i][j].getBoxs();
    }

    public Wall wall(int i, int j){
        return  tile[i][j].getWalls();
    }

    public Ledakan getLedakan(int index){
        if (ledakan.size()>0){
            return ledakan.get(index);
        } else {
            return null;
        }
    }

    public boolean isItems(int i, int j){
        return tile[i][j].isItem();
    }

    public String getNamaItem(int i, int j){
        return tile[i][j].getNameItem();
    }

    public void claim(int i, int j){
        tile[i][j].terimaItem();
    }
}