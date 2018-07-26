package ch.travbit.exploring.system;

import ch.travbit.exploring.component.PositionComponent;
import ch.travbit.exploring.component.VisualComponent;
import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public final class RenderSystem extends EntitySystem {

    private ImmutableArray<Entity> entities;

    private SpriteBatch batch;
    private OrthographicCamera camera;

    private ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
    private ComponentMapper<VisualComponent> vm = ComponentMapper.getFor(VisualComponent.class);

    public RenderSystem(OrthographicCamera camera, SpriteBatch batch) {
        this.camera = camera;
        this.batch = batch;
    }

    @Override
    public void addedToEngine (Engine engine) {
        entities = engine.getEntitiesFor(Family.all(PositionComponent.class, VisualComponent.class).get());
    }

    @Override
    public void update(float deltaTime) {

        camera.update();

        batch.begin();
        batch.setProjectionMatrix(camera.combined);
        entities.forEach(entity -> {
            PositionComponent position = pm.get(entity);
            VisualComponent visual = vm.get(entity);
            batch.setColor(visual.color);
            batch.draw(visual.textureRegion, position.vector.x, position.vector.y);
        });

        batch.end();
    }
}
