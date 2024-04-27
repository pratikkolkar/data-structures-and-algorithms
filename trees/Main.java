package trees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        binaryTree();
        binarySearchTree();
        avlTree();
    }

    private static void avlTree() {
        AVL avl= new AVL();
        // int[] arr = {1,90,3,4,76,6,7,8,34,10};
        // avl.populateSorted(arr);
        for (int i = 0; i < 20; i++) {
            avl.insert(i);
        }
        // avl.populate(arr);
        // System.out.println(avl.height());
        avl.prettyDisplay();
        System.out.println(avl.isBalanced());
    }

    private static void binarySearchTree() {
        BST bst= new BST();
        int[] arr = {1,90,3,4,76,6,7,8,34,10};
        bst.populateSorted(arr);
        bst.prettyDisplay();
        System.out.println(bst.isBalanced());
    }

    private static void binaryTree() {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt= new BinaryTree();
        bt.populate(scanner);
        // bt.prettyDisplay();
        System.out.println("Pre-Order:");
        bt.preOrder();
        System.out.println("In-Order:");
        bt.inOrder();
        System.out.println("Pre-Order:");
        bt.postOrder();
    }


    
}
