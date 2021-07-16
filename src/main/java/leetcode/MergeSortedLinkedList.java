package leetcode;

/**
 * Definition for singly-linked list.
 * public class leetcode.ListNode {
 * int val;
 * leetcode.ListNode next;
 * leetcode.ListNode() {}
 * leetcode.ListNode(int val) { this.val = val; }
 * leetcode.ListNode(int val, leetcode.ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeSortedLinkedList {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode newNode;
        ListNode sorted = new ListNode();
        ListNode head = sorted;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newNode = new ListNode(l1.val, null);
                l1 = l1.next;
            } else {
                newNode = new ListNode(l2.val, null);
                l2 = l2.next;
            }

            sorted.next = newNode;
            sorted = sorted.next;
        }
        while (l1 != null) {
            sorted.next = l1;
            sorted = sorted.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            sorted.next = l2;
            sorted = sorted.next;
            l2 = l2.next;
        }
        return head.next;
    }
}