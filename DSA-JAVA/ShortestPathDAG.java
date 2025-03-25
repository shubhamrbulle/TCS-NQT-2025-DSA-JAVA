/*
 * Shortest Path in a Directed Acyclic Graph
 * Given a Directed Acyclic Graph (DAG) with N vertices and E edages, find the 
 * Shortest Path from the initial state to the destination state.
 * Input: 5, 7, 0 1 2,0 2 4, 1 2 2, 1 3 4,2 3 5,2 4 3,3 4 1,0,4
 * Output: 0 -> 2 -> 3 -> 4
 * Total Weight: 6
 */

 import java.util.*;

class Graph {
    private int V;
    private List<List<int[]>> adj;

    // Constructor to initialize graph
    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add directed edge (u -> v) with weight w
    public void addEdge(int u, int v, int weight) {
        adj.get(u).add(new int[]{v, weight});
    }

    // Perform topological sort using DFS
    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int[] neighbor : adj.get(v)) {
            if (!visited[neighbor[0]]) {
                topologicalSortUtil(neighbor[0], visited, stack);
            }
        }
        stack.push(v);
    }

    // Find shortest path using topological order
    public void findShortestPath(int src) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        // Perform Topological Sort
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        // Initialize distances to all vertices as infinity
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Process vertices in topological order
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (dist[u] != Integer.MAX_VALUE) {
                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0];
                    int weight = neighbor[1];
                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                    }
                }
            }
        }

        // Print shortest distances
        System.out.println("Shortest Path from Node " + src + ":");
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(i + " : Unreachable");
            } else {
                System.out.println(i + " : " + dist[i]);
            }
        }
    }
}

public class ShortestPathDAG {
    public static void main(String[] args) {
        int V = 5;
        Graph graph = new Graph(V);

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 3, 2);
        graph.addEdge(3, 4, 1);
        graph.addEdge(2, 4, 3);

        graph.findShortestPath(0);
    }
}
