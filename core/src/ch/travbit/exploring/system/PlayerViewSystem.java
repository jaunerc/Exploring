package ch.travbit.exploring.system;

import ch.travbit.exploring.component.PositionComponent;
import ch.travbit.exploring.component.TileComponent;
import ch.travbit.exploring.component.VisualComponent;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public final class PlayerViewSystem extends IteratingSystem {

    private OrthographicCamera camera;
    private ComponentMapper<PositionComponent> pm;
    private ComponentMapper<VisualComponent> vm;
    private float viewDistance;

    public PlayerViewSystem(OrthographicCamera camera, float viewDistance) {
        super(Family.all(TileComponent.class, PositionComponent.class, VisualComponent.class).get());
        this.camera = camera;
        this.viewDistance = viewDistance;

        pm = ComponentMapper.getFor(PositionComponent.class);
        vm = ComponentMapper.getFor(VisualComponent.class);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent pos = pm.get(entity);
        VisualComponent visual = vm.get(entity);
        float minPosX = camera.position.x - viewDistance;
        float minPosY = camera.position.y - viewDistance;
        float maxPosX = camera.position.x + viewDistance;
        float maxPosY = camera.position.y + viewDistance;
        if (pos.vector.x > maxPosX ||
        pos.vector.x < minPosX ||
        pos.vector.y > maxPosY ||
        pos.vector.y < minPosY) {
            visual.visible = false;
            //entity.remove(VisualComponent.class);
            //Gdx.app.debug("removed","entity removed");
        } else {
            visual.visible = true;
        }
    }
}
