package algorithms.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public static void main(String args[]) {
        /* binary tree yaradırıq və Nodelar əlavə edirik*/
        BinaryTree tree_level = new BinaryTree();
        tree_level.root = new Node(0);
        tree_level.root.left = new Node(1);
        tree_level.root.right = new Node(2);
        tree_level.root.left.left = new Node(3);
        tree_level.root.left.right = new Node(4);
        tree_level.root.right.left = new Node(5);
        tree_level.root.right.right = new Node(6);
        System.out.println("Breadth First Search of binary tree is - ");
        tree_level.printLevelOrder();
    }
}

/* Class to represent Tree node */
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = null;
        right = null;
    }
}

/* Class to print Level Order Traversal */
class BinaryTree {

    Node root;

    /**
     * Queue istifadə edərək BinaryTree-nin
     * nodelarını hər bir levelə görə gəzəcəyk.
     */
    void printLevelOrder() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            /* poll() funksiyası ilə verilmiş nodeu silirik.*/
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            /*sol nodeu queue əlavə edirik */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*sağ nodeu queue əlavə edirik*/
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
}
