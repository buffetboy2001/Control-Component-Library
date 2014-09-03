/**
 * 
 */
package org.mitre.caasd.jlcl.util;

/**
 * An interval the represents an unbounded region. The call to <code>isOnTheInterval</code> will always return <code>true</code>.
 * 
 * @author SBOWMAN
 * 
 * @param <NUMERICTYPE>
 */
public class UnboundedInterval<NUMERICTYPE extends Number> extends ValueInterval<NUMERICTYPE> {

    public UnboundedInterval(Class<NUMERICTYPE> clazz, NUMERICTYPE value1, NUMERICTYPE value2) {
        super(clazz, value1, value2);
    }

    @Override
    public boolean isOnTheInterval(NUMERICTYPE value) {
        return true;
    }

}
