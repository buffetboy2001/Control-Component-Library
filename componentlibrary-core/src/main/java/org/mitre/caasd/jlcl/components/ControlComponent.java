/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.mitre.caasd.jlcl.interfaces.IControlComponentsArguments;
import org.mitre.caasd.jlcl.interfaces.ILinearControlComponent;

/**
 * An abstract control component the implements the basic methods all components
 * are likely to need.
 * 
 * @author SBOWMAN
 * @param <NUMERICTYPE>
 * @param <CONTROL_EVALUATION_ARGS>
 * 
 */
public abstract class ControlComponent<NUMERICTYPE extends Number, CONTROL_EVALUATION_ARGS extends IControlComponentsArguments<NUMERICTYPE>> extends
        ParameterizedExtendsNumber<NUMERICTYPE> implements ILinearControlComponent<NUMERICTYPE, CONTROL_EVALUATION_ARGS> {

    public ControlComponent(Class<NUMERICTYPE> clazz) {
        super(clazz);
    }

    @Override
    public NUMERICTYPE evaluate(final CONTROL_EVALUATION_ARGS evaluationArguments) {
        NUMERICTYPE errorSignal = evaluationArguments.getErrorSignalValue();
        if (errorSignal == null)
            throw new UnsupportedOperationException("Unable to process an error signal value of null.");

        if (this.performCalculationsAsDoublePrimitive) {
            // use double primitive
            return convertToOutputType(evaluateAsDoublePrimitive(evaluationArguments));
        } else {
            // use long primitive
            return convertToOutputType(evaluateAsLongPrimitive(evaluationArguments));
        }
    }

    /**
     * @param evaluationArguments
     * @return The return value.
     */
    protected abstract double evaluateAsDoublePrimitive(final CONTROL_EVALUATION_ARGS evaluationArguments);

    /**
     * @param evaluationArguments
     * @return The return value.
     */
    protected abstract long evaluateAsLongPrimitive(final CONTROL_EVALUATION_ARGS evaluationArguments);

}
