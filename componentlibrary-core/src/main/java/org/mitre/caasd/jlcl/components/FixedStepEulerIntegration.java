package org.mitre.caasd.jlcl.components;

/**
 * A fixed-step Euler integrator.
 * 
 * @author SBOWMAN
 * 
 * @param <NUMERICTYPE>
 *            The data type that will be input and returned by this class.
 */
public class FixedStepEulerIntegration<NUMERICTYPE extends Number> extends FixedStepIntegrator<NUMERICTYPE, FixedStepIntegrationArguments<NUMERICTYPE>> {

    /**
     * Constructor.
     * 
     * @param clazz
     *            The class used for input & output.
     * @param fixedStepSizeArgs
     *            The integration argument object that will be used for all integrate() evaluations.
     */
    public FixedStepEulerIntegration(final Class<NUMERICTYPE> clazz, FixedStepIntegrationArguments<NUMERICTYPE> fixedStepSizeArgs) {
        super(clazz, fixedStepSizeArgs);
    }

    @Override
    public NUMERICTYPE integrate(final FixedStepIntegrationArguments<NUMERICTYPE> integratorArgs, final NUMERICTYPE integralOfThis) {
        // Simply multiply the step size by the current value
        if (this.performCalculationsAsDoublePrimitive) {
            double intermediateCalculation = this.getFixedStepSize().doubleValue() * integralOfThis.doubleValue();
            super.incrementTotal(this.convertToOutputType(intermediateCalculation));
            return super.getTotalIntegrationValue();
        } else {
            long intermediateCalculation = this.getFixedStepSize().longValue() * integralOfThis.longValue();
            super.incrementTotal(this.convertToOutputType(intermediateCalculation));
            return super.getTotalIntegrationValue();
        }
    }
}
