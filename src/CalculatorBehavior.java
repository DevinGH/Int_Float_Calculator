import java.awt.event.ActionEvent;
import java.util.*;

/**
 * Class that details the behavior of the calculator
 */
public abstract class CalculatorBehavior {
    /*
    Local Variabes
     */
    protected static List<String> inputList = new ArrayList<String>();
    protected static String[] CALC_NUM = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    protected static String[] CALC_OPERATORS = {"+", "-", "x", "/", "."};
    protected static boolean calcPower;
    protected static boolean isNegative = false;
    protected static boolean isDecimal = false;

    /**
     * Uses the list to perform proper PEMDAS
     * @param str
     * @return
     */
    protected static List<String> calculate(List<String> str) {
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
    protected static List<String> precedence2(List<String> list){
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
    protected static float getNum(String str){
        float num = Float.parseFloat(str);

        return num;
    }

    /**
     * Calculates addition
     * @param list
     * @return
     */
    protected static List<String> calcPlus(List<String> list, int index){
        String result = "";

        result += getResult(getNum(list.get(index - 1)), getNum(list.get(index + 1)), "plus");
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
    protected static List<String> calcSubtract(List<String> list, int index){
        String result = "";

        result += getResult(getNum(list.get(index - 1)), getNum(list.get(index + 1)), "minus");
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
    protected static List<String> precedence1(List<String> list){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals("x")){
                System.out.println("got here");
                list = calcMulti(list, i);
                i -= 1;
            }
            if(list.get(i).equals("/")){
                list = calcDivide(list, i);
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
    protected static List<String> calcMulti(List<String> list, int index){
        String result = "";

        result += getResult(getNum(list.get(index - 1)), getNum(list.get(index + 1)), "multiply");
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
    protected static List<String> calcDivide(List<String> list, int index){
        String result = "";

        result += getResult(getNum(list.get(index - 1)), getNum(list.get(index + 1)), "divide");
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
    protected static List<String> calcSqrt(List<String> list){
        String num = list.get(list.size() - 1);
        float new_num = (float)Math.sqrt(getNum(num));
        list.set(list.size() - 1, Float.toString(new_num));

        return list;
    }

    /**
     * Calculates the reciprocal of the most recent number inputted
     * @param list
     * @return
     */
    protected static List<String> calcFrac(List<String> list){
        String num = list.get(list.size() - 1);
        float new_num = 1/getNum(num);
        list.set(list.size() - 1, Float.toString(new_num));

        return list;
    }

    /**
     * Calculates the square of the previously inputted number
     * @param list
     * @return
     */
    protected static List<String> calcSquared(List<String> list){
        String num = list.get(list.size() - 1);
        float new_num = (float)Math.pow(getNum(num), 2);
        list.set(list.size() - 1, Float.toString(new_num));

        return list;
    }

    /**
     * Adds inputted number to list in appropriate place
     * @param e
     */
    protected static void addInput(ActionEvent e){
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
    protected static void addOperator(ActionEvent e){
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
    protected static void ifDecimal(ActionEvent e){
        inputList.set(inputList.size() - 1, inputList.get(inputList.size() - 1) + e.getActionCommand());
    }

    /**
     * Performs specific operation chosen by user
     * @param e
     */
    protected static void doOperator(ActionEvent e){
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
    protected static List<String> addIfNegative(ActionEvent e, List<String> list){
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
    protected static boolean checkNegative(List<String> list){
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
    protected static void clear(){
        inputList.clear();
        isNegative = false;
        isDecimal = false;
    }

    /**
     * Deletes the previous term in the list
     */
    protected static void delete(){
        inputList.remove(inputList.size() - 1);
    }

    /**
     * Controls whether the calculator is on or off
     * @param e
     */
    protected static void powerController(ActionEvent e){
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
    protected static void testPrint(List<String> list){
        for(String s: list){
            System.out.print(s + ",");
        }
    }

    public static float getResult(float f1, float f2, String str){
        float result = 0;
        if(str.equals("plus")){
            result += f1 + f2;
        }
        if(str.equals("minus")){
            result +=  f1 - f2;
        }
        if(str.equals("multiply")){
            result +=  f1 * f2;
        }
        if(str.equals("divide")){
            result +=  f1 / f2;
        }

        return result;
    }

}
