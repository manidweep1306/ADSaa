import java.io.*;
// import java.util.*;

class AVLTree {
    class Node {
        int data, height;
        Node left, right;
        Node(int d) {
            data = d;
            height = 1;
        }
    }

    private Node root;

    // Utility methods to calculate height, balance factor, and rotations
    int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

    int getBalanceFactor(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    // Left and right rotations to balance the tree
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    // Insert and Delete operations
    Node insertNode(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.data) {
            node.left = insertNode(node.left, value);
        } else if (value > node.data) {
            node.right = insertNode(node.right, value);
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1) {
            if (value < node.left.data) {
                return rightRotate(node);
            } else {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (balanceFactor < -1) {
            if (value > node.right.data) {
                return leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    Node deleteNode(Node root, int value) {
        if (root == null) return root;
        if (value < root.data) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.data) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left == null || root.right == null) {
                Node temp = root.left != null ? root.left : root.right;
                if (temp == null) {
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                Node temp = minValueNode(root.right);
                root.data = temp.data;
                root.right = deleteNode(root.right, temp.data);
            }
        }

        if (root == null) return root;

        root.height = 1 + Math.max(height(root.left), height(root.right));

        int balance = getBalanceFactor(root);
        if (balance > 1) {
            if (getBalanceFactor(root.left) >= 0) {
                return rightRotate(root);
            } else {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }
        if (balance < -1) {
            if (getBalanceFactor(root.right) <= 0) {
                return leftRotate(root);
            } else {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }
        return root;
    }

    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // In-order traversal
    void inorder(Node root, PrintWriter writer) {
        if (root != null) {
            inorder(root.left, writer);
            writer.print(root.data + " ");
            inorder(root.right, writer);
        }
    }

    // Driver code
    public static void main(String[] args) throws IOException {
        AVLTree tree = new AVLTree();

        // Read elements from a file
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(" ");
            for (String value : values) {
                int num = Integer.parseInt(value);
                tree.root = tree.insertNode(tree.root, num);
            }
        }
        reader.close();

        // In-order traversal and write to file
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));
        tree.inorder(tree.root, writer);
        writer.close();
    }
}
