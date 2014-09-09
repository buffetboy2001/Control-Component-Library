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
public class TestFixedStepBackwardDifferentiator {

    /*
     * The FixedsStepBackwardDifferentiator will have no error when
     * differentiating a linear function. Use this to create expected responses
     * and tests.
     */

    /**
     * 
     */
    public TestFixedStepBackwardDifferentiator() {
        // Auto-generated constructor stub
    }

    @Test
    public void testDouble() {
        Double m = .5, b = 5d, stepSize = 1d;
        Double x0 = 1d, x1 = x0 + stepSize;
        Double y0 = m * x0 + b, y1 = m * x1 + b; // y = mx+b
        Double expectedSlope = m;
        FixedStepBackwardDiffentiatorArguments<Double> args = new FixedStepBackwardDiffentiatorArguments<Double>(Double.class, stepSize);
        args.updatePreviousFunctionValue(y0);
        FixedStepBackwardDifferentiator<Double> differentiator = new FixedStepBackwardDifferentiator<Double>(Double.class);
        Double calculatedSlope = differentiator.differentiate(args, y1);
        Assert.assertEquals(expectedSlope, calculatedSlope);
    }

    @Test
    public void testLong() {
        Long m = 1l, b = 5l, stepSize = 1l;
        Long x0 = 1l, x1 = x0 + stepSize;
        Long y0 = m * x0 + b, y1 = m * x1 + b; // y = mx+b
        Long expectedSlope = m;
        FixedStepBackwardDiffentiatorArguments<Long> args = new FixedStepBackwardDiffentiatorArguments<Long>(Long.class, stepSize);
        args.updatePreviousFunctionValue(y0);
        FixedStepBackwardDifferentiator<Long> differentiator = new FixedStepBackwardDifferentiator<Long>(Long.class);
        Long calculatedSlope = differentiator.differentiate(args, y1);
        Assert.assertEquals(expectedSlope, calculatedSlope);
    }
}
