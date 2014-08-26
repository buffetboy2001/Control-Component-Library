/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.junit.Assert;
import org.junit.Test;

import org.mitre.caasd.jlcl.interfaces.IControlComponentsArguments;
import org.mitre.caasd.jlcl.interfaces.IDeadband;
import org.mitre.caasd.jlcl.util.ExteriorRegionInterval;

/**
 * @author SBOWMAN
 * 
 */
public class TestDeadband {

    // TODO re-examine all of these tests. Not sure they are correct for a Deadband!!

    @Test
    public void testDeadbandDoubleNullErrorSignal() {
        ExteriorRegionInterval<Double> interval = new ExteriorRegionInterval<Double>(Double.class, -1d, 1d);
        IDeadband<Double> ddbnd = new DeadbandFixedInterval<Double>(Double.class, interval);
        Double errorSignal = null; // this will cause a throw inside Deadband
        IControlComponentsArguments<Double> args = new SimpleControlComponentArgs<Double>();
        args.updateErrorSignalValue(errorSignal);
        try {
            ddbnd.evaluate(args); // this should throw because the args object contains a null
            Assert.assertTrue(false);
        } catch (UnsupportedOperationException e) {
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
        return;
    }

    @Test
    public void testDeadbandMaxDouble() {
        Double minimumValue = -1d, maximumValue = 1d;
        ExteriorRegionInterval<Double> interval = new ExteriorRegionInterval<Double>(Double.class, minimumValue, maximumValue);
        IDeadband<Double> ddbnd = new DeadbandFixedInterval<Double>(Double.class, interval);
        Double errorSignal = maximumValue * 2;
        SimpleControlComponentArgs<Double> args = new SimpleControlComponentArgs<Double>();
        args.updateErrorSignalValue(errorSignal);
        Double expectedValue = errorSignal;
        Assert.assertEquals(expectedValue, ddbnd.evaluate(args));
    }

    @Test
    public void testDeadbandMinDouble() {
        Double minimumValue = -1d, maximumValue = 1d;
        ExteriorRegionInterval<Double> interval = new ExteriorRegionInterval<Double>(Double.class, minimumValue, maximumValue);
        IDeadband<Double> ddbnd = new DeadbandFixedInterval<Double>(Double.class, interval);
        Double errorSignal = minimumValue * 2;
        SimpleControlComponentArgs<Double> args = new SimpleControlComponentArgs<Double>();
        args.updateErrorSignalValue(errorSignal);
        Double expectedValue = errorSignal;
        Assert.assertEquals(expectedValue, ddbnd.evaluate(args));
    }

    @Test
    public void testDeadbandDouble() {
        Double minimumValue = -1d, maximumValue = 1d;
        Double errorSignal = 0d;
        Double expectedValue = errorSignal;
        ExteriorRegionInterval<Double> interval = new ExteriorRegionInterval<Double>(Double.class, minimumValue, maximumValue);
        IDeadband<Double> ddbnd = new DeadbandFixedInterval<Double>(Double.class, interval);
        SimpleControlComponentArgs<Double> args = new SimpleControlComponentArgs<Double>();
        args.updateErrorSignalValue(errorSignal);
        Assert.assertEquals(expectedValue, ddbnd.evaluate(args));
    }

    @Test
    public void testDeadbandMaxLong() {
        Long minimumValue = -1l, maximumValue = 1l;
        ExteriorRegionInterval<Long> interval = new ExteriorRegionInterval<Long>(Long.class, minimumValue, maximumValue);
        IDeadband<Long> ddbnd = new DeadbandFixedInterval<Long>(Long.class, interval);
        Long errorSignal = maximumValue * 2;
        SimpleControlComponentArgs<Long> args = new SimpleControlComponentArgs<Long>();
        args.updateErrorSignalValue(errorSignal);
        Long expectedValue = errorSignal;
        Assert.assertEquals(expectedValue, ddbnd.evaluate(args));
    }

    @Test
    public void testDeadbandMinLong() {
        Long minimumValue = -1l, maximumValue = 1l;
        ExteriorRegionInterval<Long> interval = new ExteriorRegionInterval<Long>(Long.class, minimumValue, maximumValue);
        IDeadband<Long> ddbnd = new DeadbandFixedInterval<Long>(Long.class, interval);
        Long errorSignal = minimumValue * 2;
        SimpleControlComponentArgs<Long> args = new SimpleControlComponentArgs<Long>();
        args.updateErrorSignalValue(errorSignal);
        Long expectedValue = errorSignal;
        Assert.assertEquals(expectedValue, ddbnd.evaluate(args));
    }

    @Test
    public void testDeadbandLong() {
        Long minimumValue = -1l, maximumValue = 1l;
        Long errorSignal = 0l;
        Long expectedValue = errorSignal;
        ExteriorRegionInterval<Long> interval = new ExteriorRegionInterval<Long>(Long.class, minimumValue, maximumValue);
        IDeadband<Long> ddbnd = new DeadbandFixedInterval<Long>(Long.class, interval);
        SimpleControlComponentArgs<Long> args = new SimpleControlComponentArgs<Long>();
        args.updateErrorSignalValue(errorSignal);
        Assert.assertEquals(expectedValue, ddbnd.evaluate(args));
    }

}
