package bomberman.game;

import Entity.Player;
import Entity.Player1;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyProject extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Player player;

	MyProject(){
		player = new Player1();
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)){
			player.jalan();
		}

		batch.draw(img, player.x,player.y)
		;
		batch.end();



	}


	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
