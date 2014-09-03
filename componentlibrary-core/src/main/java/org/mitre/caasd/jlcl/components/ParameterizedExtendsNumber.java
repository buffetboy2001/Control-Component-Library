/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * All classes which are parameterized on a type that extends <code>Number</code> and that
 * contain outward facing methods that return <code>NUMERICTYPE</code> should subclass from
 * this abstract class. This class takes on the load of type characterization which
 * must be performed upon construction of all objects.
 * 
 * @author SBOWMAN
 * 
 * @param <NUMERICTYPE>
 *            The data type that will be input and returned by this class.
 */
public abstract class ParameterizedExtendsNumber<NUMERICTYPE extends Number> {

    /**
     * Use this constructor class in subclasses to massage the output of a mathematical operation (+,-,*,/) into the correct
     * type for return at NUMERICTYPE.
     */
    protected Constructor<NUMERICTYPE> constructorOfNumericType = null;

    /**
     * Use this boolean in subclasses to switch between the primitive type to use for mathematical calculations. Only <code>double</code> and <code>long</code> are to be used.
     */
    protected boolean performCalculationsAsDoublePrimitive = true;

    /**
     * Use this in subclasses when instantiating other objects of type clazz.
     */
    protected Class<NUMERICTYPE> clazz;

    /**
     * The abstract class must do some work to determine at runtime construction which variable type has been requested.
     * 
     * @param clazz
     */
    public ParameterizedExtendsNumber(Class<NUMERICTYPE> clazz) {
        this.clazz = clazz;
        if (Double.class.isAssignableFrom(clazz) || Float.class.isAssignableFrom(clazz)) {
            // use doubleValue()
            try {
                constructorOfNumericType = clazz.getConstructor(double.class);
            } catch (SecurityException e1) {
                e1.printStackTrace();
            } catch (NoSuchMethodException e1) {
                e1.printStackTrace();
            }
            performCalculationsAsDoublePrimitive = true;
        } else {
            try {
                constructorOfNumericType = clazz.getConstructor(String.class);
            } catch (SecurityException e1) {
                e1.printStackTrace();
            } catch (NoSuchMethodException e1) {
                e1.printStackTrace();
            }
            performCalculationsAsDoublePrimitive = false;
        }
    }

    /**
     * If the result of a mathematical operation in a subclass must conform to <code>NUMERICTYPE</code>,
     * call this method.
     * 
     * @param in
     * @return the value of <code>in</code> typed as <code>NUMERICTYPE</code>
     */
    protected final NUMERICTYPE convertToOutputType(final double in) {
        if (performCalculationsAsDoublePrimitive) {
            NUMERICTYPE returnThis = null;
            try {
                returnThis = this.constructorOfNumericType.newInstance(in);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return returnThis;
        } else {
            return convertToOutputType(Double.toString(in));
        }
    }

    /**
     * If the result of a mathematical operation in a subclass must conform to <code>NUMERICTYPE</code>,
     * call this method.
     * 
     * @param in
     * @return the value of <code>in</code> typed as <code>NUMERICTYPE</code>
     */
    protected final NUMERICTYPE convertToOutputType(final String in) {
        if (!performCalculationsAsDoublePrimitive) {
            NUMERICTYPE returnThis = null;
            try {
                returnThis = this.constructorOfNumericType.newInstance(in);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return returnThis;
        } else {
            return null; // TODO use this? convertToOutputType((double) in.);
        }
    }

    /**
     * If the result of a mathematical operation in a subclass must conform to <code>NUMERICTYPE</code>,
     * call this method.
     * 
     * @param in
     * @return the value of <code>in</code> typed as <code>NUMERICTYPE</code>
     */
    protected final NUMERICTYPE convertToOutputType(final long in) {
        return convertToOutputType(Long.toString(in));
    }

    /**
     * A utility method to get zero in it's correctly parameterized type.
     * 
     * @return zero in its correct type
     */
    protected final NUMERICTYPE getZeroAsCorrectType() {
        if (performCalculationsAsDoublePrimitive)
            return convertToOutputType(0d);
        else
            return convertToOutputType("" + 0);
    }

    /**
     * A static utility method to produce the value of zero when only the clazz is known. This is similar to getZeroAtCorrectType(), but the static attribute makes is available in more situations. Warning, the user must cast the returned value correctly!
     * 
     * @param clazz
     *            The numeric class type (extends <code>Number</code>) that should be used to produce zero.
     * @return The value zero as a <code>Number</code>. The caller must cast this as appropriate (usually with a generic type parameter).
     * @see #getZeroAsCorrectType()
     */
    public static final Number getZeroForClazz(Class<? extends Number> clazz) {
        if (Double.class.isAssignableFrom(clazz) || Float.class.isAssignableFrom(clazz)) {
            // use doubleValue()
            return Double.valueOf(0d);
        } else {
            return Long.valueOf(0l);
        }
    }
}
