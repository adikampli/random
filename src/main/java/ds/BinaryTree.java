package ds;

public class BinaryTree {

    static class Node {
        int key;
        String value;
        private Node left;
        private Node right;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    public void insert(int key, String value) {
        root = insert(root, key, value);
    }

    private Node insert(Node node, int key, String value) {
        Node newNode = new Node(key, value);

        if (node == null) {
            node = newNode;
            return node;
        } else if (key > node.key) {
            node.right = insert(node.right, key, value);
        } else {
            node.left = insert(node.left, key, value);
        }
        return node;
    }

    public void delete(int key) {
        root = deleteNode(root, key);
    }

    public Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Node deleteNode(Node node, int key) {
        if (node == null) {
            return null;
        } else if (node.key < key) {
            node.right = deleteNode(node.right, key);
        } else if (node.key > key) {
            node.left = deleteNode(node.left, key);
        } else {
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {

                Node min = findMin(node.right);
                node.key = min.key;
                node.value = min.value;

                node.right = deleteNode(node.right, node.key);
            }
        }
        return node;
    }

    public void inorderTraversal() {
        inorder(root);
    }

    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.key);
            inorder(node.right);
        }
    }

    public void preorderTraversal() {
        preorder(root);
    }

    public void preorder(Node node) {
        if (node != null) {
            System.out.println(node.key);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorderTraversal() {
        postorder(root);
    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.key);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(5, "sdf");
        tree.insert(3, "ghg");
        tree.insert(8, "sdfa");
        tree.insert(2, "yui");

        System.out.println("Inorder");
        tree.inorderTraversal();
        tree.delete(5);
        System.out.println("Inorder");
        tree.inorderTraversal();
        System.out.println("Preorder");
        tree.preorderTraversal();
        System.out.println("Postorder");
        tree.postorderTraversal();
    }
}
