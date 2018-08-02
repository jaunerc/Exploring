package ch.travbit.exploring.world;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for {@link ch.travbit.exploring.world.ChunkPos}
 */
public class ChunkPosTest {

    @Test
    public void testEquals() {
        ChunkPos pos1 = new ChunkPos(1,-2);
        ChunkPos pos2 = new ChunkPos(1,-2);
        Assert.assertEquals(pos1, pos2);
    }

    @Test
    public void testNotEqual() {
        ChunkPos pos1 = new ChunkPos(0,0);
        ChunkPos pos2 = new ChunkPos(1,0);
        Assert.assertNotEquals(pos1, pos2);
    }

    @Test
    public void testHashCode() {
        ChunkPos pos1 = new ChunkPos(3,-1);
        ChunkPos pos2 = new ChunkPos(3,-1);
        Assert.assertEquals(pos1.hashCode(), pos2.hashCode());
    }
}
