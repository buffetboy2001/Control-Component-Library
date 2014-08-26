/**
 * 
 */
package org.mitre.caasd.jlcl.components;

/**
 * A concrete instance of an arguments object that can be used with {@link FixedStepForwardDifferentiator}.
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
     *            The class that defines the numeric type to be used.
     * @param fixedStepSize
     *            The step size that will be used for all differentation operations.
     */
    public FixedStepForwardDiffentiatorArguments(Class<NUMERICTYPE> clazz, NUMERICTYPE fixedStepSize) {
        super(clazz, fixedStepSize);
    }

    /**
     * Provide the function value necessary for {@link FixedStepForwardDifferentiator}.
     * 
     * @param functionValue
     */
    public void updateNextFunctionValue(NUMERICTYPE functionValue) {
        this.nextFunctionValue = functionValue;
    }

    /**
     * @return the nextFunctionValue
     */
    public NUMERICTYPE getNextFunctionValue() {
        return nextFunctionValue;
    }

}
