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
class Not extends UnaryOperator {

    Not(LogicCircuit op1) {
        super(op1);
    }

    @Override
    public boolean evaluate() {
        return (!this.op1.evaluate());
    }

    @Override
    public double doubleEvaluate() {
        return 1 - this.op1.doubleEvaluate();
    }

}
