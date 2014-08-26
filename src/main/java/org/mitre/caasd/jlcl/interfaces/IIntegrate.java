/**
 * 
 */
package org.mitre.caasd.jlcl.interfaces;

/**
 * @author SBOWMAN
 * 
 * @param <NUMERICTYPE>
 *            The data type that will be input and returned by this class.
 * @param <ARGTYPE>
 *            The integration argument object type. Must extend from <code>IIntegrationArguments</code>.
 */
public interface IIntegrate<NUMERICTYPE extends Number, ARGTYPE extends IIntegrationArguments<NUMERICTYPE>> extends IMaintainsState {

    /**
     * Perform integration operation. The return value is the cumulative summation of
     * all integration steps taken.
     * 
     * @param integratorArgs
     *            The integrator's argument object.
     * @param integralOfThis
     *            The function evaluation value.
     * @return The cumulative summation of all integration steps taken.
     * @see #getTotalIntegrationValue()
     */
    NUMERICTYPE integrate(final ARGTYPE integratorArgs, final NUMERICTYPE integralOfThis);

    /**
     * @return NUMERICTYPE the cumulative sum of all integration steps
     */
    NUMERICTYPE getTotalIntegrationValue();
}
