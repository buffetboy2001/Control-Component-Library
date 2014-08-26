/**
 * 
 */
package org.mitre.caasd.jlcl.interfaces;

/**
 * @author SBOWMAN
 * 
 * @param <NUMERICTYPE>
 *            The numeric type that will be used to evaluate mathematical operations.
 */
public interface IDeadband<NUMERICTYPE extends Number> extends ILinearControlComponent<NUMERICTYPE, IControlComponentsArguments<NUMERICTYPE>> {

}
