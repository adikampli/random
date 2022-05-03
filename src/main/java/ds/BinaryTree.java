package ds;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E extends Integer> {

    private BinaryTreeNode<E> root;

    public void insert(E value) {
        root = insert(root, value);
    }

    private BinaryTreeNode<E> insert(BinaryTreeNode<E> binaryTreeNode, E value) {
        BinaryTreeNode<E> newBinaryTreeNode = new BinaryTreeNode<>(value);

        if (binaryTreeNode == null) {
            binaryTreeNode = newBinaryTreeNode;
            return binaryTreeNode;
        } else if (value.intValue() > binaryTreeNode.val.intValue()) {
            binaryTreeNode.right = insert(binaryTreeNode.right, value);
        } else {
            binaryTreeNode.left = insert(binaryTreeNode.left, value);
        }
        return binaryTreeNode;
    }

    public void delete(int key) {
        root = deleteNode(root, key);
    }

    public BinaryTreeNode<E> findMin(BinaryTreeNode<E> binaryTreeNode) {
        while (binaryTreeNode.left != null) {
            binaryTreeNode = binaryTreeNode.left;
        }
        return binaryTreeNode;
    }

    public BinaryTreeNode<E> deleteNode(BinaryTreeNode<E> binaryTreeNode, int key) {
        if (binaryTreeNode == null) {
            return null;
        } else if (binaryTreeNode.val.intValue() < key) {
            binaryTreeNode.right = deleteNode(binaryTreeNode.right, key);
        } else if (binaryTreeNode.val.intValue() > key) {
            binaryTreeNode.left = deleteNode(binaryTreeNode.left, key);
        } else {
            if (binaryTreeNode.left == null && binaryTreeNode.right == null) {
                binaryTreeNode = null;
            } else if (binaryTreeNode.left == null) {
                binaryTreeNode = binaryTreeNode.right;
            } else if (binaryTreeNode.right == null) {
                binaryTreeNode = binaryTreeNode.left;
            } else {
                BinaryTreeNode<E> min = findMin(binaryTreeNode.right);
                binaryTreeNode.val = min.val;

                binaryTreeNode.right = deleteNode(binaryTreeNode.right, binaryTreeNode.val);
            }
        }
        return binaryTreeNode;
    }

    public void inorderTraversal() {
        inorder(root);
    }

    public void inorder(BinaryTreeNode<E> binaryTreeNode) {
        if (binaryTreeNode != null) {
            inorder(binaryTreeNode.left);
            System.out.println(binaryTreeNode.val);
            inorder(binaryTreeNode.right);
        }
    }

    public void preorderTraversal() {
        preorder(root);
    }

    public void preorder(BinaryTreeNode<E> binaryTreeNode) {
        if (binaryTreeNode != null) {
            System.out.println(binaryTreeNode.val);
            preorder(binaryTreeNode.left);
            preorder(binaryTreeNode.right);
        }
    }

    public void postorderTraversal() {
        postorder(root);
    }

    public void postorder(BinaryTreeNode<E> binaryTreeNode) {
        if (binaryTreeNode != null) {
            postorder(binaryTreeNode.left);
            postorder(binaryTreeNode.right);
            System.out.println(binaryTreeNode.val);
        }
    }

    public void levelOrderTraversal() {
        Queue<BinaryTreeNode<E>> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                BinaryTreeNode<E> curr = queue.poll();
                assert curr != null;
                System.out.println(curr.val.intValue());
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
    }


    public int maxDepth(BinaryTreeNode<E> binaryTreeNode) {
        if (binaryTreeNode == null) return 0;
        return Integer.max(maxDepth(binaryTreeNode.left), maxDepth(binaryTreeNode.left)) + 1;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(8);

        System.out.println("Inorder");
        tree.inorderTraversal();
        tree.delete(8);
        System.out.println("Inorder");
        tree.inorderTraversal();
        System.out.println("Preorder");
        tree.preorderTraversal();
        System.out.println("Postorder");
        tree.postorderTraversal();
        System.out.println("Level Order");
        tree.levelOrderTraversal();
        System.out.println("Max Depth : " + tree.maxDepth(tree.root));
    }
}
