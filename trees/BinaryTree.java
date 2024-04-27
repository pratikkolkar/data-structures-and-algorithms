package trees;

import java.util.Scanner;

public class BinaryTree {
    
    public BinaryTree() {}

    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    //insert elements
    public void populate(Scanner scanner){
        System.out.println("Enter the root node: ");
        this.root = new Node(scanner.nextInt());
        populate(scanner,root);
    }

    
    private void populate(Scanner scanner, Node root) {
        System.out.println("Do you want to enter node to left of "+root.value+" ?");
        if(scanner.nextBoolean()){
            System.out.println("Enter the node: ");
            root.left = new Node(scanner.nextInt());
            populate(scanner,root.left);
        }
        System.out.println("Do you want to enter node to right of "+root.value+" ?");
        if(scanner.nextBoolean()){
            System.out.println("Enter the node: ");
            root.right = new Node(scanner.nextInt());
            populate(scanner,root.right);
        }
    }

    public void display() {
        display(this.root, "");
      }
    
      private void display(Node node, String indent) {
        if (node == null) {
          return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
      }
    
      public void prettyDisplay() {
        prettyDisplay(root, 0);
      }
    
      private void prettyDisplay(Node node, int level) {
        if (node == null) {
          return;
        }
    
        prettyDisplay(node.right, level + 1);
    
        if (level != 0) {
          for (int i = 0; i < level - 1; i++) {
            System.out.print("|\t\t");
          }
          System.out.println("|------->" + node.value);
        } else {
          System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);
      }

      public void preOrder(){
        preOrder(this.root);
      }


      private void preOrder(Node node) {
        if(node == null){
          return;
        }
        System.out.print(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
      }


      public void inOrder(){
        inOrder(this.root);
      }


      private void inOrder(Node node) {
        if(node == null){
          return;
        }
        inOrder(node.left);
        System.out.print(node.value+" ");
        inOrder(node.right);
      }

      public void postOrder(){
        postOrder(this.root);
      }


      private void postOrder(Node node) {
        if (node == null) {
          return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+" ");
      }

      public void insert(int value){
        this.root = insert(value,this.root);
     }
 
     private Node insert(int value, Node node) {
         if(node == null){
             return new Node(value);
         }
         if(value<node.value){
            node.left= insert(value,node.left);
         }else{
             node.right=insert(value, node.right);
         }
 
         //adjust the height
        //  node.height =  Math.max(height(node.left),height(node.right)) + 1;
         return node;
     }
     public void populate(int[] arr){
      for(int num:arr){
          insert(num);
      }
  }
}
