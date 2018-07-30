package ch.travbit.exploring.world.climate;

public interface ClimateZone {

    void setTemperatureBorders(float minTemperature, float maxTemperature);

    boolean temperatureIsInsideZone(float temperature);

    LifeZone getLifeZoneByHumidity(float humidity);
}
