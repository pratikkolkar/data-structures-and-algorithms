import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GP02BFS {
    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
         
        ArrayList < Integer > ans = bfsOfGraph(5, adj);
        int n = ans.size(); 
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" "); 
        }
    }

    /* 
     * TC: O(N) + O(2E) - inner for loop which represents degree of graph
     * SC: O(3N) ~ O(N)
     */
    private static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[V];
        queue.add(0);
        vis[0]=true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfs.add(node);
            for (int num : adj.get(node)) {
                if(!vis[num]){
                    queue.add(num);
                    vis[num]=true;
                }
            }
        }
        return bfs;
    }
}
