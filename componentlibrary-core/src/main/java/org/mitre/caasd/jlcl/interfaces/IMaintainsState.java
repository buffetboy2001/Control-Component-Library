/**
 * 
 */
package org.mitre.caasd.jlcl.interfaces;

/**
 * The control component that implements this interface will privately maintain state variables and values during its operation.
 * 
 * @author SBOWMAN
 * 
 */
public interface IMaintainsState {

    /**
     * Immediately reset all state values to zero.
     */
    void resetStateValues();

}
