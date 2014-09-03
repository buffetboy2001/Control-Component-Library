package org.mitre.caasd.jlcl;

import org.mitre.caasd.jlcl.components.FixedStepEulerIntegration;
import org.mitre.caasd.jlcl.components.FixedStepIntegrationArguments;
import org.mitre.caasd.jlcl.components.NoDifferentiation;

/**
 * An example class for showing how to programmatically build a control component. See the main().
 * 
 * @author SBOWMAN
 * @see #main(String[])
 */
public class BuildLinearControlComponent {

    /**
     * Empty constructor.
     */
    private BuildLinearControlComponent() {
        // nothing here.
    }

    /**
     * @param args
     *            The args.
     */
    public static void main(final String[] args) {

        /*
         * How to build a PID component:
         * 1. Build by hand
         * 2. Build via factory methods
         * a. P-only component
         */

        // 1. Build a fully described PID by hand
        // Double kp = 0d, ki = 0d, kd = 0d;
        // NoIntegration<Double> i = new NoIntegration<Double>(Double.class);
        // NoDifferentiation<Double> d = new NoDifferentiation<Double>(Double.class);
        // ProportionalOnlyArguments<Double> pidArgs = new ProportionalOnlyArguments<Double>(Double.class);
        // IPID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>> myPOnlyController = new PID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>>(Double.class, kp, i, ki, d, kd);

        // 2a. Use the factory to create a simple p-only component
        // Double kp = 0d;
        // IPID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>> myPOnlyController = ControlComponentFactory.createProportionalOnlyPidComponentAsDouble(kp);
        // ProportionalOnlyArguments<Double> pidArgs = new ProportionalOnlyArguments<Double>(Double.class);

        // Use the component
        // Double u = 0d;
        // pidArgs.updateErrorSignalValue(u);
        // Double y = myPOnlyController.evaluate(pidArgs);
        // System.out.println("For an input of " + u + ", the PID produced an output of " + y);

    }

    private static void designProblemsToFix() {
        final Double kp = 0.5, ki = 0.2;
        final Double timeStep = 1.0;
        FixedStepIntegrationArguments<Double> fixedStepArgs = new FixedStepIntegrationArguments<Double>(Double.class, timeStep); // Set the timestep. It cannot be updated (fixed step).
        FixedStepEulerIntegration<Double> integrator = new FixedStepEulerIntegration<Double>(Double.class, fixedStepArgs);
        NoDifferentiation<Double> derivator = new NoDifferentiation<Double>(Double.class);

        /*
         * Why do I have to define the integrator args multiple times in the interface declarations?
         * SOLVED!!
         */
        // PIController<Double, FixedStepEulerIntegration<Double>, FixedStepIntegrationArguments<Double>> testPid = new PIController<Double, FixedStepEulerIntegration<Double>, FixedStepIntegrationArguments<Double>>(Double.class, kp, integrator, ki);

        /*
         * Can we use the SpecialPID?
         * Yup. This works.
         */
        // SpecialPID1<Double, FixedStepEulerIntegration<Double>, FixedStepIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>> specialPid = new SpecialPID1<Double, FixedStepEulerIntegration<Double>, FixedStepIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>>(Double.class, kp, ki, integrator, derivator, 0d);
        // IPidEvaluationArguments<Double, FixedStepIntegrationArguments<Double>, NoDifferentiationArguments<Double>> pidEvalArgs = new ProportionalIntegralArguments<Double, FixedStepIntegrationArguments<Double>>(Double.class);
        // pidEvalArgs.updateErrorSignalValue(0d);
        // specialPid.evaluate(pidEvalArgs);
    }
}
