package Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player2 implements Player {
    public float y=0,x=70;
    float speed=1;
    Controller controller = new Controller();

    public void jalan(){
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            this.y=controller.naik(this.y, speed);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.y=controller.turun(this.y, speed);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.x=controller.kanan(this.x, speed);
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.x=controller.kiri(this.x, speed);
        }

        System.out.println(x+ " " +y);

    }
}
