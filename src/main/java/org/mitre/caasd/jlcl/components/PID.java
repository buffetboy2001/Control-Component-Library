package org.mitre.caasd.jlcl.components;

import org.mitre.caasd.jlcl.interfaces.IDifferentiate;
import org.mitre.caasd.jlcl.interfaces.IDifferentiateArguments;
import org.mitre.caasd.jlcl.interfaces.IIntegrate;
import org.mitre.caasd.jlcl.interfaces.IIntegrationArguments;
import org.mitre.caasd.jlcl.interfaces.IPID;
import org.mitre.caasd.jlcl.interfaces.IPidEvaluationArguments;

/**
 * This class represents a basic Proportional-Integrator-Derivative control component. The PID control law defines
 * a summation operation between three error signal operations: <li>proportional operation</li> <li>integration operation</li> <li>derivative operation</li>
 * <p>
 * The output of each operation is summed to provide the output of the control law.
 * 
 * 
 * @author SBOWMAN
 * 
 * @param <NUMERICTYPE>
 *            The data type that will be input and returned by this class.
 * @param <INTEGRATOR>
 *            The integrator to be used for integration operations.
 * @param <INTEGRATOR_ARGS_TYPE>
 *            The Integrator argument object type.
 * @param <DIFFERENTIATOR>
 *            The differentiator to be used for differential operations.
 * @param <DIFFERENTIATOR_ARGS_TYPE>
 *            The Differentiator argument object type.
 * @see org.mitre.caasd.jlcl.factories.ControlComponentFactory
 */
public class PID<NUMERICTYPE extends Number, INTEGRATOR extends IIntegrate<NUMERICTYPE, INTEGRATOR_ARGS_TYPE>, INTEGRATOR_ARGS_TYPE extends IIntegrationArguments<NUMERICTYPE>, DIFFERENTIATOR extends IDifferentiate<NUMERICTYPE, DIFFERENTIATOR_ARGS_TYPE>, DIFFERENTIATOR_ARGS_TYPE extends IDifferentiateArguments<NUMERICTYPE>> extends ControlComponent<NUMERICTYPE, IPidEvaluationArguments<NUMERICTYPE, INTEGRATOR_ARGS_TYPE, DIFFERENTIATOR_ARGS_TYPE>> implements IPID<NUMERICTYPE, INTEGRATOR, INTEGRATOR_ARGS_TYPE, DIFFERENTIATOR, DIFFERENTIATOR_ARGS_TYPE> {

    /**
     * The proportional gain value.
     */
    private NUMERICTYPE kp = null;
    /**
     * The integral gain value.
     */
    private NUMERICTYPE ki = null;
    /**
     * The derivative gain value.
     */
    private NUMERICTYPE kd = null;
    /**
     * The integrator.
     */
    protected INTEGRATOR i = null;
    /**
     * The derivator.
     */
    protected DIFFERENTIATOR d = null;

    /**
     * PID Constructor. Inputs may not be null.
     * 
     * @param clazz
     *            The class numeric type that will be used for all input & ouput.
     * @param proportionalGain
     *            The proportional gain.
     * @param integratorInstance
     *            The integrator instance to be used.
     * @param integratorGain
     *            The integrator gain to be used.
     * @param derivativeInstance
     *            The derivative instance to be used.
     * @param derivativeGain
     *            The derivative gain to be used.
     */
    public PID(final Class<NUMERICTYPE> clazz,
            final NUMERICTYPE proportionalGain,
            final INTEGRATOR integratorInstance,
            final NUMERICTYPE integratorGain,
            final DIFFERENTIATOR derivativeInstance,
            final NUMERICTYPE derivativeGain) {
        super(clazz);
        this.updateProportionalGain(proportionalGain);
        i = integratorInstance;
        this.updateIntegralGain(integratorGain);
        d = derivativeInstance;
        this.updateDerivativeGain(derivativeGain);
    }

    @Override
    public void resetStateValues() {
        // Reset all state values to zero.
        i.resetStateValues();
        d.resetStateValues();
    }

    @Override
    public void updateProportionalGain(NUMERICTYPE kp) {
        this.kp = kp;
    }

    @Override
    public void updateIntegralGain(NUMERICTYPE ki) {
        this.ki = ki;
    }

    @Override
    public void updateDerivativeGain(NUMERICTYPE kd) {
        this.kd = kd;
    }

    @Override
    public NUMERICTYPE getProportionalGain() {
        return kp;
    }

    @Override
    public NUMERICTYPE getIntegralGain() {
        return ki;
    }

    @Override
    public NUMERICTYPE getDerivativeGain() {
        return kd;
    }

    @Override
    public IIntegrate<NUMERICTYPE, INTEGRATOR_ARGS_TYPE> getItegratorComponent() {
        return i;
    }

    @Override
    public IDifferentiate<NUMERICTYPE, DIFFERENTIATOR_ARGS_TYPE> getDerivativeComponent() {
        return d;
    }

    // This evaluateAs method is final to prevent extension of the implementation. To need a different implementation is to move away from PID entirely.
    @Override
    protected final double evaluateAsDoublePrimitive(IPidEvaluationArguments<NUMERICTYPE, INTEGRATOR_ARGS_TYPE, DIFFERENTIATOR_ARGS_TYPE> evaluationArguments) {
        // use double primitive
        NUMERICTYPE errorSignal = evaluationArguments.getErrorSignalValue();
        double controlOuput = 0d;
        controlOuput += kp.doubleValue() * errorSignal.doubleValue();
        controlOuput += ki.doubleValue() * i.integrate(evaluationArguments.getIntegratorEvaluationArgs(), errorSignal).doubleValue();
        controlOuput += kd.doubleValue() * d.differentiate(evaluationArguments.getDifferentiatorEvaluationArgs(), errorSignal).doubleValue();
        return controlOuput;
    }

    // This evaluateAs method is final to prevent extension of the implementation. To need a different implementation is to move away from PID entirely.
    @Override
    protected final long evaluateAsLongPrimitive(IPidEvaluationArguments<NUMERICTYPE, INTEGRATOR_ARGS_TYPE, DIFFERENTIATOR_ARGS_TYPE> evaluationArguments) {
        // use long primitive via string conversion (which does not contain any loss of precision)
        NUMERICTYPE errorSignal = evaluationArguments.getErrorSignalValue();
        long controlOuput = 0l;
        controlOuput += kp.longValue() * errorSignal.longValue();
        controlOuput += ki.longValue() * i.integrate(evaluationArguments.getIntegratorEvaluationArgs(), errorSignal).longValue();
        controlOuput += kd.longValue() * d.differentiate(evaluationArguments.getDifferentiatorEvaluationArgs(), errorSignal).longValue();
        return controlOuput;
    }

}
