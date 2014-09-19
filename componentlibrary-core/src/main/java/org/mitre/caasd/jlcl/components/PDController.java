/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.mitre.caasd.jlcl.interfaces.IDifferentiate;
import org.mitre.caasd.jlcl.interfaces.IDifferentiateArguments;

/**
 * A pre-built Proportional-Derivative control component that subclasses
 * {@link PID}. The integrator term is guaranteed to remain zero.
 * 
 * @param <NUMERICTYPE>
 *            The numeric type of the component.
 * @param <DIFFERENTIATOR>
 *            The differentiator to be used for derivative calculations.
 * @param <DIFFERENTIATOR_ARGS_TYPE>
 *            The argument object for the differentiator.
 * 
 * @author SBOWMAN
 * @see PID
 * 
 */
public class PDController<NUMERICTYPE extends Number, DIFFERENTIATOR extends IDifferentiate<NUMERICTYPE, DIFFERENTIATOR_ARGS_TYPE>, DIFFERENTIATOR_ARGS_TYPE extends IDifferentiateArguments<NUMERICTYPE>>
        extends PID<NUMERICTYPE, NoIntegration<NUMERICTYPE>, NoIntegrationArguments<NUMERICTYPE>, DIFFERENTIATOR, DIFFERENTIATOR_ARGS_TYPE> {

    @SuppressWarnings("unchecked")
    public PDController(Class<NUMERICTYPE> clazz, NUMERICTYPE proportionalGain, DIFFERENTIATOR differentiatorInstance, NUMERICTYPE differentiatorGain) {
        super(clazz, proportionalGain, new NoIntegration<NUMERICTYPE>(clazz), (NUMERICTYPE) ParameterizedExtendsNumber.getZeroForClazz(clazz), differentiatorInstance,
                differentiatorGain);
    }
}
