/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author SBOWMAN
 * 
 */
public class TestParameterizedExtendsNumber {

    @Test
    public void TestZeroAsDouble() {
        Number actualValue = ParameterizedExtendsNumber.getZeroForClazz(Double.class);
        Assert.assertTrue(Double.class.isAssignableFrom(actualValue.getClass()));
    }

    @Test
    public void TestZeroAsLong() {
        Number actualValue = ParameterizedExtendsNumber.getZeroForClazz(Long.class);
        Assert.assertTrue(Long.class.isAssignableFrom(actualValue.getClass()));
    }

    @Test
    public void TestZeroAsFloat() {
        Number actualValue = ParameterizedExtendsNumber.getZeroForClazz(Float.class);
        Assert.assertTrue(Double.class.isAssignableFrom(actualValue.getClass()));
    }

    @Test
    public void TestZeroAsShort() {
        Number actualValue = ParameterizedExtendsNumber.getZeroForClazz(Short.class);
        Assert.assertTrue(Long.class.isAssignableFrom(actualValue.getClass()));
    }

    @Test
    public void TestZeroAsInteger() {
        Number actualValue = ParameterizedExtendsNumber.getZeroForClazz(Integer.class);
        Assert.assertTrue(Long.class.isAssignableFrom(actualValue.getClass()));
    }

    @Test
    public void TestZeroValueAsDouble() {
        Double expectedValue = new Double(0);
        Number actualValue = ParameterizedExtendsNumber.getZeroForClazz(Double.class);
        Assert.assertEquals(expectedValue.doubleValue(), actualValue.doubleValue(), 0);
    }

    @Test
    public void TestZeroValueAsLong() {
        Long expectedValue = new Long(0);
        Number actualValue = ParameterizedExtendsNumber.getZeroForClazz(Double.class);
        Assert.assertEquals(expectedValue.longValue(), actualValue.longValue(), 0);
    }
}
