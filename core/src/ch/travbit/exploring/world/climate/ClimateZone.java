package ch.travbit.exploring.world.climate;

import java.util.Optional;

/**
 * This interface represents a climate zone. A climate zone holds
 * different life zones.
 */
public interface ClimateZone {

    /**
     * Sets the range of temperature for this climate zone.
     * @param minTemperature the minimal value of temperature
     * @param maxTemperature the maximal value of temperature
     */
    void setTemperatureBorders(float minTemperature, float maxTemperature);

    /**
     * Whether the given value fits into this temperature range.
     * @param temperature value to check
     * @return
     */
    boolean temperatureIsInsideZone(float temperature);

    /**
     * Gets the first matching life zone.
     * @param humidity value that must be in range of the life zone
     * @return
     */
    Optional<LifeZone> getLifeZoneByHumidity(float humidity);

    /**
     * Gets the climate specific water life zone.
     * @return
     */
    LifeZone getWaterLifeZone();
}
