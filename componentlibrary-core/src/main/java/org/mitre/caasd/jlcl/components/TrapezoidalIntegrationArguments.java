/**
 * 
 */
package org.mitre.caasd.jlcl.components;

/**
 * @author SBOWMAN
 * 
 */
public class TrapezoidalIntegrationArguments<NUMERICTYPE extends Number> extends FixedStepIntegrationArguments<NUMERICTYPE> {

    private NUMERICTYPE prevFval = super.getZeroAsCorrectType();

    /**
     * 
     */
    public TrapezoidalIntegrationArguments(Class<NUMERICTYPE> clazz, NUMERICTYPE fixedStepSize) {
        super(clazz, fixedStepSize);
    }

    /**
     * @return The previous function value provided.
     */
    public NUMERICTYPE getPreviousFunctionValue() {
        return this.prevFval;
    }

    /**
     * @param value
     *            The function value that should be stored.
     */
    public void updatePreviousFunctionValue(NUMERICTYPE value) {
        this.prevFval = value;
    }
}
