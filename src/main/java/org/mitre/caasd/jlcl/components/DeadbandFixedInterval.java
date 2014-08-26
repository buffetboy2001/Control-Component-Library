/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.mitre.caasd.jlcl.interfaces.IControlComponentsArguments;
import org.mitre.caasd.jlcl.interfaces.IDeadband;
import org.mitre.caasd.jlcl.util.ExteriorRegionInterval;

/**
 * @author SBOWMAN
 * 
 * @param <NUMERICTYPE>
 *            The numeric type that will be used to evaluate mathematical operations.
 * 
 */
public class DeadbandFixedInterval<NUMERICTYPE extends Number> extends ControlComponent<NUMERICTYPE, IControlComponentsArguments<NUMERICTYPE>> implements IDeadband<NUMERICTYPE> {

    private final ExteriorRegionInterval<NUMERICTYPE> valueInterval;

    public DeadbandFixedInterval(final Class<NUMERICTYPE> clazz, final ExteriorRegionInterval<NUMERICTYPE> interval) {
        super(clazz);
        this.valueInterval = interval;
    }

    @Override
    protected double evaluateAsDoublePrimitive(final IControlComponentsArguments<NUMERICTYPE> evaluationArguments) {
        NUMERICTYPE value = evaluationArguments.getErrorSignalValue();
        if (valueInterval.isOnTheInterval(value)) {
            return value.doubleValue();
        }
        return 0d;
    }

    @Override
    protected long evaluateAsLongPrimitive(final IControlComponentsArguments<NUMERICTYPE> evaluationArguments) {
        NUMERICTYPE value = evaluationArguments.getErrorSignalValue();
        if (valueInterval.isOnTheInterval(value)) {
            return value.longValue();
        }
        return 0l;
    }

}
