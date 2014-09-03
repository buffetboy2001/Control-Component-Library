/**
 * 
 */
package org.mitre.caasd.jlcl.interfaces;

/**
 * Defines the basic interface for arguments necessary for evaluation of integration objects. Intended to be extended for specialized argument objects.
 * 
 * @author SBOWMAN
 * 
 */
public interface IIntegrationArguments<NUMERICTYPE extends Number> extends IIterativeAlgorithmArguments<NUMERICTYPE> {
    // Populate with methods specific to arguments for integration processes.
}
