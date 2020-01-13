package oop.ex6.line;

import oop.ex6.line.exception.DeclaredVariableException;
import oop.ex6.line.exception.LogicException;
import oop.ex6.line.exception.SyntaxException;
import oop.ex6.main.FileData;
import oop.ex6.main.regex;
import oop.ex6.variables.*;
import oop.ex6.variables.exception.WrongValueTypeException;
import oop.ex6.variables.exception.ChangedFinalValueException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * this class checks all the lines that are in the global scope.
 */
public class RegularLine implements checkLines {

    private String type;
    private Boolean Final;
    private String line;
    private String[] potentialVariables;

    private Matcher commentMatcher;
    private Matcher declarationMatcher;
    private Matcher initializationMatcher;

    public RegularLine(String line) throws SyntaxException, LogicException, ChangedFinalValueException {
        //find if there is Comment
        Pattern commentPattern = Pattern.compile(regex.COMMENT);
        commentMatcher = commentPattern.matcher(line);
        //find if there is Declaration
        Pattern declarationPattern = Pattern.compile(regex.TYPES); //find if there is Declaration
        declarationMatcher = declarationPattern.matcher(line);
        //find if there is initialization
        Pattern initializationPattern = Pattern.compile(regex.EQUALS); //find if there is initialization
        initializationMatcher = initializationPattern.matcher(line);

        this.line = line;
        this.type = findType();
        this.potentialVariables = sortVariables();
        this.Final = thereIsFinal();
        checkLine();

    }

    /**
     * @return true if there is final and false otherwise.
     */
    private Boolean thereIsFinal() {
        Pattern finalPattern = Pattern.compile(regex.FINAL);
        Matcher finalMatcher = finalPattern.matcher(line);
        if (finalMatcher.matches()) {
            return true;
        }
        return false;
    }

    /**
     * find the name of the oop.ex6.variable
     *
     * @param string the string that the oop.ex6.variable is there
     * @return the name of the oop.ex6.variable
     */
    private String findName(String string) {
        String name = string;
        if (string.contains("=")) {
            name = string.substring(0, string.indexOf("="));
        }
        return name;
    }

    /**
     * if there is declaration of oop.ex6.variables, create them.
     *
     * @throws LogicException if there are the same oop.ex6.variables, or syntax problem
     */
    private void findDeclarationVariable() throws LogicException {
        for (String string : potentialVariables) {
            String name = findName(string);
            if (FileData.isDeclaredVariable(0, name)) {
                throw new DeclaredVariableException("there is a oop.ex6.variable that declared twice");
            } else {
                String value = null;
                Pattern localPattern = Pattern.compile(regex.EQUALS);
                Matcher localMatcher = localPattern.matcher(string);
                if (localMatcher.find()) {
                    value = string.substring(string.indexOf("=") + 1);
                    TypeCheck typeCheck = new TypeCheck(type, value);
                    typeCheck.checkType();
                }
                createVariable(type,0,null,name,Final,value);
            }
        }
    }

    /**
     * if there is initialization of oop.ex6.variable and they are fine- out their value
     *
     * @throws LogicException- if it's suppose to be final, or the syntax isn't fine
     */
    private void findInitializationVariable() throws LogicException, ChangedFinalValueException {
        for (String string : potentialVariables) {
            Pattern localPattern = Pattern.compile(regex.EQUALS);
            Matcher localMatcher = localPattern.matcher(string);
            if (localMatcher.find()) { // it's have to be just initialization without declaration
                if (!FileData.isDeclaredVariable(0, string.substring(0, 1))) {
                    throw new DeclaredVariableException("there is a oop.ex6.variable that declared twice");
                } else {
                    Variables variable = FileData.getSpecificDeclaredVariable(0, findName(string));
                    if (variable.getFinal()) {
                        throw new LogicException();
                    }
                    String value = string.substring(string.indexOf("=") + 1);
                    variable.setValue(value);

                }
            }
        }
    }

    /**
     * @return if there is declaration, return the type.
     */
    private String findType() {
        try {
            if (declarationMatcher.find()) {
                return line.substring(declarationMatcher.start(), declarationMatcher.end());
            }
        } catch (NullPointerException e) {
            return null;
        }
        return null;
    }

    /**
     * @return return StringArray of all oop.ex6.variables.
     */
    private String[] sortVariables() throws SyntaxException {
        checkSyntax();
        int startIndexWithoutDec = 0;
        try {
            if (declarationMatcher.find()) {
                startIndexWithoutDec = declarationMatcher.end();
            }
            ;
        } catch (NullPointerException ignored) {
        }
        String lineWithoutType = line.substring(startIndexWithoutDec, line.indexOf(";"));
        String StrVariables = lineWithoutType.replace(" ", "");
        return StrVariables.split(",");
    }

    @Override
    public void checkSyntax() throws SyntaxException {
        //first check- if it's comment oop.ex6.line
        if (!commentMatcher.find()) {
            //second check- if it's oop.ex6.variable comment oop.ex6.line
            Pattern VariablePattern = Pattern.compile(regex.TOTAL);
            Matcher VariableMatcher = VariablePattern.matcher(line);
            if (!VariableMatcher.matches()) {
                throw new SyntaxException();

            }
        }
    }

    @Override
    public void checkLogic() throws LogicException, WrongValueTypeException, ChangedFinalValueException {
        if (commentMatcher.find()) {
            return;
        } else {
            if (declarationMatcher.find()) {
                findDeclarationVariable();
            } else {
                findInitializationVariable();
            }
        }
    }

    @Override
    public void createVariable(String type, int scope, String Method, String name, boolean Final, String value) {
        Variables variable=new Variables(scope,Method,type,name,value,Final);
        FileData.setDeclaredVariables(variable,0);
    }




    @Override
    public void checkLine() throws LogicException, SyntaxException, ChangedFinalValueException {
        checkLogic();
    }


}
