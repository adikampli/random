package udemy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxCharsTest {

    @Test
    public void testMaxChars() {
        MaxChars c = new MaxChars();
        assertEquals('c', c.maxChars("acccasd"));
        assertEquals('e', c.maxChars("Hello There!"));
    }

}