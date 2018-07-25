package ch.travbit.exploring.util.noise;

import org.junit.Assert;
import org.junit.Test;

public class SimplexNoiseCalculatorTest {

    @Test
    public void testNoiseCalculation() {
        int x = 1;
        int y = 1;
        SimplexNoise sn = new SimplexNoise(1234);
        double noise = SimplexNoiseCalculator.calcNoise(sn, x, y, 1, 1.0, 0.01);
        Assert.assertEquals(0.087360, noise, 0.0000001);
    }
}
