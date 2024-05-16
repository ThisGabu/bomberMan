package bomberman.game;

import Entity.Player;
import Entity.Player1;
import Entity.Player2;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyProject extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img, img1;
	Player1 player1;
	Player2 player2;

	MyProject(){
		player1 = new Player1();
		player2 = new Player2();
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("test2.png");
		img1 = new Texture("test.png");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);

		if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)){
			player1.jalan();
			player2.jalan();
		}
		batch.begin();
		batch.draw(img, player1.x, player1.y, 50, 50);

		batch.draw(img1, player2.x, player2.y, 50, 50);
		batch.end();

	}


	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
