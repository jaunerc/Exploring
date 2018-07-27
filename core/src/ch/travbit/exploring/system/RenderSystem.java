package ch.travbit.exploring.system;

import ch.travbit.exploring.component.PositionComponent;
import ch.travbit.exploring.component.VisualComponent;
import com.badlogic.ashley.core.*;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import java.util.Comparator;

/**
 * This class represents a rendering system to draw textures.
 */
public final class RenderSystem extends IteratingSystem {

    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Comparator<Entity> zComparator;
    private Array<Entity> renderQueue;

    private ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
    private ComponentMapper<VisualComponent> vm = ComponentMapper.getFor(VisualComponent.class);

    public RenderSystem(OrthographicCamera camera, SpriteBatch batch) {
        super(Family.all(PositionComponent.class, VisualComponent.class).get());
        this.camera = camera;
        this.batch = batch;

        renderQueue = new Array<>();

        zComparator = (Entity e1, Entity e2) -> (int) Math.signum(vm.get(e2).renderLevel - vm.get(e1).renderLevel);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        renderQueue.add(entity);
    }



    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        camera.update();

        renderQueue.sort(zComparator);

        batch.begin();

        batch.setProjectionMatrix(camera.combined);
        renderQueue.forEach(entity -> {
            PositionComponent position = pm.get(entity);
            VisualComponent visual = vm.get(entity);
            batch.setColor(visual.color);
            batch.draw(visual.textureRegion, position.vector.x, position.vector.y);
        });

        batch.end();
    }
}
