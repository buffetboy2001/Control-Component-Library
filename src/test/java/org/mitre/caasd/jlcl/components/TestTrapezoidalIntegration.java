/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.junit.Assert;
import org.junit.Test;

import org.mitre.caasd.jlcl.interfaces.IIntegrate;

/**
 * @author SBOWMAN
 * 
 */
public class TestTrapezoidalIntegration {

    private static final Double slope = 2d, yIntercept = 3d;

    @Test
    public void testDouble() {
        /*
         * Trapezoidal integration will be have no error when the function
         * integrated is linear.
         */
        Double lowerLimit = 0d, upperLimit = 10d;
        Double stepSize = 1d;
        Double expected = yIntercept * (upperLimit - lowerLimit) + 0.5 * (upperLimit - lowerLimit) * (linearFunction(upperLimit) - yIntercept);
        Double actual = 0d;
        TrapezoidalIntegrationArguments<Double> args = new TrapezoidalIntegrationArguments<Double>(Double.class, stepSize);
        IIntegrate<Double, TrapezoidalIntegrationArguments<Double>> trap = new TrapezoidalIntegration<Double>(Double.class, args);
        args.updatePreviousFunctionValue(linearFunction(lowerLimit));
        for (int i = lowerLimit.intValue() + 1; i <= upperLimit.intValue(); i += stepSize) {
            Double fval = linearFunction((double) i);
            actual = trap.integrate(args, fval);
            args.updatePreviousFunctionValue(fval);
        }
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLong() {
        /*
         * Trapezoidal integration will be have no error when the function
         * integrated is linear.
         */
        Long lowerLimit = 0l, upperLimit = 10l;
        Long stepSize = 1l;
        Long expected = (long) (yIntercept.longValue() * (upperLimit - lowerLimit) + 0.5 * (upperLimit - lowerLimit) * (linearFunction(upperLimit) - yIntercept.longValue()));
        Long actual = 0l;
        TrapezoidalIntegrationArguments<Long> args = new TrapezoidalIntegrationArguments<Long>(Long.class, stepSize);
        IIntegrate<Long, TrapezoidalIntegrationArguments<Long>> trap = new TrapezoidalIntegration<Long>(Long.class, args);
        args.updatePreviousFunctionValue(linearFunction(lowerLimit));
        for (int i = lowerLimit.intValue() + 1; i <= upperLimit.intValue(); i += stepSize) {
            Long fval = linearFunction((long) i);
            actual = trap.integrate(args, fval);
            args.updatePreviousFunctionValue(fval);
        }
        Assert.assertEquals(expected, actual);
    }

    private Long linearFunction(Long x) {
        return slope.longValue() * x + yIntercept.longValue();
    }

    private Double linearFunction(Double x) {
        return slope * x + yIntercept;
    }
}
