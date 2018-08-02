package ch.travbit.exploring.world.climate;

import ch.travbit.exploring.util.AssetLoader;
import ch.travbit.exploring.util.TileAsset;

public class TemperateClimateZone extends BaseClimateZone {

    public TemperateClimateZone(AssetLoader assetLoader) {
        super(new WaterLifeZone(assetLoader.getTile(TileAsset.TILE_WATER)));
        LifeZone grass = new GrassLifeZone(assetLoader.getTile(TileAsset.TILE_GRASS));

        grass.setHumidityBorders(-1f, 1f);

        addLifeZone(grass);
    }
}
