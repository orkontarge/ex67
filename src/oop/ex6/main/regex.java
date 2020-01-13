package oop.ex6.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {
    public static final String COMMENT = "^//";
    public static final String END_LINE=" *; *";
    public static final String TYPES = "((int|char|String|boolean|double) )?";
    public static final String DECELERATION ="(int|char|String|boolean|double)";
    public static final String FINAL = " *(final )? *";
    public static final String INT  = "[\\d]+";
    public static final String DOUBLE = "[\\d]+\\.[\\d]*|[\\d]*\\.[\\d]+";
    public static final String STRING = "\"[^'\\\\,\"]*\"";
    public static final String BOOLEAN = "true|false";


    public static final String OPTIONAL_SPACE = " *";
    public static final String VARIABLE_NAME = " *([a-zA-Z]|_[\\w])[\\w]*";
    public static final String EQUALS = " *= *";
    public static final String VARIABLE_VALUE = "("+INT+"|"+DOUBLE+"|"+STRING+"|"+BOOLEAN+")";//check if needs space afterwards
    public static final String EQUALS_VALUE = EQUALS+VARIABLE_VALUE;


    public static final String BEGINNING = FINAL+TYPES;
    public static final String MIDDLE = VARIABLE_NAME+"("+EQUALS_VALUE+")?";
    public static final String END = "(("+OPTIONAL_SPACE+","+VARIABLE_NAME+")*("+EQUALS_VALUE+")?)*"+END_LINE;
    public static final String TOTAL = BEGINNING+MIDDLE+END;
}
