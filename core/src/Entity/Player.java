package Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Player {
    float y=0,x=0;
    Controller controller = new Controller(x,y);

    public void jalan(SpriteBatch batch, Texture img){
        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            y=controller.naik(y);
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            y=controller.turun(y);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            x=controller.kanan(x);
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            x=controller.kiri(x);
        }

        batch.begin();
        batch.draw(img, x, y);
        batch.end();
    }
}
