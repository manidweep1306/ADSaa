import java.util.*;

public class BFSAM {
    static void bfs(int[][] adj, int start) {
        boolean[] visited = new boolean[adj.length];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        System.out.print("BFSM : ");
        while (!q.isEmpty()) {
            int vis = q.poll();
            System.out.print(vis + " ");

            for (int i = 0; i < adj.length; i++) {
                if (adj[vis][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] adj = {
            {0, 1, 0, 0, 0}, 
            {0, 0, 1, 0, 0}, 
            {0, 0, 0, 1, 0}, 
            {0, 0, 0, 0, 1}, 
            {1, 0, 0, 0, 0}
        };
        bfs(adj, 0);
    }
}
