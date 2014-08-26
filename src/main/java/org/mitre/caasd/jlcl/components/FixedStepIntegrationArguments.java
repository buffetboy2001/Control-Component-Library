/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.mitre.caasd.jlcl.interfaces.IFixedStepIntegratorArguments;

/**
 * This class does not contain a setter, so the value cannot be updated within the lifetime of the object.
 * 
 * @author SBOWMAN
 * 
 */
public class FixedStepIntegrationArguments<NUMERICTYPE extends Number> extends FixedStepIterativeAlgorithmArguments<NUMERICTYPE> implements IFixedStepIntegratorArguments<NUMERICTYPE> {

    /**
     * Constructor.
     */
    public FixedStepIntegrationArguments(Class<NUMERICTYPE> clazz, NUMERICTYPE fixedStepSize) {
        super(clazz,fixedStepSize);
    }

}
