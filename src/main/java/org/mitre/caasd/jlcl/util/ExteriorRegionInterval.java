/**
 * 
 */
package org.mitre.caasd.jlcl.util;

/**
 * A value interval the evaluates the boundaries for external regions. The call to <code>isOnTheInterval</code> will return true if the value is outside of the window region, not including its boundary values.
 * 
 * @author SBOWMAN
 * 
 */
public class ExteriorRegionInterval<NUMERICTYPE extends Number> extends ValueInterval<NUMERICTYPE> {

    private ClosedInterval<NUMERICTYPE> oppositeRegion = null;

    public ExteriorRegionInterval(Class<NUMERICTYPE> clazz, NUMERICTYPE value1, NUMERICTYPE value2) {
        super(clazz, value1, value2);
        oppositeRegion = new ClosedInterval<NUMERICTYPE>(clazz, value1, value2);
    }

    @Override
    public boolean isOnTheInterval(NUMERICTYPE value) {
        // simply return the opposite of the closed interval evaluation
        return !oppositeRegion.isOnTheInterval(value);
    }

}
