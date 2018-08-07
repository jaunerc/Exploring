package ch.travbit.exploring.util.config;

import java.util.HashMap;
import java.util.Optional;

public class BasicConfigStore<T> implements ConfigStore<T> {

    private HashMap<ConfigKey, T> configStore;

    public BasicConfigStore() {
        configStore = new HashMap<>();
    }

    @Override
    public void setValue(ConfigKey key, T value) {
        if (configStore.containsKey(key)) {
            configStore.replace(key, value);
        } else {
            configStore.put(key, value);
        }
    }

    @Override
    public Optional<T> getValue(ConfigKey key) {
        return Optional.ofNullable(configStore.get(key));
    }
}
