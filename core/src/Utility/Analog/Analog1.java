package Utility.Analog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Analog1 extends Analog{
    @Override
    public String update() {

        String gerakan;
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            gerakan="bomb";
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)){
            gerakan="left";
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)){
            gerakan="down";
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)){
            gerakan="right";
        } else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            gerakan="up";
        } else {
            gerakan=null;
        }

        return gerakan;
    }

    public boolean sprint(){
        boolean sprint=false;

        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)){
            sprint=true;
        } else {
            sprint=false;
        }

        return sprint;
    }
}
