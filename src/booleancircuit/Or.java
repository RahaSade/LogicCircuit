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
class Or extends BinaryOperator{
    
    Or(LogicCircuit op1, LogicCircuit op2) {
        super(op1, op2);
    }

    @Override
    public boolean evaluate() {
        return (this.op1.evaluate() || this.op2.evaluate());
    }
    
     @Override
    public double doubleEvaluate() {
        return 1 - ((1 - this.op1.doubleEvaluate()) * (1 - this.op2.doubleEvaluate()));
    }
    
}
