import java.awt.event.ActionEvent;
import java.sql.SQLOutput;
import java.util.*;

public class IntCalculatorBehavior extends CalculatorBehavior{
    /**
     * Uses the ActionEvent to determine what to do with the calculator
     * @param e
     * @return
     */
    public static String takeIntAction(ActionEvent e) {
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
            if(checkNum(str)){
                System.out.println("Str = " + str);
                output += Math.round(Float.parseFloat(str));
            }else{
                output += str;
            }
        }

        return output;
    }

    private static boolean checkNum(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch(NumberFormatException e){
            try{
                Float.parseFloat(str);
                return true;
            }catch(NumberFormatException n){
                return false;
            }
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
            System.out.println("Decimals not required for Int Calculator");
        }else {
            isNegative = false;
            isDecimal = false;
            inputList.add(e.getActionCommand());
        }
    }


}
