/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.mitre.caasd.jlcl.interfaces.IPidEvaluationArguments;

/**
 * An argument object for a proportional-only PID controller component.
 * 
 * @author SBOWMAN
 * 
 * @param <NUMERICTYPE>
 *            The numeric type used for input and output.
 */
public class ProportionalOnlyArguments<NUMERICTYPE extends Number> extends ParameterizedExtendsNumber<NUMERICTYPE> implements IPidEvaluationArguments<NUMERICTYPE, NoIntegrationArguments<NUMERICTYPE>, NoDifferentiationArguments<NUMERICTYPE>> {

    /**
     * A final reference to the only integration argument object that should ever be returned.
     */
    private final NoIntegrationArguments<NUMERICTYPE> integratorArgs = new NoIntegrationArguments<NUMERICTYPE>(clazz);
    /**
     * A final reference to the only differentiation argument object that should ever be returned.
     */
    private final NoDifferentiationArguments<NUMERICTYPE> differentiatorArgs = new NoDifferentiationArguments<NUMERICTYPE>(clazz);
    /**
     * The error signal value.
     */
    private NUMERICTYPE errorSignal = null;

    /**
     * Basic constructor.
     * 
     * @param clazz The numeric class, must extend from {@link Number}.
     *            The numeric type used for input & output.
     */
    public ProportionalOnlyArguments(Class<NUMERICTYPE> clazz) {
        super(clazz);
    }

    @Override
    public NUMERICTYPE getErrorSignalValue() {
        return this.errorSignal;
    }

    @Override
    public void updateErrorSignalValue(NUMERICTYPE errorSignal) {
        this.errorSignal = errorSignal;
    }

    @Override
    public void setIntegratorEvaluationArgs(NoIntegrationArguments<NUMERICTYPE> evaluationArgs) {
        // Do nothing.
    }

    @Override
    public NoIntegrationArguments<NUMERICTYPE> getIntegratorEvaluationArgs() {
        return integratorArgs;
    }

    @Override
    public void setDifferentiatorEvaluationArgs(NoDifferentiationArguments<NUMERICTYPE> evaluationArgs) {
        // Do nothing
    }

    @Override
    public NoDifferentiationArguments<NUMERICTYPE> getDifferentiatorEvaluationArgs() {
        return differentiatorArgs;
    }

}
