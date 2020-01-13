package oop.ex6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tests {

    public static final String COMMENT = "^//";
    public static final String END_LINE=" *; *";
    public static final String TYPES = "((int|char|String|boolean|double) ?)";
    public static final String FINAL = " *(final )? *";
    public static final String INT  = "[\\d]+";
    public static final String DOUBLE = "[\\d]+.[\\d]*|[\\d]*.[\\d]+";
    public static final String STRING = "\"[^\\,\"']\"";
    public static final String BOOLEAN = "true|false";



    public static final String OPTIONAL_SPACE = " *";
    public static final String MANDATORY_SPACE = " +";
    public static final String VARIABLE_NAME = " *([a-zA-Z]|_[\\w])[\\w]*";
    public static final String EQUALS = " *= *";
    public static final String VARIABLE_VALUE = "("+INT+"|"+DOUBLE+"|"+STRING+"|"+BOOLEAN+")";//check if needs space afterwards
    public static final String EQUALS_VALUE = EQUALS+VARIABLE_VALUE;

    public static final String DECLARATION_PREFIX=" *(final )? *(int|char|String|boolean|double) +([A-Za-z]|_[\\w])[\\w]*";
    public static final String DECLERATION_SEARCH=".?(int|char|String|boolean|double)+";
    public static final String SUFFIX1 = ";";
    //public static final String  TYUTA= "("+ OPTIONAL_SPACE+FINAL+OPTIONAL_SPACE+TYPES+MANDATORY_SPACE+")*"+VARIABLE_NAME+EQUALS+VARIABLE_VALUE(OPTIONAL_SPACE //FIRST DECELERATION;
    public static final String BEGINNING = FINAL+TYPES;
    public static final String MIDDLE = VARIABLE_NAME+"("+EQUALS_VALUE+")?";
    public static final String END = "(("+OPTIONAL_SPACE+","+VARIABLE_NAME+")*("+EQUALS_VALUE+")?)*"+END_LINE;
    public static final String TOTAL = BEGINNING+MIDDLE+END;

    //public static final String DECLARATION=DECLARATION_PREFIX+END_LINE;
    public static final String INITIALIZATION = " *([a-zA-Z]|_[\\w])[\\w]* *= *[^/,'\"] *; *";
    public static final String DECLARATION_INITIALIZATION = " *(final )? *(int|String|char|double|boolean) +([a-zA-Z]|_[\\w])[\\w]* += +[^/,'\"]* *; *";


    public static final String NEW_INIT = OPTIONAL_SPACE+VARIABLE_NAME+OPTIONAL_SPACE+EQUALS+OPTIONAL_SPACE+VARIABLE_VALUE+END_LINE;
    public static final String NEW_DEC = OPTIONAL_SPACE+FINAL+OPTIONAL_SPACE+TYPES+MANDATORY_SPACE+VARIABLE_NAME+END_LINE;
    public static final String NEW_DEC_INITI = OPTIONAL_SPACE+FINAL+OPTIONAL_SPACE+TYPES+MANDATORY_SPACE+VARIABLE_NAME+MANDATORY_SPACE+EQUALS+MANDATORY_SPACE+VARIABLE_VALUE+END_LINE;
    //double a ,b ,  c =1,2,3;
    public static final String DOUBLE_INIT = OPTIONAL_SPACE+FINAL+OPTIONAL_SPACE+TYPES+MANDATORY_SPACE+VARIABLE_NAME+MANDATORY_SPACE+EQUALS+MANDATORY_SPACE+VARIABLE_VALUE+END_LINE;
    @Before
    public void createStuff(){
        System.out.println(TOTAL);
        System.out.println(VARIABLE_VALUE);

    }



    @Test
    public void VariableDeclaration() {
        Pattern pattern = Pattern.compile(NEW_DEC);
        Matcher matcher1 = pattern.matcher("");
        Matcher matcher2 = pattern.matcher("int a;");
        Matcher matcher3 = pattern.matcher("final int a;");
        Matcher matcher4 = pattern.matcher("inal int a;");
        Matcher matcher5 = pattern.matcher("finalint a;");
        Matcher matcher6 = pattern.matcher("final    int a;");
        Matcher matcher7 = pattern.matcher("   final    int avds535_;");
        Matcher matcher8 = pattern.matcher(" final int avds535_;     ");
        Matcher matcher9 = pattern.matcher("   final    int avds535_         ");
        Matcher matcher10 = pattern.matcher("       double avds535_    ;     ");
        Matcher matcher11 = pattern.matcher("   final    boolean avds535_        ; ");
        Matcher matcher12 = pattern.matcher("       String avd_5_ ;        ");
        Matcher matcher13 = pattern.matcher("       String 65 ;        ");
        Matcher matcher14 = pattern.matcher("       String _ ;        ");
        Matcher matcher15 = pattern.matcher("       String _7 ;        ");
        Matcher matcher16 = pattern.matcher("       String __ ;        ");
        Matcher matcher17 = pattern.matcher("       String 9_ ;        ");

        Assert.assertFalse(matcher1.matches());
        Assert.assertTrue(matcher2.matches());
        Assert.assertTrue(matcher3.matches());
        Assert.assertFalse(matcher4.matches());
        Assert.assertFalse(matcher5.matches());
        Assert.assertTrue(matcher6.matches());
        Assert.assertTrue(matcher7.matches());
        Assert.assertTrue(matcher8.matches());
        Assert.assertFalse(matcher9.matches());
        Assert.assertTrue(matcher10.matches());
        Assert.assertTrue(matcher11.matches());
        Assert.assertTrue(matcher12.matches());
        Assert.assertFalse(matcher13.matches());
        Assert.assertFalse(matcher14.matches());
        Assert.assertTrue(matcher15.matches());
        Assert.assertTrue(matcher16.matches());
        Assert.assertFalse(matcher17.matches());


    }
    @Test
    public void doubleDecliration(){
        Pattern p = Pattern.compile(" *(int|double|char|String|boolean) +");
        Matcher m = p.matcher("double a,b = 1,2;");
        Matcher m2 = p.matcher("   double  a  ,   b   =   1  ,  2 ;  ");
        Matcher m3 = p.matcher("double a,b=1,2;");
        Matcher m4 = p.matcher("int aec13, _dsf=3_5,_a3;");
        Matcher m5 = p.matcher("int _,b=1,2;");//false
        Matcher m6 = p.matcher("int 3a,b=1,2;");//false
        Matcher m7 = p.matcher("int a,b = 1/3,2");//false
        Matcher m8 = p.matcher("");//false
        Matcher m9 = p.matcher("int ,b=1,2;");
        Matcher m10 = p.matcher("");
        Matcher m11 = p.matcher("");

    }


}
