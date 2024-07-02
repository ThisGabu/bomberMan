package bomberman.game;

import GameScreen.ControllerScreen;
import Utility.MapGame;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class BomberMan extends Game {

	public static final int widthScreen=1280;
	public static final int heightScreen=720;


	Screen controller;


	
	@Override
	public void create () {
		controller = new ControllerScreen();
	}

	@Override
	public void render () {

		if (ControllerScreen.restartPlayScreen){
			controller.dispose();
		}

		if (ControllerScreen.exitGame) {
			Gdx.app.exit();
		}

			controller.render(Gdx.graphics.getDeltaTime());

	}

	@Override
	public void resume(){
		controller.render(Gdx.graphics.getDeltaTime());
	}


	@Override
	public void dispose() {

	}
}
