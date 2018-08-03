package ch.travbit.exploring.world.climate;

/**
 * This class represents a basic life zone.
 */
public abstract class BaseLifeZone implements LifeZone {

    private float minHumidity, maxHumidity;
    private TileFactory tileFactory;

    public BaseLifeZone(TileFactory tileFactory) {
        this.tileFactory = tileFactory;
    }

    @Override
    public void setHumidityBorders(float minHumidity, float maxHumidity) {
        this.minHumidity = minHumidity;
        this.maxHumidity = maxHumidity;
    }

    @Override
    public boolean humidityIsInsideZone(float humidity) {
        return humidity >= minHumidity && humidity <= maxHumidity;
    }

    @Override
    public TileFactory getGroundTileFactory() {
        return tileFactory;
    }
}
