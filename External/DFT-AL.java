import java.util.*;
class DFTL {
    private List<List<Integer>> adjList;
    private int vertices;

    public DFTL(int size) {
        vertices = size;
        adjList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void printDFT(int start) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        System.out.print("DFT: ");
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited[vertex]) {
                System.out.print(vertex + " ");
                visited[vertex] = true;
                for (int neighbor : adjList.get(vertex)) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DFTL graph = new DFTL(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.printDFT(0); // Start DFT from vertex 0
    }
}
