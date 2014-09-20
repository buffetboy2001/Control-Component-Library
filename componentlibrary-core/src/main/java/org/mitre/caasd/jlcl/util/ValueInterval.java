/**
 * 
 */
package org.mitre.caasd.jlcl.util;

import org.mitre.caasd.jlcl.components.ParameterizedExtendsNumber;

/**
 * Enforces a basic numerical interval concept. The values stored are guaranteed
 * to be ordered properly.
 * 
 * @author SBOWMAN
 * 
 * @param <NUMERICTYPE>
 *            The data type to be used by operations of this class.
 */
public abstract class ValueInterval<NUMERICTYPE extends Number> extends ParameterizedExtendsNumber<NUMERICTYPE> {

    private NUMERICTYPE lowerValue;
    private NUMERICTYPE upperValue;

    /**
     * @param clazz
     *            The numeric class, must extend from {@link Number}.
     * @param value1
     *            Any value of the correct numeric type.
     * @param value2
     *            Any value of the correct numeric type.
     */
    public ValueInterval(final Class<NUMERICTYPE> clazz, NUMERICTYPE value1, NUMERICTYPE value2) {
        super(clazz);
        orderInputs(value1, value2);
    }

    /**
     * A standard compare implementation. This uses the correct
     * <code>compare</code> method for the NUMERICTYPE.
     * 
     * @param value1
     *            The first value.
     * @param value2
     *            The second value.
     * @return The return value.
     */
    public int compare(NUMERICTYPE value1, NUMERICTYPE value2) {
        if (this.performCalculationsAsDoublePrimitive) {
            double v1 = value1.doubleValue();
            double v2 = value2.doubleValue();
            return Double.compare(v1, v2);
        } else {
            // evaluate as long
            long v1 = value1.longValue();
            long v2 = value2.longValue();
            return Long.compare(v1, v2);
        }

    }

    private void orderInputs(NUMERICTYPE value1, NUMERICTYPE value2) {
        int compareResult = compare(value1, value2);
        if (compareResult > 0) {
            // v1 > v2
            storeUpperLower(value1, value2);
        } else {
            // equal, which is the same as
            // v2 > v1
            storeUpperLower(value2, value1);
        }
    }

    private void storeUpperLower(NUMERICTYPE upper, NUMERICTYPE lower) {
        upperValue = upper;
        lowerValue = lower;
    }

    /**
     * @return the lowerValue
     */
    public NUMERICTYPE getLowerValue() {
        return lowerValue;
    }

    /**
     * @return the upperValue
     */
    public NUMERICTYPE getUpperValue() {
        return upperValue;
    }

    /**
     * 
     * @param value
     *            Any value of interest and of the correct NUMERICTYPE.
     * @return <code>true</code> if on the interval, <code>false</code>
     *         otherwise.
     */
    public abstract boolean isOnTheInterval(NUMERICTYPE value);
}
