package oop.ex6.variables;

import oop.ex6.variables.exception.ChangedFinalValueException;

/**
 * abstract class representing a oop.ex6.variable found in the s-java file.
 * oop.ex6.variable can be of types:int,double,char,String,boolean. each of these types has its own
 * subclass that extends this oop.ex6.variable class.
 */
 public class Variables {
    
//*************************data members******************************************************************
    
    private boolean decliration;
    private boolean initilization;
    private boolean isFinal;
    private int methodNumber;
    private int scopeNumber;
    
    /** the value of this oop.ex6.variable*/
    private String value;
    
    /**the type of this oop.ex6.variable*/
    private String objectType;
    
    /**an instance of TypeCheck - used as composition for type checks*/
    private TypeCheck typeCheck;

    /** the name of the oop.ex6.variable*/
    private String name;
    
//***********************constructor*******************************************************************
    
     public Variables(int scope, String Method, String objectType, String name, String value, boolean isFinal){
        this.value = value;
        this.objectType = objectType;
        this.name=name;
        this.isFinal=isFinal;
        typeCheck = new TypeCheck(objectType,value);

    }

    /**
     * checks if the oop.ex6.variable value is of the right type.
     */
    public void checkValueType() {

        typeCheck.checkType();
    }

    /**
     * sets new value
     * @param value - new value
     */
    public void setValue(String value) throws ChangedFinalValueException {
        if (isFinal) {
            throw new ChangedFinalValueException();
        } else {
            this.value = value;
        }
    }

    public boolean getFinal(){
        return isFinal;
    }

    public String getName(){
        return name;
    }
}
