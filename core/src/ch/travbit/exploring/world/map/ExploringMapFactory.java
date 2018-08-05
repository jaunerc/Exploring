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

    private SimplexNoiseCalculator heightCalculator;
    private SimplexNoiseCalculator temperatureCalculator;
    private SimplexNoiseCalculator humidityCalculator;

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
        int octaves = 4;
        double roughness = 0.3;
        double scale = 0.001;
        heightCalculator = new SimplexNoiseCalculator(random.nextInt(), octaves, roughness, scale);
        temperatureCalculator = new SimplexNoiseCalculator(random.nextInt(), octaves, roughness, scale);
        humidityCalculator = new SimplexNoiseCalculator(random.nextInt(), octaves, roughness, scale);
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
        float height = heightCalculator.calcNoiseForPosition(x, y);
        float humidity = humidityCalculator.calcNoiseForPosition(x, y);
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
        float temperature = temperatureCalculator.calcNoiseForPosition(chunkPos.getX(), chunkPos.getY());
        Optional<ClimateZone> climateZoneOptional = climateZones.stream()
                .filter(climateZone -> climateZone.temperatureIsInsideZone(temperature)).findFirst();
        if (climateZoneOptional.isPresent()) {
            matchedClimateZone = climateZoneOptional.get();
        }
        return  matchedClimateZone;
    }
}
