package algorithms.dfs;

public class DepthFirstSearch {
    // Driver code
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

//        BinaryTree tree_level = new BinaryTree();
//        tree_level.root = new Node(0);
//        tree_level.root.left = new Node(1);
//        tree_level.root.right = new Node(2);
//        tree_level.root.left.left = new Node(3);
//        tree_level.root.left.right = new Node(4);
//        tree_level.root.right.left = new Node(5);
//        tree_level.root.right.right = new Node(6);

        // Function call
        System.out.println(
                "Preorder traversal of binary tree is ");
        tree.printPreorder();
    }
}

/* Class containing left and right child of current
node and key value*/
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinaryTree {
    // Root of Binary Tree
    Node root;

    BinaryTree() {
        root = null;
    }

    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node) {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.key + " ");

        /* then recur on left subtree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }

    // Wrappers over above recursive functions
    void printPreorder() {
        printPreorder(root);
    }
}

