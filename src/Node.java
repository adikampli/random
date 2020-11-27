import java.util.concurrent.*;

public class Node {
    //    Node prev;
    int ele;
    Node next;

    public Node(int ele) {
        this.ele = ele;
    }
}

class CustomLL {
    Node first;

    void add(int ele) {
        Node newNode = new Node(ele);
        if (first == null || ele < first.ele) {
            newNode.next = first;
            first = newNode;
        } else {
            Node current = first;
            while (current.next != null && ele > current.next.ele) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
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
        Node ele = first;
        StringBuilder builder = new StringBuilder();
        while (ele != null) {
            builder.append(ele.ele + " -> ");
            ele = ele.next;
        }
        return builder.toString();
    }
}

class Test1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
//        CustomLL ll = new CustomLL();
//        ll.add(2);
//        ll.add(1);
//        ll.add(9);
//        ll.add(11);
//        ll.add(6);
//        ll.add(5);
//        System.out.println(ll);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        Future<String> f = CompletableFuture.supplyAsync(() -> "test", executorService);
        String s = f.get(1, TimeUnit.SECONDS);
        System.out.println(s);
        }
    }
