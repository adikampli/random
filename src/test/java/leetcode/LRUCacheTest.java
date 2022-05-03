package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {
    @Test
    void test() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 2);
        cache.put(2, 2);
        cache.put(3, 2);

        assertEquals(-1, cache.get(1));
        assertEquals(2, cache.get(2));
        cache.put(4, 4);
        assertEquals(4, cache.get(4));

        assertEquals(-1, cache.get(3));

    }
}