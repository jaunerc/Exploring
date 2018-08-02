package ch.travbit.exploring.world.climate;

import ch.travbit.exploring.util.AssetLoader;
import ch.travbit.exploring.util.TileAsset;

import java.util.LinkedList;
import java.util.List;

public class TemperateClimateZone implements ClimateZone {

    private float minTemperature, maxTemperature;
    private List<LifeZone> lifeZones;

    public TemperateClimateZone(AssetLoader assetLoader) {
        lifeZones = new LinkedList<>();

        LifeZone water = new WaterLifeZone(assetLoader.getTile(TileAsset.TILE_WATER));
        LifeZone grass = new GrassLifeZone(assetLoader.getTile(TileAsset.TILE_GRASS));

        water.setHumidityBorders(-1f, 0f);
        grass.setHumidityBorders(0f, 1f);

        lifeZones.add(water);
        lifeZones.add(grass);
    }

    @Override
    public void setTemperatureBorders(float minTemperature, float maxTemperature) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    @Override
    public boolean temperatureIsInsideZone(float temperature) {
        return temperature >= minTemperature && temperature <= maxTemperature;
    }

    @Override
    public LifeZone getLifeZoneByHumidity(float humidity) {
        return lifeZones.stream().filter(lifeZone -> lifeZone.humidityIsInsideZone(humidity)).findFirst().get();
    }
}
