/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.mitre.caasd.jlcl.interfaces.IDifferentiate;

/**
 * A place-holder object to be used when an <code>IDerivate</code> object is required but no derivative calculation is desired.
 * 
 * @author SBOWMAN
 * 
 * @param <NUMERICTYPE>
 *            The data type that will be input and returned by this class.
 */
public final class NoDifferentiation<NUMERICTYPE extends Number> extends ParameterizedExtendsNumber<NUMERICTYPE> implements IDifferentiate<NUMERICTYPE, NoDifferentiationArguments<NUMERICTYPE>> {

    /**
     * Constructor.
     * 
     * @param clazz
     */
    public NoDifferentiation(Class<NUMERICTYPE> clazz) {
        super(clazz);
    }

    @Override
    public void resetStateValues() {
        // Nothing to do
    }

    @Override
    public NUMERICTYPE differentiate(NoDifferentiationArguments<NUMERICTYPE> differentiatorArgs, NUMERICTYPE derivativeOfThis) {
        return this.getZeroAsCorrectType();
    }

}
