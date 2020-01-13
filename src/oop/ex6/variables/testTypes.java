//package oop.ex6.variable;
//
//import org.junit.Assert;
//import org.junit.Assert.*;
//import org.junit.Before;
//import org.junit.Test;
//
//
//public class testTypes {
//
//    private String Type;
//    public Variable var1;
//    public Variable var2;
//    public Variable var3;
//    public Variable var4;
//    public Variable var5;
//    public Variable var6;
//    public Variable var7;
//    public Variable var8;
//    public Variable var9;
//    public Variable var10;
//    public Variable var11;
//    public Variable var12;
//    public Variable var13;
//
//
//    @Before
//    public void createVariables(){
//
//
//
//    }
//    @Test
//    public void testINT(){
//        Type = "int";
//        var1 = new Variable(Type,"0");
//        var2 = new Variable(Type,"3.");
//        var3 = new Variable(Type,"3.0");
//        var4 = new Variable(Type,".8");
//        var5 = new Variable(Type,"\"string\"");
//        var6 = new Variable(Type,"'c'");
//        var7 = new Variable(Type,"string");
//        var8 = new Variable(Type,"true");
//        var9 = new Variable(Type,"\"true\"");
//        var10 = new Variable(Type,"\"3\"");
//        var11 = new Variable(Type,"'2'");
//        System.out.println(" var 1: ");//todo the only one that should pass
//        var1.checkValueType();
//        System.out.println(" var 2: ");
//        var2.checkValueType();
//        System.out.println(" var 3: ");
//        var3.checkValueType();
//        System.out.println(" var 4: ");
//        var4.checkValueType();
//        System.out.println(" var 5: ");
//        var5.checkValueType();
//        System.out.println(" var 6: ");
//        var6.checkValueType();
//        System.out.println(" var 7: ");
//        var7.checkValueType();
//        System.out.println(" var 8: ");
//        var8.checkValueType();
//        System.out.println(" var 9: ");
//        var9.checkValueType();
//    }
//    @Test
//    public void testDOUBLE(){
//        Type = "double";
//        var1 = new Variable(Type,"0");
//        var2 = new Variable(Type,"-3.");
//        var3 = new Variable(Type,"-3.0");
//        var4 = new Variable(Type,"-.8");
//        var5 = new Variable(Type,"\"string\"");
//        var6 = new Variable(Type,"'c'");
//        var7 = new Variable(Type,"string");
//        var8 = new Variable(Type,"true");
//        var9 = new Variable(Type,"\"true\"");
//        System.out.println(" var 1: ");//todo pass
//        var1.checkValueType();
//        System.out.println(" var 2: ");//todo pass
//        var2.checkValueType();
//        System.out.println(" var 3: ");//todo pass
//        var3.checkValueType();
//        System.out.println(" var 4: ");//todo pass
//        var4.checkValueType();
//        System.out.println(" var 5: ");
//        var5.checkValueType();
//        System.out.println(" var 6: ");
//        var6.checkValueType();
//        System.out.println(" var 7: ");
//        var7.checkValueType();
//        System.out.println(" var 8: ");
//        var8.checkValueType();
//        System.out.println(" var 9: ");
//        var9.checkValueType();
//    }
//    @Test
//    public void testBOOLEAN(){
//        Type = "boolean";
//        var1 = new Variable(Type,"0");
//        var2 = new Variable(Type,"3.");
//        var3 = new Variable(Type,"3.0");
//        var4 = new Variable(Type,".8");
//        var5 = new Variable(Type,"\"string\"");
//        var6 = new Variable(Type,"'c'");
//        var7 = new Variable(Type,"string");
//        var8 = new Variable(Type,"true");
//        var9 = new Variable(Type,"\"true\"");
//        var13 = new Variable(Type,"null");
//
//        System.out.println(" var 1: ");//todo pass
//        var1.checkValueType();
//        System.out.println(" var 2: ");//todo pass
//        var2.checkValueType();
//        System.out.println(" var 3: ");//todo pass
//        var3.checkValueType();
//        System.out.println(" var 4: ");//todo pass
//        var4.checkValueType();
//        System.out.println(" var 5: ");
//        var5.checkValueType();
//        System.out.println(" var 6: ");
//        var6.checkValueType();
//        System.out.println(" var 7: ");
//        var7.checkValueType();
//        System.out.println(" var 8: ");//todo pass
//        var8.checkValueType();
//        System.out.println(" var 9: ");
//        var9.checkValueType();
//        System.out.println("var 13:");
//        var13.checkValueType();
//    }
//    @Test
//    public void testString(){
//        Type = "String";
//        var1 = new Variable(Type,"0");
//        var2 = new Variable(Type,"3.");
//        var3 = new Variable(Type,"3.0");
//        var4 = new Variable(Type,".8");
//        var5 = new Variable(Type,"\"string\"");
//        var6 = new Variable(Type,"'c'");
//        var7 = new Variable(Type,"string");
//        var8 = new Variable(Type,"true");
//        var9 = new Variable(Type,"\"true\"");
//        var10 = new Variable(Type,"\"3\"");
//        var12 = new Variable(Type,"\"\"");
//        var13 = new Variable(Type,"null");
//        System.out.println(" var 1: ");
//        var1.checkValueType();
//        System.out.println(" var 2: ");
//        var2.checkValueType();
//        System.out.println(" var 3: ");
//        var3.checkValueType();
//        System.out.println(" var 4: ");
//        var4.checkValueType();
//        System.out.println(" var 5: ");//todo pass
//        var5.checkValueType();
//        System.out.println(" var 6: ");
//        var6.checkValueType();
//        System.out.println(" var 7: ");
//        var7.checkValueType();
//        System.out.println(" var 8: ");
//        var8.checkValueType();
//        System.out.println(" var 9: ");//todo pass
//        var9.checkValueType();
//        System.out.println(" var 10: ");//todo pass
//        var10.checkValueType();
//        System.out.println("var 12:");//todo pass
//        var12.checkValueType();
//        System.out.println("var 13:");//todo pass
//        var13.checkValueType();
//    }
//    @Test
//    public void testCHAR(){
//        Type = "char";
//        var1 = new Variable(Type,"0");
//        var2 = new Variable(Type,"3.");
//        var3 = new Variable(Type,"3.0");
//        var4 = new Variable(Type,".8");
//        var5 = new Variable(Type,"\"string\"");
//        var6 = new Variable(Type,"'c'");
//        var7 = new Variable(Type,"string");
//        var8 = new Variable(Type,"true");
//        var9 = new Variable(Type,"\"true\"");
//        var10 = new Variable(Type,"\"3\"");
//        var11 = new Variable(Type,"'2'");
//
//        var13 = new Variable(Type,"null");
//
//        System.out.println(" var 1: ");
//        var1.checkValueType();
//        System.out.println(" var 2: ");
//        var2.checkValueType();
//        System.out.println(" var 3: ");
//        var3.checkValueType();
//        System.out.println(" var 4: ");
//        var4.checkValueType();
//        System.out.println(" var 5: ");
//        var5.checkValueType();
//        System.out.println(" var 6: ");//todo pass
//        var6.checkValueType();
//        System.out.println(" var 7: ");
//        var7.checkValueType();
//        System.out.println(" var 8: ");
//        var8.checkValueType();
//        System.out.println(" var 9: ");
//        var9.checkValueType();
//        System.out.println(" var 10: ");
//        var10.checkValueType();
//        System.out.println("var 11:");//todo pass
//        var11.checkValueType();
//        System.out.println("var 13:");
//        var13.checkValueType();
//
//    }
//
//
//
//
//}