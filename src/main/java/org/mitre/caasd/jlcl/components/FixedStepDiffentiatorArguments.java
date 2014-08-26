/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.mitre.caasd.jlcl.interfaces.IDifferentiateArguments;

/**
 * A subclass of {@link FixedStepIterativeAlgorithmArguments} that is specific to differentiators. Subclass this
 * to get a guaranteed fixed step size arguments object that can be used with anything that requires {@link IDifferentiateArguments}.
 * 
 * @author SBOWMAN
 * 
 */
public abstract class FixedStepDiffentiatorArguments<NUMERICTYPE extends Number> extends FixedStepIterativeAlgorithmArguments<NUMERICTYPE> implements IDifferentiateArguments<NUMERICTYPE> {

    public FixedStepDiffentiatorArguments(Class<NUMERICTYPE> clazz, NUMERICTYPE fixedStepSize) {
        super(clazz, fixedStepSize);
    }

}
