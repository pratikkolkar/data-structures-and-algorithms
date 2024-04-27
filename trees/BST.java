package trees;

public class BST {
    private class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;
        public Node(int value){
            this.value= value;
        }
    }
    private Node root;

    public BST() {
    }

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty() {
        return this.root == null;
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
        node.height =  Math.max(height(node.left),height(node.right)) + 1;
        return node;
    }

    public boolean isBalanced(){
        return isBalanced(this.root);
    }

    private boolean isBalanced(Node node) {
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <=1 && isBalanced(node.left) && isBalanced(node.right);
    }

    public void display(){
        display(this.root);
    }

    private void display(Node node) {
        if (node == null) {
            return;
        }

        System.out.println("Root Node: "+node.value);
        System.out.println("Left of Node "+node.value+ node.left.value);
        System.out.println("Right of Node "+node.value+ node.right.value);
        display(node.left);
        display(node.right);
    }

    public void populate(int[] arr){
        for(int num:arr){
            insert(num);
        }
    }

    public void populateSorted(int[] arr){
        populateSorted(arr,0,arr.length-1);
    }

    private void populateSorted(int[] arr, int start, int end) {
        if(start >=end){
            return;
        }
        int mid = start + (end - start)/2;
        this.insert(arr[mid]);
        populateSorted(arr, start, mid);
        populateSorted(arr, mid+1, end);
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

}
