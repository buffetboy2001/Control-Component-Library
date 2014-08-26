/**
 * 
 */
package org.mitre.caasd.jlcl.components;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.mitre.caasd.jlcl.interfaces.IMaintainsState;

/**
 * 
 * @author SBOWMAN
 * 
 */
@RunWith(Parameterized.class)
public class TestStateMaintainingObjects {

    private IMaintainsState testObject;

    public TestStateMaintainingObjects(IMaintainsState objectThatMaintainsState) {
        this.testObject = objectThatMaintainsState;
    }

    @Parameters
    public static List<Object[]> getTestClasses() {
        List<Object[]> returnThis = new ArrayList<Object[]>();
        List<IMaintainsState> stateMaintaintersToTest = new ArrayList<IMaintainsState>();

        /*
         * Append to this list any objects that maintain state. They will be tested for basic functionality.
         */
        stateMaintaintersToTest.add(new NoIntegration<Double>(Double.class));
        stateMaintaintersToTest.add(new NoDifferentiation<Double>(Double.class));
        stateMaintaintersToTest.add(new FixedStepEulerIntegration<Double>(Double.class, new FixedStepIntegrationArguments<Double>(Double.class, 1d)));
        stateMaintaintersToTest.add(new TrapezoidalIntegration<Double>(Double.class, new TrapezoidalIntegrationArguments<Double>(Double.class, 1d)));

        // Convert to the output type
        for (IMaintainsState ms : stateMaintaintersToTest) {
            Object[] o = { ms };
            returnThis.add(o);
        }
        return returnThis;
    }

    /**
     * Ensure the method <code>resetStateValues()</code> does not throw an exception.
     */
    @Test
    public void testStateValueResetMethod() {
        try {
            testObject.resetStateValues();
        } catch (Exception e) {
            fail("Exceptions occurred when resetting the object's state.");
        }
    }

}
