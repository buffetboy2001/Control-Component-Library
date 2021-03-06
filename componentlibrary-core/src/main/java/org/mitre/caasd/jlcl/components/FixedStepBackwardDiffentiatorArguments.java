/**
 * 
 */
package org.mitre.caasd.jlcl.components;

/**
 * A concrete instance of an arguments object that can be used with
 * {@link FixedStepBackwardDifferentiator}.
 * 
 * @author SBOWMAN
 * 
 */
public class FixedStepBackwardDiffentiatorArguments<NUMERICTYPE extends Number> extends FixedStepDiffentiatorArguments<NUMERICTYPE> {

    /**
     * The next function value.
     */
    private NUMERICTYPE previousFunctionValue = null;

    /**
     * @param clazz
     *            The numeric class, must extend from {@link Number}. The class
     *            that defines the numeric type to be used.
     * @param fixedStepSize
     *            The step size that will be used for all differentation
     *            operations.
     */
    public FixedStepBackwardDiffentiatorArguments(Class<NUMERICTYPE> clazz, NUMERICTYPE fixedStepSize) {
        super(clazz, fixedStepSize);
    }

    /**
     * Provide the function value necessary for
     * {@link FixedStepForwardDifferentiator}.
     * 
     * @param functionValue
     *            The previous function value.
     */
    public void updatePreviousFunctionValue(NUMERICTYPE functionValue) {
        this.previousFunctionValue = functionValue;
    }

    /**
     * @return the nextFunctionValue The next function value.
     */
    public NUMERICTYPE getPreviousFunctionValue() {
        return previousFunctionValue;
    }

}
