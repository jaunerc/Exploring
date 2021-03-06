package ch.travbit.exploring.world.climate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

/**
 * Test for {@link ch.travbit.exploring.world.climate.ClimateZone}
 */
public class ClimateZoneTest {

    private ClimateZone climateZone;

    @Before
    public void prepare() {
        climateZone = new ClimateZoneDummy();
        climateZone.setTemperatureBorders(0f, 0.3f);
    }

    @Test
    public void testIsInsideTemperatureBorders() {
        Assert.assertTrue(climateZone.temperatureIsInsideZone(0.2f));
    }

    @Test
    public void testIsNotInsideTemperatureBorders() {
        Assert.assertFalse(climateZone.temperatureIsInsideZone(1f));
    }

    @Test
    public void testGetLifeZone() {
        Assert.assertNotNull(climateZone.getLifeZoneByHumidity(0.1f));
    }

    @Test
    public void testFalseLifeZone() {
        Assert.assertFalse(climateZone.getLifeZoneByHumidity(-1f).isPresent());
    }

    private class ClimateZoneDummy implements ClimateZone {

        float minT, maxT;
        LifeZone lifeZone;

        ClimateZoneDummy() {
            lifeZone = new LifeZoneDummy();
            lifeZone.setHumidityBorders(0f, 0.2f);
        }

        @Override
        public void setTemperatureBorders(float minTemperature, float maxTemperature) {
            minT = minTemperature;
            maxT = maxTemperature;
        }

        @Override
        public boolean temperatureIsInsideZone(float temperature) {
            return temperature >= minT && temperature <= maxT;
        }

        @Override
        public Optional<LifeZone> getLifeZoneByHumidity(float humidity) {
            return lifeZone.humidityIsInsideZone(humidity) ? Optional.of(lifeZone) : Optional.empty();
        }

        @Override
        public LifeZone getWaterLifeZone() {
            return null;
        }
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
