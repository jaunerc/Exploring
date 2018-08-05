package ch.travbit.exploring.util.noise;

public interface NoiseCalculator {


    float calcNoiseForPosition(int x, int y);

    /**
     * Calculates the noise value of the given coordinates.
     * @param sn SimplexNoise instance.
     * @param x Coordinate.
     * @param y Coordinate.
     * @param octaves The number of iterations.
     * @param roughness Factor to handle the flatness.
     * @param scale Factor to decrease the frequency. This value should be small (e.g. 0.01).
     * @return Noise value.
     */
    static double calcNoise(SimplexNoise sn, int x, int y, int octaves, double roughness, double scale) {
        double noise = 0.0;
        double layerFrequency = scale;
        double layerWeight = 1f;

        for (int i = 0; i < octaves; i++) {
            noise += sn.noise(x * layerFrequency, y * layerFrequency) * layerWeight;
            layerFrequency *= 2;
            layerWeight *= roughness;
        }

        return noise;
    }
}
