import java.util.Scanner;

class BST {
    // Node class to represent a node in the tree
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Root of the tree
    static Node root = null;

    // Insert method to add a new node to the BST
    static Node insert(Node root, int item) {
        if (root == null) {
            root = new Node(item);  // Create a new node if root is null
        } else if (item < root.data) {
            root.left = insert(root.left, item);  // Insert in left subtree
        } else {
            root.right = insert(root.right, item);  // Insert in right subtree
        }
        return root;
    }

    // Inorder traversal (Left, Root, Right)
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.printf("%4d", root.data);
            inorder(root.right);
        }
    }

    // Preorder traversal (Root, Left, Right)
    static void preorder(Node root) {
        if (root != null) {
            System.out.printf("%4d", root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder traversal (Left, Right, Root)
    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.printf("%4d", root.data);
        }
    }

    // Count the number of nodes in the tree
    static int count(Node root) {
        if (root == null) {
            return 0;
        } else {
            return count(root.left) + count(root.right) + 1;
        }
    }

    // Main method to drive the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int item, ch;

        // Insert elements into the BST
        do {
            System.out.print("Enter the Element: ");
            item = scanner.nextInt();
            root = insert(root, item);
            System.out.print("Press 1 to continue: ");
            ch = scanner.nextInt();
        } while (ch == 1);

        // Output number of nodes
        System.out.println("No. of Nodes: " + count(root));

        // Inorder traversal
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        // Preorder traversal
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();

        // Postorder traversal
        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();

        scanner.close();
    }
}
