package ds;

public class LLNode<E> {
    E val;
    LLNode<E> next;

    public LLNode(E val) {
        this.val = val;
    }

    public LLNode(E val, LLNode<E> next) {
        this.val = val;
        this.next = next;
    }
}


