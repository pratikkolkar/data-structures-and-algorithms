import java.util.ArrayList;

public class GP01GraphRespresentation {
    public static void main(String[] args) {   
        int[][] input = { { 1, 2 , 2}, { 1, 3, 3 }, { 2, 4,4 }, { 3, 4,5 }, { 3, 5,6 }, { 4, 5,7 } };
        // matrixRespresentation(input);
        // listRespresentation(input);
        weightedGraph(input);
    }

    private static void weightedGraph(int[][] input) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int nodes = 5;
        for (int i = 0; i <=nodes; i++) {
            adj.add(new ArrayList<Pair>());
        }
        for (int[] arr : input) {
            adj.get(arr[0]).add(new Pair(arr[1],arr[2]));
            adj.get(arr[1]).add(new Pair(arr[0],arr[2]));
            
        }

        for (ArrayList<Pair> arrayList : adj) {
            System.out.println(arrayList);
        }
    }

    private static void listRespresentation(int[][] input) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int nodes = 5;
        for (int i = 0; i <=nodes; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] arr : input) {
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }

        for (ArrayList<Integer> arrayList : adj) {
            System.out.println(arrayList);
        }
    }

    private static void matrixRespresentation(int[][] input) {
        // instantiate adj metrics
        int n = input.length;
        int[][] adj = new int[n + 1][n + 1];
        for(int[] arr: input){
            adj[arr[0]][arr[1]]=1;
            adj[arr[1]][arr[0]]=1;
        }

        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj.length; j++) {
                System.out.print(adj[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}

/**
     * InnerGP01GraphRespresentation
     */
    class Pair {
        int n;
        int w;
        public Pair(int n,int w) {
            this.n=n;
            this.w=2;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "( "+this.n + ", "+this.w+" )";
        }
    }

