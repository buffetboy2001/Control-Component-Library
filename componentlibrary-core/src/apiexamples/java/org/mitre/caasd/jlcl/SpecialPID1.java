/**
 * 
 */
package org.mitre.caasd.jlcl;

import org.mitre.caasd.jlcl.components.PIController;
import org.mitre.caasd.jlcl.components.PID;
import org.mitre.caasd.jlcl.components.ParameterizedExtendsNumber;
import org.mitre.caasd.jlcl.components.ProportionalIntegralArguments;
import org.mitre.caasd.jlcl.interfaces.IDifferentiate;
import org.mitre.caasd.jlcl.interfaces.IDifferentiateArguments;
import org.mitre.caasd.jlcl.interfaces.IIntegrate;
import org.mitre.caasd.jlcl.interfaces.IIntegrationArguments;
import org.mitre.caasd.jlcl.interfaces.IPIControllerArguments;
import org.mitre.caasd.jlcl.interfaces.IPID;
import org.mitre.caasd.jlcl.interfaces.IPidEvaluationArguments;

/**
 * An attempt to create a PI-D control component using the JLCL architecture. The derivative term is applied to the feedback
 * signal rather than the error signal. The proportional gain term is applied to the output of the entire operation rather than
 * just the proportional term.
 * 
 * The point here is to create a new component from the ground up using the interfaces available (e.g. IPID, etc), and that does
 * not extend {@link PID}. If the API has been designed correctly, this
 * kind of component should not be difficult to create.
 * 
 * See Ogata, pg 680.
 * 
 * @author sbowman
 * 
 * @param <NUMERICTYPE>
 * @param <INTEGRATE>
 * @param <INTEGRATOR_ARGS_TYPE>
 * @param <DIFFERENTIATE>
 * @param <DIFFERENTIATOR_ARGS_TYPE>
 */
public class SpecialPID1<NUMERICTYPE extends Number, INTEGRATE extends IIntegrate<NUMERICTYPE, INTEGRATOR_ARGS_TYPE>, INTEGRATOR_ARGS_TYPE extends IIntegrationArguments<NUMERICTYPE>, DIFFERENTIATE extends IDifferentiate<NUMERICTYPE, DIFFERENTIATOR_ARGS_TYPE>, DIFFERENTIATOR_ARGS_TYPE extends IDifferentiateArguments<NUMERICTYPE>> extends ParameterizedExtendsNumber<NUMERICTYPE> implements IPID<NUMERICTYPE, INTEGRATE, INTEGRATOR_ARGS_TYPE, DIFFERENTIATE, DIFFERENTIATOR_ARGS_TYPE> {

    private PIController<NUMERICTYPE, INTEGRATE, INTEGRATOR_ARGS_TYPE> piController = null;
    private DIFFERENTIATE derivator = null;
    private NUMERICTYPE kd = null;

    public SpecialPID1(Class<NUMERICTYPE> clazz, NUMERICTYPE proportionalGain, NUMERICTYPE integratorGain, INTEGRATE integratorInstance, DIFFERENTIATE derivator, NUMERICTYPE derivativeGain) {
        super(clazz);

        piController = new PIController<NUMERICTYPE, INTEGRATE, INTEGRATOR_ARGS_TYPE>(clazz, proportionalGain, integratorInstance, integratorGain);
        this.derivator = derivator;
        updateDerivativeGain(derivativeGain);
    }

    @Override
    public NUMERICTYPE evaluate(IPidEvaluationArguments<NUMERICTYPE, INTEGRATOR_ARGS_TYPE, DIFFERENTIATOR_ARGS_TYPE> evaluationArguments) {
        IPIControllerArguments<NUMERICTYPE, INTEGRATOR_ARGS_TYPE> piArgs = new ProportionalIntegralArguments<NUMERICTYPE, INTEGRATOR_ARGS_TYPE>(clazz, evaluationArguments.getErrorSignalValue(), evaluationArguments.getIntegratorEvaluationArgs());
        if (this.performCalculationsAsDoublePrimitive) {
            // use double primitive
            double piResult = piController.evaluate(piArgs).doubleValue();
            double dResult = kd.doubleValue() * derivator.differentiate(evaluationArguments.getDifferentiatorEvaluationArgs(), evaluationArguments.getErrorSignalValue()).doubleValue(); // FIXME need the reference, not error signal
            double controlOuput = 0d;
            controlOuput += piResult;
            controlOuput += dResult;
            return this.convertToOutputType(controlOuput);
        } else {
            // use long primitive via string conversion (which does not contain any loss of precision)
            System.out.println("not implemented");
            long controlOuput = 0l;
            return this.convertToOutputType(controlOuput);
        }
    }

    @Override
    public void resetStateValues() {
        piController.resetStateValues();
        derivator.resetStateValues();
    }

    @Override
    public void updateProportionalGain(NUMERICTYPE kp) {
        piController.updateProportionalGain(kp);
    }

    @Override
    public void updateIntegralGain(NUMERICTYPE ki) {
        piController.updateIntegralGain(ki);
    }

    @Override
    public void updateDerivativeGain(NUMERICTYPE kd) {
        this.kd = kd;
    }

    @Override
    public NUMERICTYPE getProportionalGain() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NUMERICTYPE getIntegralGain() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NUMERICTYPE getDerivativeGain() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IIntegrate<NUMERICTYPE, INTEGRATOR_ARGS_TYPE> getItegratorComponent() {
        return piController.getItegratorComponent();
    }

    @Override
    public IDifferentiate<NUMERICTYPE, DIFFERENTIATOR_ARGS_TYPE> getDerivativeComponent() {
        return derivator;
    }

}
