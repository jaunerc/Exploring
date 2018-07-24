package ch.travbit.exploring.system;

import ch.travbit.exploring.component.PlayerComponent;
import ch.travbit.exploring.component.PositionComponent;
import ch.travbit.exploring.tilemap.MapFactory;
import ch.travbit.exploring.tilemap.TileMapFacade;
import ch.travbit.exploring.util.AssetLoader;
import com.badlogic.ashley.core.*;
import com.badlogic.ashley.systems.IteratingSystem;

public class MapSystem extends IteratingSystem {

    private ComponentMapper<PositionComponent> pm;
    private MapFactory mapFactory;

    public MapSystem(AssetLoader assetLoader) {
        super(Family.all(PlayerComponent.class, PositionComponent.class).get());

        pm = ComponentMapper.getFor(PositionComponent.class);
        mapFactory = TileMapFacade.createSimpleMapFactory(assetLoader);
    }

    @Override
    public void addedToEngine(Engine engine) {
        super.addedToEngine(engine);
        generateStartMap((PooledEngine) engine);
    }

    private void generateStartMap(PooledEngine engine) {
        mapFactory.generateMap(engine, 10, 10);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = pm.get(entity);
        if (position.getVector().x > 50) {
            PooledEngine engine = (PooledEngine) getEngine();
            mapFactory.generateMap(engine, 20, 10);
        }
    }
}
