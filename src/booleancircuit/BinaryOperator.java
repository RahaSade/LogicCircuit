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
public abstract class BinaryOperator implements LogicCircuit {
    final protected LogicCircuit op1;
    final protected LogicCircuit op2;

    protected BinaryOperator(LogicCircuit op1, LogicCircuit op2) {
        this.op1 = op1;
        this.op2 = op2;
    }
}
