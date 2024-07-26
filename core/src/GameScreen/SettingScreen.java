package GameScreen;

import bomberman.game.BomberMan;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SettingScreen implements Screen {

    SpriteBatch batch;

    public int SizeSekarang = 7;
    public int MapType = 1;
    Texture[] Angka = new Texture[10];
    Texture angka1;
    Texture angka2;

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

    private final float widthSettingBackground=1038/1.3f;
    private final float heightSettingBackground=614;
    private final float xSettingBackground= BomberMan.widthScreen/2-widthSettingBackground/2;
    private final float ySettingBackground= BomberMan.heightScreen/2-heightSettingBackground/2;

    private final float widthSettingText=467/3.6f;
    private final float heightSettingText=119/3.6f;
    private final float xSettingText=widthBackground/3.7f-widthSettingText/2;
    private final float ySettingText=heightBackground/1.177f-heightSettingText/2;

    private final float widthPanjangText=615/1.4f;
    private final float heightPanjangText=100/1.4f;
    private final float xPanjangText=widthBackground/2-widthPanjangText/2;
    private final float yPanjangText=heightBackground/1.34f-heightPanjangText/2;

    private final float widthArrow=35*1.75f;
    private final float heightArrow=26*1.75f;

    private final float widthAngka=66*1.2f;
    private final float heightAngka=93*1.2f;

    private final float xAngkaPertamaPanjang=widthBackground/2-widthAngka/2-widthAngka/2;
    private final float yAngkaPertamaPanjang=yPanjangText-17-heightAngka;
    private final float xAngkaKeduaPanjang=widthBackground/2+widthAngka/4;
    private final float yAngkaKeduaPanjang=yAngkaPertamaPanjang;
    private final float xArrowKananPanjang=xAngkaKeduaPanjang+widthAngka+widthArrow*2;
    private final float yArrowKananPanjang=yAngkaKeduaPanjang+heightAngka/2-heightArrow/1.7f;
    private final float xArrowKiriPanjang=xAngkaPertamaPanjang-widthAngka-widthArrow*1.7f;
    private final float yArrowKiriPanjang=yAngkaKeduaPanjang+heightAngka/2-heightArrow/2;

    private final float widthMapText=321/1.6f;
    private final float heightMapText=115/1.6f;
    private final float xMapText=widthBackground/2-widthMapText/2;
    private final float yMapText=yAngkaPertamaPanjang-heightMapText*1.65f;

    private final float xAngkaPertamaMap=widthBackground/2-widthAngka/2;
    private final float yAngkaPertamaMap=yMapText-22-heightAngka;
    private final float xArrowKananMap=xAngkaPertamaMap+widthAngka+widthArrow*2;
    private final float yArrowKananMap=yAngkaPertamaMap+heightAngka/2-heightArrow/1.7f;
    private final float xArrowKiriMap=xAngkaPertamaMap-widthAngka-widthArrow*1.7f;
    private final float yArrowKiriMap=yAngkaPertamaMap+heightAngka/2-heightArrow/2;



    SettingScreen(){
        batch= new SpriteBatch();
        backgorund = new Texture("D:\\Project coding\\bomberMan\\assets\\MainMenuScreen\\background.png");
        SettingBackground= new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\settingBackground.png");
        SettingText = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\Setting.png");
        MapText = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\MAP.png");
        PanjangMapText = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\panjang map.png");
        angka1 = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\1.png");
        angka2 = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\2.png");
        Angka[0] = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\0.png");
        Angka[1] = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\1.png");
        Angka[2] = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\2.png");
        Angka[3] = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\3.png");
        Angka[4] = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\4.png");
        Angka[5] = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\5.png");
        Angka[6] = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\6.png");
        Angka[7] = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\7.png");
        Angka[8] = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\8.png");
        Angka[9] = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\9.png");
        ArrowKanan = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\arrow kanan.png");
        ArrowKiri= new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\arrow kiri.png");
        ArrowKananHover= new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\arrow kananHover.png");
        ArrowKiriHover= new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\arrow kiriHover.png");

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(backgorund,xBackground,yBackground,widthBackground,heightBackground);
        batch.draw(SettingBackground,xSettingBackground,ySettingBackground,widthSettingBackground,heightSettingBackground);
        batch.draw(SettingText,xSettingText,ySettingText,widthSettingText,heightSettingText);
        batch.draw(PanjangMapText,xPanjangText,yPanjangText,widthPanjangText,heightPanjangText);
        batch.draw(Angka[0],xAngkaPertamaPanjang,yAngkaPertamaPanjang,widthAngka,heightAngka);
        batch.draw(Angka[3],xAngkaKeduaPanjang,yAngkaKeduaPanjang,widthAngka,heightAngka);
        batch.draw(ArrowKanan,xArrowKananPanjang,yArrowKananPanjang,widthArrow,heightArrow);
        batch.draw(ArrowKiri,xArrowKiriPanjang,yArrowKiriPanjang,widthArrow,heightArrow);
        batch.draw(MapText, xMapText, yMapText, widthMapText, heightMapText);
        batch.draw(angka1,xAngkaPertamaMap,yAngkaPertamaMap,widthAngka,heightAngka);
        batch.draw(ArrowKanan,xArrowKananMap,yArrowKananMap,widthArrow,heightArrow);
        batch.draw(ArrowKiri,xArrowKiriMap,yArrowKiriMap,widthArrow,heightArrow);

        if (Gdx.input.getX()>xArrowKiriPanjang&&Gdx.input.getX()<xArrowKiriPanjang+widthArrow&&Gdx.input.getY()<heightBackground-yArrowKiriPanjang&&Gdx.input.getY()>heightBackground-yArrowKiriPanjang-heightArrow*2){
            if(Gdx.input.isTouched()){
                if (SizeSekarang > 7){
                    //Kurangi Tile
                    //SizeSekarang-=2;
                    //for array number -1 (2kali for)
                }

            } else{
                batch.draw(ArrowKiriHover,xArrowKiriPanjang, yArrowKiriPanjang, widthArrow, heightArrow);
            }
        }

        if (Gdx.input.getX()>xArrowKananPanjang&&Gdx.input.getX()<xArrowKananPanjang+widthArrow&&Gdx.input.getY()<heightBackground-yArrowKananPanjang&&Gdx.input.getY()>heightBackground-yArrowKananPanjang-heightArrow*2){
            if(Gdx.input.isTouched()){
                if (SizeSekarang > 7){
                    //Tambah Tile
                    //SizeSekarang+=2;
                    //for array number +1 (2kali for)
                }

            } else{
                batch.draw(ArrowKananHover,xArrowKananPanjang, yArrowKananPanjang, widthArrow, heightArrow);
            }
        }

        if (Gdx.input.getX()>xArrowKiriMap&&Gdx.input.getX()<xArrowKiriMap+widthArrow&&Gdx.input.getY()<heightBackground-yArrowKiriMap&&Gdx.input.getY()>heightBackground-yArrowKiriMap-heightArrow*2){
            if(ControllerScreen.mapNumber==2&&Gdx.input.isTouched()){
                batch.draw(angka1,xAngkaPertamaMap,yAngkaPertamaMap,widthAngka,heightAngka);
                ControllerScreen.mapNumber--;
            } else{
                batch.draw(ArrowKiriHover,xArrowKiriMap, yArrowKiriMap, widthArrow, heightArrow);
            }
        }

        if (Gdx.input.getX()>xArrowKananMap&&Gdx.input.getX()<xArrowKananMap+widthArrow&&Gdx.input.getY()<heightBackground-yArrowKananMap&&Gdx.input.getY()>heightBackground-yArrowKananMap-heightArrow*2){
            if(ControllerScreen.mapNumber==1&&Gdx.input.isTouched()){
                    batch.draw(angka2,xAngkaPertamaMap,yAngkaPertamaMap,widthAngka,heightAngka);
                    ControllerScreen.mapNumber++;
            } else{
                batch.draw(ArrowKananHover,xArrowKananMap, yArrowKananMap, widthArrow, heightArrow);
            }
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
