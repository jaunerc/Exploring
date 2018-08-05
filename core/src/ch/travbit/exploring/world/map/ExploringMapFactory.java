package ch.travbit.exploring.world.map;

import ch.travbit.exploring.util.AssetLoader;
import ch.travbit.exploring.util.noise.SimplexNoise;
import ch.travbit.exploring.util.noise.SimplexNoiseCalculator;
import ch.travbit.exploring.world.World;
import ch.travbit.exploring.world.climate.ClimateZone;
import ch.travbit.exploring.world.climate.LifeZone;
import ch.travbit.exploring.world.climate.temperate.TemperateClimateZone;
import ch.travbit.exploring.world.util.ChunkPos;
import com.badlogic.ashley.core.PooledEngine;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class ExploringMapFactory implements MapFactory {

    private final static float SEALEVEL = -0.6f;

    private int chunkSize;
    private int pixelsPerMeter;

    private SimplexNoise heightNoise;
    private SimplexNoise temperatureNoise;
    private SimplexNoise humidityNoise;

    private ClimateZone temperate;
    private List<ClimateZone> climateZones;

    public ExploringMapFactory(AssetLoader assetLoader) {
        temperate = new TemperateClimateZone(assetLoader);
        climateZones = new LinkedList<>();
    }

    @Override
    public void init(World world) {
        chunkSize = world.getChunkSize();
        pixelsPerMeter = world.getPixelsPerMeter();

        climateZones.add(temperate);

        Random random = new Random();
        heightNoise = new SimplexNoise(random.nextInt());
        temperatureNoise = new SimplexNoise(random.nextInt());
        humidityNoise = new SimplexNoise(random.nextInt());
    }

    @Override
    public void createTiles(PooledEngine engine, float startCoordinateX, float startCoordinateY, ChunkPos chunkPos) {
        int coordX;
        int coordY;
        ClimateZone climateZone = getClimateZoneByTemperature(chunkPos);
        for (int i = 0; i < chunkSize; i++) {
            for (int j = 0; j < chunkSize; j++) {
                coordX = (int) (startCoordinateX + i * pixelsPerMeter);
                coordY = (int) (startCoordinateY + j * pixelsPerMeter);
                LifeZone lifeZone = getLifeZone(climateZone, coordX, coordY);
                lifeZone.getGroundTileFactory().addTileToEngine(engine, coordX, coordY);
            }
        }
    }

    private LifeZone getLifeZone(ClimateZone climateZone, int x, int y) {
        float height = (float) SimplexNoiseCalculator.calcNoise(heightNoise, x, y, 4, 0.3, 0.001);
        float humidity = (float) SimplexNoiseCalculator.calcNoise(humidityNoise, x, y, 4, 0.3, 0.001);
        LifeZone lifeZone = climateZone.getWaterLifeZone();
        if (height > SEALEVEL) {
            Optional<LifeZone> lifeZoneOptional = climateZone.getLifeZoneByHumidity(humidity);
            if (lifeZoneOptional.isPresent()) {
                lifeZone = lifeZoneOptional.get();
            }
        }
        return lifeZone;
    }

    private ClimateZone getClimateZoneByTemperature(ChunkPos chunkPos) {
        ClimateZone matchedClimateZone = temperate;
        float temperature = (float) SimplexNoiseCalculator.calcNoise(
                temperatureNoise,
                chunkPos.getX(),
                chunkPos.getY(),
                4,
                0.3,
                0.001);
        Optional<ClimateZone> climateZoneOptional = climateZones.stream()
                .filter(climateZone -> climateZone.temperatureIsInsideZone(temperature)).findFirst();
        if (climateZoneOptional.isPresent()) {
            matchedClimateZone = climateZoneOptional.get();
        }
        return  matchedClimateZone;
    }
}
