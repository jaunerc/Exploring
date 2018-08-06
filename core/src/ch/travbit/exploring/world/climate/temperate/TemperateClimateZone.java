package ch.travbit.exploring.world.climate.temperate;

import ch.travbit.exploring.util.AssetLoader;
import ch.travbit.exploring.util.TileAsset;
import ch.travbit.exploring.world.climate.BaseClimateZone;
import ch.travbit.exploring.world.climate.LifeZone;
import ch.travbit.exploring.world.climate.water.WaterLifeZone;

public final class TemperateClimateZone extends BaseClimateZone {

    public TemperateClimateZone(AssetLoader assetLoader) {
        super(new WaterLifeZone(assetLoader.getTile(TileAsset.TILE_WATER)));

        setTemperatureBorders(-1.0f, 0.0f);

        LifeZone grass = new GrassLifeZone(assetLoader.getTile(TileAsset.TILE_GRASS));
        LifeZone forest = new ForestLifeZone(assetLoader.getTile(TileAsset.TILE_FOREST));

        grass.setHumidityBorders(-1f, 0.4f);
        forest.setHumidityBorders(0.4f, 1f);

        addLifeZone(grass);
        addLifeZone(forest);
    }
}
