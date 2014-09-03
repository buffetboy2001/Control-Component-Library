/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.mitre.caasd.jlcl.interfaces.IDifferentiate;

/**
 * An abstract implementation of a fixed-step differentiator. This class implements nearly all functionality for a differentiator
 * whose step size is fixed. Subclass and complete the behavior.
 * 
 * @author SBOWMAN
 * 
 */
public abstract class FixedStepDifferentiator<NUMERICTYPE extends Number, DIFFERENTIATOR_ARGS extends FixedStepDiffentiatorArguments<NUMERICTYPE>> extends ParameterizedExtendsNumber<NUMERICTYPE> implements IDifferentiate<NUMERICTYPE, DIFFERENTIATOR_ARGS> {

    public FixedStepDifferentiator(Class<NUMERICTYPE> clazz) {
        super(clazz);
    }

}
