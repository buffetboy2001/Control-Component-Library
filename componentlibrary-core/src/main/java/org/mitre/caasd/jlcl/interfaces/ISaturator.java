/**
 * 
 */
package org.mitre.caasd.jlcl.interfaces;

import org.mitre.caasd.jlcl.components.SimpleControlComponentArgs;

/**
 * A saturation control component the will limit the minimum and maximum values possible.
 * 
 * @author SBOWMAN
 * 
 * @param <NUMERICTYPE>
 *            The numeric type used for input & output.
 */
public interface ISaturator<NUMERICTYPE extends Number> extends ILinearControlComponent<NUMERICTYPE, SimpleControlComponentArgs<NUMERICTYPE>> {

}
