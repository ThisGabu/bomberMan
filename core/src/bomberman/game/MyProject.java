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

import static GameScreen.MainMenuScreen.*;

public class MyProject extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img, img1, map;
	Player1 player1;
	Player2 player2;
	Texture backgorund;

	MyProject(){
		player1 = new Player1();
		player2 = new Player2();
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();

	}

	@Override
	public void render () {

		batch.begin();
		batch.draw(backgorund, xBackground, yBackgorund, width, height);
		batch.end();

	}


	@Override
	public void dispose () {
		batch.dispose();
	}
}
