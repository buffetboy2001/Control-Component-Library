/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.mitre.caasd.jlcl.interfaces.IIntegrate;
import org.mitre.caasd.jlcl.interfaces.IIntegrationArguments;

/**
 * A pre-built Proportional-Integral control component that subclasses {@link PID}. The derivative term is guaranteed to remain zero. The {@link #evaluate(org.mitre.caasd.jlcl.interfaces.IPidEvaluationArguments)} method must be called with a {@link ProportionalIntegralArguments} object.
 * 
 * @param <NUMERICTYPE>
 * @param <INTEGRATOR>
 * @param <INTEGRATOR_ARGS_TYPE>
 * @param <PI_ARGS>
 * 
 * @author SBOWMAN
 * @see PID
 * @see ProportionalIntegralArguments
 * 
 */
public class PIController<NUMERICTYPE extends Number, INTEGRATOR extends IIntegrate<NUMERICTYPE, INTEGRATOR_ARGS_TYPE>, INTEGRATOR_ARGS_TYPE extends IIntegrationArguments<NUMERICTYPE>>
        extends PID<NUMERICTYPE,
        INTEGRATOR,
        INTEGRATOR_ARGS_TYPE,
        NoDifferentiation<NUMERICTYPE>,
        NoDifferentiationArguments<NUMERICTYPE>> {

    @SuppressWarnings("unchecked")
    public PIController(Class<NUMERICTYPE> clazz, NUMERICTYPE proportionalGain, INTEGRATOR integratorInstance, NUMERICTYPE integratorGain) {
        super(clazz, proportionalGain, integratorInstance, integratorGain, new NoDifferentiation<NUMERICTYPE>(clazz), (NUMERICTYPE) ParameterizedExtendsNumber.getZeroForClazz(clazz));
    }
}
