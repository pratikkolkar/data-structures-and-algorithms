package trees;

public class AVL {
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

    public AVL() {
    }
    public int height() {
        return height(this.root);
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
        return rotate(node);
    }

    public Node rotate(Node node){
        if(height(node.left)-height(node.right) > 1){
            if(height(node.left.left) - height(node.left.right) > 1){
                //left left
                return rotateRight(node);
            }
            if(height(node.left.left) - height(node.left.right) < -1){
                // left right
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }

        if(height(node.left)-height(node.right) < -1){
             if(height(node.right.left)  - height(node.right.right) > 1){
                //left left
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
            if(height(node.right.left) - height(node.right.right) < -1){
                // left right
                // node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }
        return node;
    }

    private Node rotateLeft(Node c) {
        Node g = c.right;
        c.right = g.left;
        g.left = c;
        g.height=Math.max(height(g.left), height(g.right))+1;
        c.height=Math.max(height(c.left), height(c.right))+1;
        return g;
    }

    private Node rotateRight(Node p) {
        Node c = p.left;
        p.left=c.right;
        c.right=p;
        p.height=Math.max(height(p.left), height(p.right))+1;
        c.height=Math.max(height(c.left), height(c.right))+1;
        return c;
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
