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
class OperandImpl implements Operand {

    private Boolean value;
    private Double doubleValue;

    @Override
    public void setValue(boolean value) {
        this.value = value;
        this.doubleValue = value ? 1.0 : 0.0;
    }

    @Override
    public void setValue(double value) {
        this.value = null;
        this.doubleValue = value;
    }

    @Override
    public double doubleEvaluate() {
        if (doubleValue == null) {
            throw new IllegalStateException("No value!");
        }
        if (doubleValue > 1.0 || doubleValue < 0.0) {
            throw new IllegalStateException("Value is out of the range!");
        }
        return doubleValue;
    }

    @Override
    public boolean evaluate() {
        if (value == null) {
            throw new IllegalStateException("No value!");
        }
        return value;
    }
}
