package ch.travbit.exploring.world.climate.temperate;

import ch.travbit.exploring.util.AssetLoader;
import ch.travbit.exploring.util.TileAsset;
import ch.travbit.exploring.world.climate.BaseClimateZone;
import ch.travbit.exploring.world.climate.LifeZone;
import ch.travbit.exploring.world.climate.water.WaterLifeZone;

public class TemperateClimateZone extends BaseClimateZone {

    public TemperateClimateZone(AssetLoader assetLoader) {
        super(new WaterLifeZone(assetLoader.getTile(TileAsset.TILE_WATER)));
        LifeZone grass = new GrassLifeZone(assetLoader.getTile(TileAsset.TILE_GRASS));

        grass.setHumidityBorders(-1f, 1f);

        addLifeZone(grass);
    }
}
