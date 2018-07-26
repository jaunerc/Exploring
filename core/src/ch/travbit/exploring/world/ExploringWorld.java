package ch.travbit.exploring.world;

import ch.travbit.exploring.ExploringGame;
import ch.travbit.exploring.component.PlayerComponent;
import ch.travbit.exploring.component.PositionComponent;
import ch.travbit.exploring.component.VisualComponent;
import ch.travbit.exploring.component.WorldComponent;
import ch.travbit.exploring.util.PlayerAsset;
import ch.travbit.exploring.world.tilemap.MapFactory;
import ch.travbit.exploring.world.tilemap.TileMapFacade;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * This class represents the concrete in game world.
 */
public class ExploringWorld implements World {

    private ExploringGame game;
    private MapFactory mapFactory;
    private PooledEngine engine;
    private int chunkSize;

    public ExploringWorld(ExploringGame game, PooledEngine engine) {
        this.game = game;
        this.engine = engine;
        mapFactory = TileMapFacade.createSimpleMapFactory(game.getAssetLoader());
    }

    @Override
    public void init() {
        Entity worldEntity = engine.createEntity();
        worldEntity.add(new WorldComponent(11));
        engine.addEntity(worldEntity);

        chunkSize = 10;
        mapFactory.init(this);
    }

    @Override
    public void createWorld() {
        mapFactory.createTiles(engine, 10, 0);
        createPlayer();
    }

    @Override
    public void expandWorld() {

    }

    @Override
    public int getChunkSize() {
        return chunkSize;
    }

    private void createPlayer() {
        Entity player = engine.createEntity();
        player.add(new PositionComponent(0,0));
        player.add(new VisualComponent(new TextureRegion(game.getAssetLoader().getPlayer(PlayerAsset.PSEUDO)), Color.CYAN));
        player.add(new PlayerComponent("Dave"));
        engine.addEntity(player);
    }
}
