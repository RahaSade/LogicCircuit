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
public class Or extends BinaryOperator{
    
    public Or(LogicCircuit op1, LogicCircuit op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    @Override
    public boolean evaluate() {
        return (this.op1.evaluate() || this.op2.evaluate());
    }
    
}
