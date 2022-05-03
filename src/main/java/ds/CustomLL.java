package ds;

class CustomLL<E extends Integer> {
    LLNode<E> first;

    void add(E val) {
        LLNode<E> newLLNode = new LLNode<>(val);
        if (first == null || val.intValue() < first.val.intValue()) {
            newLLNode.next = first;
            first = newLLNode;
        } else {
            LLNode<E> current = first;
            while (current.next != null && val.intValue() > current.next.val.intValue()) {
                current = current.next;
            }
            newLLNode.next = current.next;
            current.next = newLLNode;
        }

//        Node l = last;
//        Node node = new Node(l, ele, null);
//        l.next = node;
//        last = node;


      /*  Node node = first;
        while(node != null) {
            if(node == last) {
                Node newNode = new Node(last, ele, null);
                last= newNode;
                node.next = newNode;
                break;
            }
            if(ele < node.ele){
                Node newNode = new Node(node.prev, ele, node);
                node.prev = newNode;
                break;
            }
            node = node.next;
        }*/
    }

    @Override
    public String toString() {
        LLNode<E> ele = first;
        StringBuilder builder = new StringBuilder();
        while (ele != null) {
            builder.append(ele.val).append(" -> ");
            ele = ele.next;
        }
        return builder.toString();
    }
}