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
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

class InstructionScreen implements Screen {

    ControllerPlayer player;
    SpawnTile[] spawnTile;
    SpriteBatch batch;
    BitmapFont font;
    MapGame map;

    Texture backgorund;;
    float widthBackground= BomberMan.widthScreen;
    float heightBackground=BomberMan.heightScreen;
    float xBackground=0;
    float yBackground=0;

    Texture instructionBackground;
    private final float widthInstruction= 776;
    private final float heightInstruction= 361;
    private final float xInstruction= BomberMan.widthScreen/2-widthInstruction/2;
    private final float yInstruction= BomberMan.heightScreen/2-heightInstruction/2;

    Texture center;
    private final float widthCenter= heightInstruction/2/3*10;
    private final float heightCenter= heightInstruction/2;
    private final float xCenter= BomberMan.widthScreen/2-widthCenter/2;
    private final float yCenter= yInstruction+heightInstruction/2-heightCenter/3;

    Texture sButton;
    Texture sHover;
    private final float widthS= heightCenter/3;
    private final float heightS= heightCenter/3;
    private final float xS= (xInstruction+widthInstruction)/4-widthS;
    private final float yS= (yInstruction+heightInstruction)/4;

    Texture aButton;
    Texture aHover;
    private final float widthA= widthS;
    private final float heightA= heightS;
    private final float xA= xS-widthA-1;
    private final float yA= yS;

    Texture wButton;
    Texture wHover;
    private final float widthW= widthA;
    private final float heightW= heightA;
    private final float xW= xS;
    private final float yW= yS+heightW+1;

    Texture dButton;
    Texture dHover;
    private final float widthD= widthA;
    private final float heightD= heightA;
    private final float xD= xS+widthA+1;
    private final float yD= yS;

    Texture spaceButton;
    Texture spaceHover;
    private final float widthSpace= widthA*3;
    private final float heightSpace= heightA;
    private final float xSpace= xD+widthS+1;
    private final float ySpace= yS;

    Texture downButton;
    Texture downHover;
    private final float widthDown= widthA;
    private final float heightDown= heightA;
    private final float xDown= (xInstruction+widthInstruction)-(xS-xInstruction)-widthDown;
    private final float yDown= yS;

    Texture upButton;
    Texture upHover;
    private final float widthUp= widthA;
    private final float heightUp= heightA;
    private final float xUp= xDown;
    private final float yUp= yDown+heightDown+1;

    Texture rightButton;
    Texture rightHover;
    private final float widthRight= widthA;
    private final float heightRight= heightA;
    private final float xRight= xDown+widthRight+1;
    private final float yRight= yDown;

    Texture leftButton;
    Texture leftHover;
    private final float widthLeft= widthA;
    private final float heightLeft= heightA;
    private final float xLeft= xDown-widthDown-1;
    private final float yLeft= yDown;

    Texture ctrlButton;
    Texture ctrlHover;
    private final float widthCTRL= widthA*2.5f;
    private final float heightCTRL= heightA;
    private final float xCTRL= xLeft-widthCTRL-1;
    private final float yCTRL= yDown;

    InstructionScreen(){

        map= new MapGame(1,11,11,11,11);

        backgorund = new Texture("..\\bomberMan\\assets\\MainMenuScreen\\background.png");
        instructionBackground= new Texture("..\\bomberMan\\assets\\IntructionScreen\\background.png");
        center= new Texture("..\\bomberMan\\assets\\IntructionScreen\\center.png");

        aButton= new Texture("..\\bomberMan\\assets\\IntructionScreen\\KeyboardA.png");
        wButton= new Texture("..\\bomberMan\\assets\\IntructionScreen\\KeyboardW.png");
        sButton= new Texture("..\\bomberMan\\assets\\IntructionScreen\\KeyboardS.png");
        dButton= new Texture("..\\bomberMan\\assets\\IntructionScreen\\KeyboardD.png");
        spaceButton= new Texture("..\\bomberMan\\assets\\IntructionScreen\\KeyboardSpace.png");

        aHover= new Texture("..\\bomberMan\\assets\\IntructionScreen\\KeyboardAHover.png");
        wHover= new Texture("..\\bomberMan\\assets\\IntructionScreen\\KeyboardWHover.png");
        sHover= new Texture("..\\bomberMan\\assets\\IntructionScreen\\KeyboardSHover.png");
        dHover= new Texture("..\\bomberMan\\assets\\IntructionScreen\\KeyboardDHover.png");
        spaceHover= new Texture("..\\bomberMan\\assets\\IntructionScreen\\SpaceHover.png");

        upButton= new Texture("..\\bomberMan\\assets\\IntructionScreen\\arrowUp.png");
        downButton= new Texture("..\\bomberMan\\assets\\IntructionScreen\\arrowDown.png");
        rightButton= new Texture("..\\bomberMan\\assets\\IntructionScreen\\arrowRight.png");
        leftButton= new Texture("..\\bomberMan\\assets\\IntructionScreen\\arrowLeft.png");
        ctrlButton= new Texture("..\\bomberMan\\assets\\IntructionScreen\\keyboardCTRL.png");

        upHover= new Texture("..\\bomberMan\\assets\\IntructionScreen\\ArrowUpHover.png");
        downHover= new Texture("..\\bomberMan\\assets\\IntructionScreen\\ArrowDownHover.png");
        rightHover= new Texture("..\\bomberMan\\assets\\IntructionScreen\\ArrowRightHover.png");
        leftHover= new Texture("..\\bomberMan\\assets\\IntructionScreen\\ArrowLeftHover.png");
        ctrlHover= new Texture("..\\bomberMan\\assets\\IntructionScreen\\CTRLHover.png");

        spawnTile= new SpawnTile[PlayScreen.jumlahPlayer];
        batch= new SpriteBatch();
        font= new BitmapFont();

        for (int i=0; i< PlayScreen.jumlahPlayer; i++){
            spawnTile[i]= new SpawnTile();
        }

        for (int i=0; i<PlayScreen.jumlahPlayer; i++){
            if (i==0){
                spawnTile[i].setxPosition(BomberMan.widthScreen/2-widthA);
                spawnTile[i].setyPosition(BomberMan.heightScreen/2);
            } else if (i==1){
                spawnTile[i].setxPosition(BomberMan.widthScreen/2+widthA);
                spawnTile[i].setyPosition(BomberMan.heightScreen/2);
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

        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            batch.draw(aHover,xA,yA,widthA,heightA);
        } else {
            batch.draw(aButton,xA,yA,widthA,heightA);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            batch.draw(wHover,xW,yW,widthW,heightW);
        } else {
            batch.draw(wButton,xW,yW,widthW,heightW);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            batch.draw(sHover, xS, yS, widthS, heightS);
        } else {
            batch.draw(sButton, xS, yS, widthS, heightS);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            batch.draw(dHover, xD, yD, widthD, heightD);
        } else {
            batch.draw(dButton, xD, yD, widthD, heightD);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            batch.draw(spaceHover, xSpace, ySpace, widthSpace, heightSpace);
        } else {
            batch.draw(spaceButton, xSpace, ySpace, widthSpace, heightSpace);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            batch.draw(upHover, xUp, yUp, widthUp, heightUp);
        } else {
            batch.draw(upButton, xUp, yUp, widthUp, heightUp);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            batch.draw(downHover, xDown, yDown, widthDown, heightDown);
        } else {
            batch.draw(downButton, xDown, yDown, widthDown, heightDown);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            batch.draw(rightHover, xRight, yRight, widthRight, heightRight);
        } else {
            batch.draw(rightButton, xRight, yRight, widthRight, heightRight);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            batch.draw(leftHover, xLeft, yLeft, widthLeft, heightLeft);
        } else {
            batch.draw(leftButton, xLeft, yLeft, widthLeft, heightLeft);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_RIGHT)){
            batch.draw(ctrlHover, xCTRL, yCTRL, widthCTRL, heightCTRL);
        } else {
            batch.draw(ctrlButton, xCTRL, yCTRL, widthCTRL, heightCTRL);
        }

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
