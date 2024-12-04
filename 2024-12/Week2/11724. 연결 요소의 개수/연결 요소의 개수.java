import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    static class Edge{
        int destination;

        public Edge(int destination) {
            this.destination = destination;
        }
    }
    static class Graph{
        int nodes;
        LinkedList<Edge>[] adjList;
        boolean flag = false;
        int count = 0;

        public Graph(int nodes) {
            this.nodes = nodes + 1;
            adjList = new LinkedList[nodes + 1];
            for (int i = 1; i < nodes + 1; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
        public void addEdge(int src, int dest) {
            adjList[src].add(new Edge(dest));
            adjList[dest].add(new Edge(src));
        }

        public void dfs(int start) {
            boolean[] visited = new boolean[nodes];
            Stack<Integer> stack = new Stack<>();

            stack.push(start);
            
            while(!stack.isEmpty()){
                int node = stack.pop();

                if(!visited[node]){
                    visited[node] = true;

                    for (Edge edge : adjList[node]) {
                        if (!visited[edge.destination]) {
                            stack.push(edge.destination);
                            flag = true;
                        }
                    }
                }
                if(stack.isEmpty()){
                    if(flag) count++;

                    for(int i = 1 ; i< nodes ; i++){
                        if(!visited[i]){
                            stack.push(i);
                            break;
                        }
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

        Graph graph = new Graph(N);


        try{
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            graph.addEdge(start, Integer.parseInt(st.nextToken()));

            for (int i = 1; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                graph.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            graph.dfs(start);

            System.out.println(graph.count);

        } catch(Exception e){
            System.out.println(N);
        }
    }
}
