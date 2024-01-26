package at.campus02.swe.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.Calculator.Operation;

import java.util.Random;

public class CalculatorTest {

    private Calculator calculator;
    private int seed = 12345;

    @Test
    public void testSimpleAddOperation() throws Exception {

        //setup
        Calculator calc = new CalculatorImpl();

        //execute
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.add);

        //verify
        assertEquals(5, result, 0);


    }

    @Test
    public void testSimpleMulOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.mul);

        assertEquals(6, result, 0);

    }

    @Test
    public void testSimpleDivOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(6.0);
        calc.push(2);
        double result = calc.perform(Operation.div);

        assertEquals(3, result, 0);

    }

    @Test
    public void testSimpleModOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(7);
        calc.push(2);
        double result = calc.perform(Operation.mod);

        assertEquals(1, result, 0);

    }

    @Test
    public void testSimpleSinOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(90);
        double result = calc.perform(Operation.sin);

        assertEquals(1, result, 0);
    }

    @Test
    public void testSimpleCosOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(180);
        double result = calc.perform(Operation.cos);

        assertEquals(-1, result, 0);
    }





    //
    @Test(expected = CalculatorException.class)
    public void testPopOnEmptyStack() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.pop();

    }

    @Test
    public void testDivisionByZero() throws Exception {

        //Setup
        Calculator calc = new CalculatorImpl();
        try {
            calc.push(2);
            calc.push(0);
            calc.perform(Operation.div);

            fail("Exception expected");


        } catch (CalculatorException e) {
            assertEquals("Division by zero", e.getMessage());
            // e.getCause()
        }

    }

    @Before
    public void setUp() {
        calculator = new CalculatorImpl();
    }

    @Test
    public void testMinMaxRandom() throws CalculatorException {
        // Angenommene Werte für den Test
        double min = 5;
        double max = 10;

        // Werte auf den Stack legen
        calculator.push(min);
        calculator.push(max);

        // Führe die 'random' Operation aus
        double result = calculator.perform(Operation.random);

        // Überprüfen, ob das Ergebnis innerhalb des Bereichs liegt
        Assert.assertTrue("Das Ergebnis sollte größer oder gleich dem Minimum sein", result >= min);
        Assert.assertTrue("Das Ergebnis sollte kleiner oder gleich dem Maximum sein", result <= max);
    }

    @Before
    public void setUpSeed() {
        calculator = new CalculatorImpl();
    }

    @Test
    public void testRandomOperation() throws CalculatorException {
        double min = 5;
        double max = 10;
        boolean minGenerated = false;
        boolean maxGenerated = false;

        for (int i = 0; i < 100; i++) {
            calculator.push(min);
            calculator.push(max);
            double result = calculator.perform(Operation.random);

            if (result == min) minGenerated = true;
            if (result == max) maxGenerated = true;

            if (minGenerated && maxGenerated) break;
        }

        Assert.assertTrue("Minimum sollte generiert werden", minGenerated);
        Assert.assertTrue("Maximum sollte generiert werden", maxGenerated);
    }



    @Test
    public void testDotProductNegativ() throws CalculatorException {
        // Pushen der Elemente für Vektoren (1, 3) und (2, 4) auf den Stack
        calculator.push(4); // b2
        calculator.push(2); // b1
        calculator.push(3); // a2
        calculator.push(1); // a1
        calculator.push(2); // Anzahl der Elemente pro Vektor

        // Ausführen der dotproduct Operation
        double result = calculator.perform(Operation.dotproduct);

        // Überprüfen, ob das Ergebnis wie erwartet ist
        assertEquals("Skalarprodukt von (1, 3) und (2, 4) sollte 11 sein", 14, result, 0.001);
    }
    @Test
    public void testDotProductPositiv() throws CalculatorException {
        // Pushen der Elemente für Vektoren (1, 3) und (2, 4) auf den Stack
        calculator.push(4); // b2
        calculator.push(2); // b1
        calculator.push(3); // a2
        calculator.push(1); // a1
        calculator.push(2); // Anzahl der Elemente pro Vektor

        // Ausführen der dotproduct Operation
        double result = calculator.perform(Operation.dotproduct);

        // Überprüfen, ob das Ergebnis wie erwartet ist
        assertEquals("Skalarprodukt von (1, 3) und (2, 4) sollte 11 sein", 11, result, 0.001);
    }

}


