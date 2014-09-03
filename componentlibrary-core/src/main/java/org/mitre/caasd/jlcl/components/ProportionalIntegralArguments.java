/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.mitre.caasd.jlcl.interfaces.IIntegrationArguments;
import org.mitre.caasd.jlcl.interfaces.IPIControllerArguments;

/**
 * An argument object for use with Proportional-Integral control components.
 * 
 * @author SBOWMAN
 * @see PIController
 * 
 */
public class ProportionalIntegralArguments<NUMERICTYPE extends Number, INTEGRATOR_ARGS_TYPE extends IIntegrationArguments<NUMERICTYPE>> extends ParameterizedExtendsNumber<NUMERICTYPE> implements IPIControllerArguments<NUMERICTYPE, INTEGRATOR_ARGS_TYPE> {

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
    final private NoDifferentiationArguments<NUMERICTYPE> noDifferentiationArgs;

    public ProportionalIntegralArguments(Class<NUMERICTYPE> clazz) {
        super(clazz);
        this.noDifferentiationArgs = new NoDifferentiationArguments<NUMERICTYPE>(clazz);
    }

    public ProportionalIntegralArguments(Class<NUMERICTYPE> clazz, NUMERICTYPE errorSignal, INTEGRATOR_ARGS_TYPE integratorArgs) {
        this(clazz);
        updateErrorSignalValue(errorSignal);
        setIntegratorEvaluationArgs(integratorArgs);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mitre.caasd.jlcl.interfaces.IControlComponentsArguments#getErrorSignalValue()
     */
    @Override
    public NUMERICTYPE getErrorSignalValue() {
        return this.errorSignal;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mitre.caasd.jlcl.interfaces.IControlComponentsArguments#updateErrorSignalValue(java.lang.Number)
     */
    @Override
    public void updateErrorSignalValue(NUMERICTYPE errorSignal) {
        this.errorSignal = errorSignal;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mitre.caasd.jlcl.interfaces.IPidEvaluationArguments#setIntegratorEvaluationArgs(org.mitre.caasd.jlcl.interfaces.IIntegrationArguments)
     */
    @Override
    public void setIntegratorEvaluationArgs(INTEGRATOR_ARGS_TYPE evaluationArgs) {
        this.integratorArgs = evaluationArgs;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mitre.caasd.jlcl.interfaces.IPidEvaluationArguments#getIntegratorEvaluationArgs()
     */
    @Override
    public INTEGRATOR_ARGS_TYPE getIntegratorEvaluationArgs() {
        return this.integratorArgs;
    }

    @Override
    public void setDifferentiatorEvaluationArgs(NoDifferentiationArguments<NUMERICTYPE> evaluationArgs) {
        // empty, unused. Never overwrite the noDifferentiationArgs member.
    }

    @Override
    public NoDifferentiationArguments<NUMERICTYPE> getDifferentiatorEvaluationArgs() {
        return noDifferentiationArgs;
    }

}
