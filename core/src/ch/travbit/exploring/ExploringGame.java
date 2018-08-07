package ch.travbit.exploring;

import ch.travbit.exploring.util.AssetLoader;
import ch.travbit.exploring.util.config.ConfigKey;
import ch.travbit.exploring.util.config.GameConfig;
import ch.travbit.exploring.view.GameScreen;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ExploringGame extends Game {

    private SpriteBatch spriteBatch;
    private AssetLoader assetLoader;
    private GameConfig gameConfig;

    public ExploringGame() {
        assetLoader = new AssetLoader();
        gameConfig = new GameConfig();
    }

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        spriteBatch = new SpriteBatch();
        loadAssets();
        initGameConfig();
        setScreen(new GameScreen(this));
    }

    private void loadAssets() {
        assetLoader.prepareTileLoading();
        assetLoader.preparePlayerLoading();
        assetLoader.loadAllResourcesBlocking();
    }

    private void initGameConfig() {
        gameConfig.setIntValue(ConfigKey.CHUNK_SIZE, 8);
        gameConfig.setIntValue(ConfigKey.PIXELS_PER_METER, 32);
        gameConfig.setFloatValue(ConfigKey.START_POS_X, 0);
        gameConfig.setFloatValue(ConfigKey.START_POS_Y, 0);
        gameConfig.setFloatValue(ConfigKey.CAMERA_VIEWPORT_WIDTH, 320);
        gameConfig.setFloatValue(ConfigKey.CAMERA_VIEWPORT_HEIGHT, 240);
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public AssetLoader getAssetLoader() {
        return assetLoader;
    }

    public GameConfig getGameConfig() {
        return gameConfig;
    }
}
