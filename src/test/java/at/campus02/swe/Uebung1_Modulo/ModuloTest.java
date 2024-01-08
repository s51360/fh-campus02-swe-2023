package at.campus02.swe.Uebung1_Modulo;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ModuloTest extends TestCase {

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testModuloOperation() {
        int zahl1 = 20;
        int zahl2 = 7;
        int expected = 6; // Der erwartete Rest der Division von 20 durch 7 ist 6

        int ergebnis = zahl1 % zahl2;

        Assertions.assertEquals(expected,ergebnis);
    }

    @Test
    public void testModuloOperationWithZeroDivisor() {
        int zahl1 = 20;
        int zahl2 = 0;
        // In Java führt eine Division durch Null zu einer ArithmeticException
        // Daher ist es nicht möglich, ein erwartetes Ergebnis festzulegen
        assertThrows(ArithmeticException.class, () -> {
            int ergebnis = zahl1 % zahl2; // Modulo-Operation mit Null als Divisor
        });
    }

    @Test
    public void testModuloOperationWithNegativeNumbers() {
        int zahl1 = -17;
        int zahl2 = 5;
        int expected = 1234; // Der erwartete Rest der Division von -17 durch 5 ist -2

        int ergebnis = zahl1 % zahl2;

        assertNotEquals(expected, ergebnis, "Der Modulo-Test mit negativen Zahlen ist fehlgeschlagen");
    }

}