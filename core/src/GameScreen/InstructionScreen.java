package GameScreen;

import Entity.Bomb.Bomb;
import Entity.Player.ControllerPlayer;
import Utility.MapGame;
import Utility.SpawnTile;
import bomberman.game.BomberMan;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

class InstructionScreen implements Screen {

    ControllerPlayer player;
    SpawnTile[] spawnTile;
    SpriteBatch batch;
    MapGame map;

    Texture backgorund;;
    float widthBackground= BomberMan.widthScreen;
    float heightBackground=BomberMan.heightScreen;
    float xBackground=0;
    float yBackground=0;

    Texture instructionBackground;
    private final float widthInstruction= 776*2;
    private final float heightInstruction= 361*2;
    private final float xInstruction= BomberMan.widthScreen/2-widthInstruction/2;
    private final float yInstruction= BomberMan.heightScreen/2-heightInstruction/2;

    Texture center;
    private final float widthCenter= 502*2;
    private final float heightCenter= 152*3;
    private final float xCenter= BomberMan.widthScreen/2-widthCenter/2;
    private final float yCenter= yInstruction+heightInstruction/2-heightCenter/3;

    Texture sButton;
    private final float widthS= 54*2;
    private final float heightS= 52*2;
    private final float xS= (xInstruction+widthInstruction)/4-widthS;
    private final float yS= (yInstruction+heightInstruction)/4;

    Texture aButton;
    private final float widthA= widthS;
    private final float heightA= heightS;
    private final float xA= xS-widthA-1;
    private final float yA= yS;

    Texture wButton;
    private final float widthW= widthA;
    private final float heightW= heightA;
    private final float xW= xS;
    private final float yW= yS+heightW+1;

    Texture dButton;
    private final float widthD= widthA;
    private final float heightD= heightA;
    private final float xD= xS+widthA+1;
    private final float yD= yS;

    Texture spaceButton;
    private final float widthSpace= 202*2;
    private final float heightSpace= 52*2;
    private final float xSpace= xD+widthS+1;
    private final float ySpace= yS;

    Texture downButton;
    private final float widthDown= 54*2;
    private final float heightDown= 52*2;
    private final float xDown= (xInstruction+widthInstruction)-(xS-xInstruction)-widthDown;
    private final float yDown= yS;

    Texture upButton;
    private final float widthUp= widthA;
    private final float heightUp= heightA;
    private final float xUp= xDown;
    private final float yUp= yDown+heightDown+1;

    Texture rightButton;
    private final float widthRight= widthA;
    private final float heightRight= heightA;
    private final float xRight= xDown+widthRight+1;
    private final float yRight= yDown;

    Texture leftButton;
    private final float widthLeft= widthA;
    private final float heightLeft= heightA;
    private final float xLeft= xDown-widthDown-1;
    private final float yLeft= yDown;

    Texture ctrlButton;
    private final float widthCTRL= 135*2;
    private final float heightCTRL= 52*2;
    private final float xCTRL= xLeft-widthCTRL-1;
    private final float yCTRL= yDown;

    InstructionScreen(){

        map= new MapGame(1);

        backgorund = new Texture("D:\\Project coding\\bomberMan\\assets\\MainMenuScreen\\background.png");
        instructionBackground= new Texture("D:\\Project coding\\bomberMan\\assets\\IntructionScreen\\background.png");
        center= new Texture("D:\\Project coding\\bomberMan\\assets\\IntructionScreen\\center.png");

        aButton= new Texture("D:\\Project coding\\bomberMan\\assets\\IntructionScreen\\KeyboardA.png");
        wButton= new Texture("D:\\Project coding\\bomberMan\\assets\\IntructionScreen\\KeyboardW.png");
        sButton= new Texture("D:\\Project coding\\bomberMan\\assets\\IntructionScreen\\KeyboardS.png");
        dButton= new Texture("D:\\Project coding\\bomberMan\\assets\\IntructionScreen\\KeyboardD.png");
        spaceButton= new Texture("D:\\Project coding\\bomberMan\\assets\\IntructionScreen\\KeyboardSpace.png");

        upButton= new Texture("D:\\Project coding\\bomberMan\\assets\\IntructionScreen\\arrowUp.png");
        downButton= new Texture("D:\\Project coding\\bomberMan\\assets\\IntructionScreen\\arrowDown.png");
        rightButton= new Texture("D:\\Project coding\\bomberMan\\assets\\IntructionScreen\\arrowRight.png");
        leftButton= new Texture("D:\\Project coding\\bomberMan\\assets\\IntructionScreen\\arrowLeft.png");
        ctrlButton= new Texture("D:\\Project coding\\bomberMan\\assets\\IntructionScreen\\keyboardCTRL.png");

        spawnTile= new SpawnTile[PlayScreen.jumlahPlayer];
        batch= new SpriteBatch();

        for (int i=0; i< PlayScreen.jumlahPlayer; i++){
            spawnTile[i]= new SpawnTile();
        }

        for (int i=0; i<PlayScreen.jumlahPlayer; i++){
            if (i==0){
                spawnTile[i].setxPosition((xCenter+widthCenter)/3);
                spawnTile[i].setyPosition((yCenter+heightCenter)/2);
            } else if (i==1){
                spawnTile[i].setxPosition((xCenter+widthCenter)-(((xCenter+widthCenter)/3)-xCenter+widthCenter/10));
                spawnTile[i].setyPosition((yCenter+heightCenter)/2);
            }
        }

        player= new ControllerPlayer(PlayScreen.jumlahPlayer,spawnTile);

        for (int i=0; i<PlayScreen.jumlahPlayer; i++){
            player.setWidth(widthCenter/10,i);
            player.setHeight(widthCenter/10,i);
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(backgorund,xBackground,yBackground,widthBackground,heightBackground);
        batch.draw(instructionBackground,xInstruction,yInstruction,widthInstruction,heightInstruction);
        batch.draw(center, xCenter, yCenter, widthCenter, heightCenter);
        batch.draw(aButton,xA,yA,widthA,heightA);
        batch.draw(wButton,xW,yW,widthW,heightW);
        batch.draw(sButton, xS, yS, widthS, heightS);
        batch.draw(dButton, xD, yD, widthD, heightD);
        batch.draw(spaceButton, xSpace, ySpace, widthSpace, heightSpace);
        batch.draw(upButton, xUp, yUp, widthUp, heightUp);
        batch.draw(downButton, xDown, yDown, widthDown, heightDown);
        batch.draw(rightButton, xRight, yRight, widthRight, heightRight);
        batch.draw(leftButton, xLeft, yLeft, widthLeft, heightLeft);
        batch.draw(ctrlButton, xCTRL, yCTRL, widthCTRL, heightCTRL);

        for (int i= 0; i<PlayScreen.jumlahPlayer; i++){
            player.update(i,map,delta);
        }

        for (int i=0; i<PlayScreen.jumlahPlayer; i++){
            if (player.isAlive(i)) {
                batch.draw(player.drawPlayer(i, delta), player.getXPositionPlayer(i), player.getYPositionPlayer(i), player.getWidthPlayer(i), player.getHeightPlayer(i));

                if (player.isShield(i)){
                    batch.draw(player.drawShield(i,delta),((player.getXPositionPlayer(i)+player.getWidthPlayer(i)/2))-(player.getPictureShield(i).getHeight()/2),player.getYPositionPlayer(i)+(player.getHeightPlayer(i)/2)-(player.getPictureShield(i).getHeight()/2));
                }

                if (player.isStun(i)){
                    batch.draw(player.drawStun(i,delta),((player.getXPositionPlayer(i)+player.getWidthPlayer(i)/2))-(15/2),player.getYPositionPlayer(i)+(player.getHeightPlayer(i)),15,15);
                }
            }
        }

        for (int i=0; i<PlayScreen.jumlahPlayer; i++){
            if (player.getYPositionPlayer(i)+player.getHeightPlayer(i)<yCenter+heightCenter){
                player.setUp(true,i);
            } else {
                player.setUp(false, i);
            }
        }

        for (int i=0; i<PlayScreen.jumlahPlayer; i++){
            if (player.getYPositionPlayer(i)>yCenter){
                player.setDown(true,i);
            } else {
                player.setDown(false, i);
            }
        }

        for (int i=0; i<PlayScreen.jumlahPlayer; i++){
            if (player.getXPositionPlayer(i)>xCenter){
                player.setLeft(true,i);
            } else {
                player.setLeft(false, i);
            }
        }

        for (int i=0; i<PlayScreen.jumlahPlayer; i++){
            if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<xCenter+widthCenter){
                player.setRight(true,i);
            } else {
                player.setRight(false, i);
            }
        }

        for (int i=0; i<PlayScreen.jumlahPlayer; i++){
            if (player.getIsBomb(i)) {

            } else {
                player.setCapacityBomb(i, player.getCapacityBomb(i)+1);
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            ControllerScreen.instruction=false;
            ControllerScreen.mainMenu=true;
        }

        batch.end();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
