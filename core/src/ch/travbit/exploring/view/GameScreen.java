package ch.travbit.exploring.view;

import ch.travbit.exploring.ExploringGame;
import ch.travbit.exploring.system.MapSystem;
import ch.travbit.exploring.system.PlayerSystem;
import ch.travbit.exploring.system.RenderSystem;
import ch.travbit.exploring.world.World;
import ch.travbit.exploring.world.WorldFacade;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

/**
 * This class represents the main game screen.
 */
public class GameScreen implements Screen {

    private PooledEngine engine;
    private OrthographicCamera camera;
    private ExploringGame exploringGame;

    public GameScreen(ExploringGame exploringGame) {
        this.exploringGame = exploringGame;
        camera = new OrthographicCamera(640, 480);
        engine = new PooledEngine();
        init();
    }

    private void init() {
        camera.position.set(320, 240, 0);

        World world = WorldFacade.createExploringWorld(exploringGame, engine);
        world.init();
        world.createWorldAroundPlayer(new Vector2(0,0));

        engine.addSystem(new RenderSystem(camera, exploringGame.getSpriteBatch()));
        engine.addSystem(new MapSystem(world));
        engine.addSystem(new PlayerSystem());
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
