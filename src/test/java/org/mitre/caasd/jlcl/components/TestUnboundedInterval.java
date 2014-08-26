/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import junit.framework.Assert;

import org.junit.Test;

import org.mitre.caasd.jlcl.util.UnboundedInterval;

/**
 * @author SBOWMAN
 * 
 */
public class TestUnboundedInterval {

    /**
     * 
     */
    public TestUnboundedInterval() {
        // Auto-generated constructor stub
    }

    @Test
    public void testMiddleOfInteriorRegionDouble() {
        double min = -1d, max = 1d;
        double testValue = 0d;
        boolean expected = true;
        UnboundedInterval<Double> interval = new UnboundedInterval<Double>(Double.class, min, max);
        Assert.assertEquals(expected, interval.isOnTheInterval(testValue));
    }

    @Test
    public void testBelowInteriorRegionDouble() {
        double min = -1d, max = 1d;
        double testValue = min - 1d;
        boolean expected = true;
        UnboundedInterval<Double> interval = new UnboundedInterval<Double>(Double.class, min, max);
        Assert.assertEquals(expected, interval.isOnTheInterval(testValue));
    }

    @Test
    public void testAboveInteriorRegionDouble() {
        double min = -1d, max = 1d;
        double testValue = max + 1d;
        boolean expected = true;
        UnboundedInterval<Double> interval = new UnboundedInterval<Double>(Double.class, min, max);
        Assert.assertEquals(expected, interval.isOnTheInterval(testValue));
    }

    @Test
    public void testOnUpperBoundaryDouble() {
        double min = -1d, max = 1d;
        double testValue = max;
        boolean expected = true;
        UnboundedInterval<Double> interval = new UnboundedInterval<Double>(Double.class, min, max);
        Assert.assertEquals(expected, interval.isOnTheInterval(testValue));
    }

    @Test
    public void testOnLowerBoundaryDouble() {
        double min = -1d, max = 1d;
        double testValue = min;
        boolean expected = true;
        UnboundedInterval<Double> interval = new UnboundedInterval<Double>(Double.class, min, max);
        Assert.assertEquals(expected, interval.isOnTheInterval(testValue));
    }
}
