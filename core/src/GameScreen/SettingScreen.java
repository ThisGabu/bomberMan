package GameScreen;

import Utility.MapGame;
import bomberman.game.BomberMan;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SettingScreen implements Screen {

    SpriteBatch batch;

    public int SizeSekarang = ControllerScreen.jumlahTileRumput;
    public int MapType = 1;
    Texture[] Angka = new Texture[10];
    Texture angka1;
    Texture angka2;
    Texture angka3;

    Texture backgorund;;
    Texture SettingBackground;
    Texture SettingText;
    Texture MapText;
    Texture PanjangMapText;
    Texture ArrowKanan;
    Texture ArrowKiri;
    Texture ArrowKananHover;
    Texture ArrowKiriHover;


    float widthBackground=BomberMan.widthScreen;
    float heightBackground=BomberMan.heightScreen;
    float xBackground=0;
    float yBackground=0;

    private final float widthSettingBackground=1038;
    private final float heightSettingBackground=614;
    private final float xSettingBackground= BomberMan.widthScreen/2-widthSettingBackground/2;
    private final float ySettingBackground= BomberMan.heightScreen/2-heightSettingBackground/2;

    private final float widthSettingText=widthSettingBackground/4/2;
    private final float heightSettingText=heightSettingBackground/4/4;
    private final float xSettingText=xSettingBackground+widthSettingText/4;
    private final float ySettingText=ySettingBackground+heightSettingBackground-heightSettingText-heightSettingText/2;

    private final float widthPanjangText=widthSettingBackground/2;
    private final float heightPanjangText=heightSettingBackground/5;
    private final float xPanjangText=widthBackground/2-widthPanjangText/2;
    private final float yPanjangText=ySettingText-heightPanjangText-heightPanjangText/6;

    private final float widthAngka=66;
    private final float heightAngka=93;

    private final float widthArrow=heightAngka/5*7;
    private final float heightArrow=heightAngka;

    private final float xAngkaPertamaPanjang=widthBackground/2-widthAngka;
    private final float yAngkaPertamaPanjang=yPanjangText-heightAngka-heightAngka/4;
    private final float xAngkaKeduaPanjang=xAngkaPertamaPanjang+widthAngka;
    private final float yAngkaKeduaPanjang=yAngkaPertamaPanjang;
    private final float xArrowKananPanjang=xAngkaKeduaPanjang+widthAngka+widthArrow;
    private final float yArrowKananPanjang=yAngkaPertamaPanjang;
    private final float xArrowKiriPanjang=xAngkaPertamaPanjang-widthAngka-widthAngka-widthArrow;
    private final float yArrowKiriPanjang=yArrowKananPanjang;

    private final float widthMapText=heightPanjangText/1.5f/23*64;
    private final float heightMapText=heightPanjangText/1.5f;
    private final float xMapText=widthBackground/2-widthMapText/2;
    private final float yMapText=yAngkaPertamaPanjang-heightMapText-heightMapText/2;

    private final float xAngkaPertamaMap=widthBackground/2-widthAngka/2;
    private final float yAngkaPertamaMap=yMapText-heightAngka-heightAngka/4;
    private final float xArrowKananMap=xArrowKananPanjang;
    private final float yArrowKananMap=yAngkaPertamaMap;
    private final float xArrowKiriMap=xArrowKiriPanjang;
    private final float yArrowKiriMap=yAngkaPertamaMap;



    SettingScreen(){
        batch= new SpriteBatch();
        backgorund = new Texture("..\\bomberMan\\assets\\MainMenuScreen\\background.png");
        SettingBackground= new Texture("..\\bomberMan\\assets\\SettingScreen\\settingBackground.png");
        SettingText = new Texture("..\\bomberMan\\assets\\SettingScreen\\Setting.png");
        MapText = new Texture("..\\bomberMan\\assets\\SettingScreen\\MAP.png");
        PanjangMapText = new Texture("..\\bomberMan\\assets\\SettingScreen\\panjang map.png");
        angka1 = new Texture("..\\bomberMan\\assets\\SettingScreen\\0.png");
        angka2 = new Texture("..\\bomberMan\\assets\\SettingScreen\\0.png");
        angka3 = new Texture("..\\bomberMan\\assets\\SettingScreen\\0.png");
        Angka[0] = new Texture("..\\bomberMan\\assets\\SettingScreen\\0.png");
        Angka[1] = new Texture("..\\bomberMan\\assets\\SettingScreen\\1.png");
        Angka[2] = new Texture("..\\bomberMan\\assets\\SettingScreen\\2.png");
        Angka[3] = new Texture("..\\bomberMan\\assets\\SettingScreen\\3.png");
        Angka[4] = new Texture("..\\bomberMan\\assets\\SettingScreen\\4.png");
        Angka[5] = new Texture("..\\bomberMan\\assets\\SettingScreen\\5.png");
        Angka[6] = new Texture("..\\bomberMan\\assets\\SettingScreen\\6.png");
        Angka[7] = new Texture("..\\bomberMan\\assets\\SettingScreen\\7.png");
        Angka[8] = new Texture("..\\bomberMan\\assets\\SettingScreen\\8.png");
        Angka[9] = new Texture("..\\bomberMan\\assets\\SettingScreen\\9.png");
        ArrowKanan = new Texture("..\\bomberMan\\assets\\SettingScreen\\arrow kanan.png");
        ArrowKiri= new Texture("..\\bomberMan\\assets\\SettingScreen\\arrow kiri.png");
        ArrowKananHover= new Texture("..\\bomberMan\\assets\\SettingScreen\\arrow kananHover.png");
        ArrowKiriHover= new Texture("..\\bomberMan\\assets\\SettingScreen\\arrow kiriHover.png");

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        SizeSekarang = ControllerScreen.jumlahTileRumput;
        angka2= Angka[ControllerScreen.jumlahTileRumput%10];
        angka1= Angka[ (int) ControllerScreen.jumlahTileRumput/10];
        angka3= Angka[ControllerScreen.numberMap%10];

        batch.begin();
        batch.draw(backgorund,xBackground,yBackground,widthBackground,heightBackground);
        batch.draw(SettingBackground,xSettingBackground,ySettingBackground,widthSettingBackground,heightSettingBackground);
        batch.draw(SettingText,xSettingText,ySettingText,widthSettingText,heightSettingText);
        batch.draw(PanjangMapText,xPanjangText,yPanjangText,widthPanjangText,heightPanjangText);
        batch.draw(angka1,xAngkaPertamaPanjang,yAngkaPertamaPanjang,widthAngka,heightAngka);
        batch.draw(angka2,xAngkaKeduaPanjang,yAngkaKeduaPanjang,widthAngka,heightAngka);
        batch.draw(ArrowKanan,xArrowKananPanjang,yArrowKananPanjang,widthArrow,heightArrow);
        batch.draw(ArrowKiri,xArrowKiriPanjang,yArrowKiriPanjang,widthArrow,heightArrow);
        batch.draw(MapText, xMapText, yMapText, widthMapText, heightMapText);
        batch.draw(angka3,xAngkaPertamaMap,yAngkaPertamaMap,widthAngka,heightAngka);
        batch.draw(ArrowKanan,xArrowKananMap,yArrowKananMap,widthArrow,heightArrow);
        batch.draw(ArrowKiri,xArrowKiriMap,yArrowKiriMap,widthArrow,heightArrow);

        if (Gdx.input.getX()>xArrowKiriPanjang&&Gdx.input.getX()<xArrowKiriPanjang+widthArrow&&Gdx.input.getY()<heightBackground-yArrowKiriPanjang&&Gdx.input.getY()>heightBackground-yArrowKiriPanjang-heightArrow*2){
            if(Gdx.input.justTouched()){
                if (SizeSekarang == 11){
                    ControllerScreen.jumlahTileRumput=39;
                    ControllerScreen.jumlahTileMetal=ControllerScreen.jumlahTileRumput+2;
                    //for array number -1 (2kali for)
                } else {
                    ControllerScreen.jumlahTileRumput-=2;
                    ControllerScreen.jumlahTileMetal-=2;
                }

            } else{
                batch.draw(ArrowKiriHover,xArrowKiriPanjang, yArrowKiriPanjang, widthArrow, heightArrow);
            }
        }

        if (Gdx.input.getX()>xArrowKananPanjang&&Gdx.input.getX()<xArrowKananPanjang+widthArrow&&Gdx.input.getY()<heightBackground-yArrowKananPanjang&&Gdx.input.getY()>heightBackground-yArrowKananPanjang-heightArrow*2){
            if(Gdx.input.justTouched()){
                if (SizeSekarang==39){
                    ControllerScreen.jumlahTileRumput=11;
                    ControllerScreen.jumlahTileMetal=ControllerScreen.jumlahTileRumput+2;
                } else {
                    ControllerScreen.jumlahTileRumput+=2;
                    ControllerScreen.jumlahTileMetal+=2;
                }
                    //for array number +1 (2kali for)
            } else{
                batch.draw(ArrowKananHover,xArrowKananPanjang, yArrowKananPanjang, widthArrow, heightArrow);
            }
        }

        if (Gdx.input.getX()>xArrowKiriMap&&Gdx.input.getX()<xArrowKiriMap+widthArrow&&Gdx.input.getY()<heightBackground-yArrowKiriMap&&Gdx.input.getY()>heightBackground-yArrowKiriMap-heightArrow*2){
            if(Gdx.input.justTouched()){
                if (ControllerScreen.numberMap==1){
                    ControllerScreen.numberMap=ControllerScreen.jumlahMap;
                } else {
                    ControllerScreen.numberMap--;
                }
            } else{
                batch.draw(ArrowKiriHover,xArrowKiriMap, yArrowKiriMap, widthArrow, heightArrow);
            }
        }

        if (Gdx.input.getX()>xArrowKananMap&&Gdx.input.getX()<xArrowKananMap+widthArrow&&Gdx.input.getY()<heightBackground-yArrowKananMap&&Gdx.input.getY()>heightBackground-yArrowKananMap-heightArrow*2){
            if(Gdx.input.justTouched()){
                if (ControllerScreen.numberMap==ControllerScreen.jumlahMap){
                    ControllerScreen.numberMap=1;
                } else {
                    ControllerScreen.numberMap++;
                }
            } else{
                batch.draw(ArrowKananHover,xArrowKananMap, yArrowKananMap, widthArrow, heightArrow);
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            ControllerScreen.setting=false;
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
