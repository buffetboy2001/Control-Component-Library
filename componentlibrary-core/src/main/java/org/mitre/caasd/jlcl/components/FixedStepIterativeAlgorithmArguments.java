/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.mitre.caasd.jlcl.interfaces.IIterativeAlgorithmArguments;

/**
 * A base class for any implementation of {@link IIterativeAlgorithmArguments}
 * that will enforced fixed step sizes. Just subclass this and then the step
 * size is guaranteed not to change.
 * 
 * @author SBOWMAN
 * 
 */
public abstract class FixedStepIterativeAlgorithmArguments<NUMERICTYPE extends Number> extends ParameterizedExtendsNumber<NUMERICTYPE> implements
        IIterativeAlgorithmArguments<NUMERICTYPE> {

    /**
     * A constant step size.
     */
    private final NUMERICTYPE stepSize;

    /**
     * Constructor.
     * 
     * @param clazz
     *            The class to be used for operations, must extend from
     *            {@link Number}.
     * @param fixedStepSize
     *            The step size to be used for operations.
     */
    public FixedStepIterativeAlgorithmArguments(Class<NUMERICTYPE> clazz, NUMERICTYPE fixedStepSize) {
        super(clazz);
        this.stepSize = fixedStepSize;
    }

    @Override
    public NUMERICTYPE getStepSize() {
        return this.stepSize;
    }

}
