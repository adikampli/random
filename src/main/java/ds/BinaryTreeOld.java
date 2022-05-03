package ds;

public class BinaryTreeOld {
    int data;
    BinaryTreeOld left;
    BinaryTreeOld right;

    public BinaryTreeOld(int value) {
        this.data = value;
    }

    public void insert(int value) {
        if (value < data) {
            if (left == null) left = new BinaryTreeOld(value);
            else left.insert(value);
        }

        if (value > data) {
            if (right == null) right = new BinaryTreeOld(value);
            else right.insert(value);
        }
    }

    public void inOrderTraversal() {
        if (left != null) left.inOrderTraversal();
        System.out.print(data + ",");
        if (right != null) right.inOrderTraversal();
    }

    public void preOrderTraversal() {
        System.out.print(data + ",");
        if (left != null) left.inOrderTraversal();
        if (right != null) right.inOrderTraversal();
    }

    public void rightOrderTraversal() {
        System.out.println(data);
        if(right != null) {
//            System.out.println(right.data);
            right.rightOrderTraversal();
        }
    }

    public static void main(String[] args) {
        BinaryTreeOld node = new BinaryTreeOld(29);

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
