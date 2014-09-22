/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.mitre.caasd.jlcl.interfaces.IIntegrate;
import org.mitre.caasd.jlcl.interfaces.IIntegrationArguments;

/**
 * A pre-built Proportional-Integral control component that subclasses
 * {@link PID}. The derivative term is guaranteed to remain zero. The
 * {@link #evaluate(org.mitre.caasd.jlcl.interfaces.IControlComponentsArguments)}
 * method must be called with a {@link ProportionalIntegralArguments} object.
 * 
 * @param <NUMERICTYPE>
 *            The numeric type of the component.
 * @param <INTEGRATOR>
 *            The integrator to be used for integration operations.
 * @param <INTEGRATOR_ARGS_TYPE>
 *            The arguements object to be used for integration operations.
 * 
 * @author SBOWMAN
 * @see PID
 * @see ProportionalIntegralArguments
 * 
 */
public class PIController<NUMERICTYPE extends Number, INTEGRATOR extends IIntegrate<NUMERICTYPE, INTEGRATOR_ARGS_TYPE>, INTEGRATOR_ARGS_TYPE extends IIntegrationArguments<NUMERICTYPE>>
        extends PID<NUMERICTYPE, INTEGRATOR, INTEGRATOR_ARGS_TYPE, NoDifferentiation<NUMERICTYPE>, NoDifferentiationArguments<NUMERICTYPE>> {

    @SuppressWarnings("unchecked")
    public PIController(Class<NUMERICTYPE> clazz, NUMERICTYPE proportionalGain, INTEGRATOR integratorInstance, NUMERICTYPE integratorGain) {
        super(clazz, proportionalGain, integratorInstance, integratorGain, new NoDifferentiation<NUMERICTYPE>(clazz), (NUMERICTYPE) ParameterizedExtendsNumber
                .getZeroForClazz(clazz));
    }
}
