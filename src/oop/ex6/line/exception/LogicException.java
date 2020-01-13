package oop.ex6.line.exception;

/**
 * this class signals if there is problem with the logic exception of the file
 */
public class LogicException extends Exception {

    public LogicException() {
        super("ERROR: problem with oop.ex6.line logic");

    }

    LogicException(String errorMessage) {
        super(errorMessage);

    }
}