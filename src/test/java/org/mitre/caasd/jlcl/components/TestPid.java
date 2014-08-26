/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.junit.Assert;
import org.junit.Test;

import org.mitre.caasd.jlcl.factories.ControlComponentFactory;
import org.mitre.caasd.jlcl.interfaces.IIntegrate;
import org.mitre.caasd.jlcl.interfaces.IPID;

/**
 * @author SBOWMAN
 * 
 */
public class TestPid {

    @Test
    public void testProportionalOnlyComponentViaFactoryTypedAsDouble() {
        final Double kp = 0.5;
        final Double errorSignalValue = 10d;
        Double expected = kp * errorSignalValue;
        IPID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>> testPid = ControlComponentFactory.createProportionalOnlyPidComponentAsDouble(kp);
        ProportionalOnlyArguments<Double> propArgs = new ProportionalOnlyArguments<Double>(Double.class);
        propArgs.updateErrorSignalValue(errorSignalValue);
        Double actual = testPid.evaluate(propArgs);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testProportionalOnlyComponentViaFactoryTypedAsLong() {
        final Long kp = 5l;
        final Long errorSignalValue = 10l;
        Long expected = kp * errorSignalValue;
        IPID<Long, NoIntegration<Long>, NoIntegrationArguments<Long>, NoDifferentiation<Long>, NoDifferentiationArguments<Long>> testPid = ControlComponentFactory.createProportionalOnlyPidComponentAsLong(kp);
        ProportionalOnlyArguments<Long> propArgs = new ProportionalOnlyArguments<Long>(Long.class);
        propArgs.updateErrorSignalValue(errorSignalValue);
        Long actual = testPid.evaluate(propArgs);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testProportionalOnlyComponentViaFactoryTypedAsInteger() {
        final Integer kp = 5;
        final Integer errorSignalValue = 10;
        Integer expected = kp * errorSignalValue;
        IPID<Integer, NoIntegration<Integer>, NoIntegrationArguments<Integer>, NoDifferentiation<Integer>, NoDifferentiationArguments<Integer>> testPid = ControlComponentFactory.createProportionalOnlyPidComponentAsInteger(kp);
        ProportionalOnlyArguments<Integer> propArgs = new ProportionalOnlyArguments<Integer>(Integer.class);
        propArgs.updateErrorSignalValue(errorSignalValue);
        Integer actual = testPid.evaluate(propArgs);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testProportionalOnlyComponentViaFactoryTypedAsFloat() {
        final Float kp = 5f;
        final Float errorSignalValue = 10f;
        Float expected = kp * errorSignalValue;
        IPID<Float, NoIntegration<Float>, NoIntegrationArguments<Float>, NoDifferentiation<Float>, NoDifferentiationArguments<Float>> testPid = ControlComponentFactory.createProportionalOnlyPidComponentAsFloat(kp);
        ProportionalOnlyArguments<Float> propArgs = new ProportionalOnlyArguments<Float>(Float.class);
        propArgs.updateErrorSignalValue(errorSignalValue);
        Float actual = testPid.evaluate(propArgs);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testProportionalOnlyComponentViaFactoryTypedAsShort() {
        final Short kp = 5;
        final Short errorSignalValue = 10;
        Short expected = (short) (kp * errorSignalValue);
        IPID<Short, NoIntegration<Short>, NoIntegrationArguments<Short>, NoDifferentiation<Short>, NoDifferentiationArguments<Short>> testPid = ControlComponentFactory.createProportionalOnlyPidComponentAsShort(kp);
        ProportionalOnlyArguments<Short> propArgs = new ProportionalOnlyArguments<Short>(Short.class);
        propArgs.updateErrorSignalValue(errorSignalValue);
        Short actual = testPid.evaluate(propArgs);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetGainKp() {
        final Double kp = 5.0;
        IPID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>> testPid = ControlComponentFactory.createProportionalOnlyPidComponentAsDouble(kp);
        Assert.assertEquals(kp, testPid.getProportionalGain(), 0);
    }

    @Test
    public void testGetGainKi() {
        final Double ki = 5.0;
        IPID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>> testPid = new PID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>>(Double.class, 0d, new NoIntegration<Double>(Double.class), ki, new NoDifferentiation<Double>(Double.class), 0d);
        Assert.assertEquals(ki, testPid.getIntegralGain(), 0);
    }

    @Test
    public void testGetGainKd() {
        final Double kd = 5.0;
        IPID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>> testPid = new PID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>>(Double.class, 0d, new NoIntegration<Double>(Double.class), 0d, new NoDifferentiation<Double>(Double.class), kd);
        Assert.assertEquals(kd, testPid.getDerivativeGain(), 0);
    }

    @Test
    public void testUpdateGainKp() {
        final Double kp = 5.0, newkp = 2.0;
        IPID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>> testPid = ControlComponentFactory.createProportionalOnlyPidComponentAsDouble(kp);
        testPid.updateProportionalGain(newkp);
        Assert.assertEquals(newkp, testPid.getProportionalGain(), 0);
    }

    @Test
    public void testUpdateGainKi() {
        final Double ki = 5.0, newki = 2.0;
        IPID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>> testPid = new PID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>>(Double.class, 0d, new NoIntegration<Double>(Double.class), ki, new NoDifferentiation<Double>(Double.class), 0d);
        testPid.updateIntegralGain(newki);
        Assert.assertEquals(newki, testPid.getIntegralGain(), 0);
    }

    @Test
    public void testUpdateGainKd() {
        final Double kd = 5.0, newkd = 2.0;
        IPID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>> testPid = new PID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>>(Double.class, 0d, new NoIntegration<Double>(Double.class), 0d, new NoDifferentiation<Double>(Double.class), kd);
        testPid.updateDerivativeGain(newkd);
        Assert.assertEquals(newkd, testPid.getDerivativeGain(), 0);
    }

    @Test
    public void testDoubleIntegratorGetterSame() {
        final Double kd = 5.0;
        NoIntegration<Double> expectedIntegrator = new NoIntegration<Double>(Double.class);
        IPID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>> testPid = new PID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>>(Double.class, 0d, expectedIntegrator, 0d, new NoDifferentiation<Double>(Double.class), kd);
        Assert.assertSame(expectedIntegrator, testPid.getItegratorComponent());
    }

    @Test
    public void testDoubleIntegratorGetterNotSame() {
        final Double kd = 5.0;
        NoIntegration<Double> expectedIntegrator = new NoIntegration<Double>(Double.class);
        IPID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>> testPid = new PID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>>(Double.class, 0d, expectedIntegrator, 0d, new NoDifferentiation<Double>(Double.class), kd);
        IIntegrate<Long, NoIntegrationArguments<Long>> newIntegrator = new NoIntegration<Long>(Long.class);
        Assert.assertNotSame(newIntegrator, testPid.getItegratorComponent());
    }

    @Test
    public void testLongIntegratorGetterSame() {
        final Long kd = 5l;
        NoIntegration<Long> expectedIntegrator = new NoIntegration<Long>(Long.class);
        IPID<Long, NoIntegration<Long>, NoIntegrationArguments<Long>, NoDifferentiation<Long>, NoDifferentiationArguments<Long>> testPid = new PID<Long, NoIntegration<Long>, NoIntegrationArguments<Long>, NoDifferentiation<Long>, NoDifferentiationArguments<Long>>(Long.class, 0l, expectedIntegrator, 0l, new NoDifferentiation<Long>(Long.class), kd);
        Assert.assertSame(expectedIntegrator, testPid.getItegratorComponent());
    }

    @Test
    public void testLongIntegratorGetterNotSame() {
        final Long kd = 5l;
        NoIntegration<Long> expectedIntegrator = new NoIntegration<Long>(Long.class);
        IPID<Long, NoIntegration<Long>, NoIntegrationArguments<Long>, NoDifferentiation<Long>, NoDifferentiationArguments<Long>> testPid = new PID<Long, NoIntegration<Long>, NoIntegrationArguments<Long>, NoDifferentiation<Long>, NoDifferentiationArguments<Long>>(Long.class, 0l, expectedIntegrator, 0l, new NoDifferentiation<Long>(Long.class), kd);
        IIntegrate<Double, NoIntegrationArguments<Double>> newIntegrator = new NoIntegration<Double>(Double.class);
        Assert.assertNotSame(newIntegrator, testPid.getItegratorComponent());
    }

    @Test
    public void testDoubleDerivatorGetterSame() {
        final Double k = 5.0;
        NoIntegration<Double> integrator = new NoIntegration<Double>(Double.class);
        NoDifferentiation<Double> expectedDerivator = new NoDifferentiation<Double>(Double.class);
        IPID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>> testPid = new PID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>>(Double.class, 0d, integrator, 0d, expectedDerivator, k);
        Assert.assertSame(expectedDerivator, testPid.getDerivativeComponent());
    }

    @Test
    public void testDoubleDerivatorGetterNotSame() {
        final Double k = 5.0;
        NoIntegration<Double> integrator = new NoIntegration<Double>(Double.class);
        NoDifferentiation<Double> expectedDerivator = new NoDifferentiation<Double>(Double.class);
        IPID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>> testPid = new PID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>>(Double.class, k, integrator, k, expectedDerivator, k);
        NoDifferentiation<Long> wrongDerivator = new NoDifferentiation<Long>(Long.class);
        Assert.assertNotSame(wrongDerivator, testPid.getDerivativeComponent());
    }

    @Test
    public void testLongDerivatorGetterSame() {
        final Long k = 5l;
        NoIntegration<Long> integrator = new NoIntegration<Long>(Long.class);
        NoDifferentiation<Long> expectedDerivator = new NoDifferentiation<Long>(Long.class);
        IPID<Long, NoIntegration<Long>, NoIntegrationArguments<Long>, NoDifferentiation<Long>, NoDifferentiationArguments<Long>> testPid = new PID<Long, NoIntegration<Long>, NoIntegrationArguments<Long>, NoDifferentiation<Long>, NoDifferentiationArguments<Long>>(Long.class, k, integrator, k, expectedDerivator, k);
        Assert.assertSame(expectedDerivator, testPid.getDerivativeComponent());
    }

    @Test
    public void testLongDerivatorGetterNotSame() {
        final Long k = 5l;
        NoIntegration<Long> integrator = new NoIntegration<Long>(Long.class);
        NoDifferentiation<Long> expectedDerivator = new NoDifferentiation<Long>(Long.class);
        IPID<Long, NoIntegration<Long>, NoIntegrationArguments<Long>, NoDifferentiation<Long>, NoDifferentiationArguments<Long>> testPid = new PID<Long, NoIntegration<Long>, NoIntegrationArguments<Long>, NoDifferentiation<Long>, NoDifferentiationArguments<Long>>(Long.class, k, integrator, k, expectedDerivator, k);
        NoDifferentiation<Double> wrongDerivator = new NoDifferentiation<Double>(Double.class);
        Assert.assertNotSame(wrongDerivator, testPid.getDerivativeComponent());
    }

    @Test
    public void testReset() {
        final Double kp = 0.5, ki = 0.2;
        final Double errorSignalValue = 10d;
        final Double timeStep = 1.0;
        Double expected = kp * errorSignalValue + ki * (errorSignalValue / timeStep);
        FixedStepIntegrationArguments<Double> fixedStepArgs = new FixedStepIntegrationArguments<Double>(Double.class, timeStep); // Set the timestep. It cannot be updated (fixed step).
        FixedStepEulerIntegration<Double> integrator = new FixedStepEulerIntegration<Double>(Double.class, fixedStepArgs);
        IPID<Double, FixedStepEulerIntegration<Double>, FixedStepIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>> testPid = new PIController<Double, FixedStepEulerIntegration<Double>, FixedStepIntegrationArguments<Double>>(Double.class, kp, integrator, ki);
        ProportionalIntegralArguments<Double, FixedStepIntegrationArguments<Double>> propArgs = new ProportionalIntegralArguments<Double, FixedStepIntegrationArguments<Double>>(Double.class);
        propArgs.updateErrorSignalValue(errorSignalValue);
        propArgs.setIntegratorEvaluationArgs(fixedStepArgs);
        testPid.evaluate(propArgs); // advance the state values
        testPid.resetStateValues(); // reset to zero everything out
        Assert.assertEquals(expected, testPid.evaluate(propArgs)); // advance the state values again and Assert
    }

    @Test
    public void testPIControllerTypedAsDouble() {
        final Double kp = 0.5, ki = 0.2;
        final Double errorSignalValue = 10d;
        final Double timeStep = 1.0;
        Double expected = kp * errorSignalValue + ki * (errorSignalValue / timeStep);
        FixedStepIntegrationArguments<Double> fixedStepArgs = new FixedStepIntegrationArguments<Double>(Double.class, timeStep); // Set the timestep. It cannot be updated (fixed step).
        FixedStepEulerIntegration<Double> integrator = new FixedStepEulerIntegration<Double>(Double.class, fixedStepArgs);
        IPID<Double, FixedStepEulerIntegration<Double>, FixedStepIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>> testPid = new PIController<Double, FixedStepEulerIntegration<Double>, FixedStepIntegrationArguments<Double>>(Double.class, kp, integrator, ki);
        ProportionalIntegralArguments<Double, FixedStepIntegrationArguments<Double>> propArgs = new ProportionalIntegralArguments<Double, FixedStepIntegrationArguments<Double>>(Double.class);
        propArgs.updateErrorSignalValue(errorSignalValue);
        propArgs.setIntegratorEvaluationArgs(fixedStepArgs);
        Double actual = testPid.evaluate(propArgs);
        Assert.assertEquals(expected, actual);
    }

}
