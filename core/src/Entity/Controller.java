package Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Controller {

    float x,y;
    Controller(float x, float y){
        this.x=x;
        this.y=y;
    }


    float naik(float y){
        y=+ 4;
        return y;
    }

    float turun(float y){
        y=- 4;
        return y;
    }

    float kanan(float x){
        x=+4;
        return x;
    }

    float kiri(float x){
        x=-4;
        return x;
    }
}
