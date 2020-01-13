package oop.ex6.tests;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testing_nonMethod_line {
    public static final String COMMENT = "^//";
    public static final String END_LINE=" *; *";
    public static final String TYPES = "((int|char|String|boolean|double) )?";
    public static final String FINAL = " *(final )? *";
    public static final String INT  = "[\\d]+";
    public static final String DOUBLE = "[\\d]+\\.[\\d]*|[\\d]*\\.[\\d]+";
    public static final String STRING = "\"[^'\\\\,\"]*\"";
    public static final String BOOLEAN = "true|false";
    public static final String NULL = "null";


    public static final String OPTIONAL_SPACE = " *";
    public static final String VARIABLE_NAME = " *([a-zA-Z]|_[\\w])[\\w]*";
    public static final String EQUALS = " *= *";
    public static final String VARIABLE_VALUE = "("+INT+"|"+DOUBLE+"|"+STRING+"|"+BOOLEAN+"|"+NULL+")";//check if needs space afterwards
    public static final String EQUALS_VALUE = EQUALS+VARIABLE_VALUE;


    public static final String BEGINNING = FINAL+TYPES;
    public static final String MIDDLE = VARIABLE_NAME+"("+EQUALS_VALUE+")?";
    public static final String END = "(("+OPTIONAL_SPACE+","+VARIABLE_NAME+")*("+EQUALS_VALUE+")?)*"+END_LINE;
    public static final String TOTAL = BEGINNING+MIDDLE+END;
    @Before
    public void createREGEX() {
        System.out.println(TOTAL);

    }
    

    @Test
    public void allVariableSyntax(){
        Pattern pattern = Pattern.compile(TOTAL);
        Matcher m1 = pattern.matcher("     final int a = "+"\"1sc\""+";  ");
        Matcher m2 = pattern.matcher("final int a = 1;");
        Matcher m3 = pattern.matcher("int a = "+"\"sc\""+";");
        Matcher m4 = pattern.matcher("     final     int    a   =    "+"\"1sc\""+   ";");
        Matcher m5 = pattern.matcher("double a = false;");
        Matcher m6 = pattern.matcher("int a1s2d3_asd = true;");
        Matcher m7 = pattern.matcher("int  = 1;"); // false
        Matcher m8 = pattern.matcher("     final int a = 1;");//false
        Matcher m9 = pattern.matcher("     final int a = "+"1,s\"c"+";");//false

        Assert.assertTrue(m1.matches());
        Assert.assertTrue(m2.matches());
        Assert.assertTrue(m3.matches());
        Assert.assertTrue(m4.matches());
        Assert.assertTrue(m5.matches());
        Assert.assertTrue(m6.matches());
//        Assert.assertFalse(m7.matches()); //TODO int as varibaleNAME (AT LEAST FOR NOW)
        Assert.assertTrue(m8.matches());
        Assert.assertFalse(m9.matches());
        Matcher matcher10 = pattern.matcher("");
        Matcher matcher11 = pattern.matcher("int a =5;");
        Matcher matcher12 = pattern.matcher("final int a='c';");
        Matcher matcher13= pattern.matcher("inal int a = 5;");
        Matcher matcher14 = pattern.matcher("finalint a=5;");
        Matcher matcher15 = pattern.matcher("final    int a=5;");
        Matcher matcher16 = pattern.matcher("   final    int avds535_=5;");
        Matcher matcher17 = pattern.matcher(" final int avds535_=5;     ");
        Matcher matcher18 = pattern.matcher("   final    int avds535_ =5        ");
        Matcher matcher19 = pattern.matcher("       double avds535_    =5;     ");
        Matcher matcher20 = pattern.matcher("   final    boolean avds535_=5        ; ");
        Matcher matcher21 = pattern.matcher("       String avd_5_ =5;        ");
        Matcher matcher22 = pattern.matcher("       String 65 =5;        ");
        Matcher matcher23 = pattern.matcher("       String _ =5;        ");
        Matcher matcher24 = pattern.matcher("       String _7 =   5    ;        ");
        Matcher matcher25 = pattern.matcher("       String __ =5;        ");
        Matcher matcher26 = pattern.matcher("       String 9_ =5;        ");
        Assert.assertFalse(matcher10.matches());
        Assert.assertTrue(matcher11.matches());
        Assert.assertTrue(matcher12.matches());
        Assert.assertFalse(matcher13.matches());
        Assert.assertFalse(matcher14.matches());
        Assert.assertTrue(matcher15.matches());
        Assert.assertTrue(matcher16.matches());
        Assert.assertTrue(matcher17.matches());
        Assert.assertFalse(matcher18.matches());
        Assert.assertTrue(matcher19.matches());
        Assert.assertTrue(matcher20.matches());
        Assert.assertTrue(matcher21.matches());
        Assert.assertFalse(matcher22.matches());
        Assert.assertFalse(matcher23.matches());
        Assert.assertTrue(matcher24.matches());
        Assert.assertTrue(matcher25.matches());
        Assert.assertFalse(matcher26.matches());

        Matcher matcher27 = pattern.matcher("int a;");
        Matcher matcher28 = pattern.matcher("inat a;");
        Matcher matcher29 = pattern.matcher("   double a;");
        Matcher matcher30 = pattern.matcher(" final  double a;");


        Assert.assertTrue(matcher27.matches());
        Assert.assertFalse(matcher28.matches());
        Assert.assertTrue(matcher29.matches());
        Assert.assertTrue(matcher30.matches());


        Matcher matcher31 = pattern.matcher(" a =  5 ;    ");
        Matcher matcher32 = pattern.matcher(" a=5;");
        Matcher matcher33 = pattern.matcher(" a==5;");
        Matcher matcher34 = pattern.matcher("final     a=5;");
        Matcher matcher35 = pattern.matcher("   final    int avds535_=true;");
        Matcher matcher36 = pattern.matcher(" final int avd,s535_=5;     ");
        Matcher matcher37 = pattern.matcher("   final    int avds53'5_ =5        ");
        Matcher matcher38 = pattern.matcher("       double avds"+"\"\""+"535_    =5.6;     ");
        Matcher matcher39 = pattern.matcher("   final    boolean avds535_=9.42622        ; ");
        Matcher matcher40 = pattern.matcher("       avd_5_ = jdqkqd;        ");
        Matcher matcher41 = pattern.matcher("       String adds65 = "+"\"43\""+";        ");
        Matcher matcher42 = pattern.matcher("       String ds_ ="+"\"jdqkqd\""+";        ");
        Matcher matcher43 = pattern.matcher("       String _7 =   "+"\"jd'qkqd\""+"    ;        ");
        Matcher matcher44 = pattern.matcher("       char __ ="+"\"$%2kffejioew567113QRF^%$?><\""+";        ");
        Matcher matcher45 = pattern.matcher("       String a9_ ="+"\"\""+";        ");
        Matcher matcher46 = pattern.matcher("       String a9_ ="+"\"fqjk3489,fkr\""+";        ");
        Matcher matcher47 = pattern.matcher("   final    boolean avds535_=9.42622.23.        ; ");
        Matcher matcher48 = pattern.matcher("   final    boolean avds535_=945.42622.23.        ; ");
        Matcher matcher49 = pattern.matcher("   final    boolean avds535_=false       ; ");
        Matcher matcher50 = pattern.matcher("   final    boolean avds535_="+"\"false\""+"       ; ");
        Matcher matcher51 = pattern.matcher("   final    boolean avds535_="+"\""+ "      ; ");
        Matcher matcher52 = pattern.matcher("       boolean avds535_=9.        ; ");
        Matcher matcher53 = pattern.matcher("       boolean avds535_=.42622        ; ");
        Matcher matcher54=pattern.matcher("       char avds535_="+"\\"+ "      ; ");
        Matcher matcher55=pattern.matcher(      "char avds535_="+"\",\""+ "      ; ");
        Matcher matcher56=pattern.matcher("char avds535_="+"\"'\""+ "      ;" );

        Matcher matcher57=pattern.matcher("double a,b;");
        Matcher matcher58=pattern.matcher("int i1, i2 = 6; ");
        Matcher matcher59=pattern.matcher("char c=" +"\"Z\""+", f;");
        Matcher matcher60=pattern.matcher("boolean a, b ,c , d = true, e, f = 5;");
        Matcher matcher61=pattern.matcher("String a = "+"\"hello\""+" , b = "+"\"goodbye\""+";");
        Matcher matcher62=pattern.matcher("int i1, i2 = 6, i3=223, i4,i5=123,i5=431654,i6; ");


        Assert.assertTrue(matcher31.matches());
        Assert.assertTrue(matcher32.matches());
        Assert.assertFalse(matcher33.matches());
        Assert.assertTrue(matcher34.matches());
        Assert.assertTrue(matcher35.matches());
        Assert.assertTrue(matcher36.matches());
        Assert.assertFalse(matcher37.matches());
        Assert.assertFalse(matcher38.matches());
        Assert.assertTrue(matcher39.matches());
        Assert.assertFalse(matcher40.matches());
        Assert.assertTrue(matcher41.matches());
        Assert.assertTrue(matcher42.matches());
        Assert.assertFalse(matcher43.matches());
        Assert.assertTrue(matcher44.matches());
        Assert.assertTrue(matcher45.matches());
        Assert.assertFalse(matcher46.matches());
        Assert.assertFalse(matcher47.matches());
        Assert.assertFalse(matcher48.matches());
        Assert.assertTrue(matcher49.matches());
        Assert.assertTrue(matcher50.matches());
        Assert.assertFalse(matcher51.matches());
        Assert.assertTrue(matcher52.matches());
        Assert.assertTrue(matcher53.matches());
        Assert.assertFalse(matcher54.matches());
        Assert.assertFalse(matcher55.matches());
        Assert.assertFalse(matcher56.matches());
        Assert.assertTrue(matcher57.matches());
        Assert.assertTrue(matcher58.matches());
        Assert.assertTrue(matcher59.matches());
        Assert.assertTrue(matcher60.matches());
        Assert.assertTrue(matcher61.matches());
        Assert.assertTrue(matcher62.matches());
        Matcher m63 = pattern.matcher("final int a = null;");
        Matcher m64 = pattern.matcher("final int a,b,c = null;");
        Matcher m65 = pattern.matcher("boolean aaaa =  null;");
        Assert.assertTrue(m63.matches());
        Assert.assertTrue(m64.matches());
        Assert.assertTrue(m65.matches());




    }



}
