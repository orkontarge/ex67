package oop.ex6.variables.exception;

import oop.ex6.line.exception.SyntaxException;

public class WrongValueTypeException extends SyntaxException {
    private static final String ERROR_MESSAGE = "Wrong Value Type";
    public WrongValueTypeException(){
    }

   public String getErrorMessage(){
        return ERROR_MESSAGE;
   }
}
