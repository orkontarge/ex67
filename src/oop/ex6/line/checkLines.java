package oop.ex6.line;

import oop.ex6.line.exception.LogicException;
import oop.ex6.line.exception.SyntaxException;
import oop.ex6.variables.exception.ChangedFinalValueException;
import oop.ex6.variables.exception.WrongValueTypeException;

/**
 * this interface has the basic Methods for checking lines
 */

public interface checkLines {
    /**
     * this function checks the syntax of the oop.ex6.line
     */
    public void checkSyntax() throws SyntaxException;

    /**
     * this function checks the logic of the oop.ex6.line. that means if there is no syntax problem but still
     * sJavac can't read that oop.ex6.line.
     */
    public void checkLogic() throws LogicException, WrongValueTypeException, WrongValueTypeException, ChangedFinalValueException;

    /**
     * if needs and possible, creates a oop.ex6.variable
     */
    public void createVariable(String type,int scope,String Method,String name,boolean Final,String value);

    /**
     * check if the oop.ex6.line is fine from every perspective
     */
    public void checkLine() throws LogicException, SyntaxException, ChangedFinalValueException;
}
