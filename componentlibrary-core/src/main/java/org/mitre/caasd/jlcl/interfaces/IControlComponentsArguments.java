/**
 * 
 */
package org.mitre.caasd.jlcl.interfaces;

/**
 * @author SBOWMAN
 * 
 */
public interface IControlComponentsArguments<NUMERICTYPE extends Number> {

    /**
     * @return Provides the current error signal value upon which the control component must operate.
     */
    NUMERICTYPE getErrorSignalValue();

    /**
     * @param errorSignal
     *            The updated value of the error signal.
     */
    void updateErrorSignalValue(final NUMERICTYPE errorSignal);
}
