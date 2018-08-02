package ch.travbit.exploring.system;

import ch.travbit.exploring.component.PlayerComponent;
import ch.travbit.exploring.component.PositionComponent;
import ch.travbit.exploring.world.ChunkPos;
import ch.travbit.exploring.world.World;
import ch.travbit.exploring.world.WorldCalculator;
import com.badlogic.ashley.core.*;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;

import java.util.HashSet;

public final class MapSystem extends IteratingSystem {

    private final static int[] neighborX = new int[] {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    private final static int[] neighborY = new int[] {1, 1, 1, 0, 0, 0, -1, -1, -1};

    private ComponentMapper<PositionComponent> pm;
    private World world;
    private WorldCalculator worldCalculator;
    private ChunkPos currentChunk;
    private Vector2 currentChunkWorldCoordinateMin;
    private Vector2 currentChunkWorldCoordinateMax;
    private HashSet<ChunkPos> generatedChunks;

    public MapSystem(World world, Vector2 playerStartPosition) {
        super(Family.all(PlayerComponent.class, PositionComponent.class).get());

        pm = ComponentMapper.getFor(PositionComponent.class);

        this.world = world;
        int pixelsPerMeter = world.getPixelsPerMeter();
        int chunkSize = world.getChunkSize();
        worldCalculator = new WorldCalculator(chunkSize, pixelsPerMeter);

        generatedChunks = new HashSet<>();
        currentChunk = worldCalculator.calcChunkPosByWorldCoordinate(playerStartPosition);
        currentChunkWorldCoordinateMin = worldCalculator.calcWorldCoordinateByChunkCorner(
                currentChunk.getX(), currentChunk.getY());
        currentChunkWorldCoordinateMax = worldCalculator.calcWorldCoordinateByChunkCorner(
                currentChunk.getX() + 1, currentChunk.getY() + 1);
    }

    @Override
    public void addedToEngine(Engine engine) {
        super.addedToEngine(engine);
        createMapAroundPlayer();
    }

    private void createMapAroundPlayer() {
        for (int i = 0 ; i < neighborX.length; i++) {
            ChunkPos pos = new ChunkPos(currentChunk.getX() + neighborX[i],
                    currentChunk.getY() + neighborY[i]);
            createChunkIfNotExist(pos);
        }
        System.out.println(currentChunk.getX() + ", " + currentChunk.getY());
    }

    private boolean isInsideChunk(Vector2 pos) {
        return pos.x >= currentChunkWorldCoordinateMin.x &&
                pos.y >= currentChunkWorldCoordinateMin.y &&
                pos.x < currentChunkWorldCoordinateMax.x &&
                pos.y < currentChunkWorldCoordinateMax.y;
    }

    private void createChunkIfNotExist(ChunkPos chunkPos) {
        if (! generatedChunks.contains(chunkPos)) {
            Vector2 startCoordinates = worldCalculator.calcWorldCoordinateByChunkCorner(chunkPos.getX(), chunkPos.getY());
            world.expandWorld(startCoordinates.x, startCoordinates.y);
            generatedChunks.add(chunkPos);
        }
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = pm.get(entity);
        if (! isInsideChunk(position.vector)) {
            currentChunk = worldCalculator.calcChunkPosByWorldCoordinate(position.vector);
            ChunkPos tmpPos = new ChunkPos(0,0);

            for (int i = 0; i < neighborX.length; i++) {
                tmpPos.setX(currentChunk.getX() + neighborX[i]);
                tmpPos.setY(currentChunk.getY() + neighborY[i]);
                createChunkIfNotExist(tmpPos);
            }
            currentChunkWorldCoordinateMin = worldCalculator.calcWorldCoordinateByChunkCorner(
                    currentChunk.getX(), currentChunk.getY());
            currentChunkWorldCoordinateMax = worldCalculator.calcWorldCoordinateByChunkCorner(
                    currentChunk.getX() + 1, currentChunk.getY() + 1);
            System.out.println(generatedChunks.size());
        }
    }
}
