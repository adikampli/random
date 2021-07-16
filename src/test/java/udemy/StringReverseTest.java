package udemy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringReverseTest {

    @Test
    public void testReverse() {
        StringReverse reverse = new StringReverse();
        assertEquals("olleH", reverse.reverse("Hello"));
        assertEquals("!sgniteerG", reverse.reverse("Greetings!"));
        assertEquals("elppa", reverse.reverse("apple"));
    }

    @Test
    public void test() {
        assertEquals(8, StringReverse.howMany(" )}OJR 92ww. z )UPl 49e ]S  g. zrZEnQ  D. FoKp ]ow 1EceB 3oK }w ]CA? L 3LPbDN! trqJY 0sBmm. Nwn"));
    }
}