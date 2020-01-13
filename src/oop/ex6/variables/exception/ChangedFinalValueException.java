package oop.ex6.variables.exception;

public class ChangedFinalValueException extends Exception{
    private static final String ERROR_MESSAGE = "Cannot change value of a Final oop.ex6.variable";
    public ChangedFinalValueException(){}
    public String getErrorMessage(){
        return ERROR_MESSAGE;
    }

}
