import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class IntCalculatorBehaviorTest extends IntCalculatorBehavior{

    @Test
    void calculate() {
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("4", "x", "2", "+", "2"));
        List<String> resultList = List.of("10.0");

        assertEquals(resultList, calculate(testList));
    }

    @Test
    void precedence2() {
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("4", "x", "2", "+", "2"));
        List<String> resultList = List.of("4", "x", "4.0");

        assertEquals(resultList, precedence2(testList));
    }

    @Test
    void getNum() {
        String str = "4";

        assertEquals(4.0f, getNum(str));
    }

    @Test
    void calcPlus() {
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("4", "+", "2"));
        List<String> resultList = List.of("6.0");

        assertEquals(resultList, calcPlus(testList, 1));
    }

    @Test
    void calcSubtract() {
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("4", "-", "2"));
        List<String> resultList = List.of("2.0");

        assertEquals(resultList, calcSubtract(testList, 1));
    }

    @Test
    void precedence1() {
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("4", "x", "2", "+", "2"));
        List<String> resultList = List.of("8.0", "+", "2");

        assertEquals(resultList, precedence1(testList));
    }

    @Test
    void calcMulti() {
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("4", "x", "2"));
        List<String> resultList = List.of("8.0");

        assertEquals(resultList, calcMulti(testList, 1));
    }

    @Test
    void calcDivide() {
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("4", "/", "2"));
        List<String> resultList = List.of("2.0");

        assertEquals(resultList, calcDivide(testList, 1));
    }

    @Test
    void calcSqrt() {
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("4", "x", "4"));
        List<String> resultList = List.of("4", "x", "2.0");

        assertEquals(resultList, calcSqrt(testList));
    }

    @Test
    void calcFrac() {
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("4", "x", "4"));
        List<String> resultList = List.of("4", "x", "0.25");

        assertEquals(resultList, calcFrac(testList));
    }

    @Test
    void calcSquared() {
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("4", "x", "4"));
        List<String> resultList = List.of("4", "x", "16.0");

        assertEquals(resultList, calcSquared(testList));
    }

    @Test
    void checkNegative() {
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("4", "-", "-", "4"));

        assertTrue(checkNegative(testList));
    }

    @Test
    void getResult() {
        float f1 = 1.0f;
        float f2 = 2.0f;
        String type = "plus";
        float result = 3.0f;

        assertEquals(result, getResult(f1, f2, type));
    }

    @Test
    void printEquation() {
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("4", "x", "4"));
        String result = "4x4";

        assertEquals(result, printEquation(testList));
    }
}