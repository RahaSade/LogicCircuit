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
public class BinaryOperatorFactoryImpl implements BinaryOperatorFactory {

    @Override
    public BinaryOperator create(Type type, LogicCircuit lhs, LogicCircuit rhs) {
        switch(type) {
            case AND:
                return new And(lhs, rhs);
            case OR:
                return new Or(lhs, rhs);
            default:
                throw new TypeNotPresentException(type.name(), null);
        }
    }
    
}
