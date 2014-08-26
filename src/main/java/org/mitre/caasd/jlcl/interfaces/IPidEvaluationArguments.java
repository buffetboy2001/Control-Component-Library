/**
 * 
 */
package org.mitre.caasd.jlcl.interfaces;

/**
 * @author SBOWMAN
 * 
 */
public interface IPidEvaluationArguments<NUMERICTYPE extends Number, INTEGRATOR_ARGS_TYPE extends IIntegrationArguments<NUMERICTYPE>, DIFFERENTIATOR_ARGS_TYPE extends IDifferentiateArguments<NUMERICTYPE>> extends IControlComponentsArguments<NUMERICTYPE> {

    /**
     * @param evaluationArgs
     *            Set the evaluation argument object.
     */
    void setIntegratorEvaluationArgs(INTEGRATOR_ARGS_TYPE evaluationArgs);

    /**
     * @return Provides the evaluation argument object needed to evaluate the PID.
     */
    INTEGRATOR_ARGS_TYPE getIntegratorEvaluationArgs();

    /**
     * @param evaluationArgs
     *            Set the evaluation argument object.
     */
    void setDifferentiatorEvaluationArgs(DIFFERENTIATOR_ARGS_TYPE evaluationArgs);

    /**
     * @return Provides the evaluation argument object needed to evaluate the PID.
     */
    DIFFERENTIATOR_ARGS_TYPE getDifferentiatorEvaluationArgs();
}
