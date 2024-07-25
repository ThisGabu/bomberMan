package GameScreen;

import bomberman.game.BomberMan;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SettingScreen implements Screen {

    SpriteBatch batch;

    Texture backgorund;;
    Texture SettingBackground;
    Texture SettingText;
    Texture MapText;
    Texture PanjangMapText;
    Texture Angka1;
    Texture Angka3;
    Texture Angka5;
    Texture Angka7;
    Texture Angka9;
    Texture Angka0;
    Texture ArrowKanan;
    Texture ArrowKiri;
    Texture ArrowBawah;

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

    private final float widthPanjangText=615/1.5f;
    private final float heightPanjangText=100/1.5f;
    private final float xPanjangText=widthBackground/2-widthPanjangText/2;
    private final float yPanjangText=heightBackground/1.32f-heightPanjangText/2;

    private final float widthMapText=321;
    private final float heightMapText=115;
    private final float xMapText=0;
    private final float yMapText=0;

    private final float widthArrow=35*1.7f;
    private final float heightArrow=26*1.7f;

    private final float widthAngka=66;
    private final float heightAngka=93;

    private final float xAngkaPertamaPanjang=widthBackground/2-widthAngka-widthAngka/2;
    private final float yAngkaPertamaPanjang=yPanjangText-10-heightAngka;
    private final float xAngkaKeduaPanjang=widthBackground/2+widthAngka/2;
    private final float yAngkaKeduaPanjang=yPanjangText-10-heightAngka;
    private final float xArrowKananPanjang=xAngkaKeduaPanjang+widthAngka+widthArrow*2;
    private final float yArrowKananPanjang=yAngkaKeduaPanjang+heightAngka/2-heightArrow/1.7f;
    private final float xArrowKiriPanjang=xAngkaPertamaPanjang-widthAngka-widthArrow*1.7f;
    private final float yArrowKiriPanjang=yAngkaKeduaPanjang+heightAngka/2-heightArrow/2;

    private final float xAngkaPertamaMap=0;
    private final float yAngkaPertamaMap=0;
    private final float xAngkaKeduaMap=0;
    private final float yAngkaKeduaMap=0;
    private final float xArrowKananMap=0;
    private final float yArrowKananMap=0;



    SettingScreen(){
        batch= new SpriteBatch();
        backgorund = new Texture("D:\\Project coding\\bomberMan\\assets\\MainMenuScreen\\background.png");
        SettingBackground= new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\settingBackground.png");
        SettingText = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\Setting.png");
        MapText = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\MAP.png");
        PanjangMapText = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\panjang map.png");
        Angka0 = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\0.png");
        Angka1 = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\1.png");
        Angka3 = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\3.png");
        Angka5 = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\5.png");
        Angka7 = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\7.png");
        Angka9 = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\9.png");
        ArrowBawah= new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\arrow.png");
        ArrowKanan = new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\arrow kanan.png");
        ArrowKiri= new Texture("D:\\Project coding\\bomberMan\\assets\\SettingScreen\\arrow kiri.png");
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
        batch.draw(Angka0,xAngkaPertamaPanjang,yAngkaPertamaPanjang,widthAngka,heightAngka);
        batch.draw(Angka0,xAngkaKeduaPanjang,yAngkaKeduaPanjang,widthAngka,heightAngka);
        batch.draw(ArrowKanan,xArrowKananPanjang,yArrowKananPanjang,widthArrow,heightArrow);
        batch.draw(ArrowKiri,xArrowKiriPanjang,yArrowKiriPanjang,widthArrow,heightArrow);
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
