/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.mitre.caasd.jlcl.interfaces.IDifferentiateArguments;
import org.mitre.caasd.jlcl.interfaces.IIntegrationArguments;
import org.mitre.caasd.jlcl.interfaces.IPIDControllerArguments;

/**
 * An argument object for use with any Proportional-Integral-Derivative control
 * components.
 * 
 * @author SBOWMAN
 * 
 */
public class ProportionalIntegralDerivativeArguments<NUMERICTYPE extends Number, INTEGRATOR_ARGS_TYPE extends IIntegrationArguments<NUMERICTYPE>, DIFFERENTIATION_ARGS_TYPE extends IDifferentiateArguments<NUMERICTYPE>>
        extends ParameterizedExtendsNumber<NUMERICTYPE> implements IPIDControllerArguments<NUMERICTYPE, INTEGRATOR_ARGS_TYPE, DIFFERENTIATION_ARGS_TYPE> {

    /**
     * The error signal value.
     */
    private NUMERICTYPE errorSignal = null;

    /**
     * The integrator args object.
     */
    private INTEGRATOR_ARGS_TYPE integratorArgs;

    /**
     * The differentiator args object.
     */
    private DIFFERENTIATION_ARGS_TYPE differentiationArgs;

    public ProportionalIntegralDerivativeArguments(Class<NUMERICTYPE> clazz) {
        super(clazz);
    }

    public ProportionalIntegralDerivativeArguments(Class<NUMERICTYPE> clazz, NUMERICTYPE errorSignal, INTEGRATOR_ARGS_TYPE integratorArgs) {
        this(clazz);
        updateErrorSignalValue(errorSignal);
        setIntegratorEvaluationArgs(integratorArgs);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mitre.caasd.jlcl.interfaces.IControlComponentsArguments#
     * getErrorSignalValue()
     */
    @Override
    public NUMERICTYPE getErrorSignalValue() {
        return this.errorSignal;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mitre.caasd.jlcl.interfaces.IControlComponentsArguments#
     * updateErrorSignalValue(java.lang.Number)
     */
    @Override
    public void updateErrorSignalValue(NUMERICTYPE errorSignal) {
        this.errorSignal = errorSignal;
    }

    @Override
    public void setIntegratorEvaluationArgs(INTEGRATOR_ARGS_TYPE evaluationArgs) {
        this.integratorArgs = evaluationArgs;
    }

    @Override
    public INTEGRATOR_ARGS_TYPE getIntegratorEvaluationArgs() {
        return this.integratorArgs;
    }

    @Override
    public void setDifferentiatorEvaluationArgs(DIFFERENTIATION_ARGS_TYPE evaluationArgs) {
        this.differentiationArgs = evaluationArgs;
    }

    @Override
    public DIFFERENTIATION_ARGS_TYPE getDifferentiatorEvaluationArgs() {
        return differentiationArgs;
    }

}
