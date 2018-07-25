package ch.travbit.exploring.util.noise;

public final class SimplexNoiseCalculator {

    private SimplexNoiseCalculator() {
    }

    public static double calcNoise(SimplexNoise sn, int x, int y, int octaves, double roughness, double scale) {
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
