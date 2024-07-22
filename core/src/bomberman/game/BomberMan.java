package bomberman.game;

import GameScreen.ControllerScreen;
import Utility.MapGame;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import java.awt.*;

public class BomberMan extends Game {

	static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	public static final int widthScreen= gd.getDisplayMode().getWidth();
	public static final int heightScreen= gd.getDisplayMode().getHeight();

	Screen controller;


	@Override
	public void create () {
		controller = new ControllerScreen();
	}

	@Override
	public void render () {

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
