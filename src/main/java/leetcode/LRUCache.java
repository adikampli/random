package leetcode;

import org.junit.platform.commons.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LRUCache {
    private Node head, tail;
    private Map<Integer, Node> map;
    private final int CAPACITY;

    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        map = new HashMap<>(this.CAPACITY);
        head = new Node();
        tail = new Node();
        head.prev = null;
        tail.next = null;
        head.next = tail;
        tail.prev = head;
    }

    private void deleteNode(Node node) {
        Node prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void updateNode(Node node) {
        deleteNode(node);
        addToTop(node);
    }

    private void addToTop(Node node) {
        Node top = head.next;
        head.next = node;
        node.prev = head;
        node.next = top;
        top.prev = node;
    }

    private void deleteTail() {
        Node tailPrev = tail.prev, prev = tailPrev.prev;
        prev.next = tail;
        tail.prev = prev;
        map.remove(tailPrev.key);
    }

    public int get(int key) {

        Node n = map.get(key);
        if (n != null) {
            updateNode(n);
            return n.val;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        Node n = map.get(key);

        if (n == null) {
            if (map.size() >= CAPACITY) {
                deleteTail();
                addToTop(newNode);
            } else {
                addToTop(newNode);
            }
            map.put(key, newNode);

        } else {
            n.val = value;
            updateNode(n);
            map.put(key, n);
        }
    }
}

class Node {
    Node next;
    Node prev;
    int key, val;

    Node(int key, int val, Node next, Node prev) {
        this.next = next;
        this.prev = prev;
        this.val = val;
        this.key = key;
    }

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    Node() {
    }

}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */