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
public class OperandFactoryImpl implements OperandFactory{

    @Override
    public Operand create() {
        return new OperandImpl();
    }
    
}
