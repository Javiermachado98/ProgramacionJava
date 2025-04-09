package Bisiesto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BisiestoTest {

    @Test
    public void testEsBisiesto() {
        Bisiesto b = new Bisiesto();
        assertTrue(b.esBisiesto(2000));
        assertFalse(b.esBisiesto(2100));
        assertEquals(b.esBisiesto(2000), true);
        assertEquals(b.esBisiesto(2018), false);
    }
}