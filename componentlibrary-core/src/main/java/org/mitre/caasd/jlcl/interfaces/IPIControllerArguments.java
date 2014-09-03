/**
 * 
 */
package org.mitre.caasd.jlcl.interfaces;

import org.mitre.caasd.jlcl.components.NoDifferentiationArguments;

/**
 * @author SBOWMAN
 * 
 */
public interface IPIControllerArguments<NUMERICTYPE extends Number, INTEGRATOR_ARGS_TYPE extends IIntegrationArguments<NUMERICTYPE>> extends IPidEvaluationArguments<NUMERICTYPE, INTEGRATOR_ARGS_TYPE, NoDifferentiationArguments<NUMERICTYPE>> {

}
