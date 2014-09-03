/**
 * 
 */
package org.mitre.caasd.jlcl.components;

/**
 * @author SBOWMAN
 * 
 */
public class FixedStepForwardDifferentiator<NUMERICTYPE extends Number> extends FixedStepDifferentiator<NUMERICTYPE, FixedStepForwardDiffentiatorArguments<NUMERICTYPE>> {

    public FixedStepForwardDifferentiator(Class<NUMERICTYPE> clazz) {
        super(clazz);
    }

    @Override
    public NUMERICTYPE differentiate(FixedStepForwardDiffentiatorArguments<NUMERICTYPE> differentiatorArgs, NUMERICTYPE derivativeOfThis) {
        // f_prime = (f(x+1)-f(x))/h
        if (this.performCalculationsAsDoublePrimitive) {
            // double
            double derivative = 0;
            derivative = (differentiatorArgs.getNextFunctionValue().doubleValue() - derivativeOfThis.doubleValue()) / differentiatorArgs.getStepSize().doubleValue();
            return convertToOutputType(derivative);
        } else {
            // long
            long derivative = 0;
            derivative = (differentiatorArgs.getNextFunctionValue().longValue() - derivativeOfThis.longValue()) / differentiatorArgs.getStepSize().longValue();
            return convertToOutputType(derivative);
        }
    }

    @Override
    public void resetStateValues() {
        // Nothing to reset.
    }

}
