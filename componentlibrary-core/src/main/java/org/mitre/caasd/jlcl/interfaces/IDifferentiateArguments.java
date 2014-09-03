/**
 * 
 */
package org.mitre.caasd.jlcl.interfaces;

/**
 * Defines the basic interface for arguments needed for evaluation of differentiator objects. Intended to be extended for specialized argument objects.
 * 
 * @author SBOWMAN
 * 
 */
public interface IDifferentiateArguments<NUMERICTYPE extends Number> extends IIterativeAlgorithmArguments<NUMERICTYPE> {
    // Populate with methods specific to arguments for differentation processes.
}
