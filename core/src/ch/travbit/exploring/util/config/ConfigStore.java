package ch.travbit.exploring.util.config;

import java.util.Optional;

public interface ConfigStore<T> {

    /**
     * Sets the given value. This method replaces an existing value for the given key.
     * @param key the referenced key for the value
     * @param value the value to save
     */
    void setValue(ConfigKey key, T value);

    /**
     * Gets the referenced value for the given key.
     * @param key for the value
     * @return Optional value for the given key
     */
    Optional<T> getValue(ConfigKey key);
}
