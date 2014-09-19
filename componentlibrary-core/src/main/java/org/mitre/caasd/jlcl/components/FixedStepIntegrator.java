/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.mitre.caasd.jlcl.interfaces.IFixedStepIntegratorArguments;
import org.mitre.caasd.jlcl.interfaces.IIntegrate;

/**
 * An abstract class that should be subclassed by all fixed-step integration classes. The benefit
 * is that this class provides nearly full implementation. The subclass needs only to implement
 * one method (integrate()).
 * 
 * @author SBOWMAN
 * 
 * @param <NUMERICTYPE>
 *            The data type that will be input and returned by this class.
 */
public abstract class FixedStepIntegrator<NUMERICTYPE extends Number, ARGTYPE extends IFixedStepIntegratorArguments<NUMERICTYPE>> extends ParameterizedExtendsNumber<NUMERICTYPE> implements IIntegrate<NUMERICTYPE, ARGTYPE> {

    /**
     * The itegration total (cumulative sum).
     */
    private NUMERICTYPE integrationTotal = null;

    /**
     * The fixed step argument objects used for all evaluations of integrate().
     */
    protected IFixedStepIntegratorArguments<NUMERICTYPE> fixedStepArgs = null;

    /**
     * @param clazz The numeric class, must extend from {@link Number}.
     *            The numeric class that will be used for all input & output data types.
     * @param fixedStepArgs
     *            The fixed step argument object to be used for all integration operations. Must implement <code>IFixedStepIntegratorArguments</code>.
     * @see IFixedStepIntegratorArguments
     */
    public FixedStepIntegrator(final Class<NUMERICTYPE> clazz, IFixedStepIntegratorArguments<NUMERICTYPE> fixedStepArgs) {
        super(clazz);
        this.fixedStepArgs = fixedStepArgs;
        resetStateValues();
    }

    @Override
    public void resetStateValues() {
        integrationTotal = this.getZeroAsCorrectType();
    }

    @Override
    public NUMERICTYPE getTotalIntegrationValue() {
        return this.integrationTotal;
    }

    /**
     * @param incrementValue
     *            Increment the cumulative sum by this value.
     */
    protected void incrementTotal(NUMERICTYPE incrementValue) {
        if (performCalculationsAsDoublePrimitive)
            integrationTotal = convertToOutputType(integrationTotal.doubleValue() + incrementValue.doubleValue());
        else
            integrationTotal = convertToOutputType("" + (integrationTotal.longValue() + incrementValue.longValue()));
    }

    /**
     * @return The fixed step size value.
     */
    protected NUMERICTYPE getFixedStepSize() {
        return fixedStepArgs.getStepSize();
    }
}
