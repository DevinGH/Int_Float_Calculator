import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;

public class FloatCalculatorBehavior extends CalculatorBehavior{
    /**
     * Uses the ActionEvent to determine what to do with the calculator
     * @param e
     * @return
     */
    public static String takeFloatAction(ActionEvent e) {
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
     * Adds inputted number to list in appropriate place
     * @param e
     */
    protected static void addInput(ActionEvent e){
        if(!isDecimal){
            if(inputList.size() >= 1  && !Arrays.asList(CALC_OPERATORS).contains(inputList.get(inputList.size() - 1))){
                inputList.set(inputList.size() - 1, returnInt(inputList.get(inputList.size() - 1)) + e.getActionCommand() + ".0");
                testPrint(inputList);
            }else {
                inputList.add(Float.parseFloat(e.getActionCommand()) + "");
                testPrint(inputList);
            }
        }else {
            ifDecimal(e);
            testPrint(inputList);
        }
    }

    public static int returnInt(String str){
        int num = (int)Float.parseFloat(str);

        return num;
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
            inputList.set(inputList.size() - 1, returnInt(inputList.get(inputList.size() - 1)) + ".");
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
}
