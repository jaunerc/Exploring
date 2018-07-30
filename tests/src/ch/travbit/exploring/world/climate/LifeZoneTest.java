package ch.travbit.exploring.world.climate;

import ch.travbit.exploring.world.tilemap.tiles.TileFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for {@link ch.travbit.exploring.world.climate.ClimateZone}
 */
public class LifeZoneTest {

    private LifeZone lifeZone;
    @Before
    public void prepare() {
        lifeZone = new LifeZoneDummy();
        lifeZone.setHumidityBorders(0f, 0.5f);
    }

    @Test
    public void testHumidityIsInsideZone() {
        Assert.assertTrue(lifeZone.humidityIsInsideZone(0.4f));
    }

    @Test
    public void testHumidityIsNotInZone() {
        Assert.assertFalse(lifeZone.humidityIsInsideZone(0.6f));
    }

    private class LifeZoneDummy implements LifeZone {
        float minH, maxH;
        @Override
        public void setHumidityBorders(float minHumidity, float maxHumidity) {
            minH = minHumidity;
            maxH = maxHumidity;
        }

        @Override
        public boolean humidityIsInsideZone(float humidity) {
            return humidity >= minH && humidity <= maxH;
        }

        @Override
        public TileFactory getGroundTileFactory() {
            return null;
        }
    }
}
