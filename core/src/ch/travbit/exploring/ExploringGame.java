package ch.travbit.exploring;

import ch.travbit.exploring.util.AssetLoader;
import ch.travbit.exploring.view.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ExploringGame extends Game {

	private SpriteBatch spriteBatch;
	private AssetLoader assetLoader;

    public ExploringGame() {
        assetLoader = new AssetLoader();
    }

    private void loadAssets() {
        assetLoader.prepareTileLoading();
        assetLoader.preparePlayerLoading();
        assetLoader.loadAllResourcesBlocking();
    }

    @Override
	public void create () {
        spriteBatch = new SpriteBatch();
		OrthographicCamera camera = new OrthographicCamera(640, 480);
		camera.position.set(320, 240, 0);
		camera.update();
        loadAssets();
		setScreen(new GameScreen(this));
	}

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public AssetLoader getAssetLoader() {
        return assetLoader;
    }
}
