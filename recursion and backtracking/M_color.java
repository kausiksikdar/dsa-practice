import java.util.*;
public class M_color {
    static boolean DFS(int node, int[] color, int v, boolean[][] graph, int m) {
        // Base case: if we've processed all vertices, coloring is complete
    if(node == v)
        return true;
    
        // Try each color (0 to m-1) for current node
    for(int i = 0; i < m; i++) {
        //Indicates if current color i is possible for current node
        boolean isPossible = true;
        
        // Check if any adjacent vertex has the same color i
        for(int j = 0; j < v; j++) {
            if(graph[node][j] && color[j] == i) {
                isPossible = false;
                break;
            }
        }
        
        // If color i conflicts with adjacent vertices, don't proceed and try next color
        if(!isPossible)
        continue;
        
        // Assign color i to current node
        color[node] = i;
        
        // Recursively try to color all uncolored adjacent vertices
        for(int j = 0; j < v; j++) {
            // If adjacent vertex is uncolored (-1) and can't be colored, mark current coloring as invalid
            if((graph[node][j] && color[j] == -1) && !DFS(j, color, v, graph, m)) {
                isPossible = false;
                break;
            }
        }
        
        // If current color assignment works, return true
        if(isPossible)
            return true;
            
            // If current color doesn't work, change another color by uncoloring current node
        color[node] = -1;
    }
    // If no color works, return false
    return false;
}
static boolean graphColoring(int v, List<int[]> edges, int m) {
    // Initialize color array with -1 (uncolored)
    int[] color = new int[v];
    for(int j = 0; j < v; j++)
        color[j] = -1;
    
    // Create adjacency matrix from edge list
    boolean[][] graph = new boolean[v][v];
    for(int j = 0; j < edges.size(); j++) {
        int s = edges.get(j)[0];
        int d = edges.get(j)[1];
        
        // Mark edges in both directions (undirected graph)
        graph[s][d] = true;
        graph[d][s] = true;
    }
    
    // Try coloring starting from each uncolored vertex
    for(int j = 0; j < v; j++) {
        if(color[j] == -1 && !DFS(j, color, v, graph, m))
        return false;
    }
    return true;
}
static boolean colorGraph(int node, int[] color, int v, boolean[][] graph, int m)
{
    // Base case: if we've processed all vertices, coloring is complete
    if(node == v)
        return true;
    
        // Try each color (0 to m-1) for current node
    for(int i = 0; i < m; i++) {
        //Indicates if current color i is possible for current node
        boolean isPossible = true;
        
        // Check if any adjacent vertex has the same color i
        for(int j = 0; j < v; j++) {
            if(graph[node][j] && color[j] == i) {
                isPossible = false;
                break;
            }
        }
        
        // If color i is possible, color it...
        if(isPossible)
        {
            color[node] = i;
            if(colorGraph(node+1, color, v, graph, m))
            return true;
        }
        color[node] = -1;
    }
    // If no color works, return false
    return false;
}
static boolean graphColoringOptmized(int v, List<int[]> edges, int m)
{
    // Initialize color array with -1 (uncolored)
    int[] color = new int[v];
    for(int j = 0; j < v; j++)
        color[j] = -1;
    
    // Create adjacency matrix from edge list
    boolean[][] graph = new boolean[v][v];
    for(int j = 0; j < edges.size(); j++) {
        int s = edges.get(j)[0];
        int d = edges.get(j)[1];
        
        // Mark edges in both directions (undirected graph)
        graph[s][d] = true;
        graph[d][s] = true;
    }
    // Try coloring starting from each uncolored vertex
    for(int j = 0; j < v; j++) {
        if(color[j] == -1 && !colorGraph(j, color, v, graph, m))
        return false;
    }
    return true;
}
public static void main(String[] args) {
    List<int[]> edges = new ArrayList<int[]>();
    edges.add(new int[]{0, 1});
    edges.add(new int[]{0, 2});
    edges.add(new int[]{0, 3});
    edges.add(new int[]{1, 2});
    edges.add(new int[]{2, 3});
    int v = 4;
    int m = 3;
    System.out.println(graphColoringOptmized(v, edges, m));
}
}