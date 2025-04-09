package Concatena;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcatenaTest {

    @Test
    public void concatenaTest() {
        Concatena A = new Concatena();
        String res = A.concatena("hola", "adios");
        assertEquals("holaadios", res);
        // assertTrue("holaadios".equals(A.concatena("hola", "nada")));
    }
}