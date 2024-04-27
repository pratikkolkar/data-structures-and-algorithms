package trees;

public class PathSum {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static void main(String[] args) {
        Integer[] arr={10,5,-3,3,2,null,11,3,-2,null,1};
        PathSum p=new PathSum();

        TreeNode node = p.new TreeNode(10);
        TreeNode root=node;
        node.left=p.new TreeNode(5);
        node.right=p.new TreeNode(-3);
        TreeNode nodeL=node.left;
        TreeNode nodeR=node.right;
        nodeL.left=p.new TreeNode(3);
        nodeL.right=p.new TreeNode(2);
        nodeL.right.right=p.new TreeNode(1);
        nodeR.right=p.new TreeNode(11);
        nodeL=nodeL.left;
        nodeL.left=p.new TreeNode(3);
        nodeL.right=p.new TreeNode(-2);

        int count = addsum(root,8,0);
        System.out.println(count);
    }

    static public int addsum(TreeNode node, int targetSum, int runSum) {
        if(node == null){
            return 0;
        }
       if(node.val + runSum > targetSum){
         if(node.val > targetSum){
            runSum = 0;
        }else{
            runSum = node.val;
        }
        }else{
            runSum +=node.val;
        }
        int count=0;
        if(runSum == targetSum || node.val == targetSum){
            count++;
        }

        count += addsum(node.left, targetSum,runSum);
        count += addsum(node.right, targetSum,runSum);
        return count;

        
    }

 
  
//   public TreeNode insert(Integer[] arr){
//     TreeNode node=new TreeNode(arr[0]);
//     TreeNode root=node;
//     for(int i=1; i<arr.length; i++){
//         if(arr[i]!=null){
//         if(1%2!=0){
//             node.left=new TreeNode(arr[i]);

//         }
//     }
//     }

//     return node;
//   }
}
