package org.mitre.caasd.jlcl.interfaces;

/**
 * The super interface that all control components must implement. The parameter
 * variable is used to define the input/output date type that a component will
 * operate on.
 * 
 * @author SBOWMAN
 * 
 * @param <NUMERICTYPE>
 *            The data type that will be input and returned by this class.
 * @param <CONTROL_EVALUATION_ARGS>
 *            The argument object used to evaluate the control component.
 */
public interface ILinearControlComponent<NUMERICTYPE extends Number, CONTROL_EVALUATION_ARGS extends IControlComponentsArguments<NUMERICTYPE>> {

    /**
     * Evaluate the linear control law component by providing it the current evaluation arguments which it will operate on.
     * 
     * @param evaluationArguments
     *            The fully populated evaluation argument object needed to evaluate the control component.
     * @return NUMERICTYPE The numeric result of the control component.
     */
    NUMERICTYPE evaluate(final CONTROL_EVALUATION_ARGS evaluationArguments);
}
