package ch.travbit.exploring.system;

import ch.travbit.exploring.component.PlayerComponent;
import ch.travbit.exploring.component.PositionComponent;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public class PlayerSystem extends IteratingSystem {

    private ComponentMapper<PositionComponent> pm;

    private OrthographicCamera camera;

    public PlayerSystem(OrthographicCamera camera) {
        super(Family.all(PlayerComponent.class, PositionComponent.class).get());

        this.camera = camera;
        pm = ComponentMapper.getFor(PositionComponent.class);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = pm.get(entity);
        Vector2 nextPos = new Vector2();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            nextPos.x += deltaTime * 25;
        }
        position.vector.x += nextPos.x;
        camera.position.x += nextPos.x;
    }
}
