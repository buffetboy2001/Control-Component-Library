package org.mitre.caasd.jlcl.interfaces;

/**
 * The interface for PID implementations. A PID control component is both a
 * linear control component and a component that maintains state.
 * 
 * @author SBOWMAN
 * @see org.mitre.caasd.jlcl.components.PID
 * @see org.mitre.caasd.jlcl.factories.ControlComponentFactory
 * 
 * @param <NUMERICTYPE>
 *            The data type that will be input and returned by this class.
 * @param <INTEGRATOR>
 *            The integrator object.
 * @param <INTEGRATOR_ARGS_TYPE>
 *            The integrator argument object.
 * @param <DIFFERENTIATE>
 *            The differentiator object.
 * @param <DIFFERENTIATOR_ARGS_TYPE>
 *            The differentiator argument object.
 */
public interface IPID<NUMERICTYPE extends Number, INTEGRATOR extends IIntegrate<NUMERICTYPE, INTEGRATOR_ARGS_TYPE>, INTEGRATOR_ARGS_TYPE extends IIntegrationArguments<NUMERICTYPE>, DIFFERENTIATE extends IDifferentiate<NUMERICTYPE, DIFFERENTIATOR_ARGS_TYPE>, DIFFERENTIATOR_ARGS_TYPE extends IDifferentiateArguments<NUMERICTYPE>>
        extends ILinearControlComponent<NUMERICTYPE, IPidEvaluationArguments<NUMERICTYPE, INTEGRATOR_ARGS_TYPE, DIFFERENTIATOR_ARGS_TYPE>>, IMaintainsState {

    /**
     * @param kp
     *            Update the proportional gain value using the same
     *            <code>NUMERICTYPE</code> that was used to build the
     *            <code>IPID</code> component.
     */
    void updateProportionalGain(NUMERICTYPE kp);

    /**
     * @param ki
     *            Update the integral gain value using the same
     *            <code>NUMERICTYPE</code> that was used to build the
     *            <code>IPID</code> component.
     */
    void updateIntegralGain(NUMERICTYPE ki);

    /**
     * @param kd
     *            Update the derivative gain value using the same
     *            <code>NUMERICTYPE</code> that was used to build the
     *            <code>IPID</code> component.
     */
    void updateDerivativeGain(NUMERICTYPE kd);

    /**
     * @return Provides the proportional gain value (of type
     *         <code>NUMERICTYPE</code>) currently in use.
     */
    NUMERICTYPE getProportionalGain();

    /**
     * @return Provides the integral gain value (of type
     *         <code>NUMERICTYPE</code>) currently in use.
     */
    NUMERICTYPE getIntegralGain();

    /**
     * @return Provides the derivative gain value (of type
     *         <code>NUMERICTYPE</code>) currently in use.
     */
    NUMERICTYPE getDerivativeGain();

    /**
     * @return The object being used for integrate the error signal.
     */
    IIntegrate<NUMERICTYPE, INTEGRATOR_ARGS_TYPE> getItegratorComponent();

    /**
     * @return The object being used to derivate the error signal.
     */
    IDifferentiate<NUMERICTYPE, DIFFERENTIATOR_ARGS_TYPE> getDerivativeComponent();
}
