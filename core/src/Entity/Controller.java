package Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Controller {

    int x,y;
    Controller(int x, int y){
        this.x=x;
        this.y=y;
    }


    int naik(int y){
        y=+ 4;
        return y;
    }

    int turun(int y){
        y=- 4;
        return y;
    }

    int kanan(int x){
        x=+4;
        return x;
    }

    int kiri(int x){
        x=-4;
        return x;
    }
}
