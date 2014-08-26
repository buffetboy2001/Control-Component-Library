/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.mitre.caasd.jlcl.interfaces.IIntegrationArguments;

/**
 * A blank integrator args object. Returns zero for the step size.
 * 
 * @author SBOWMAN
 * 
 */
public class NoIntegrationArguments<NUMERICTYPE extends Number> extends ParameterizedExtendsNumber<NUMERICTYPE> implements IIntegrationArguments<NUMERICTYPE> {

    public NoIntegrationArguments(Class<NUMERICTYPE> clazz) {
        super(clazz);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mitre.caasd.jlcl.interfaces.IIntegrationArguments#getStepSize()
     */
    @Override
    public NUMERICTYPE getStepSize() {
        return this.getZeroAsCorrectType();
    }

}
