
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
    private static String[] CALC_OPERATORS = {"+", "-", "x", "/"};

    /**
     * Uses the ActionEvent to determine what to do with the calculator
     * @param e
     * @return
     */
    public static String takeAction(ActionEvent e) {
        boolean moreThanOneDigit = false;
        /*
        Checks to see what value has been inputted
         */
        /*
        ERROR: When checking the previous index it doesn't read any number above 9, and needs to check if the number is
        the proper one we want.
         */
        if(Arrays.asList(CALC_NUM).contains(e.getActionCommand())){
            if(inputList.size() > 2  && !Arrays.asList(CALC_OPERATORS).contains(inputList.get(inputList.size() - 1))){
                inputList.set(inputList.size() - 1, inputList.get(inputList.size() - 1) + e.getActionCommand());
                testPrint(inputList);
            }
            inputList.add(e.getActionCommand());
            moreThanOneDigit = true;
        }else if(Arrays.asList(CALC_OPERATORS).contains(e.getActionCommand())){
            moreThanOneDigit = false;
            inputList.add(e.getActionCommand());
        }else if(e.getActionCommand().equals("\u221A")){
            inputList = calcSqrt(inputList);
        }else if(e.getActionCommand().equals("1/x")){
            inputList = calcFrac(inputList);
        }else if(e.getActionCommand().equals("x\u00B2")){

        }else if(e.getActionCommand().equals("DEL")){

        }else if(e.getActionCommand().equals("C")){

        }else if(e.getActionCommand().equals("=")){
            inputList = calculate(inputList);
        }

        /*
        Returns the full string to set on the display
         */
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
       while(str.contains("x")){
           str = calcMulti(str);
       }
       while(str.contains("/")){
           str = calcDivide(str);
       }
       while(str.contains("+")){
           str = calcPlus(str);
       }
       while(str.contains("-")){
           str = calcSubtract(str);
       }

       return str;
    }

    /**
     * Calculates addition
     * @param list
     * @return
     */
    public static List<String> calcPlus(List<String> list){
        String result = "";
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals("+")){
                result = "";
                result += Integer.parseInt(list.get(i-1)) + Integer.parseInt(list.get(i+1));
                list.set(i-1, result);
                list.remove(i+1);
                list.remove(i);
                i -= 2;
            }
        }

        return list;
    }

    /**
     * Calculates Subtraction
     * @param list
     * @return
     */
    public static List<String> calcSubtract(List<String> list){
        String result = "";
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals("-")){
                result = "";
                result += Integer.parseInt(list.get(i-1)) - Integer.parseInt(list.get(i+1));
                list.set(i-1, result);
                list.remove(i+1);
                list.remove(i);
                i -= 2;
            }
        }

        return list;
    }

    /**
     * Calculates Multiplication
     * @param list
     * @return
     */
    public static List<String> calcMulti(List<String> list){
        String result = "";
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals("x")){
                result = "";
                result += Integer.parseInt(list.get(i-1)) * Integer.parseInt(list.get(i+1));
                list.set(i-1, result);
                list.remove(i+1);
                list.remove(i);
                i -= 2;
            }
        }

        return list;
    }

    /**
     * Calculates Division
     * @param list
     * @return
     */
    public static List<String> calcDivide(List<String> list){
        String result = "";
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals("/")){
                result = "";
                result += Integer.parseInt(list.get(i-1)) / Integer.parseInt(list.get(i+1));
                list.set(i-1, result);
                list.remove(i+1);
                list.remove(i);
                i -= 2;
            }
        }

        return list;
    }

    /**
     * Calculates the square root of the most recent number inputted
     * @param list
     * @return
     */
    public static List<String> calcSqrt(List<String> list){
        String num = list.get(list.size() - 1);
        double new_num = Math.sqrt(Double.parseDouble(num));
        list.set(list.size() - 1, Double.toString(new_num));

        return list;
    }

    /**
     * Calculates the reciprocal of the most recent number inputted
     * @param list
     * @return
     */
    public static List<String> calcFrac(List<String> list){
        String num = list.get(list.size() - 1);
        double new_num = 1/Double.parseDouble(num);
        list.set(list.size() - 1, Double.toString(new_num));

        return list;
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
