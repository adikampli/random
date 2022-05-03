package ds;

public class BinaryTreeOld<E extends Integer> {
    E value;
    BinaryTreeOld<E> left;
    BinaryTreeOld<E> right;

    public BinaryTreeOld(E value) {
        this.value = value;
    }

    public void insert(E value) {
        if (value.intValue() < this.value.intValue()) {
            if (left == null) left = new BinaryTreeOld<>(value);
            else left.insert(value);
        }

        if (value.intValue() > this.value.intValue()) {
            if (right == null) right = new BinaryTreeOld<>(value);
            else right.insert(value);
        }
    }

    public void inOrderTraversal() {
        if (left != null) left.inOrderTraversal();
        System.out.print(value + ",");
        if (right != null) right.inOrderTraversal();
    }

    public void preOrderTraversal() {
        System.out.print(value + ",");
        if (left != null) left.inOrderTraversal();
        if (right != null) right.inOrderTraversal();
    }

    public void rightOrderTraversal() {
        System.out.println(value);
        if (right != null) {
//            System.out.println(right.data);
            right.rightOrderTraversal();
        }
    }

    public static void main(String[] args) {
        BinaryTreeOld<Integer> node = new BinaryTreeOld<>(29);

        node.insert(10);
        node.insert(39);
        node.insert(64);
        node.insert(11);

        node.inOrderTraversal();
        System.out.println();
        node.preOrderTraversal();
        System.out.println("RIghtOrder ");
        node.rightOrderTraversal();
    }

}
