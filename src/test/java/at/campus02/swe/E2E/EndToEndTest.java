package at.campus02.swe.E2E;

import at.campus02.swe.Calculator;
import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;


public class EndToEndTest {

    @Test
    public void testE2Eadd() throws Exception {

        double tmp = 0;

        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        tmp = parser.parse(new File("src/test/resources/test01.xml"));

        assertEquals(3, tmp, 0);
    }

    @Test
    public void testE2Emod() throws Exception {

        double tmp = 0;

        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        tmp = parser.parse(new File("src/test/resources/test04.xml"));

        assertEquals(3, tmp, 0);
    }
}
