import java.awt.event.ActionEvent;
import java.util.*;

/**
 * Class that details the behavior of the calculator
 */
public class CalculatorBehavior {
    /*
    Local Variabes
     */
    private static List<String> inputList = new ArrayList<String>();
    private static String[] CALC_NUM = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    private static String[] CALC_OPERATORS = {"+", "-", "x", "/", "."};
    private static boolean calcPower;
    private static boolean isNegative = false;
    private static boolean isDecimal = false;

    /**
     * Uses the ActionEvent to determine what to do with the calculator
     * @param e
     * @return
     */
    public static String takeAction(ActionEvent e) {
        powerController(e);
        while(calcPower){
            /*
            Checks to see what value has been inputted
            */
            if(Arrays.asList(CALC_NUM).contains(e.getActionCommand())){
                if(!isNegative){
                    addInput(e);
                }else {
                    inputList = addIfNegative(e, inputList);
                    testPrint(inputList);
                }
            }else if(Arrays.asList(CALC_OPERATORS).contains(e.getActionCommand())){
                addOperator(e);

            }else {
                doOperator(e);
            }

            /*
            Returns the full string to set on the display
            */
            return printEquation(inputList);
        }
        return printEquation(inputList);
    }

    /**
     * Takes the list and creates a full string
     * @param list
     * @return
     */
    public static String printEquation(List<String> list){
        String output = "";
        for(String str: list){
            output += str;
        }

        return output;
    }

    /**
     * Uses the list to perform proper PEMDAS
     * @param str
     * @return
     */
    public static List<String> calculate(List<String> str) {
       try{
           while(str.contains("x") || str.contains("/")){
               str = precedence1(str);
           }
           while(str.contains("+") || str.contains("-")){
               str = precedence2(str);
           }
       }catch(Exception e){
           str.clear();
           System.out.println("Invalid Input, please try again.");
        }

       return str;
    }

    /**
     * Does specific calculation in order of PEMDAS order for addition and subtraction
     * @param list
     * @return
     */
    public static List<String> precedence2(List<String> list){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals("+")){
                list = calcPlus(list, i);
                i -= 1;
            }
            if(list.get(i).equals("-")){
                list = calcSubtract(list, i);
                i -= 1;
            }
        }

        return list;
    }

    /**
     * Returns an int no matter if it is float or int
     * @param str
     * @return
     */
    public static int getNum(String str){
        int num = Math.round(Float.parseFloat(str));

        return num;
    }

    /**
     * Calculates addition
     * @param list
     * @return
     */
    public static List<String> calcPlus(List<String> list, int index){
        String result = "";

        result += getNum(list.get(index - 1)) + getNum(list.get(index + 1));
        list.set(index - 1, result);
        list.remove(index + 1);
        list.remove(index);

        return list;
    }

    /**
     * Calculates Subtraction
     * @param list
     * @return
     */
    public static List<String> calcSubtract(List<String> list, int index){
        String result = "";

        result += getNum(list.get(index - 1)) - getNum(list.get(index + 1));
        list.set(index - 1, result);
        list.remove(index + 1);
        list.remove(index);

        return list;
    }

    /**
     * Does specific calculation in order of PEMDAS order for multiplication and division
     * @param list
     * @return
     */
    public static List<String> precedence1(List<String> list){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals("x")){
                list = calcPlus(list, i);
                i -= 1;
            }
            if(list.get(i).equals("/")){
                list = calcSubtract(list, i);
                i -= 1;
            }
        }

        return list;
    }

    /**
     * Calculates Multiplication
     * @param list
     * @return
     */
    public static List<String> calcMulti(List<String> list, int index){
        String result = "";

        result += getNum(list.get(index - 1)) * getNum(list.get(index + 1));
        list.set(index - 1, result);
        list.remove(index + 1);
        list.remove(index);

        return list;
    }

    /**
     * Calculates Division
     * @param list
     * @return
     */
    public static List<String> calcDivide(List<String> list, int index){
        String result = "";

        result += getNum(list.get(index - 1)) / getNum(list.get(index + 1));
        list.set(index - 1, result);
        list.remove(index + 1);
        list.remove(index);

        return list;
    }

    /**
     * Calculates the square root of the most recent number inputted
     * @param list
     * @return
     */
    public static List<String> calcSqrt(List<String> list){
        String num = list.get(list.size() - 1);
        int new_num = (int)Math.sqrt(getNum(num));
        list.set(list.size() - 1, Integer.toString(new_num));

        return list;
    }

    /**
     * Calculates the reciprocal of the most recent number inputted
     * @param list
     * @return
     */
    public static List<String> calcFrac(List<String> list){
        String num = list.get(list.size() - 1);
        int new_num = 1/getNum(num);
        list.set(list.size() - 1, Integer.toString(new_num));

        return list;
    }

    /**
     * Calculates the square of the previously inputted number
     * @param list
     * @return
     */
    public static List<String> calcSquared(List<String> list){
        String num = list.get(list.size() - 1);
        int new_num = (int)Math.pow(getNum(num), 2);
        list.set(list.size() - 1, Integer.toString(new_num));

        return list;
    }

    /**
     * Adds inputted number to list in appropriate place
     * @param e
     */
    public static void addInput(ActionEvent e){
        if(!isDecimal){
            if(inputList.size() >= 1  && !Arrays.asList(CALC_OPERATORS).contains(inputList.get(inputList.size() - 1))){
                inputList.set(inputList.size() - 1, inputList.get(inputList.size() - 1) + e.getActionCommand());
                testPrint(inputList);
            }else {
                inputList.add(e.getActionCommand());
                testPrint(inputList);
            }
        }else {
            ifDecimal(e);
            testPrint(inputList);
        }
    }

    /**
     * Adds operator in appropriate place
     * @param e
     */
    public static void addOperator(ActionEvent e){
        if(e.getActionCommand().equals("-")){
            inputList.add(e.getActionCommand());
            checkNegative(inputList);
        }else if(e.getActionCommand().equals(".")){
            isDecimal = true;
            inputList.set(inputList.size() - 1, inputList.get(inputList.size() - 1) + ".");
        }else {
            isNegative = false;
            isDecimal = false;
            inputList.add(e.getActionCommand());
        }
    }

    /**
     * If the current index is a decimal number, add the inputted number onto to that decimal chain
     * @param e
     */
    public static void ifDecimal(ActionEvent e){
        inputList.set(inputList.size() - 1, inputList.get(inputList.size() - 1) + e.getActionCommand());
    }

    /**
     * Performs specific operation chosen by user
     * @param e
     */
    public static void doOperator(ActionEvent e){
        if(e.getActionCommand().equals("\u221A")){
            inputList = calcSqrt(inputList);
        }else if(e.getActionCommand().equals("1/x")){
            inputList = calcFrac(inputList);
        }else if(e.getActionCommand().equals("x\u00B2")){
            inputList = calcSquared(inputList);
        }else if(e.getActionCommand().equals("DEL")){
            delete();
        }else if(e.getActionCommand().equals("C")){
            clear();
        }else if(e.getActionCommand().equals("=")){
            inputList = calculate(inputList);
        }
    }

    /**
     * If the number is negative add it to the negative sign
     * @param e
     * @param list
     * @return
     */
    public static List<String> addIfNegative(ActionEvent e, List<String> list){
        String prev = list.get(list.size() - 1);
        String after = prev + e.getActionCommand();
        list.set(list.size() - 1, after);

        return list;
    }

    /**
     * Checks to see if the current number would be negative or not
     * @param list
     * @return
     */
    public static boolean checkNegative(List<String> list){
        if(Arrays.asList(CALC_OPERATORS).contains(list.get(0))){
            isNegative = true;
        }else if(list.size() >= 2 && Arrays.asList(CALC_OPERATORS).contains(list.get(list.size() - 2))){
            isNegative = true;
        }else{
            isNegative = false;
        }

        return isNegative;
    }

    /**
     * Completely clears and resets all variables
     */
    public static void clear(){
        inputList.clear();
        isNegative = false;
        isDecimal = false;
    }

    /**
     * Deletes the previous term in the list
     */
    public static void delete(){
        inputList.remove(inputList.size() - 1);
    }

    /**
     * Controls whether the calculator is on or off
     * @param e
     */
    public static void powerController(ActionEvent e){
        if(e.getActionCommand().equals("off")){
            calcPower = false;
            inputList.clear();
            inputList.add("CALCULATOR OFF");
        }else if(e.getActionCommand().equals("on")){
            inputList.clear();
            calcPower = true;
        }
    }

    /*
    Used to check errors in list
     */
    public static void testPrint(List<String> list){
        for(String s: list){
            System.out.print(s + ",");
        }
    }

}
