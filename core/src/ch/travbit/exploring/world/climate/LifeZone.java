package ch.travbit.exploring.world.climate;

import ch.travbit.exploring.world.tilemap.tiles.TileFactory;

public interface LifeZone {

    void setHumidityBorders(float minHumidity, float maxHumidity);

    boolean humidityIsInsideZone(float humidity);

    TileFactory getGroundTileFactory();
}
