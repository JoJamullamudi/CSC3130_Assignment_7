import java.util.LinkedList;
import java.util.Queue;

public class DirectOrUndirect {

    public static boolean isWeaklyConnected(int[][] matrix, int n) // input takes in the adjacency matrix and int n which is the mount of nodes.
    {
        if ( n <= 1) // checks if the graph is one node/point or theres no graph at all.
        {
            return true; // one point would mean it could get to every point from there
        }

        boolean[] nodes_visited = new boolean[n]; // this creates an array that takes all the nodes visited.

        Queue<Integer> check = new LinkedList<>();
        int vcount = 1;

        nodes_visited[0] = true; // to start
        check.add(0);

        while(!check.isEmpty())
        {
            int a = check.poll(); // brings out the first number on the list and remove it from the list.
            for ( int b = 0; b < n; b++)
            {
                if (!nodes_visited[b] && ( matrix[a][b] == 1 || matrix[b][a] == 1)) // only looks at unvisited node and checks if theirs an edge from a to b or from b to a.
                {
                    nodes_visited[b] = true; // if conditions are meet mark node as visited
                    check.add(b); // add it to the queue
                    vcount++;
                }
            }
        }

        if (vcount == n) // if all nodes are visited mark true
        {
            return true;
        }
        return false;

    }


    public static void main(String[] args)
    {
        int[][] mat = { {0,1,0},
                        {0,0,0},
                        {0,1,0} };
        int node = 3;

        if ( isWeaklyConnected(mat, node)) {
            System.out.println("This Matrix is weakly connected");
        }
        else
        {
            System.out.println("This Martix is not weakly connected");
        }

        int[][] matr = { {0,1,0},
                        {0,0,0},
                        {0,0,1} };
        int nodes = 3;

        if ( isWeaklyConnected(matr, nodes)) {
            System.out.println("This Matrix is weakly connected");
        }
        else
        {
            System.out.println("This Martix is not weakly connected");
        }

        int[][] ma = { {0,1,0},
                        {1,0,1},
                        {0,1,1} };
        int nod = 3;

        if ( isWeaklyConnected(ma, nod)) {
            System.out.print("This Matrix is weakly connected");
        }
        else
        {
            System.out.print("This Martix is not weakly connected");
        }


    }

}
