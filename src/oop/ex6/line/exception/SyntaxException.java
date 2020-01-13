package oop.ex6.line.exception;

/**
 * this class is inherited from Exception and suppose to signal Non-Method-Syntax Error.
 */
public class SyntaxException extends Exception{

    public SyntaxException(){
        super("ERROR: problem with oop.ex6.line syntax");

    }
    SyntaxException(String s){
        super(s);
    }
}
