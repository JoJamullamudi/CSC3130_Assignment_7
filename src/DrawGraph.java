public class DrawGraph {

    public static int[][] draw(String input){

        String[] nodes = input.split(" "); // adds all the elements in the array using spaces to know the different elements
        int count = nodes.length;

        int[][]adjMat = new int[count][count]; // creates the matrix for size of the string

        if(input.equals(" ")||input.equals(""))
        {
            System.out.println("Empty Input"); // left empty return this
        }

        for(int a = 0; a < count; a++) // goes through each vertex
        {
            int right = (2*a + 1) % count; // calculate index using binary tree formula and mod makes it circular
            int left = (2*a + 2) % count; // also for left

            adjMat[a][right] = 1; // plots it on the matrix
            adjMat[a][left] = 1;// same for left
        }

        return adjMat;

    }



}
