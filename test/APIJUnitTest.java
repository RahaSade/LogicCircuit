/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import booleancircuit.OperatorFactory;
import booleancircuit.OperandFactory;

import booleancircuit.Operand;
import booleancircuit.LogicCircuit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import booleancircuit.OperatorType.*;


/**
 *
 * @author 20195003
 */
public class APIJUnitTest {

    protected OperatorFactory operatorFactory;
    protected OperandFactory operandFactory; 
    
    public APIJUnitTest() {       
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        operatorFactory = new OperatorFactory();
        operandFactory = new OperandFactory();
        
    }
    
    @After
    public void tearDown() {
    }
    
    
    //------------------------------------------------
    
    /** 
     * Create a circuit to evaluate x1 and x2 and then
     * verify that its result is false for input (false, true) and
     * it is true for input (true, true).
     */
    @Test
    public void testX1andX2() {
          Operand x1 = operandFactory.create();
          Operand x2 = operandFactory.create();
          LogicCircuit circuit = operatorFactory.create(Binary.AND, x1, x2);
          x1.setValue(false);
          x2.setValue(true);
          assertFalse(circuit.evaluate());
          
          x1.setValue(true);
          x2.setValue(true);
          assertTrue(circuit.evaluate());
    }
    
    /** 
     * Create a circuit to evaluate (x1 and x2) or x3 and then
     * verify that its result is false for input (false, true, false) and
     * it is true for input (false, false, true).
     */
    @Test
    public void testX1andX2orX3() {
          Operand x1 = operandFactory.create();
          Operand x2 = operandFactory.create();
          Operand x3 = operandFactory.create();
          
          LogicCircuit circuit = operatorFactory.create(Binary.OR, 
                  operatorFactory.create(Binary.AND, x1,x2), x3);
          
          x1.setValue(false);
          x2.setValue(true);
          x3.setValue(false);
          
          assertFalse(circuit.evaluate());
          
          x1.setValue(false);
          x2.setValue(false);
          x3.setValue(true);
          
          assertTrue(circuit.evaluate());
    }
    /** 
     * Create a circuit to evaluate (x1 or not(x1)) and then
     * verify that its result is true for all values of x1.
     */
    @Test
    public void testAlwaysTrue() {
          Operand x1 = operandFactory.create();
          LogicCircuit circuit = operatorFactory.create(Binary.OR, 
                  x1, operatorFactory.create(Unary.NOT, x1));
          x1.setValue(false);
          assertTrue(circuit.evaluate());
          
          x1.setValue(true);
          assertTrue(circuit.evaluate());
    }

    @Test(expected = IllegalStateException.class)
    public void testNoValue() {
        Operand x1 = operandFactory.create();
        LogicCircuit circuit = x1;
        circuit.evaluate();
    }
    
    //-----------------------------------------------------
  
}
