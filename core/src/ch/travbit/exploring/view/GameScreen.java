package ch.travbit.exploring.view;

import ch.travbit.exploring.system.RenderSystem;
import ch.travbit.exploring.tilemap.MapFactory;
import ch.travbit.exploring.tilemap.TileMapFacade;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameScreen implements Screen {

    private PooledEngine engine;

    public GameScreen(OrthographicCamera camera) {
        engine = new PooledEngine();
        engine.addSystem(new RenderSystem(camera));
        test();
    }

    private void test() {
        MapFactory factory = TileMapFacade.createSimpleMapFactory();
        factory.generateMap(engine, 10, 10);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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
