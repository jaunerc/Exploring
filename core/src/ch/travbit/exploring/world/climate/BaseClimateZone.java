package ch.travbit.exploring.world.climate;

import java.util.LinkedList;
import java.util.List;

public abstract class BaseClimateZone implements ClimateZone {

    private float minTemperature, maxTemperature;
    private List<LifeZone> lifeZones;
    private LifeZone waterLifeZone;

    public BaseClimateZone(LifeZone waterLifeZone) {
        lifeZones = new LinkedList<>();
        this.waterLifeZone = waterLifeZone;
    }

    public void addLifeZone(LifeZone lifeZone) {
        lifeZones.add(lifeZone);
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

    @Override
    public LifeZone getWaterLifeZone() {
        return waterLifeZone;
    }
}
