package ch.travbit.exploring.util.config;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link GameConfig}
 */
public class GameConfigTest {

    private GameConfig config;

    @Before
    public void before() {
        config = new GameConfig();
    }

    @Test
    public void testAddNewIntValue() {
        config.setIntValue(ConfigKey.CHUNK_SIZE, 42);
        try {
            Assert.assertEquals(42, config.getIntValue(ConfigKey.CHUNK_SIZE));
        } catch (IllegalArgumentException e) {
            Assert.fail();
        }
    }

    @Test
    public void testAddNewFloatValue() {
        config.setFloatValue(ConfigKey.PIXELS_PER_METER, 55.0f);
        try {
            Assert.assertEquals(55.0f, config.getFloatValue(ConfigKey.PIXELS_PER_METER), 0.01f);
        } catch (IllegalArgumentException e) {
            Assert.fail();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNonExistingIntValue() {
        config.getIntValue(ConfigKey.CHUNK_SIZE);
    }
}
