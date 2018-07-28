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
        float translation = deltaTime * 30; //ToDo velocity
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            nextPos.x += translation;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {
            nextPos.y -= translation;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            nextPos.x -= translation;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {
            nextPos.y += translation;
        }
        position.vector.add(nextPos);
        camera.position.add(nextPos.x, nextPos.y, 0);
    }
}
