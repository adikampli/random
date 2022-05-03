package ds;

public class SinglyLinkedList<E> {
    LLNode<E> head = null;

    public void add(E ele) {
        LLNode<E> newLLNode;
        if (head == null) {
            newLLNode = new LLNode<E>(ele, null);
        } else {
            newLLNode = new LLNode<E>(ele, head);
        }
        head = newLLNode;
    }

    public E get() {
        return null;
    }

    public E remove() {
        return null;
    }

    public void reverse() {
        LLNode<E> curr = head;
        LLNode<E> prev = null, temp = null;

        while (curr != null) {
            temp = curr;
            curr = curr.next;

            temp.next = prev;
            prev = temp;
            head = temp;
        }

    }

    public static void main(String[] args) {
        SinglyLinkedList<String> node = new SinglyLinkedList<>();
        node.add("test");
        node.add("test2");
        node.add("test3");

        LLNode<String> current = node.head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }

        node.reverse();
        current = node.head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

}
