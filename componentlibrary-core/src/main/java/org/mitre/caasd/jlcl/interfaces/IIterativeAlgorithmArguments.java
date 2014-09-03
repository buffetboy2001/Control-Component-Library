/**
 * 
 */
package org.mitre.caasd.jlcl.interfaces;

/**
 * Any iterative algorithm will require arguments that are specific to the algorithm. This interface
 * acts as the super, containing methods that are common to all iterative solution processes.
 * 
 * @author sbowman
 * 
 */
public interface IIterativeAlgorithmArguments<NUMERICTYPE extends Number> {

    /**
     * @return the step size value.
     */
    NUMERICTYPE getStepSize();

}
