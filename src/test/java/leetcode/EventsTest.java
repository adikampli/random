package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EventsTest {
    @Test
    public void testEvents() {
        Events events = new Events();
        assertEquals(4, events.events(new int[][]{{1, 4}, {4, 4}, {2, 2}, {3, 4}, {1, 1}}));
    }

}