/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.junit.Assert;
import org.junit.Test;

import org.mitre.caasd.jlcl.interfaces.IPID;
import org.mitre.caasd.jlcl.interfaces.IPidEvaluationArguments;

/**
 * @author sbowman
 * 
 */
public class TestPDController {

    @Test
    public void testPDControllerTypedAsDouble() {
        final Double kp = 0.5, kd = 0d;
        final Double errorSignalValue = 10d;
        final Double timeStep = 1.0;
        Double expected = kp * errorSignalValue + kd * (errorSignalValue / timeStep);
        NoDifferentiationArguments<Double> fixedStepArgs = new NoDifferentiationArguments<Double>(Double.class);
        NoDifferentiation<Double> integrator = new NoDifferentiation<Double>(Double.class);
        IPID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>> testPid = new PDController<Double, NoDifferentiation<Double>, NoDifferentiationArguments<Double>>(Double.class, kp, integrator, kd);
        IPidEvaluationArguments<Double, NoIntegrationArguments<Double>, NoDifferentiationArguments<Double>> propArgs = new ProportionalOnlyArguments<Double>(Double.class);
        propArgs.updateErrorSignalValue(errorSignalValue);
        propArgs.setDifferentiatorEvaluationArgs(fixedStepArgs);
        Double actual = testPid.evaluate(propArgs); // evaluate once and get the response
        Assert.assertEquals(expected, actual);
    }

}
