import java.util.ArrayList;

public class EveryPath {

    public static void cycle(Graph g){

        ArrayList<Graph.Vertex> vertices = new ArrayList<>(g.getVertices()); // get all vertices from graph on a list

        for(int a = 0; a < g.getVertices().size(); a++){
            Graph.Vertex start = g.getVertex(a); // current starting vertex
            ArrayList<Graph.Vertex> path = new ArrayList<>();
            path.add(start); // add starting vertex to path
            CycleCheck(g, start, start, path); // starts the search
        }

    }
    // Uses Depth First Search (DFS) to find the cycles
    public static void CycleCheck(Graph g, Graph.Vertex start, Graph.Vertex current, ArrayList<Graph.Vertex> path){
        if(path.size() == 4){ // checks if path has four vertices
            if(g.hasEdge( current, start)){ // if last points to the first node
                System.out.println("Cycle found: " + path);
            }
            return; //stop going deeper
        }

        ArrayList<Graph.Edge> edges = new ArrayList<>(g.getEdgesFrom(current)); // gets all edges from current node

        for(int i = 0; i < edges.size(); i++){
            Graph.Edge e = edges.get(i);
            if(!path.contains(e.toVertex)){ // only visit if node is not in the path
                path.add(e.toVertex); // add neighbor to path
                CycleCheck(g, start, e.toVertex, path); // recurse with neighbor as new current
                path.remove(path.size() - 1); // backtrack to try new paths
            }
        }

    }




}
