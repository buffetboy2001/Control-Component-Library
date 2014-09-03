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
     * 
     */
    public NoDifferentiationArguments(Class<NUMERICTYPE> clazz) {
        super(clazz);
    }

    @Override
    public NUMERICTYPE getStepSize() {
        return this.getZeroAsCorrectType();
    }

}
