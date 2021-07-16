package leetcode;

public class LinkedListPalindrome {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode el1 = new ListNode();
        ListNode el2 = new ListNode();
        ListNode el3 = new ListNode();
        ListNode el4 = new ListNode();
        ListNode el5 = new ListNode();

        head.val = 1;
        head.next = el1;

        el1.val = 2;
        el1.next = el2;

        el2.val = 2;
        el2.next = el3;

        el3.val = 1;
//        el3.next = el4;

        el4.val = 0;
        el4.next = el5;

        el5.val = 1;
//        el5.next = el4;

        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode temp, curr = head, prev = null;
        while (curr.next != null) {
            temp = curr;
            curr.next = prev;
        }
        return true;
    }
}