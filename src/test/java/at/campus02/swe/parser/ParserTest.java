package at.campus02.swe.parser;

import java.io.File;
import java.io.FileNotFoundException;

import at.campus02.swe.logic.CalculatorImpl;
import org.junit.Test;
import static org.mockito.Mockito.*;

import at.campus02.swe.Calculator;
import at.campus02.swe.Calculator.Operation;
import org.mockito.InOrder;


public class ParserTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullParser() {
        new Parser(null);
    }

    @Test(expected = FileNotFoundException.class)
    public void testParserInvalidFile() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("invalid"));
    }

    @Test
    public void testParserTest04Xml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test04.xml"));

        verify(cal).push(3.0);
        verify(cal).push(9.0);
        verify(cal).perform(Operation.mod);

        verifyNoMoreInteractions(cal);
    }

    @Test
    public void testParserSinTest06Xml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test06.xml"));

        verify(cal).push(90);
        verify(cal).perform(Operation.sin);

        verifyNoMoreInteractions(cal);
    }
    @Test
    public void testParserCosTest07Xml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test07.xml"));

        verify(cal).push(180);
        verify(cal).perform(Operation.cos);

        verifyNoMoreInteractions(cal);
    }

    @Test
    public void testDotProductOperation() throws Exception {
        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test08.xml"));

        // Überprüfen, ob die push-Methode in der korrekten Reihenfolge und Anzahl aufgerufen wird
        InOrder inOrder = inOrder(cal);
        inOrder.verify(cal).push(4); // b2
        inOrder.verify(cal).push(2); // b1
        inOrder.verify(cal).push(3); // a2
        inOrder.verify(cal).push(1); // a1
        inOrder.verify(cal).push(2); // Anzahl der Elemente
        inOrder.verify(cal).perform(Operation.dotproduct);

        verifyNoMoreInteractions(cal);
    }
}