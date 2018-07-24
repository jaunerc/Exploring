package ch.travbit.exploring.view;

import ch.travbit.exploring.component.PlayerComponent;
import ch.travbit.exploring.component.PositionComponent;
import ch.travbit.exploring.component.VisualComponent;
import ch.travbit.exploring.system.MapSystem;
import ch.travbit.exploring.system.PlayerSystem;
import ch.travbit.exploring.system.RenderSystem;
import ch.travbit.exploring.tilemap.MapFactory;
import ch.travbit.exploring.tilemap.TileMapFacade;
import ch.travbit.exploring.util.AssetLoader;
import ch.travbit.exploring.util.PlayerAsset;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameScreen implements Screen {

    private PooledEngine engine;
    private AssetLoader assetLoader;

    public GameScreen(OrthographicCamera camera, AssetLoader assetLoader) {
        this.assetLoader = assetLoader;
        engine = new PooledEngine();
        engine.addSystem(new RenderSystem(camera));
        engine.addSystem(new MapSystem(assetLoader));
        engine.addSystem(new PlayerSystem());
        tmpCreatePlayer();
    }

    private void tmpCreatePlayer() {
        Entity player = engine.createEntity();
        player.add(new PositionComponent(0,0));
        player.add(new VisualComponent(new TextureRegion(assetLoader.getPlayer(PlayerAsset.PSEUDO)), Color.CYAN));
        player.add(new PlayerComponent("Dave"));
        engine.addEntity(player);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);
    }

    private void update(float delta) {
        engine.update(delta);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
