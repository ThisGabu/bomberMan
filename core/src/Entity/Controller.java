package Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Controller {


    float naik(float y, float speed){
        y= y+ speed;
        return y;
    }

    float turun(float y, float speed){
        y= y - speed;
        return y;
    }

    float kanan(float x, float speed){
        x=x+speed;
        return x;
    }

    float kiri(float x, float speed){
        x=x-speed;
        return x;
    }
}
