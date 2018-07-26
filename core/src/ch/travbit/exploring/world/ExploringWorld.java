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
import com.badlogic.gdx.math.Vector2;

import java.util.HashSet;

/**
 * This class represents the concrete in game world.
 */
public class ExploringWorld implements World {

    private ExploringGame game;
    private MapFactory mapFactory;
    private PooledEngine engine;
    private ChunkPos currentChunk;
    private Vector2 currentChunkWorldCoordinateMin;
    private Vector2 currentChunkWorldCoordinateMax;
    private HashSet<ChunkPos> generatedChunks;
    private final int chunkSize;
    private final int pixelsPerMeter;

    public ExploringWorld(ExploringGame game, PooledEngine engine, int chunkSize, int pixelsPerMeter) {
        this.game = game;
        this.engine = engine;
        this.chunkSize = chunkSize;
        this.pixelsPerMeter = pixelsPerMeter;
        mapFactory = TileMapFacade.createSimpleMapFactory(game.getAssetLoader());
        generatedChunks = new HashSet<>();
        currentChunk = null;
        currentChunkWorldCoordinateMin = new Vector2();
        currentChunkWorldCoordinateMax = new Vector2();
    }

    @Override
    public void init() {
        Entity worldEntity = engine.createEntity();
        worldEntity.add(new WorldComponent(11));
        engine.addEntity(worldEntity);

        mapFactory.init(this);
    }

    @Override
    public void createWorldAroundPlayer(Vector2 playerPosition) {
        mapFactory.createTiles(engine, 0, 0);
        currentChunk = new ChunkPos(0,0);
        generatedChunks.add(currentChunk);
        currentChunkWorldCoordinateMin = new Vector2(calcWorldCoordinate(0, pixelsPerMeter, chunkSize),
                calcWorldCoordinate(0, pixelsPerMeter, chunkSize));
        currentChunkWorldCoordinateMax = new Vector2(calcWorldCoordinate(1, pixelsPerMeter, chunkSize),
                calcWorldCoordinate(1, pixelsPerMeter, chunkSize));
        createPlayer();
    }

    private float calcWorldCoordinate(int index, int pixelsPerMeter, int chunkSize) {
        return index * pixelsPerMeter * chunkSize;
    }

    @Override
    public void expandWorld(Vector2 playerPosition) {
        if (! isInsideChunk(playerPosition)) {
            ChunkPos tmpPos = new ChunkPos(0,0);
            int[] neighborX = new int[] {-1, 0, 1, -1, 0, 1, -1, 0, 1};
            int[] neighborY = new int[] {1, 1, 1, 0, 0, 0, -1, -1, -1};

            for (int i = 0; i < neighborX.length; i++) {
                tmpPos.setX(currentChunk.getX() + neighborX[i]);
                tmpPos.setY(currentChunk.getY() + neighborY[i]);
                createChunkIfNotExist(tmpPos);
            }
        }
    }

    private boolean isInsideChunk(Vector2 pos) {
        return pos.x >= currentChunkWorldCoordinateMin.x &&
                pos.y >= currentChunkWorldCoordinateMin.y &&
                pos.x < currentChunkWorldCoordinateMax.x &&
                pos.y < currentChunkWorldCoordinateMax.y;
    }

    private void createChunkIfNotExist(ChunkPos chunkPos) {
        if (! generatedChunks.contains(chunkPos)) {
            System.out.println(chunkPos.getX()+", "+chunkPos.getY());
        }
    }

    @Override
    public int getChunkSize() {
        return chunkSize;
    }

    @Override
    public int getPixelsPerMeter() {
        return pixelsPerMeter;
    }

    private void createPlayer() {
        Entity player = engine.createEntity();
        player.add(new PositionComponent(0,0));
        player.add(new VisualComponent(new TextureRegion(game.getAssetLoader().getPlayer(PlayerAsset.PSEUDO)), Color.CYAN));
        player.add(new PlayerComponent("Dave"));
        engine.addEntity(player);
    }
}
