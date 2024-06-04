package bomberman.game;

import GameScreen.MainGameScreen;
import GameScreen.MainMenuScreen;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import bomberman.game.MyProject;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("BomberManGame");
		config.setWindowedMode(MainGameScreen.widthScreen, MainGameScreen.heightScreen);
		new Lwjgl3Application(new MainMenuScreen(), config);

	}
}
