package oop.ex6.line.exception;

public class DeclaredVariableException extends LogicException {
    private static final String ERROR_MESSAGE = "Variable was already declared";
    /**
     * this class signals if there is a oop.ex6.variable that declared twice
     */
    public DeclaredVariableException(){
    super(ERROR_MESSAGE);
    }
    public DeclaredVariableException(String s){
        super(s);
    }



}
