package oop.ex6.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * runs the program
 */
public class sjavac {
    /**
     * tuns the program
     * @param args - s-java file the check
     */
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^//");
        Matcher m = p.matcher("//kjfk */");
        //System.out.println(m.find());
        Pattern p2 = Pattern.compile(" *([a-zA-Z]|_*[\\w])(\\w+) += +[^/,'\"]* *; *");

        Matcher m2 = p2.matcher(" __sd = 5;");
        System.out.println(m2.matches());

    }
}
