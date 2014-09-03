/**
 * 
 */
package org.mitre.caasd.jlcl.util;

/**
 * This is an interval implementation that evaluates the provided window as closed. Therefore, <code>isOnTheInterval</code> will only return true if the value is within the window, including the boundary values.
 * 
 * @author SBOWMAN
 * 
 */
public class ClosedInterval<NUMERICTYPE extends Number> extends ValueInterval<NUMERICTYPE> {

    public ClosedInterval(Class<NUMERICTYPE> clazz, NUMERICTYPE value1, NUMERICTYPE value2) {
        super(clazz, value1, value2);
    }

    @Override
    public boolean isOnTheInterval(NUMERICTYPE value) {
        boolean isBelowLowerValue = compare(value, getLowerValue()) < 0;
        if (isBelowLowerValue)
            return false; // not on the closed interval
        boolean isAboveUpperValue = compare(value, getUpperValue()) > 0;
        if (isAboveUpperValue)
            return false; // not on the closed interval

        // on the closed interval
        return true;
    }

}
