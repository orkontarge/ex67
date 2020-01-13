package oop.ex6.tests;

import oop.ex6.line.exception.LogicException;
import oop.ex6.line.exception.SyntaxException;
import oop.ex6.main.FileData;
import oop.ex6.variables.Variables;
import oop.ex6.variables.exception.ChangedFinalValueException;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

public class TestRegularLine {
    FileData lines = FileData.getInstance();
    private RegularLineTester regularLine1;
    private RegularLineTester regularLine2;
    private RegularLineTester regularLine3;
    private RegularLineTester regularLine4;
    private RegularLineTester regularLine5;
    private RegularLineTester regularLine6;
    private RegularLineTester regularLine7;
    private RegularLineTester regularLine8;
    private RegularLineTester regularLine9;
    private RegularLineTester regularLine10;
    private RegularLineTester regularLine11;
    private RegularLineTester regularLine12;
    private RegularLineTester regularLine13;
    private RegularLineTester regularLine14;
    private RegularLineTester regularLine15;
    private RegularLineTester regularLine16;
    private RegularLineTester regularLine17;
    private RegularLineTester regularLine18;
    private RegularLineTester regularLine19;
    private RegularLineTester regularLine20;
    private RegularLineTester regularLine21;
    private RegularLineTester regularLine22;
    private RegularLineTester regularLine23;
    private RegularLineTester regularLine24;
    private RegularLineTester regularLine25;
    private RegularLineTester regularLine26;
    private RegularLineTester regularLine27;
    private RegularLineTester regularLine28;
    private RegularLineTester regularLine29;
    private RegularLineTester regularLine30;
    private RegularLineTester regularLine31;
    private RegularLineTester regularLine32;
    private RegularLineTester regularLine33;
    private RegularLineTester regularLine34;
    private RegularLineTester regularLine35;
    private RegularLineTester regularLine36;

    @Test
    public void TestSyntax() throws SyntaxException, LogicException {
        regularLine1 = new RegularLineTester("int a=3,b=2;");
        try {
            regularLine2 = new RegularLineTester("a=4,b=5;");
        } catch (SyntaxException e) {
        }
        regularLine3 = new RegularLineTester("     final String a = " + "\"1sc\"" + ";  ");
        regularLine4 = new RegularLineTester("final int a = 1;");
        regularLine5 = new RegularLineTester("String a = " + "\"sc\"" + ";");
        regularLine6 = new RegularLineTester("     final     String    a   =    " + "\"1sc\"" + ";");
        regularLine7 = new RegularLineTester("boolean a = false;");
        regularLine8 = new RegularLineTester("boolean a1s2d3_asd = true;");
        try {
            regularLine9 = new RegularLineTester("int  = 1;");
        } catch (SyntaxException e) {
        }
        regularLine10 = new RegularLineTester("     final int a = 1;");
        try {
            regularLine11 = new RegularLineTester("     final String a = " + "1,s\"c" + ";");
        } catch (SyntaxException e) {
        }
        try {
            regularLine12 = new RegularLineTester("");
        } catch (SyntaxException e) {
        }
        ;
        regularLine13 = new RegularLineTester("int a =5;");
        regularLine14 = new RegularLineTester("final int a=5;");
        try {
            regularLine15 = new RegularLineTester("inal int a = 5;");
        } catch (SyntaxException e) {
        }
        ;
        try {
            regularLine16 = new RegularLineTester("finalint a=5;");
        } catch (SyntaxException e) {
        }
        regularLine17 = new RegularLineTester("final    int a=5;");
        regularLine18 = new RegularLineTester("   final    int avds535_=5;");
        regularLine19 = new RegularLineTester(" final int avds535_=5;     ");
        try {
            regularLine20 = new RegularLineTester("   final    int avds535_ =5        ");
        } catch (SyntaxException e) {
        }
        regularLine21 = new RegularLineTester("       double avds535_    =5;     ");
        regularLine22 = new RegularLineTester("   final    boolean avds535_=5        ; ");
        regularLine23 = new RegularLineTester("       String avd_5_ =5;        ");
        try {
            regularLine24 = new RegularLineTester("       String 65 =5;        ");
        } catch (SyntaxException e) {
        }
        try {
            regularLine25 = new RegularLineTester("       String _ =5;        ");
        } catch (SyntaxException e) {
        }
        regularLine26 = new RegularLineTester("       String _7 =   5    ;        ");
        regularLine27 = new RegularLineTester("       String __ =5;        ");
        try {
            regularLine28 = new RegularLineTester("       String 9_ =5;        ");
        } catch (SyntaxException e) {
        }
        try {
            regularLine29 = new RegularLineTester("\"\"");
        } catch (SyntaxException e) {
        }
        regularLine30 = new RegularLineTester("double a,b;");
        regularLine31 = new RegularLineTester("int i1, i2 = 6; ");
        regularLine32 = new RegularLineTester("char c=" + "\"Z\"" + ", f;");
        regularLine33 = new RegularLineTester("boolean a, b ,c , d = true, e, f = 5;");
        regularLine34 = new RegularLineTester("String a = " + "\"hello\"" + " , b = " + "\"goodbye\"" + ";");
        regularLine35 = new RegularLineTester("int i1, i2 = 6, i3=223, i4,i5=123,i5=431654,i6; ");
        regularLine36 = new RegularLineTester("//int a;");

    }


    @Test
    public void TestLogic() throws SyntaxException, LogicException, ChangedFinalValueException {
        Assert.assertEquals(0, FileData.getDeclaredVariables().keySet().size());
        regularLine1 = new RegularLineTester("//int a;");
        regularLine1.checkLogic();
        Assert.assertFalse(FileData.getDeclaredVariables().containsKey(0));
        regularLine2 = new RegularLineTester("int a=3;");
        regularLine2.checkLogic();
        Assert.assertNotNull(FileData.getSpecificDeclaredVariable(0, "a"));
        regularLine3 = new RegularLineTester("int a=5;");
        try {
            regularLine3.checkLogic();
        } catch (LogicException e) {
        }
        Assert.assertEquals(1, FileData.getDeclaredVariables().size());
        regularLine4 = new RegularLineTester("int b=7 ;");
        regularLine4.checkLogic();
        regularLine5 = new RegularLineTester("b=9;");
        regularLine5.checkLogic();
        try {
            regularLine6 = new RegularLineTester("boolean abgf3=5");
        } catch (SyntaxException e) {
        }
        regularLine7 = new RegularLineTester("final char des_=\"m\";");
        regularLine7.checkLogic();
        regularLine8 = new RegularLineTester("des_=4;");
        try{
        regularLine8.checkLogic();}
        catch (LogicException e){}
        regularLine9 = new RegularLineTester("c=5;");
        try{
        regularLine9.checkLogic();}
        catch (LogicException e){}
    }


}
