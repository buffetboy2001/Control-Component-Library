package org.mitre.caasd.jlcl.components;

import org.mitre.caasd.jlcl.interfaces.IIntegrate;

/**
 * A place-holder object to be used when an <code>IIntegrate</code> object is required but no integration is desired.
 * 
 * @author SBOWMAN
 * @param <NUMERICTYPE>
 *            The data type that will be input and returned by this class.
 */
public final class NoIntegration<NUMERICTYPE extends Number> extends ParameterizedExtendsNumber<NUMERICTYPE> implements IIntegrate<NUMERICTYPE, NoIntegrationArguments<NUMERICTYPE>> {

    /**
     * Constructor.
     * 
     * @param clazz The numeric class, must extend from {@link Number}.
     */
    public NoIntegration(Class<NUMERICTYPE> clazz) {
        super(clazz);
    }

    @Override
    public void resetStateValues() {
        // Nothing to do
    }

    @Override
    public NUMERICTYPE getTotalIntegrationValue() {
        return this.getZeroAsCorrectType();
    }

    @Override
    public NUMERICTYPE integrate(NoIntegrationArguments<NUMERICTYPE> integratorArgs, NUMERICTYPE integralOfThis) {
        return this.getZeroAsCorrectType();
    }

}
