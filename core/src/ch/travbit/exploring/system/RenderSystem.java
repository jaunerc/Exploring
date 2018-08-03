package ch.travbit.exploring.system;

import ch.travbit.exploring.component.PositionComponent;
import ch.travbit.exploring.component.VisualComponent;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Comparator;

/**
 * This class represents a rendering system to draw textures.
 */
public final class RenderSystem extends SortedIteratingSystem {

    private SpriteBatch batch;
    private OrthographicCamera camera;

    private ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
    private ComponentMapper<VisualComponent> vm = ComponentMapper.getFor(VisualComponent.class);

    public RenderSystem(OrthographicCamera camera, SpriteBatch batch) {
        super(Family.all(PositionComponent.class, VisualComponent.class).get(), new ZComparator());
        this.camera = camera;
        this.batch = batch;
    }

    @Override
    public void addedToEngine(Engine engine) {
        super.addedToEngine(engine);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        camera.update();

        batch.begin();
        batch.setProjectionMatrix(camera.combined);

        getEntities()
                .forEach(entity -> {
                    VisualComponent visual = vm.get(entity);
                    if (visual.visible) {
                        PositionComponent position = pm.get(entity);
                        batch.setColor(visual.color);
                        batch.draw(visual.textureRegion, position.vector.x, position.vector.y);
                    }
                });

        batch.end();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }

    private static class ZComparator implements Comparator<Entity> {
        ComponentMapper<VisualComponent> vm = ComponentMapper.getFor(VisualComponent.class);
        @Override
        public int compare(Entity e1, Entity e2) {
            return (int) Math.signum(vm.get(e2).renderLevel - vm.get(e1).renderLevel);
        }
    }
}
