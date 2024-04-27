package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value=value;
        }
        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value=value;
            this.left=left;
            this.right=right;
        }
    }

    TreeNode root;
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        BFS bfs = new BFS();
        bfs.populateSorted(arr, 0, arr.length-1);
        List<List<Integer>> list=bfs.levelOrder();

    }


    private List<List<Integer>> levelOrder() {
        return levelOrder(this.root);
    }


    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> currentLevel = new ArrayList<>(size);
            for(int i =0; i<size; i++){
                TreeNode currentNode=queue.poll();
                currentLevel.add(currentNode.value);
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);

        }
        return result;
    }


    private void populateSorted(int[] arr, int start, int end) {
        if(start >=end){
            return;
        }
        int mid = start + (end - start)/2;
        insert(arr[mid]);
        populateSorted(arr, start, mid);
        populateSorted(arr, mid+1, end);
    }


    public void insert(int value){
       this.root = insert(value,this.root);
    }

    private TreeNode insert(int value, TreeNode node) {
        if(node == null){
            return new TreeNode(value);
        }
        if(value<node.value){
           node.left= insert(value,node.left);
        }else{
            node.right=insert(value, node.right);
        }
        return node;
    }
}
