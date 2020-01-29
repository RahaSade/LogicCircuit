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
public class UnaryOperatorFactoryImpl implements UnaryOperatorFactory {

    @Override
    public UnaryOperator create(UnaryOperator.Type type, LogicCircuit operand) {
        switch (type) {
            case NOT:
                return new Not(operand);
            default:
                throw new TypeNotPresentException(type.name(), null);
        }
    }
    
}
