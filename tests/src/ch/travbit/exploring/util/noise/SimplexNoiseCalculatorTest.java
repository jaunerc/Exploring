package ch.travbit.exploring.util.noise;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link ch.travbit.exploring.util.noise.SimplexNoiseCalculator}
 */
public class SimplexNoiseCalculatorTest {

    @Test
    public void testNoiseCalculation() {
        int x = 1;
        int y = 1;
        int seed = 1234;
        NoiseCalculator calculator = new SimplexNoiseCalculator(seed, 1, 1.0, 0.01);
        double noise = calculator.calcNoiseForPosition(x, y);
        Assert.assertEquals(0.087360, noise, 0.000001);
    }
}
