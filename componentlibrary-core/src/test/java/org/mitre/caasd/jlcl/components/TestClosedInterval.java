package org.mitre.caasd.jlcl.components;

import junit.framework.Assert;

import org.junit.Test;

import org.mitre.caasd.jlcl.util.ClosedInterval;

public class TestClosedInterval {

    public TestClosedInterval() {
        // Auto-generated constructor stub
    }

    @Test
    public void testUpperGetterOfClosedIntervalDouble() {
        double min = -1d, max = 1d;
        ClosedInterval<Double> interval = new ClosedInterval<Double>(Double.class, min, max);
        double expected = max;
        Assert.assertEquals(expected, interval.getUpperValue());
    }

    @Test
    public void testLowerGetterOfClosedIntervalDouble() {
        double min = -1d, max = 1d;
        ClosedInterval<Double> interval = new ClosedInterval<Double>(Double.class, min, max);
        double expected = min;
        Assert.assertEquals(expected, interval.getLowerValue());
    }

    @Test
    public void testUpperGetterOfClosedIntervalReversedInputsDouble() {
        double min = -1d, max = 1d;
        ClosedInterval<Double> interval = new ClosedInterval<Double>(Double.class, max, min);
        double expected = max;
        Assert.assertEquals(expected, interval.getUpperValue());
    }

    @Test
    public void testLowerGetterOfClosedIntervalReversedInputsDouble() {
        double min = -1d, max = 1d;
        ClosedInterval<Double> interval = new ClosedInterval<Double>(Double.class, max, min);
        double expected = min;
        Assert.assertEquals(expected, interval.getLowerValue());
    }

    @Test
    public void testMiddleOfClosedIntervalDouble() {
        double min = -1d, max = 1d;
        ClosedInterval<Double> interval = new ClosedInterval<Double>(Double.class, min, max);
        double testValue = (max - min) / 2;
        boolean expected = true;
        Assert.assertEquals(expected, interval.isOnTheInterval(testValue));
    }

    @Test
    public void testLowerEndOfClosedIntervalDouble() {
        double min = -1d, max = 1d;
        ClosedInterval<Double> interval = new ClosedInterval<Double>(Double.class, min, max);
        double testValue = min;
        boolean expected = true;
        Assert.assertEquals(expected, interval.isOnTheInterval(testValue));
    }

    @Test
    public void testUpperEndOfClosedIntervalDouble() {
        double min = -1d, max = 1d;
        ClosedInterval<Double> interval = new ClosedInterval<Double>(Double.class, min, max);
        double testValue = max;
        boolean expected = true;
        Assert.assertEquals(expected, interval.isOnTheInterval(testValue));
    }

    @Test
    public void testBelowLowerEndOfClosedIntervalDouble() {
        double min = -1d, max = 1d;
        ClosedInterval<Double> interval = new ClosedInterval<Double>(Double.class, min, max);
        double testValue = min - 1;
        boolean expected = false;
        Assert.assertEquals(expected, interval.isOnTheInterval(testValue));
    }

    @Test
    public void testAboveUpperEndOfClosedIntervalDouble() {
        double min = -1d, max = 1d;
        ClosedInterval<Double> interval = new ClosedInterval<Double>(Double.class, min, max);
        double testValue = max + 1;
        boolean expected = false;
        Assert.assertEquals(expected, interval.isOnTheInterval(testValue));
    }

}
