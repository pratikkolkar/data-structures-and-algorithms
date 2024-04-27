import java.util.*;

/**
 * ShortPath
 */
public class ShortPath {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Map<Integer,List<int[]>> graph = new HashMap<>();
        Scanner s = new Scanner(System.in);
        int N= s.nextInt();
        while(N>0){
            graph.put(s.nextInt(), new ArrayList<>());
            N--;
        }

        int E = s.nextInt();
        while(E>0){
            int p = s.nextInt();
            int q = s.nextInt();
            int t = s.nextInt();
            int[] arr = new int[]{q,t};
            graph.get(p).add(arr);
            E--;
        }
        // System.out.println(graph);
        int src = s.nextInt();
        int dest = s.nextInt();
        s.close();
        // graph.put(2, Arrays.asList(new int[]{9,2}));
        // graph.put(7, Arrays.asList(new int[]{2,3},new int[]{9,7}));
        // graph.put(9, Arrays.asList(new int[]{5,1}));
        // graph.put(5, new ArrayList<>());
        // graph.put(4, new ArrayList<>());

        shortPath(graph,src,dest,0);
        System.out.println(min);

    }

    private static void shortPath(Map<Integer, List<int[]>> graph, int src, int dest,int currentTime) {
    
            if(src ==  dest){
                min =Math.min(min,currentTime);
                return;
            }
            
            for(int[] arr:graph.get(src)){
               shortPath(graph, arr[0], dest,currentTime+arr[1]);
            }
         
    }
}