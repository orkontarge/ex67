package oop.ex6.line;

import oop.ex6.line.exception.LogicException;
import oop.ex6.line.exception.SyntaxException;
import oop.ex6.variables.exception.ChangedFinalValueException;
import oop.ex6.variables.exception.WrongValueTypeException;

public class MethodLine implements checkLines {
    private RegularLine regularLineComposition;

    MethodLine(String line) {

    }

    @Override
    public void checkSyntax() throws SyntaxException {

    }

    @Override
    public void checkLogic() throws LogicException, WrongValueTypeException, WrongValueTypeException, ChangedFinalValueException {

    }

    @Override
    public void createVariable(String type, int scope, String Method, String name, boolean Final, String value) {

    }

    @Override
    public void checkLine() throws LogicException, SyntaxException, ChangedFinalValueException {

    }
}
