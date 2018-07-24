package ch.travbit.exploring.util;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

/**
 * This class represents a loader for external resources. It is responsible for loading
 * all assets into memory.
 */
public class AssetLoader {

    private AssetManager assetManager;

    public AssetLoader() {
        assetManager = new AssetManager();
    }

    /**
     * Prepares the loading of all required tile resources.
     */
    public void prepareTileLoading() {
        for (TileAsset resource : TileAsset.values()) {
            assetManager.load(resource.getPath(), Texture.class);
        }
    }

    /**
     * Loads all prepared resources synchronously.
     */
    public void loadAllResourcesBlocking() {
        assetManager.finishLoading();
    }

    public Texture getTile(TileAsset tileAsset) {
        return assetManager.get(tileAsset.getPath(), Texture.class);
    }
}
