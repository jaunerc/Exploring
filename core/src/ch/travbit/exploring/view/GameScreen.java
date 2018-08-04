package ch.travbit.exploring.view;

import ch.travbit.exploring.ExploringGame;
import ch.travbit.exploring.component.PlayerComponent;
import ch.travbit.exploring.component.PositionComponent;
import ch.travbit.exploring.component.VisualComponent;
import ch.travbit.exploring.system.MapCleanupSystem;
import ch.travbit.exploring.system.MapSystem;
import ch.travbit.exploring.system.PlayerSystem;
import ch.travbit.exploring.system.RenderSystem;
import ch.travbit.exploring.util.PlayerAsset;
import ch.travbit.exploring.util.rendering.RenderLayer;
import ch.travbit.exploring.world.World;
import ch.travbit.exploring.world.WorldFacade;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
        camera = new OrthographicCamera(320, 240);
        engine = new PooledEngine();
        init();
    }

    private void init() {
        camera.position.set(320, 240, 0);

        Vector2 playerStartPosition = new Vector2(320, 240);
        createPlayer(playerStartPosition);

        World world = WorldFacade.createExploringWorld(exploringGame, engine);
        world.init();

        engine.addSystem(new RenderSystem(camera, exploringGame.getSpriteBatch()));
        engine.addSystem(new MapSystem(world, playerStartPosition));
        engine.addSystem(new PlayerSystem(camera));
        engine.addSystem(new MapCleanupSystem(camera));
    }
    private void createPlayer(Vector2 startPosition) {
        Entity player = engine.createEntity();
        PositionComponent pos = engine.createComponent(PositionComponent.class);
        pos.vector.x = startPosition.x;
        pos.vector.y = startPosition.y;
        VisualComponent visual = engine.createComponent(VisualComponent.class);
        visual.textureRegion = new TextureRegion(exploringGame.getAssetLoader().getPlayer(PlayerAsset.PSEUDO));
        visual.renderLevel = RenderLayer.PLAYER.getIndex();

        player.add(pos);
        player.add(visual);
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
