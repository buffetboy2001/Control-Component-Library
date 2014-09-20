/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.mitre.caasd.jlcl.interfaces.IDifferentiateArguments;

/**
 * @author sbowman
 * 
 */
public class NoDifferentiationArguments<NUMERICTYPE extends Number> extends ParameterizedExtendsNumber<NUMERICTYPE> implements IDifferentiateArguments<NUMERICTYPE> {

    /**
     * @param clazz
     *            The class to be used, must extend from {@link Number}.
     */
    public NoDifferentiationArguments(Class<NUMERICTYPE> clazz) {
        super(clazz);
    }

    @Override
    public NUMERICTYPE getStepSize() {
        return this.getZeroAsCorrectType();
    }

}
