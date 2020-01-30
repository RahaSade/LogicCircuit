/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import booleancircuit.LogicCircuit;
import booleancircuit.Operand;
import booleancircuit.OperatorType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 20195003
 */
public class API2JUnitTest extends APIJUnitTest {

    public API2JUnitTest() {
    }

//    static {
//        // your code shall run without any permissions
//    }
//    @Test
//    public RealTest(String testName) {
//        super(testName);
//    }
    /**
     * First of all create a circuit which will evaluate expression (x1 and x2)
     * or not(x1). Hold the circuit in some variable.
     *
     * Feed this circuit with x1=true, x2=false, assert result is false
     *
     * Feed the same circuit with x1=false, x2=true, assert result is true
     *
     * Feed the same circuit with x1=0.0, x2=1.0, assert result is 1.0
     *
     * Feed the same circuit with x1=0.5, x2=0.5, assert result is 0.625
     *
     * Feed the same circuit with x1=0.0, x2=2.0, make sure it throws an
     * exception
     */
    @Test
    public void testX1andX2orNotX1() {

        Operand x1 = operandFactory.create();
        Operand x2 = operandFactory.create();
        LogicCircuit circuit = operatorFactory.create(OperatorType.Binary.OR,
                operatorFactory.create(OperatorType.Binary.AND, x1, x2), operatorFactory.create(OperatorType.Unary.NOT, x1));
        x1.setValue(true);
        x2.setValue(false);
        assertFalse(circuit.evaluate());

        x1.setValue(false);
        x2.setValue(true);
        assertTrue(circuit.evaluate());

        x1.setValue(0.0);
        x2.setValue(1.0);
        assertEquals(circuit.doubleEvaluate(), 1.0, 0.0);

        x1.setValue(0.5);
        x2.setValue(0.5);
        assertTrue(circuit.doubleEvaluate() == 0.625);
        assertEquals(circuit.doubleEvaluate(), 0.625, 0.0);

        x1.setValue(0.0);
        x2.setValue(2.0);
        try {
            circuit.doubleEvaluate();
            fail("value out of the expected range!");
        } catch (Exception e) {
            assertEquals(e.getClass(), IllegalStateException.class);
        }

    }

    /**
     * Ensure that one variable cannot be filled with two different values.
     * Create a circuit for x1 and x1. Make sure that for any usage of your API
     * that would not lead to x1 * x1 result, an exception is thrown. For
     * example if there was a way to feed the circuit with two different values
     * 0.3 and 0.5 an exception is thrown indicating that this is improper use
     * of the circuit.
     */
    @Test
    public void testImproperUseOfTheCircuit() {
        //fail("testImproperUseOfTheCircuit");
    }

    /**
     * Write your own element type called "gte" that will have two inputs and
     * one output. The output value will be 1 if x1 >= x2 and 0 otherwise.
     *
     * Create circuit for following expression: (x1 and not(x1)) gte x1
     *
     * Feed the circuit with 0.5 and verify the result is 0
     *
     * Feed the same circuit with 1 and verify the result is 0
     *
     * Feed the same circuit with 0 and verify the result is 1
     */
    @Test
    public void testGreaterThanElement() {
        Operand x1 = operandFactory.create();
        LogicCircuit circuit =  new GTE(
                operatorFactory.create(
                        OperatorType.Binary.AND,x1, 
                        operatorFactory.create(
                                OperatorType.Unary.NOT,x1)), 
                x1);
        
        x1.setValue(0.5);
        assertEquals(circuit.doubleEvaluate(), 0.0, 0.0);
    
        x1.setValue(1.0);
        assertEquals(circuit.doubleEvaluate(), 0.0, 0.0);

        x1.setValue(0.0);
        assertEquals(circuit.doubleEvaluate(), 1.0, 0.0);
        
        x1.setValue(true);
        assertFalse(circuit.evaluate());
        
        x1.setValue(false);
        assertTrue(circuit.evaluate());
    }
    
    
    class GTE implements LogicCircuit
    {
        LogicCircuit op1;
        LogicCircuit op2;

        public GTE(LogicCircuit op1, LogicCircuit op2) {
            this.op1 = op1;
            this.op2 = op2;
        }        
        
        @Override
        public boolean evaluate() {
            return this.op1.doubleEvaluate() >= this.op2.doubleEvaluate();
        }

        @Override
        public double doubleEvaluate() {
            return this.op1.doubleEvaluate() >= this.op2.doubleEvaluate() ? 1.0 : 0.0;
        }
        
    }
    
    @Test(expected = IllegalStateException.class)
    public void testBooleanDoubleEvaluate() {
        Operand op = operandFactory.create();
        op.setValue(true);
        op.setValue(0.5);       
        op.evaluate();
    }
}
