package oop.ex6.variables;

import oop.ex6.variables.exception.WrongValueTypeException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//public class TypeCheck {
//    TypeCheck(String type,String value) throws WrongValueType {}
//
//
//    public void checkType(){}

    /**
     * this class check that the Type of object matches the value of the object
     */
    public class TypeCheck {

    //******************data members***************************************************************************

        /**The different Types that are possible for a oop.ex6.variable in a s-java file*/
        private static final String INT = "int",
                                    DOUBLE = "double",
                                    BOOLEAN = "boolean",
                                    STRING = "String",
                                    CHAR = "char";

        /** the value of the oop.ex6.variable*/
        private String value;

        /** the object type*/
        private String objectType;


    //****************constructor*******************************************************************************

        public TypeCheck(String objectType, String value) {
            this.objectType = objectType;
            this.value = value;

        }

        /**
         * checking value is valid int
         */
        private void checkInt() throws WrongValueTypeException {
            try {
                Integer.parseInt(String.valueOf(value));
            } catch (NumberFormatException ex) {
                throw new WrongValueTypeException();
            }
        }

        /**
         * checking value type for double - can be int/double
         */
        private void checkDouble() throws WrongValueTypeException {
            try {
                Double.parseDouble(String.valueOf(value));
            } catch (NumberFormatException e) {
                throw new WrongValueTypeException();
            }
        }

        /**
         * check that value is a valid boolean - can be boolean/int/double
         */
        private void checkBoolean() throws WrongValueTypeException{
            Pattern p = Pattern.compile("(true|false)");
            Matcher m = p.matcher(String.valueOf(value));
            if(m.matches()){
                return;
            }else {
                try {
                    Double number = Double.parseDouble(String.valueOf(value));
                } catch (NumberFormatException e) {
                    throw new WrongValueTypeException();
                }
            }
        }


        /**
         * checks if value is valid char - ant single character in ''.
         */
        private void checkChar() throws WrongValueTypeException{
            Pattern p = Pattern.compile("\'.?\'");
            Matcher m = p.matcher(String.valueOf(value));
            if (!m.matches()) {
                throw new WrongValueTypeException();
            }
        }

        /**
         * checks that the value is a valid string, not a int/double/boolean/char(but it can be int/float/boolean)
         */
        private void checkString() throws WrongValueTypeException {
            Pattern p = Pattern.compile("\".*\"");
            Matcher m = p.matcher(String.valueOf(value));
            if (!m.matches()) {
                throw new WrongValueTypeException();
            }
        }

        /**
         * does that actual check for correlation between value and the Object Type.
         */
        public void checkType() {
            try{
                if(objectType.equals(INT)){
                    checkInt();
                }
                if(objectType.equals(DOUBLE)){
                    checkDouble();
                }
                if(objectType.equals(CHAR)){
                    checkChar();
                }
                if(objectType.equals(STRING)){
                    checkString();
                }
                if(objectType.equals(BOOLEAN)){
                    checkBoolean();
                }
            }catch (WrongValueTypeException e){
                System.err.println(e.getErrorMessage());
            }
        }
    }

