package udemy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    @Test
    public void testPalindrome() {
        Palindrome p = new Palindrome();
        assertTrue(p.palindrome("abba"));
        assertTrue(p.palindrome("121"));
        assertTrue(p.palindrome("10101"));
        assertTrue(p.palindrome("1020201"));
        assertFalse(p.palindrome("2020201"));
    }

    @Test
    public void testIntPalindrome() {
        Palindrome p = new Palindrome();
        assertFalse(p.intPalindrome(500));
        assertTrue(p.intPalindrome(121));
        assertTrue(p.intPalindrome(10101));
        assertTrue(p.intPalindrome(1020201));
        assertFalse(p.intPalindrome(2020201));
    }
}