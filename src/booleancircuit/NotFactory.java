/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booleancircuit;

/**
 *
 * @author s132054
 */
public class NotFactory implements UnaryFactory {

    @Override
    public LogicCircuit create(LogicCircuit operand) {
        return new Not(operand);
    }
    
}
