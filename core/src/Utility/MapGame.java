package Utility;

import Entity.Bomb.Bomb;
import Entity.Bomb.Ledakan;
import Entity.Item.Item;
import Entity.Map.Box;
import Entity.Map.Wall;
import GameScreen.ControllerScreen;
import GameScreen.PlayScreen;
import bomberman.game.BomberMan;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Map;

public class MapGame {

    public static int jumlahMap=2;

    public static int panjangMap= 21;
    public static int tinggiMap= 21;
    public static int panjangBorder= panjangMap+2;
    public static int  tinggiBorder= tinggiMap+2;
    public static int jumlahSpawnTile = 2;
    public int jumlahBox = 0;
    public int jumlahWall = 0;

    public static float widthTile = BomberMan.heightScreen/panjangBorder;
    public static float heightTile = BomberMan.heightScreen/tinggiBorder;

    public static float xBorder = BomberMan.widthScreen/2 - BomberMan.heightScreen/2;
    public static float yBorder = 0;

    public static float xPosition = xBorder+widthTile;
    public static float yPosition = yBorder+heightTile;

    public static Tile[][] tile;
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
    public MapGame(int number) {
        panjangMap=11;
        tinggiMap=11;
        panjangBorder=panjangMap+2;
        tinggiBorder=tinggiMap+2;
        if (number==0){
            border= new Border[tinggiBorder][panjangBorder];

            for (int i=0; i<tinggiBorder; i++){
                for (int j=0; j<panjangBorder; i++){
                    border[i][j]= new Border();
                }
            }

            for (int i = 0; i < tinggiBorder; i++) {
                for (int j = 0; j < panjangBorder; j++) {
                    border[i][j].setPicture();
                }
            }

            for (int i = 0; i < tinggiBorder; i++) {
                for (int j = 0; j < panjangBorder; j++) {
                    border[i][j].setxPosition(xBorder + widthTile * j);
                    border[i][j].setyPosition(yBorder + heightTile * i);
                }
            }

        } else if (number == 1) {
            tile = new Tile[tinggiMap][panjangMap];
            border = new Border[tinggiBorder][panjangBorder];
            spawnTile = new SpawnTile[jumlahSpawnTile];

            for (int i = 0; i < tinggiMap; i++) {
                for (int j = 0; j < panjangMap; j++) {
                    tile[i][j] = new Tile();
                }
            }

            for (int i = 0; i < tinggiBorder; i++) {
                for (int j = 0; j < panjangBorder; j++) {
                    border[i][j] = new Border();
                }
            }

            for (int i = 0; i < jumlahSpawnTile; i++) {
                spawnTile[i] = new SpawnTile();
            }


            for (int i = 0; i < tinggiMap; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < panjangMap; j++) {
                        if (i == 0 && j == 0) {
                            tile[i][j].box = false;
                        } else if (i == tinggiMap - 1 && j == 0) {
                            tile[i][j].box = false;
                        } else if (i == 0 && j == panjangMap - 1) {
                            tile[i][j].box = false;
                        } else if (i == tinggiMap - 1 && j == panjangMap - 1) {
                            tile[i][j].box = false;
                        } else if (j % 2 == 0) {
                            tile[i][j].box = true;
                            jumlahBox++;
                        } else {
                            tile[i][j].box = false;
                        }
                    }
                } else {
                    for (int j = 0; j < panjangMap; j++) {
                        if (i == 0 && j == 0) {
                            tile[i][j].box = false;
                        } else if (i == tinggiMap - 1 && j == 0) {
                            tile[i][j].box = false;
                        } else if (i == 0 && j == panjangMap - 1) {
                            tile[i][j].box = false;
                        } else if (i == tinggiMap - 1 && j == panjangMap - 1) {
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

            for (int i = 0; i < tinggiMap; i++) {
                for (int j = 0; j < panjangMap; j++) {
                    tile[i][j].setPicture(i, j);
                }
            }

            for (int i = 0; i < tinggiMap; i++) {
                for (int j = 0; j < panjangMap; j++) {
                    tile[i][j].setxPosition(xPosition + widthTile * j);
                    tile[i][j].setyPosition(yPosition + heightTile * i);
                }
            }

            for (int i = 0; i < tinggiBorder; i++) {
                for (int j = 0; j < panjangBorder; j++) {
                    border[i][j].setPicture();
                }
            }

            for (int i = 0; i < tinggiBorder; i++) {
                for (int j = 0; j < panjangBorder; j++) {
                    border[i][j].setxPosition(xBorder + widthTile * j);
                    border[i][j].setyPosition(yBorder + heightTile * i);
                }
            }

            int index = 0;
            for (int i = 0; i < tinggiMap; i++) {
                for (int j = 0; j < panjangMap; j++) {
                    if (i == tinggiMap - 1 && j == panjangMap - 1) {
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

            for (int i = 0; i < tinggiMap; i++) {
                for (int j = 0; j < panjangMap; j++) {
                    tile[i][j].create();
                }
            }
        } else if (number==2) {
            tile = new Tile[tinggiMap][panjangMap];
            border = new Border[tinggiBorder][panjangBorder];
            spawnTile = new SpawnTile[jumlahSpawnTile];

            for (int i = 0; i < tinggiMap; i++) {
                for (int j = 0; j < panjangMap; j++) {
                    tile[i][j] = new Tile();
                }
            }

            for (int i = 0; i < tinggiBorder; i++) {
                for (int j = 0; j < panjangBorder; j++) {
                    border[i][j] = new Border();
                }
            }

            for (int i = 0; i < jumlahSpawnTile; i++) {
                spawnTile[i] = new SpawnTile();
            }


            for (int i = 0; i < tinggiMap; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < panjangMap; j++) {
                        if (i == 0 && j == 0) {
                            tile[i][j].box = false;
                        } else if (i == tinggiMap - 1 && j == 0) {
                            tile[i][j].box = false;
                        } else if (i == 0 && j == panjangMap - 1) {
                            tile[i][j].box = false;
                        } else if (i == tinggiMap - 1 && j == panjangMap - 1) {
                            tile[i][j].box = false;
                        } else if (j % 2 == 0) {
                            if (i>(getTinggiBorder()/4)-1){
                              if (i<getTinggiMap()*0.75){
                                  if (j>(getPanjangBorder()/4)-1){
                                      if (j<getPanjangMap()*0.75){
                                          tile[i][j].box = false;
                                      } else {
                                          tile[i][j].box = true;
                                          jumlahBox++;
                                      }
                                  } else {
                                      tile[i][j].box = true;
                                      jumlahBox++;
                                  }
                              } else {
                                  tile[i][j].box = true;
                                  jumlahBox++;
                              }
                            } else {
                                tile[i][j].box = true;
                                jumlahBox++;
                            }
                        } else {
                            tile[i][j].box = false;
                        }
                    }
                } else {
                    for (int j = 0; j < panjangMap; j++) {
                        if (i == 0 && j == 0) {
                            tile[i][j].box = false;
                        } else if (i == tinggiMap - 1 && j == 0) {
                            tile[i][j].box = false;
                        } else if (i == 0 && j == panjangMap - 1) {
                            tile[i][j].box = false;
                        } else if (i == tinggiMap - 1 && j == panjangMap - 1) {
                            tile[i][j].box = false;
                        } else if (j % 2 == 0) {
                            tile[i][j].box = false;
                        } else {

                            if (i > (getTinggiMap() / 4)-1) {
                                if (i < getTinggiMap() * 0.75) {
                                    if (j > (getPanjangMap() / 4)-1) {
                                        if (j < getPanjangMap() * 0.75) {
                                            tile[i][j].wall = false;
                                        } else {
                                            tile[i][j].wall = true;
                                            jumlahWall++;
                                        }
                                    } else {
                                        tile[i][j].wall = true;
                                        jumlahWall++;
                                    }
                                } else {
                                    tile[i][j].wall = true;
                                    jumlahWall++;
                                }
                            } else {
                                tile[i][j].wall = true;
                                jumlahWall++;
                            }

                        }
                    }
                }
            }

            for (int i = 0; i < tinggiMap; i++) {
                for (int j = 0; j < panjangMap; j++) {
                    tile[i][j].setPicture(i, j);
                }
            }

            for (int i = 0; i < tinggiBorder; i++) {
                for (int j = 0; j < panjangBorder; j++) {
                    border[i][j].setPicture();
                }
            }

            for (int i = 0; i < tinggiBorder; i++) {
                for (int j = 0; j < panjangBorder; j++) {
                    border[i][j].setxPosition(xBorder + widthTile * j);
                    border[i][j].setyPosition(yBorder + heightTile * i);
                }
            }

            for (int i = 0; i < tinggiMap; i++) {
                for (int j = 0; j < panjangMap; j++) {
                    tile[i][j].setxPosition(border[0][0].getxPosition()+widthTile + widthTile * j);
                    tile[i][j].setyPosition(border[0][0].getyPosition()+heightTile + heightTile * i);
                }
            }

            int index = 0;
            for (int i = 0; i < tinggiMap; i++) {
                for (int j = 0; j < panjangMap; j++) {
                    if (i == tinggiMap - 1 && j == panjangMap - 1) {
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

            for (int i = 0; i < tinggiMap; i++) {
                for (int j = 0; j < panjangMap; j++) {
                    tile[i][j].create();
                }
            }
        }
    }

    public MapGame(int number, int panjangMap,int tinggiMap, int panjangBorder, int tinggiBorder) {
        this.panjangMap=panjangMap;
        this.tinggiMap=tinggiMap;
        this.panjangBorder=panjangBorder;
        this.tinggiBorder=tinggiBorder;
        widthTile = BomberMan.heightScreen/panjangBorder;
        heightTile = BomberMan.heightScreen/tinggiBorder;
        xPosition = (BomberMan.widthScreen - widthTile * panjangBorder) / 2 + widthTile;
        yPosition = BomberMan.heightScreen/2-heightTile*(tinggiBorder/2);

        if (number==0){
            border= new Border[tinggiBorder][panjangBorder];

            for (int i=0; i<tinggiBorder; i++){
                for (int j=0; j<panjangBorder; i++){
                    border[i][j]= new Border();
                }
            }

            for (int i = 0; i < tinggiBorder; i++) {
                for (int j = 0; j < panjangBorder; j++) {
                    border[i][j].setPicture();
                }
            }

            for (int i = 0; i < tinggiBorder; i++) {
                for (int j = 0; j < panjangBorder; j++) {
                    border[i][j].setxPosition(xBorder + widthTile * j);
                    border[i][j].setyPosition(yBorder + heightTile * i);
                }
            }

        } else if (number == 1) {
            tile = new Tile[tinggiMap][panjangMap];
            border = new Border[tinggiBorder][panjangBorder];
            spawnTile = new SpawnTile[jumlahSpawnTile];

            for (int i = 0; i < tinggiMap; i++) {
                for (int j = 0; j < panjangMap; j++) {
                    tile[i][j] = new Tile();
                }
            }

            for (int i = 0; i < tinggiBorder; i++) {
                for (int j = 0; j < panjangBorder; j++) {
                    border[i][j] = new Border();
                }
            }

            for (int i = 0; i < jumlahSpawnTile; i++) {
                spawnTile[i] = new SpawnTile();
            }


            for (int i = 0; i < tinggiMap; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < panjangMap; j++) {
                        if (i == 0 && j == 0) {
                            tile[i][j].box = false;
                        } else if (i == tinggiMap - 1 && j == 0) {
                            tile[i][j].box = false;
                        } else if (i == 0 && j == panjangMap - 1) {
                            tile[i][j].box = false;
                        } else if (i == tinggiMap - 1 && j == panjangMap - 1) {
                            tile[i][j].box = false;
                        } else if (j % 2 == 0) {
                            tile[i][j].box = true;
                            jumlahBox++;
                        } else {
                            tile[i][j].box = false;
                        }
                    }
                } else {
                    for (int j = 0; j < panjangMap; j++) {
                        if (i == 0 && j == 0) {
                            tile[i][j].box = false;
                        } else if (i == tinggiMap - 1 && j == 0) {
                            tile[i][j].box = false;
                        } else if (i == 0 && j == panjangMap - 1) {
                            tile[i][j].box = false;
                        } else if (i == tinggiMap - 1 && j == panjangMap - 1) {
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

            for (int i = 0; i < tinggiMap; i++) {
                for (int j = 0; j < panjangMap; j++) {
                    tile[i][j].setPicture(i, j);
                }
            }

            for (int i = 0; i < tinggiBorder; i++) {
                for (int j = 0; j < panjangBorder; j++) {
                    border[i][j].setPicture();
                }
            }

            for (int i = 0; i < tinggiBorder; i++) {
                for (int j = 0; j < panjangBorder; j++) {
                    border[i][j].setxPosition(xBorder + widthTile * j);
                    border[i][j].setyPosition(yBorder + heightTile * i);
                }
            }

            for (int i = 0; i < tinggiMap; i++) {
                for (int j = 0; j < panjangMap; j++) {
                    tile[i][j].setxPosition(border[0][0].getxPosition()+widthTile + widthTile * j);
                    tile[i][j].setyPosition(border[0][0].getyPosition()+heightTile + heightTile * i);
                }
            }

            int index = 0;
            for (int i = 0; i < tinggiMap; i++) {
                for (int j = 0; j < panjangMap; j++) {
                    if (i == tinggiMap - 1 && j == panjangMap - 1) {
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

            for (int i = 0; i < tinggiMap; i++) {
                for (int j = 0; j < panjangMap; j++) {
                    tile[i][j].create();
                }
            }
        } else if (number==2) {
            tile = new Tile[tinggiMap][panjangMap];
            border = new Border[tinggiBorder][panjangBorder];
            spawnTile = new SpawnTile[jumlahSpawnTile];

            for (int i = 0; i < tinggiMap; i++) {
                for (int j = 0; j < panjangMap; j++) {
                    tile[i][j] = new Tile();
                }
            }

            for (int i = 0; i < panjangBorder; i++) {
                for (int j = 0; j < tinggiBorder; j++) {
                    border[i][j] = new Border();
                }
            }

            for (int i = 0; i < jumlahSpawnTile; i++) {
                spawnTile[i] = new SpawnTile();
            }


            for (int i = 0; i < tinggiMap; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < panjangMap; j++) {
                        if (i == 0 && j == 0) {
                            tile[i][j].box = false;
                        } else if (i == tinggiMap - 1 && j == 0) {
                            tile[i][j].box = false;
                        } else if (i == 0 && j == panjangMap - 1) {
                            tile[i][j].box = false;
                        } else if (i == tinggiMap - 1 && j == panjangMap - 1) {
                            tile[i][j].box = false;
                        } else if (j % 2 == 0) {
                            if (i>(getTinggiMap()/4)-1){
                                if (i<getTinggiMap()*0.75){
                                    if (j>(getPanjangMap()/4)-1){
                                        if (j<getPanjangMap()*0.75){
                                            tile[i][j].box = false;
                                        } else {
                                            tile[i][j].box = true;
                                            jumlahBox++;
                                        }
                                    } else {
                                        tile[i][j].box = true;
                                        jumlahBox++;
                                    }
                                } else {
                                    tile[i][j].box = true;
                                    jumlahBox++;
                                }
                            } else {
                                tile[i][j].box = true;
                                jumlahBox++;
                            }
                        } else {
                            tile[i][j].box = false;
                        }
                    }
                } else {
                    for (int j = 0; j < panjangMap; j++) {
                        if (i == 0 && j == 0) {
                            tile[i][j].box = false;
                        } else if (i == tinggiMap - 1 && j == 0) {
                            tile[i][j].box = false;
                        } else if (i == 0 && j == panjangMap - 1) {
                            tile[i][j].box = false;
                        } else if (i == tinggiMap - 1 && j == panjangMap - 1) {
                            tile[i][j].box = false;
                        } else if (j % 2 == 0) {
                            tile[i][j].box = false;
                        } else {

                            if (i > (getTinggiMap() / 4)-1) {
                                if (i < getTinggiMap() * 0.75) {
                                    if (j > (getPanjangMap() / 4)-1) {
                                        if (j < getPanjangMap() * 0.75) {
                                            tile[i][j].wall = false;
                                        } else {
                                            tile[i][j].wall = true;
                                            jumlahWall++;
                                        }
                                    } else {
                                        tile[i][j].wall = true;
                                        jumlahWall++;
                                    }
                                } else {
                                    tile[i][j].wall = true;
                                    jumlahWall++;
                                }
                            } else {
                                tile[i][j].wall = true;
                                jumlahWall++;
                            }

                        }
                    }
                }
            }

            for (int i = 0; i < tinggiMap; i++) {
                for (int j = 0; j < panjangMap; j++) {
                    tile[i][j].setPicture(i, j);
                }
            }

            for (int i = 0; i < tinggiBorder; i++) {
                for (int j = 0; j < panjangBorder; j++) {
                    border[i][j].setPicture();
                }
            }

            for (int i = 0; i < tinggiBorder; i++) {
                for (int j = 0; j < panjangBorder; j++) {
                    border[i][j].setxPosition(xBorder + widthTile * j);
                    border[i][j].setyPosition(yBorder + heightTile * i);
                }
            }

            for (int i = 0; i < tinggiMap; i++) {
                for (int j = 0; j < panjangMap; j++) {
                    tile[i][j].setxPosition(border[0][0].getxPosition()+widthTile + widthTile * j);
                    tile[i][j].setyPosition(border[0][0].getyPosition()+heightTile + heightTile * i);
                }
            }

            int index = 0;
            for (int i = 0; i < tinggiMap; i++) {
                for (int j = 0; j < panjangMap; j++) {
                    if (i == tinggiMap - 1 && j == panjangMap - 1) {
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

            for (int i = 0; i < tinggiMap; i++) {
                for (int j = 0; j < panjangMap; j++) {
                    tile[i][j].create();
                }
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

        for (int i = 0; i < tinggiMap; i++) {
            for (int j = 0; j < panjangMap; j++) {
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

        int indexRight=0;
        boolean right=true;
        boolean rightEnd=false;

        int indexLeft=0;
        boolean left=true;
        boolean leftEnd=false;

        int indexUp=0;
        boolean up=true;
        boolean upEnd=false;

        int indexDown=0;
        boolean down=true;
        boolean downEnd=false;

        for (int i = 1; i <= bomb.getRangeExplosion(); i++) {

            if (i < bomb.rangeExplosion) {
                if (up){
                    if (bomb.getI()+i<tinggiMap){
                        if (isWall(bomb.getI()+i,bomb.getJ())){
                            up=false;
                        } else {
                            if (isBox(bomb.getI()+i,bomb.getJ())){
                                upEnd=true;
                                up=false;
                                indexUp=i;
                            } else {
                                createLedakan = new Ledakan("up", bomb.getX(), bomb.getY() + bomb.getHeight() * (i), bomb.getWidth(), bomb.getHeight());
                                ledakan.add(createLedakan);
                                createLedakan = null;
                            }
                        }
                    } else {
                        up=false;
                    }
                }

                if (down){
                    if (bomb.getI()-i>=0){
                        if (isWall(bomb.getI()-i,bomb.getJ())){
                            down=false;
                        } else {
                            if (isBox(bomb.getI()-i,bomb.getJ())){
                                downEnd=true;
                                down=false;
                                indexDown=i;
                            } else {
                                createLedakan = new Ledakan("down", bomb.getX(), bomb.getY() - bomb.getHeight() * (i), bomb.getWidth(), bomb.getHeight());
                                ledakan.add(createLedakan);
                                createLedakan = null;
                            }
                        }
                    } else {
                        down=false;
                    }
                }

                if (left){
                    if (bomb.getJ()-i>=0){
                        if (isWall(bomb.getI(),bomb.getJ()-i)){
                            left=false;
                        } else {
                            if (isBox(bomb.getI(),bomb.getJ()-i)){
                                leftEnd=true;
                                left=false;
                                indexLeft=i;
                            } else {
                                createLedakan = new Ledakan("left", bomb.getX() - bomb.getWidth() * (i), bomb.getY(), bomb.getWidth(), bomb.getHeight());
                                ledakan.add(createLedakan);
                                createLedakan = null;
                            }
                        }
                    } else {
                        left=false;
                    }
                }

                if (right){
                    if (bomb.getJ()+i<tinggiMap){
                        if (isWall(bomb.getI(),bomb.getJ()+i)){
                            right=false;
                        } else {
                            if (isBox(bomb.getI(),bomb.getJ()+i)){
                                rightEnd=true;
                                right=false;
                                indexRight=i;
                            } else {
                                createLedakan = new Ledakan("right", bomb.getX() + bomb.getWidth() * (i), bomb.getY(), bomb.getWidth(), bomb.getHeight());
                                ledakan.add(createLedakan);
                                createLedakan = null;
                            }
                        }
                    } else {
                        right=false;
                    }
                }


            } else {
                if (up||upEnd){
                    if (up){
                        if (bomb.getI()+i<tinggiMap){
                            if (isWall(bomb.getI()+i,bomb.getJ())){
                                up=false;
                            } else {
                                createLedakan = new Ledakan("endUp", bomb.getX(), bomb.getY() + bomb.getHeight() * (i), bomb.getWidth(), bomb.getHeight());
                                ledakan.add(createLedakan);
                                createLedakan = null;
                            }
                        } else {
                            up=false;
                        }
                    } else if (upEnd) {
                        createLedakan = new Ledakan("endUp", bomb.getX(), bomb.getY() + bomb.getHeight() * (indexUp), bomb.getWidth(), bomb.getHeight());
                        ledakan.add(createLedakan);
                        createLedakan = null;
                    }
                }

                if (down||downEnd){
                    if (down){
                        if (bomb.getI()-i>=0){
                            if (isWall(bomb.getI()-i,bomb.getJ())){
                                down=false;
                            } else {
                                createLedakan = new Ledakan("endDown", bomb.getX(), bomb.getY() - bomb.getHeight() * (i), bomb.getWidth(), bomb.getHeight());
                                ledakan.add(createLedakan);
                                createLedakan = null;
                            }
                        } else {
                            down=false;
                        }
                    } else if (downEnd) {
                        createLedakan = new Ledakan("endDown", bomb.getX(), bomb.getY() - bomb.getHeight() * (indexDown), bomb.getWidth(), bomb.getHeight());
                        ledakan.add(createLedakan);
                        createLedakan = null;
                    }
                }

                if (left||leftEnd){
                    if (left){
                        if (bomb.getJ()-i>=0){
                            if (isWall(bomb.getI(),bomb.getJ()-i)){
                                left=false;
                            } else {
                                createLedakan = new Ledakan("endLeft", bomb.getX() - bomb.getWidth() * (i), bomb.getY(), bomb.getWidth(), bomb.getHeight());
                                ledakan.add(createLedakan);
                                createLedakan = null;
                            }
                        } else {
                            left=false;
                        }
                    } else if (leftEnd){
                        createLedakan = new Ledakan("endLeft", bomb.getX() - bomb.getWidth() * (indexLeft), bomb.getY(), bomb.getWidth(), bomb.getHeight());
                        ledakan.add(createLedakan);
                        createLedakan = null;
                    }
                }

                if (right||rightEnd){
                    if (right){
                        if (bomb.getJ()+i<panjangMap){
                            if (isWall(bomb.getI(),bomb.getJ()+i)){
                                right=false;
                            } else {
                                createLedakan = new Ledakan("endRight", bomb.getX() + bomb.getWidth() * (i), bomb.getY(), bomb.getWidth(), bomb.getHeight());
                                ledakan.add(createLedakan);
                                createLedakan = null;
                            }
                        } else {
                            right=false;
                        }
                    } else if (rightEnd) {
                        createLedakan = new Ledakan("endRight", bomb.getX() + bomb.getWidth() * (indexRight), bomb.getY(), bomb.getWidth(), bomb.getHeight());
                        ledakan.add(createLedakan);
                        createLedakan = null;
                    }
                }
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

    public static int getPanjangBorder() {
        return panjangBorder;
    }

    public static int getPanjangMap() {
        return panjangMap;
    }

    public static int getTinggiBorder() {
        return tinggiBorder;
    }

    public static int getTinggiMap() {
        return tinggiMap;
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