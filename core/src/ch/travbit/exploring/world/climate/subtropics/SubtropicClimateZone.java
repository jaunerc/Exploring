package ch.travbit.exploring.world.climate.subtropics;

import ch.travbit.exploring.util.AssetLoader;
import ch.travbit.exploring.util.TileAsset;
import ch.travbit.exploring.world.climate.BaseClimateZone;
import ch.travbit.exploring.world.climate.LifeZone;
import ch.travbit.exploring.world.climate.water.WaterLifeZone;

public final class SubtropicClimateZone extends BaseClimateZone {

    public SubtropicClimateZone(AssetLoader assetLoader) {
        super(new WaterLifeZone(assetLoader.getTile(TileAsset.TILE_WATER)));

        setTemperatureBorders(0.0f, 1.0f);

        LifeZone desert = new DesertLifeZone(assetLoader.getTile(TileAsset.TILE_SAND));

        desert.setHumidityBorders(-1f, 1f);

        addLifeZone(desert);
    }
}
