/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author SBOWMAN
 * 
 */
public class TestFixedStepForwardDifferentiator {

    /*
     * The FixedsStepForwardDifferentiator will have no error when differentiating a linear function.
     * Use this to create expected responses and tests.
     */

    /**
     * 
     */
    public TestFixedStepForwardDifferentiator() {
        // Auto-generated constructor stub
    }

    @Test
    public void testDouble() {
        Double m = .5, b = 5d, stepSize = 1d;
        Double x0 = 1d, x1 = x0 + stepSize;
        Double y0 = m * x0 + b, y1 = m * x1 + b; // y = mx+b
        Double expectedSlope = m;
        FixedStepForwardDiffentiatorArguments<Double> args = new FixedStepForwardDiffentiatorArguments<Double>(Double.class, stepSize);
        args.updateNextFunctionValue(y1);
        FixedStepForwardDifferentiator<Double> differentiator = new FixedStepForwardDifferentiator<Double>(Double.class);
        Double calculatedSlope = differentiator.differentiate(args, y0);
        Assert.assertEquals(expectedSlope, calculatedSlope);
    }

    @Test
    public void testLong() {
        Long m = 1l, b = 5l, stepSize = 1l;
        Long x0 = 1l, x1 = x0 + stepSize;
        Long y0 = m * x0 + b, y1 = m * x1 + b; // y = mx+b
        Long expectedSlope = m;
        FixedStepForwardDiffentiatorArguments<Long> args = new FixedStepForwardDiffentiatorArguments<Long>(Long.class, stepSize);
        args.updateNextFunctionValue(y1);
        FixedStepForwardDifferentiator<Long> differentiator = new FixedStepForwardDifferentiator<Long>(Long.class);
        Long calculatedSlope = differentiator.differentiate(args, y0);
        Assert.assertEquals(expectedSlope, calculatedSlope);
    }
}
