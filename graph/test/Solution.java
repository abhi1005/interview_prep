package graph.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges = {{1,2},{1,3},{2,3}};
        int[] ret = sol.findRedundantConnection(edges);
        System.err.println(ret[0]+","+ret[1]);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int totalEdges = edges.length;
        //calculate all the vertex
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<totalEdges;i++){
            set.add(edges[i][0]);
            set.add(edges[i][1]);
        }
        int[] retEdges = new int[2];
        Graph g = new Graph(set.size(), totalEdges);
        for(int i = 0; i < totalEdges; i++){
            g.edge[i].src = edges[i][0];
            g.edge[i].dest = edges[i][1];
        }

        if(g.isCycle(g) == 1){
            List<Integer> cycleVertexes = g.cycleVertexes;
            retEdges[0] = cycleVertexes.get(0);
            retEdges[1] = cycleVertexes.get(1);
        }
        return retEdges;
    }
}

class Graph {
    int V, E;    // V-> no. of vertices & E->no.of edges
    Edge edge[]; // /collection of all edges
    List<Integer> cycleVertexes; //for detecting cycle

    class Edge {
        int src, dest;
    };

    // Creates a graph with V vertices and E edges
    Graph(int v, int e) {
        V = v;
        E = e;
        cycleVertexes = new ArrayList<>();
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    // A utility function to find the subset of an element i
    int find(int parent[], int i)
    {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    // A utility function to do union of two subsets
    void union(int parent[], int x, int y)
    {
        parent[x] = y;
    }


    // The main function to check whether a given graph
    // contains cycle or not
    int isCycle( Graph graph)
    {
        // Allocate memory for creating V subsets
        int parent[] = new int[graph.V];

        // Initialize all subsets as single element sets
        for (int i=0; i<graph.V; ++i)
            parent[i]=-1;

        // Iterate through all edges of graph, find subset of both
        // vertices of every edge, if both subsets are same, then
        // there is cycle in graph.
        for (int i = 0; i < graph.E; ++i)
        {
            int x = find(parent, graph.edge[i].src-1);
            int y = find(parent, graph.edge[i].dest-1);

            if (x == y){
                //System.out.println(x+","+y);
                cycleVertexes.add(graph.edge[i].src);
                cycleVertexes.add(graph.edge[i].dest);
                return 1;
            }

            union(parent, x, y);
        }
        return 0;
    }
}
