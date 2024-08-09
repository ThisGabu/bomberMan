package Utility.Analog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Analog2 extends Analog{
    @Override
    public String update() {

        String gerakan;
        if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_RIGHT)){
            gerakan="bomb";
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            gerakan="left";
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            gerakan="down";
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            gerakan="right";
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            gerakan="up";
        } else {
            gerakan=null;
        }

        return gerakan;
    }

    public boolean sprint(){
        boolean sprint=false;

        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)){
            sprint=true;
        } else {
            sprint=false;
        }

        return sprint;
    }
}
