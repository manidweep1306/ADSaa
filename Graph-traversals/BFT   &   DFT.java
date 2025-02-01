import java.util.*;

public class BFTDFTList{
    private static void BFT(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                BFS(adj, i, visited);
            }
        }
    }
    private static void BFS(List<List<Integer>> adj,int s, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>(); 
        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            int curr = q.poll(); 
            System.out.print(curr + " ");
            for (int x : adj.get(curr)) {
                if (!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
    }

    public static void addEdge(List<List<Integer>> adj, 
                                    int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    private static void DFT(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                DFS(adj, i, visited);
            }
        }
    }
    private static void DFS(List<List<Integer>> adj, 
                            int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int x : adj.get(s)) {
            if (!visited[x]) {
                DFS(adj, x, visited);
            }
        }
    }
    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>(V); 
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 0, 5);
        addEdge(adj, 0, 4);
        addEdge(adj, 3, 5);
        addEdge(adj, 1, 2);
        addEdge(adj, 3, 2);
        System.out.println("BFS: ");  
        BFT(adj);
        System.out.println("\nDFS: ");
        DFT(adj);

    }
}
