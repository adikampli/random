package ds;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrayBackedBinaryTree<E> {

    E[] arr;
    int count;

    @SuppressWarnings("unchecked")
    public ArrayBackedBinaryTree(int size) {
        this.arr = (E[]) new Object[size];
    }

    public void insert(E val) {
        if (count <= arr.length)
            arr[count++] = val;
    }

    public void delete(E val) {

    }

    public int search(E val) {

        return -1;
    }

    public void printRightTree() {
        log.info("Printing right side elements");

        for (int j = 0; j < arr.length && arr[j] != null; j = j * 2 + 2) {
            log.info("{}", arr[j]);
        }
    }

    public static void main(String[] args) {
        ArrayBackedBinaryTree<Integer> tree = new ArrayBackedBinaryTree<>(20);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(null);
        tree.insert(5);
        tree.insert(null);
        tree.insert(4);

        tree.printRightTree();
    }

}
