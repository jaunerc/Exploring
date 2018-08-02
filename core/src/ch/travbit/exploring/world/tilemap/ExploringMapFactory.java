package ch.travbit.exploring.world.tilemap;

import ch.travbit.exploring.util.AssetLoader;
import ch.travbit.exploring.util.noise.SimplexNoise;
import ch.travbit.exploring.util.noise.SimplexNoiseCalculator;
import ch.travbit.exploring.world.World;
import ch.travbit.exploring.world.climate.ClimateZone;
import ch.travbit.exploring.world.climate.LifeZone;
import ch.travbit.exploring.world.climate.TemperateClimateZone;
import com.badlogic.ashley.core.PooledEngine;

import java.util.Random;

public class ExploringMapFactory implements MapFactory {

    private final static float SEALEVEL = 0.4f;

    private int chunkSize;
    private int pixelsPerMeter;

    private SimplexNoise heightNoise;

    private ClimateZone temperate;

    public ExploringMapFactory(AssetLoader assetLoader) {
        temperate = new TemperateClimateZone(assetLoader);
    }

    @Override
    public void init(World world) {
        chunkSize = world.getChunkSize();
        pixelsPerMeter = world.getPixelsPerMeter();

        Random random = new Random();
        heightNoise = new SimplexNoise(random.nextInt());
    }

    @Override
    public void createTiles(PooledEngine engine, float startCoordinateX, float startCoordinateY) {
        int coordX;
        int coordY;
        for (int i = 0; i < chunkSize; i++) {
            for (int j = 0; j < chunkSize; j++) {
                coordX = (int) (startCoordinateX + i * pixelsPerMeter);
                coordY = (int) (startCoordinateY + j * pixelsPerMeter);
                LifeZone lifeZone = getLifeZone(coordX, coordY);
                lifeZone.getGroundTileFactory().addTileToEngine(engine, coordX, coordY);
            }
        }
    }

    private LifeZone getLifeZone(int x, int y) {
        float height = (float) SimplexNoiseCalculator.calcNoise(heightNoise, x, y, 1, 0.2, 0.01);
        if (height <= SEALEVEL) {
            return temperate.getWaterLifeZone();
        }
        return temperate.getLifeZoneByHumidity(height);
    }
}
