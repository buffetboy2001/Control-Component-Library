/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.mitre.caasd.jlcl.interfaces.IFixedStepIntegratorArguments;

/**
 * This class does not contain a setter, so the value cannot be updated within
 * the lifetime of the object.
 * 
 * @author SBOWMAN
 * 
 */
public class FixedStepIntegrationArguments<NUMERICTYPE extends Number> extends FixedStepIterativeAlgorithmArguments<NUMERICTYPE> implements
        IFixedStepIntegratorArguments<NUMERICTYPE> {

    /**
     * Constructor.
     * 
     * @param clazz
     *            The numeric class, must extend from {@link Number}.
     * @param fixedStepSize
     *            The step size to be used for integration arguements.
     */
    public FixedStepIntegrationArguments(Class<NUMERICTYPE> clazz, NUMERICTYPE fixedStepSize) {
        super(clazz, fixedStepSize);
    }

}
