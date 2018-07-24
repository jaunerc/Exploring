package ch.travbit.exploring.system;

import ch.travbit.exploring.component.PlayerComponent;
import ch.travbit.exploring.component.PositionComponent;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class PlayerSystem extends IteratingSystem {

    private ComponentMapper<PositionComponent> pm;

    public PlayerSystem() {
        super(Family.all(PlayerComponent.class, PositionComponent.class).get());

        pm = ComponentMapper.getFor(PositionComponent.class);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = pm.get(entity);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            position.getVector().x += deltaTime * 10;
        }
    }
}
