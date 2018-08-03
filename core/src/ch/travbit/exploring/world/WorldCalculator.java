package ch.travbit.exploring.world;

import com.badlogic.gdx.math.Vector2;

/**
 * This class represents a calculator for coordinates and chunk positions.
 */
public class WorldCalculator {
    private int chunkSize;
    private int pixelsPerMeter;

    public WorldCalculator(int chunkSize, int pixelsPerMeter) {
        this.chunkSize = chunkSize;
        this.pixelsPerMeter = pixelsPerMeter;
    }

    public Vector2 calcWorldCoordinateByChunkCorner(int x, int y) {
        return new Vector2(
                x * chunkSize * pixelsPerMeter,
                y * chunkSize * pixelsPerMeter);
    }

    public ChunkPos calcChunkPosByWorldCoordinate(Vector2 worldPosition) {
        int x = (int) Math.floor(worldPosition.x / chunkSize / pixelsPerMeter);
        int y = (int) Math.floor(worldPosition.y / chunkSize / pixelsPerMeter); //TODO fix problem with negative coordinates
        return new ChunkPos(x, y);
    }

    public void setChunkSize(int chunkSize) {
        this.chunkSize = chunkSize;
    }

    public void setPixelsPerMeter(int pixelsPerMeter) {
        this.pixelsPerMeter = pixelsPerMeter;
    }

    public int getChunkSize() {
        return chunkSize;
    }

    public int getPixelsPerMeter() {
        return pixelsPerMeter;
    }
}
