/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.junit.Assert;
import org.junit.Test;

import org.mitre.caasd.jlcl.interfaces.ISaturator;
import org.mitre.caasd.jlcl.util.ClosedInterval;

/**
 * @author SBOWMAN
 * 
 */
public class TestSaturator {

    @Test
    public void testSaturatorDoubleNullErrorSignal() {
        Double minimumValue = -1d, maximumValue = 1d;
        ClosedInterval<Double> interval = new ClosedInterval<Double>(Double.class, minimumValue, maximumValue);
        ISaturator<Double> s = new Saturator<Double>(Double.class, interval);
        Double errorSignal = null; // this will cause a throw inside Saturator
        SimpleControlComponentArgs<Double> args = new SimpleControlComponentArgs<Double>();
        args.updateErrorSignalValue(errorSignal);
        try {
            s.evaluate(args); // this should throw because the args object contains a null
            Assert.assertTrue(false);
        } catch (UnsupportedOperationException e) {
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
        return;
    }

    @Test
    public void testSaturatorMaxDouble() {
        Double minimumValue = -1d, maximumValue = 1d;
        Double expectedValue = maximumValue;
        ClosedInterval<Double> interval = new ClosedInterval<Double>(Double.class, minimumValue, maximumValue);
        ISaturator<Double> s = new Saturator<Double>(Double.class, interval);
        Double errorSignal = maximumValue * 2;
        SimpleControlComponentArgs<Double> args = new SimpleControlComponentArgs<Double>();
        args.updateErrorSignalValue(errorSignal);
        Assert.assertEquals(expectedValue, s.evaluate(args));
    }

    @Test
    public void testSaturatorMinDouble() {
        Double minimumValue = -1d, maximumValue = 1d;
        Double expectedValue = minimumValue;
        ClosedInterval<Double> interval = new ClosedInterval<Double>(Double.class, minimumValue, maximumValue);
        ISaturator<Double> s = new Saturator<Double>(Double.class, interval);
        Double errorSignal = minimumValue * 2;
        SimpleControlComponentArgs<Double> args = new SimpleControlComponentArgs<Double>();
        args.updateErrorSignalValue(errorSignal);
        Assert.assertEquals(expectedValue, s.evaluate(args));
    }

    @Test
    public void testSaturatorDouble() {
        Double minimumValue = -1d, maximumValue = 1d;
        Double errorSignal = Math.random();
        Double expectedValue = errorSignal;
        ClosedInterval<Double> interval = new ClosedInterval<Double>(Double.class, minimumValue, maximumValue);
        ISaturator<Double> s = new Saturator<Double>(Double.class, interval);
        SimpleControlComponentArgs<Double> args = new SimpleControlComponentArgs<Double>();
        args.updateErrorSignalValue(errorSignal);
        Assert.assertEquals(expectedValue, s.evaluate(args));
    }

    @Test
    public void testSaturatorMaxLong() {
        Long minimumValue = -1l, maximumValue = 1l;
        Long expectedValue = maximumValue;
        ClosedInterval<Long> interval = new ClosedInterval<Long>(Long.class, minimumValue, maximumValue);
        ISaturator<Long> s = new Saturator<Long>(Long.class, interval);
        Long errorSignal = maximumValue * 2;
        SimpleControlComponentArgs<Long> args = new SimpleControlComponentArgs<Long>();
        args.updateErrorSignalValue(errorSignal);
        Assert.assertEquals(expectedValue, s.evaluate(args));
    }

    @Test
    public void testSaturatorMinLong() {
        Long minimumValue = -1l, maximumValue = 1l;
        Long expectedValue = minimumValue;
        ClosedInterval<Long> interval = new ClosedInterval<Long>(Long.class, minimumValue, maximumValue);
        ISaturator<Long> s = new Saturator<Long>(Long.class, interval);
        Long errorSignal = minimumValue * 2;
        SimpleControlComponentArgs<Long> args = new SimpleControlComponentArgs<Long>();
        args.updateErrorSignalValue(errorSignal);
        Assert.assertEquals(expectedValue, s.evaluate(args));
    }

    @Test
    public void testSaturatorLong() {
        Long minimumValue = -1l, maximumValue = 1l;
        Long errorSignal = (long) Math.random();
        Long expectedValue = errorSignal;
        ClosedInterval<Long> interval = new ClosedInterval<Long>(Long.class, minimumValue, maximumValue);
        ISaturator<Long> s = new Saturator<Long>(Long.class, interval);
        SimpleControlComponentArgs<Long> args = new SimpleControlComponentArgs<Long>();
        args.updateErrorSignalValue(errorSignal);
        Assert.assertEquals(expectedValue, s.evaluate(args));
    }

}
