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
public class Operand implements LogicCircuit{

      private Boolean value;

   
    public void setValue(boolean value) {
        this.value = value;
    }
   
    
    @Override
    public boolean evaluate() {
        if(value==null)
            throw new IllegalStateException("No value!");
        return value;
    }
    
    
}
