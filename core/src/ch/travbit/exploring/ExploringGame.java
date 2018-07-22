package ch.travbit.exploring;

import ch.travbit.exploring.view.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class ExploringGame extends Game {
	
	@Override
	public void create () {
		OrthographicCamera camera = new OrthographicCamera(640, 480);
		camera.position.set(320, 240, 0);
		camera.update();
		setScreen(new GameScreen(camera));
	}
}
