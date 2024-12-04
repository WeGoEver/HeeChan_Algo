import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge {
        int destination;
        int weight;

        public Edge(int dest, int weight) {
            this.destination = dest;
            this.weight = weight;
        }
    }
    static class Graph {
        LinkedList<Edge>[] adjList;
        int nodes;

        public Graph(int nodes) {
            this.nodes = nodes + 1;
            adjList = new LinkedList[nodes + 1];
            for (int i = 1; i < nodes + 1; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int src, int dest, int weight) {
            adjList[src].add(new Edge(dest, weight));
            adjList[dest].add(new Edge(src, weight));
            adjList[src].sort(Comparator.comparingInt(edge -> edge.destination));
            adjList[dest].sort(Comparator.comparingInt(edge -> edge.destination));
        }

        public void dfs(int start) {
            boolean[] visited = new boolean[nodes];
            Stack<Integer> stack = new Stack<>();

            stack.push(start);

            while (!stack.isEmpty()) {
                int node = stack.pop();
                if (!visited[node]) {
                    visited[node] = true;
                    System.out.print(node + " ");
                    
                    for (int i = adjList[node].size() - 1; i >= 0; i--) {
                        Edge edge = adjList[node].get(i);
                        if (!visited[edge.destination]) {
                            stack.push(edge.destination);
                        }
                    }
                }
            }
        }

        public void bfs(int start) {
            boolean[] visited = new boolean[nodes];
            Queue<Integer> queue = new LinkedList<>();
            visited[start] = true;
            queue.add(start);

            while (!queue.isEmpty()) {
                int node = queue.poll();
                System.out.print(node + " ");

                for (Edge edge : adjList[node]) {
                    if (!visited[edge.destination]) {
                        visited[edge.destination] = true;
                        queue.add(edge.destination);
                    }
                }
            }
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            graph.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
        }

        graph.dfs(V);
        System.out.println();
        graph.bfs(V);
    }
}
