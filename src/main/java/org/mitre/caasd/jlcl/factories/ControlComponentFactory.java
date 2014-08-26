package org.mitre.caasd.jlcl.factories;

import org.mitre.caasd.jlcl.components.NoDifferentiation;
import org.mitre.caasd.jlcl.components.NoDifferentiationArguments;
import org.mitre.caasd.jlcl.components.NoIntegration;
import org.mitre.caasd.jlcl.components.NoIntegrationArguments;
import org.mitre.caasd.jlcl.components.PID;
import org.mitre.caasd.jlcl.interfaces.IPID;

/**
 * A factory that produces linear control components.
 * 
 * @author SBOWMAN
 * 
 */
public final class ControlComponentFactory { // Is this really a factory? Check against the proper pattern definition.

    /**
     * Do not allow instantiation of the factory.
     */
    private ControlComponentFactory() {
        // nothing. just a private constructor
    }

    /**
     * Create a simple PID control component whose input and output types are of type <code>clazz</code> and that only uses a proportional gain of value <code>kp</code>.
     * Valid class types for the PID component are: Double, Float, Long, Short, and Integer.
     * <p>
     * Use of this method is discouraged because an unchecked cast will be required by the caller in order to use the returned object.
     * 
     * @param clazz
     *            The class of the data type to be used for the control component.
     * @param kp
     *            The proportional gain value to be used.
     * @return A fully configured PID control component that has only a proportional gain value of <code>kp</code>.
     */
    @Deprecated
    public static IPID<?, ?, ?, ?, ?> createSimpleProportionalOnlyPid(Class<? extends Number> clazz, Number kp) {
        if (Double.class.isAssignableFrom(clazz)) {
            // Treat as Double
            return createProportionalOnlyPidComponentAsDouble(kp.doubleValue());
        }
        if (Float.class.isAssignableFrom(clazz)) {
            // Treat as Float
            return createProportionalOnlyPidComponentAsFloat(kp.floatValue());
        }
        if (Long.class.isAssignableFrom(clazz)) {
            // Treat as Long
            return createProportionalOnlyPidComponentAsLong(kp.longValue());
        }
        if (Short.class.isAssignableFrom(clazz)) {
            // Treat as Short
            return createProportionalOnlyPidComponentAsShort(kp.shortValue());
        }
        if (Integer.class.isAssignableFrom(clazz)) {
            // Treat as Integer
            return createProportionalOnlyPidComponentAsInteger(kp.intValue());
        }
        return null;
    }

    /**
     * Create a simple PID control component whose input and output types are <code>Double</code> and that only uses a proportional gain.
     * 
     * @param kp
     *            The proportional gain value to be used.
     * @return a fully constructed PID component
     * @see org.mitre.caasd.jlcl.components.PID
     */
    public static IPID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>> createProportionalOnlyPidComponentAsDouble(final Double kp) {
        return new PID<Double, NoIntegration<Double>, NoIntegrationArguments<Double>, NoDifferentiation<Double>, NoDifferentiationArguments<Double>>(Double.class, kp, new NoIntegration<Double>(Double.class), 0d, new NoDifferentiation<Double>(Double.class), 0d);
    }

    /**
     * Create a simple PID control component whose input and output types are <code>Long</code> and that only uses a proportional gain.
     * 
     * @param kp
     *            The proportional gain value to be used.
     * @return a fully constructed PID component
     * @see org.mitre.caasd.jlcl.components.PID
     */
    public static IPID<Long, NoIntegration<Long>, NoIntegrationArguments<Long>, NoDifferentiation<Long>, NoDifferentiationArguments<Long>> createProportionalOnlyPidComponentAsLong(final Long kp) {
        return new PID<Long, NoIntegration<Long>, NoIntegrationArguments<Long>, NoDifferentiation<Long>, NoDifferentiationArguments<Long>>(Long.class, kp, new NoIntegration<Long>(Long.class), 0l, new NoDifferentiation<Long>(Long.class), 0l);
    }

    /**
     * Create a simple PID control component whose input and output types are <code>Float</code> and that only uses a proportional gain.
     * 
     * @param kp
     *            The proportional gain value to be used.
     * @return a fully constructed PID component
     * @see org.mitre.caasd.jlcl.components.PID
     */
    public static IPID<Float, NoIntegration<Float>, NoIntegrationArguments<Float>, NoDifferentiation<Float>, NoDifferentiationArguments<Float>> createProportionalOnlyPidComponentAsFloat(final Float kp) {
        return new PID<Float, NoIntegration<Float>, NoIntegrationArguments<Float>, NoDifferentiation<Float>, NoDifferentiationArguments<Float>>(Float.class, kp, new NoIntegration<Float>(Float.class), 0f, new NoDifferentiation<Float>(Float.class), 0f);
    }

    /**
     * Create a simple PID control component whose input and output types are <code>Integer</code> and that only uses a proportional gain.
     * 
     * @param kp
     *            The proportional gain value to be used.
     * @return a fully constructed PID component
     * @see org.mitre.caasd.jlcl.components.PID
     */
    public static IPID<Integer, NoIntegration<Integer>, NoIntegrationArguments<Integer>, NoDifferentiation<Integer>, NoDifferentiationArguments<Integer>> createProportionalOnlyPidComponentAsInteger(final Integer kp) {
        return new PID<Integer, NoIntegration<Integer>, NoIntegrationArguments<Integer>, NoDifferentiation<Integer>, NoDifferentiationArguments<Integer>>(Integer.class, kp, new NoIntegration<Integer>(Integer.class), 0, new NoDifferentiation<Integer>(Integer.class), 0);
    }

    /**
     * Create a simple PID control component whose input and output types are <code>Short</code> and that only uses a proportional gain.
     * 
     * @param kp
     *            The proportional gain value to be used.
     * @return a fully constructed PID component
     * @see org.mitre.caasd.jlcl.components.PID
     */
    public static IPID<Short, NoIntegration<Short>, NoIntegrationArguments<Short>, NoDifferentiation<Short>, NoDifferentiationArguments<Short>> createProportionalOnlyPidComponentAsShort(final Short kp) {
        return new PID<Short, NoIntegration<Short>, NoIntegrationArguments<Short>, NoDifferentiation<Short>, NoDifferentiationArguments<Short>>(Short.class, kp, new NoIntegration<Short>(Short.class), (short) 0, new NoDifferentiation<Short>(Short.class), (short) 0);
    }
}
