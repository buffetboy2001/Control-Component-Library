/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.mitre.caasd.jlcl.interfaces.IControlComponentsArguments;

/**
 * @author SBOWMAN
 * 
 */
public class SimpleControlComponentArgs<NUMERICTYPE extends Number> implements IControlComponentsArguments<NUMERICTYPE> {

    private NUMERICTYPE errorSignal = null;

    @Override
    public NUMERICTYPE getErrorSignalValue() {
        return this.errorSignal;
    }

    @Override
    public void updateErrorSignalValue(NUMERICTYPE errorSignal) {
        this.errorSignal = errorSignal;
    }

}
