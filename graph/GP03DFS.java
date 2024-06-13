import java.util.ArrayList;

public class GP03DFS {
    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);
        

        ArrayList < Integer > ans = dfsOfGraph(5, adj);
        int n = ans.size(); 
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" "); 
        }
    }

    private static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        dfs(adj,0,vis,dfs);
        return dfs;
    }

    /* 
     * TC: O(N) + O(2E)
     * SC: O(N) + O(N) + O(N) ~ O(N)
     */
    private static void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis, ArrayList<Integer> dfs) {
        vis[node]=true;
        dfs.add(node);
        for(int n: adj.get(node)){
            if(!vis[n]){
                dfs(adj,n,vis,dfs);
            }
        }
    }
}
