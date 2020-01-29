/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booleancircuit;

/**
 *
 * @author 20195003
 */
public abstract class UnaryOperator implements LogicCircuit {    
    
    public static enum Type {
        NOT
    }
    
    final protected LogicCircuit op1;

    protected UnaryOperator(LogicCircuit op1) {
        this.op1 = op1;
    }
}
