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
public interface BinaryOperatorFactory {
    
    public BinaryOperator create(BinaryOperator.Type type, LogicCircuit lhs, LogicCircuit rhs);
}
