package ch.travbit.exploring.util.noise;

/**
 * This class
 */
public final class SimplexNoiseCalculator implements NoiseCalculator{

    private SimplexNoise sn;
    private int seed;
    private int octaves;
    private double roughness;
    private double scale;

    public SimplexNoiseCalculator(int seed, int octaves, double roughness, double scale) {
        this.seed = seed;
        this.octaves = octaves;
        this.roughness = roughness;
        this.scale = scale;
        sn = new SimplexNoise(seed);
    }

    @Override
    public float calcNoiseForPosition(int x, int y) {
        return (float) NoiseCalculator.calcNoise(
                sn,
                x, y,
                octaves,
                roughness,
                scale);
    }

    public int getSeed() {
        return seed;
    }
}
