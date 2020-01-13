package oop.ex6.main;
import java.util.ArrayList;
import java.util.HashMap;
import oop.ex6.variables.*;
/**
 * A singleton class that suppose to represent all the methods and oop.ex6.variable in the file
 */
public class FileData {
    private static FileData single=new FileData();
    private static HashMap<Integer, ArrayList<Variables>> declaredVariables;
    private FileData() {
        declaredVariables=new HashMap<Integer, ArrayList<Variables>>();

    }

    /**
     * add new oop.ex6.variable to the list.
     */
    public static void setDeclaredVariables(Variables variable, int scope) {
        if (!declaredVariables.containsKey(scope)){
            ArrayList<Variables> newArray=new ArrayList<Variables>();
            declaredVariables.put(scope,newArray);
        }
        declaredVariables.get(scope).add(variable);
    }

    /**
     * @return gives the declaredVariable list
     */
    public static HashMap<Integer,ArrayList<Variables>> getDeclaredVariables() {
        return (declaredVariables);
    }

    /**
     * @return return the specific oop.ex6.variable
     */
    public static Variables getSpecificDeclaredVariable(int scope, String name) {
        int index=-1;
        for (Variables variables:declaredVariables.get(scope)){
            if (variables.getName().equals(name)){index= declaredVariables.get(scope).indexOf(variables);}
        }
        return (Variables) declaredVariables.get(scope).get(index);
    }

    /**
     * this function finds if a oop.ex6.variable is already declared
     *
     * @param scope the scope of the oop.ex6.variable
     * @param name  the name of the oop.ex6.variable
     * @return true if there is the oop.ex6.variable and false otherwise.
     */
    public static Boolean isDeclaredVariable(int scope, String name) {
        try {
            ArrayList<Variables> variablesArray = declaredVariables.get(scope);
            for (Variables variable : variablesArray) {
                if (variable.getName().equals(name)) {
                    return true;
                }
            }
        } catch (NullPointerException e) {
            return false;
        }
        return false;
    }
    public static FileData getInstance(){
        return single;
    }

    }




