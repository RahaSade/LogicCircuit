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
public interface LogicCircuitAPI {
    
    public boolean and(boolean op1, boolean op2);
    public boolean or(boolean op1, boolean op2);
    public boolean not(boolean op1);
    
}
