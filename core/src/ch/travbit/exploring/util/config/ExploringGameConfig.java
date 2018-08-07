package ch.travbit.exploring.util.config;

import java.util.Optional;

/**
 * This class represents the game config.
 */
public class ExploringGameConfig {

    private ConfigStore<Integer> integers;
    private ConfigStore<Float> floats;

    public ExploringGameConfig() {
        integers = new BasicConfigStore<>();
        floats = new BasicConfigStore<>();
    }

    public void setIntValue(ConfigKey key, int value) {
        integers.setValue(key, value);
    }

    public int getIntValue(ConfigKey key) throws IllegalArgumentException {
        Optional<Integer> optionalInteger = integers.getValue(key);
        if (! optionalInteger.isPresent()) {
            errorHandlingForNonPresentValues(key);
        }
        return optionalInteger.get();
    }

    public void setFloatValue(ConfigKey key, float value) {
        floats.setValue(key, value);
    }

    public float getFloatValue(ConfigKey key) throws IllegalArgumentException {
        Optional<Float> optionalFloat = floats.getValue(key);
        if (! optionalFloat.isPresent()) {
            errorHandlingForNonPresentValues(key);
        }
        return optionalFloat.get();
    }

    private void errorHandlingForNonPresentValues(ConfigKey key) {
        throw new IllegalArgumentException("The requested value for " + key + " is not present");
    }
}
