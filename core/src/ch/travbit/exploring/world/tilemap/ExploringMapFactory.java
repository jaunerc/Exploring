package ch.travbit.exploring.world.tilemap;

import ch.travbit.exploring.util.AssetLoader;
import ch.travbit.exploring.world.World;
import ch.travbit.exploring.world.climate.ClimateZone;
import ch.travbit.exploring.world.climate.LifeZone;
import ch.travbit.exploring.world.climate.TemperateClimateZone;
import com.badlogic.ashley.core.PooledEngine;

public class ExploringMapFactory implements MapFactory {

    private int chunkSize;
    private int pixelsPerMeter;

    private ClimateZone temperate;

    public ExploringMapFactory(AssetLoader assetLoader) {
        temperate = new TemperateClimateZone(assetLoader);
    }

    @Override
    public void init(World world) {
        chunkSize = world.getChunkSize();
        pixelsPerMeter = world.getPixelsPerMeter();
    }

    @Override
    public void createTiles(PooledEngine engine, float startCoordinateX, float startCoordinateY) {
        int coordX;
        int coordY;
        for (int i = 0; i < chunkSize; i++) {
            for (int j = 0; j < chunkSize; j++) {
                coordX = (int) (startCoordinateX + i * pixelsPerMeter);
                coordY = (int) (startCoordinateY + j * pixelsPerMeter);
                LifeZone lifeZone;
                if (j < 3) {
                    lifeZone = temperate.getLifeZoneByHumidity(-0.5f);
                } else {
                    lifeZone = temperate.getLifeZoneByHumidity(0.5f);
                }
                lifeZone.getGroundTileFactory()
                        .addTileToEngine(engine, coordX, coordY);
            }
        }
    }
}
