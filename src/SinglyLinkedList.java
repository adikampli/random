class SinglyNode {
    SinglyNode next;
    String ele;

    public SinglyNode(SinglyNode next, String ele) {
        this.next = next;
        this.ele = ele;
    }

    public String getEle() {
        return ele;
    }
}

public class SinglyLinkedList {
    SinglyNode head = null;

    public void add(String ele) {
        SinglyNode newNode;
        if (head == null) {
            newNode = new SinglyNode(null, ele);
        } else {
            newNode = new SinglyNode(head, ele);
        }
        head = newNode;
    }

    public String get() {
        return null;
    }

    public String remove() {
        return null;
    }

    public void reverse() {
        SinglyNode curr = head;
        SinglyNode prev = null, temp = null;

        while(curr != null) {
            temp = curr;
            curr = curr.next;

            temp.next = prev;
            prev = temp;
            head = temp;
        }

    }

    public static void main(String[] args) {
        SinglyLinkedList node = new SinglyLinkedList();
        node.add("test");
        node.add("test2");
        node.add("test3");

        SinglyNode current = node.head;
        while (current != null) {
            System.out.println(current.getEle());
            current = current.next;
        }

        node.reverse();
        current = node.head;
        while (current != null) {
            System.out.println(current.getEle());
            current = current.next;
        }
    }

}
