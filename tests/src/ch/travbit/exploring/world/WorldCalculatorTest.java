package ch.travbit.exploring.world;

import ch.travbit.exploring.world.util.ChunkPos;
import ch.travbit.exploring.world.util.WorldCalculator;
import com.badlogic.gdx.math.Vector2;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test for {@link WorldCalculator}
 */
public class WorldCalculatorTest {

    @Test
    public void testCalcWorldCoordinateByChunkCorner() {
        WorldCalculator calculator = new WorldCalculator(16, 32);
        int lowerX = 0;
        int lowerY = 0;
        Assert.assertEquals(new Vector2(0, 0), calculator.calcWorldCoordinateByChunkCorner(lowerX, lowerY));
        Assert.assertEquals(new Vector2(512, 512), calculator.calcWorldCoordinateByChunkCorner(lowerX + 1, lowerY + 1));
    }

    @Test
    public void testCalcChunkPosByWorldCoordinate() {
        WorldCalculator calculator = new WorldCalculator(16, 32);
        Vector2 worldPos = new Vector2(510, 120);
        ChunkPos chunkPos = calculator.calcChunkPosByWorldCoordinate(worldPos);
        Assert.assertEquals(new ChunkPos(0, 0), chunkPos);
    }

    @Test
    public void testCalcChunkPosByWorldCoordinate2() {
        WorldCalculator calculator = new WorldCalculator(16, 32);
        Vector2 worldPos = new Vector2(600, 120);
        ChunkPos chunkPos = calculator.calcChunkPosByWorldCoordinate(worldPos);
        Assert.assertEquals(new ChunkPos(1, 0), chunkPos);
    }

    @Test
    public void testCalcChunkPosByWorldCoordinateNeg() {
        WorldCalculator calculator = new WorldCalculator(16, 32);
        Vector2 worldPos = new Vector2(-10, 0);
        ChunkPos chunkPos = calculator.calcChunkPosByWorldCoordinate(worldPos);
        Assert.assertEquals(new ChunkPos(-1, 0), chunkPos);
    }
}
