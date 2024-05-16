package Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player1 implements Player {
    public float y=0,x=0;
    float speed=1;
    float out;
    Controller controller = new Controller();

    public void jalan(){
        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            this.y=controller.naik(this.y, speed);
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            this.y=controller.turun(this.y, speed);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            this.x=controller.kanan(this.x, speed);
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            this.x=controller.kiri(this.x, speed);
        }

        System.out.println(x+ " " +y);

    }
}
