package Utility.Analog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Analog1 extends Analog{
    @Override
    public String update() {

        String gerakan;
        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            gerakan="up";
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)){
            gerakan="left";
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)){
            gerakan="down";
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)){
            gerakan="right";
        } else {
            gerakan=null;
        }

        return gerakan;
    }
}
