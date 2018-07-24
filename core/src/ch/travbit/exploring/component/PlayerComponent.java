package ch.travbit.exploring.component;

import com.badlogic.ashley.core.Component;

public class PlayerComponent implements Component {
    private String name;

    public PlayerComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
