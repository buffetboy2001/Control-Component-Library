/**
 * 
 */
package org.mitre.caasd.jlcl.interfaces;

/**
 * @author SBOWMAN
 * 
 */
public interface IPIDControllerArguments<NUMERICTYPE extends Number, INTEGRATOR_ARGS_TYPE extends IIntegrationArguments<NUMERICTYPE>, DIFFERENTIATION_ARGS_TYPE extends IDifferentiateArguments<NUMERICTYPE>>
        extends IPidEvaluationArguments<NUMERICTYPE, INTEGRATOR_ARGS_TYPE, DIFFERENTIATION_ARGS_TYPE> {

}
