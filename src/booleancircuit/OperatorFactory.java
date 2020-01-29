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
public class OperatorFactory  {

    public LogicCircuit create(OperatorType type, LogicCircuit lhs, LogicCircuit rhs) {
        switch (type) {
            case AND:
                return new And(lhs, rhs);
            case OR:
                return new Or(lhs, rhs);
            case NOT:
                throw new IllegalStateException("only one operand is required");
            default:
                throw new TypeNotPresentException(type.name(), null);
        }
    }

   
    public LogicCircuit create(OperatorType type, LogicCircuit lc) {
        switch (type) {
            case AND:
                throw new IllegalStateException("Two operands are needed");
            case OR:
                throw new IllegalStateException("Two operands are needed");
            case NOT:
                return new Not(lc);
            default:
                throw new TypeNotPresentException(type.name(), null);
        }
    }

   
}
