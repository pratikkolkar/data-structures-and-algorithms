import java.util.ArrayList;

public class GP04NumberofProvinces {
    public static void main(String[] args) {
         // adjacency matrix 
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();

        adj.add(new ArrayList<Integer>());
        adj.get(0).add(0, 1);
        adj.get(0).add(1, 0);
        adj.get(0).add(2, 1);
        adj.add(new ArrayList<Integer>());
        adj.get(1).add(0, 0);
        adj.get(1).add(1, 1);
        adj.get(1).add(2, 0);
        adj.add(new ArrayList<Integer>());
        adj.get(2).add(0, 1);
        adj.get(2).add(1, 0);
        adj.get(2).add(2, 1);
                

        System.out.println(numProvinces(adj,3));
    }

    /* 
     * TC: O(N) + O(V+2E)
     * SC: O(N)
     */
    private static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] vis = new boolean[V];
        int cnt=0;
        for (int i = 0; i <vis.length; i++) {
            if (!vis[i]) {
                cnt++;
                dfs(adj,i,vis);
            }
        }
        return cnt;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis) {
        vis[node]=true;
        for(int n: adj.get(node)){
            if(!vis[n]){
                dfs(adj,n,vis);
            }
        }
    }
}
