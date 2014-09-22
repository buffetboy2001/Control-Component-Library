/**
 * 
 */
package org.mitre.caasd.jlcl.components;

/**
 * A concrete instance of an arguments object that can be used with
 * {@link FixedStepForwardDifferentiator}.
 * 
 * @author SBOWMAN
 * 
 */
public class FixedStepForwardDiffentiatorArguments<NUMERICTYPE extends Number> extends FixedStepDiffentiatorArguments<NUMERICTYPE> {

    /**
     * The next function value.
     */
    private NUMERICTYPE nextFunctionValue = null;

    /**
     * @param clazz
     *            The numeric class, must extend from {@link Number}. The class
     *            that defines the numeric type to be used.
     * @param fixedStepSize
     *            The step size that will be used for all differentation
     *            operations.
     */
    public FixedStepForwardDiffentiatorArguments(Class<NUMERICTYPE> clazz, NUMERICTYPE fixedStepSize) {
        super(clazz, fixedStepSize);
    }

    /**
     * Provide the function value necessary for
     * {@link FixedStepForwardDifferentiator}.
     * 
     * @param functionValue
     *            The next function value.
     */
    public void updateNextFunctionValue(NUMERICTYPE functionValue) {
        this.nextFunctionValue = functionValue;
    }

    /**
     * @return the nextFunctionValue The next function value.
     */
    public NUMERICTYPE getNextFunctionValue() {
        return nextFunctionValue;
    }

}
