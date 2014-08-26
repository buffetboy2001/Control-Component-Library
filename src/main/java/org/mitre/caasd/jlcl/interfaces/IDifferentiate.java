/**
 * 
 */
package org.mitre.caasd.jlcl.interfaces;

/**
 * @author SBOWMAN
 * 
 * @param <NUMERICTYPE>
 *            The data type that will be input and returned by this class.
 */
public interface IDifferentiate<NUMERICTYPE extends Number, ARGTYPE extends IDifferentiateArguments<NUMERICTYPE>> extends IMaintainsState {

    /**
     * Perform derivative calculation.
     * 
     * @param differentiatorArgs
     *            The differentiator argument object {@link IDifferentiateArguments}.
     * @param derivativeOfThis
     *            The function evaluation value.
     * @return The derivative of the function.
     */
    NUMERICTYPE differentiate(final ARGTYPE differentiatorArgs, final NUMERICTYPE derivativeOfThis);

}
