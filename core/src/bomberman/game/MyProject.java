package bomberman.game;

import Entity.Player;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import javax.swing.text.PlainDocument;

public class MyProject extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	float x;
	float y;
	Player player= new Player();
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);

		if (Gdx.input.isTouched()){
			player.jalan(batch, img);
		}

		batch.begin();

		batch.draw(img, x, y);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
