package ch.travbit.exploring.util.rendering;

/**
 * This enum represents the rendering layer. The layer affects the rendering order.
 * The layer with the highest index is drawn first.
 */
public enum RenderLayer {
    PLAYER(0), TILE(1);

    int index;

    RenderLayer(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
