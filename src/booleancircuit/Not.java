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
public class Not extends UnaryOperator{
    
     public Not(final LogicCircuit op1) {
        this.op1 = op1;
        
    }

    @Override
    public boolean evaluate() {
        return (!this.op1.evaluate());
    }
    
}
