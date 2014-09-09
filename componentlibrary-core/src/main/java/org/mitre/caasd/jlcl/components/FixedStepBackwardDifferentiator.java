/**
 * 
 */
package org.mitre.caasd.jlcl.components;

/**
 * @author SBOWMAN
 * 
 */
public class FixedStepBackwardDifferentiator<NUMERICTYPE extends Number> extends FixedStepDifferentiator<NUMERICTYPE, FixedStepBackwardDiffentiatorArguments<NUMERICTYPE>> {

    public FixedStepBackwardDifferentiator(Class<NUMERICTYPE> clazz) {
        super(clazz);
    }

    @Override
    public NUMERICTYPE differentiate(FixedStepBackwardDiffentiatorArguments<NUMERICTYPE> differentiatorArgs, NUMERICTYPE derivativeOfThis) {
        // f_prime = (f(x)-f(x-1))/h
        if (this.performCalculationsAsDoublePrimitive) {
            // double
            double derivative = 0;
            derivative = (derivativeOfThis.doubleValue() - differentiatorArgs.getPreviousFunctionValue().doubleValue()) / differentiatorArgs.getStepSize().doubleValue();
            return convertToOutputType(derivative);
        } else {
            // long
            long derivative = 0;
            derivative = (derivativeOfThis.longValue() - differentiatorArgs.getPreviousFunctionValue().longValue()) / differentiatorArgs.getStepSize().longValue();
            return convertToOutputType(derivative);
        }
    }

    @Override
    public void resetStateValues() {
        // Nothing to reset.
    }

}
