package ch.travbit.exploring.world.climate;

/**
 * This interface represents a climate life zone. A life zone is an area
 * with specific plant and animal communities.
 */
public interface LifeZone {

    /**
     * Sets the range of humidity for this zone.
     * @param minHumidity the minimal value of humidity
     * @param maxHumidity the maximum value of humidity
     */
    void setHumidityBorders(float minHumidity, float maxHumidity);

    /**
     * Whether the given value fits into this humidity range.
     * @param humidity value to check
     * @return
     */
    boolean humidityIsInsideZone(float humidity);

    /**
     * Gets the tile factory of this life zone. That factory produces tile
     * entities for the land of the world.
     * @return
     */
    TileFactory getGroundTileFactory();
}
