/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import junit.framework.Assert;

import org.junit.Test;

import org.mitre.caasd.jlcl.interfaces.IIntegrate;

/**
 * @author SBOWMAN
 * 
 */
public class TestFixedStepEulerIntegration {

    @Test
    public void testDouble() {
        /*
         * Fixed-Step Euler will have no error when used to integrate a
         * function that has no slope (y = mx + B, where m = 0). In this
         * case, the integration value on the interval [a,b] is trivial: B*(b-a).
         */
        Double B = 10d;
        Double a = 0d, b = 10d;
        Double expected = B * (b - a);
        Double actual = 0d;
        Double stepSize = 1d;
        FixedStepIntegrationArguments<Double> args = new FixedStepIntegrationArguments<Double>(Double.class, stepSize);
        IIntegrate<Double, FixedStepIntegrationArguments<Double>> euler = new FixedStepEulerIntegration<Double>(Double.class, args);
        for (int i = a.intValue(); i < b.intValue(); i += stepSize) {
            euler.integrate(args, B);
        }
        actual = euler.getTotalIntegrationValue();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLong() {
        /*
         * Fixed-Step Euler will have no error when used to integrate a
         * function that has no slope (y = mx + B, where m = 0). In this
         * case, the integration value on the interval [a,b] is trivial: B*(b-a).
         */
        Long B = 10l;
        Long a = 0l, b = 10l;
        Long expected = B * (b - a);
        Long actual = 0l;
        Long stepSize = 1l;
        FixedStepIntegrationArguments<Long> args = new FixedStepIntegrationArguments<Long>(Long.class, stepSize);
        IIntegrate<Long, FixedStepIntegrationArguments<Long>> euler = new FixedStepEulerIntegration<Long>(Long.class, args);
        for (int i = a.intValue(); i < b.intValue(); i += stepSize) {
            euler.integrate(args, B);
        }
        actual = euler.getTotalIntegrationValue();
        Assert.assertEquals(expected, actual);
    }

}
