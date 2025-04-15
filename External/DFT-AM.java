
import java.util.*;
public class DFS {
    public static void dfs(int[][] adj, boolean[] visited, int node) {
        System.out.print(node + " ");
        visited[node] = true;

        for (int i = 0; i < adj.length; i++) {
            if (adj[node][i] == 1 && !visited[i]) {
                dfs(adj, visited, i);
            }
        }
    }

    public static void main(String[] args) {
        int[][] adj = {
            {0, 1, 0, 0, 0}, 
            {0, 0, 1, 0, 0}, 
            {0, 0, 0, 1, 0}, 
            {0, 0, 0, 0, 1}, 
            {1, 0, o, 0, 0}
        };
        
        boolean[] visited = new boolean[adj.length];
        System.out.print("DFS Traversal: ");
        dfs(adj, visited, 0); // Start DFS from node 0
        System.out.println();
    }
}

