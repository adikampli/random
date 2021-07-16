package ds;


import java.util.logging.Logger;

public class ArrayBackedBinaryTree {

    Logger log = Logger.getLogger(this.getClass().toString());

    int[] arr;

    public ArrayBackedBinaryTree(int size) {
        this.arr = new int[size];
    }

    public void insert(int val) {

    }

    public void delete(int val) {

    }

    public int search(int val) {

        return -1;
    }

    public static void main(String[] args) {
        ArrayBackedBinaryTree tree = new ArrayBackedBinaryTree(10);
        tree.insert(10);
        tree.insert(30);
        tree.insert(20);
        tree.insert(0);

//        log.info("" + tree.search(22));
    }

}
