package avengers;

import java.util.HashMap;

/**
 * 
 * Using the Adjacency Matrix of n vertices and starting from Earth (vertex 0), 
 * modify the edge weights using the functionality values of the vertices that each edge 
 * connects, and then determine the minimum cost to reach Titan (vertex n-1) from Earth (vertex 0).
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * LocateTitanInputFile name is passed through the command line as args[0]
 * Read from LocateTitanInputFile with the format:
 *    1. g (int): number of generators (vertices in the graph)
 *    2. g lines, each with 2 values, (int) generator number, (double) funcionality value
 *    3. g lines, each with g (int) edge values, referring to the energy cost to travel from 
 *       one generator to another 
 * Create an adjacency matrix for g generators.
 * 
 * Populate the adjacency matrix with edge values (the energy cost to travel from one 
 * generator to another).
 * 
 * Step 2:
 * Update the adjacency matrix to change EVERY edge weight (energy cost) by DIVIDING it 
 * by the functionality of BOTH vertices (generators) that the edge points to. Then, 
 * typecast this number to an integer (this is done to avoid precision errors). The result 
 * is an adjacency matrix representing the TOTAL COSTS to travel from one generator to another.
 * 
 * Step 3:
 * LocateTitanOutputFile name is passed through the command line as args[1]
 * Use Dijkstra’s Algorithm to find the path of minimum cost between Earth and Titan. 
 * Output this number into your output file!
 * 
 * Note: use the StdIn/StdOut libraries to read/write from/to file.
 * 
 *   To read from a file use StdIn:
 *     StdIn.setFile(inputfilename);
 *     StdIn.readInt();
 *     StdIn.readDouble();
 * 
 *   To write to a file use StdOut (here, minCost represents the minimum cost to 
 *   travel from Earth to Titan):
 *     StdOut.setFile(outputfilename);
 *     StdOut.print(minCost);
 *  
 * Compiling and executing:
 *    1. Make sure you are in the ../InfinityWar directory
 *    2. javac -d bin src/avengers/*.java
 *    3. java -cp bin avengers/LocateTitan locatetitan.in locatetitan.out
 * 
 * @author Yashas Ravi
 * 
 */

public class LocateTitan {

    public static int minDistance(int dist[], Boolean sptSet[],int numGen)
    {
        int min = Integer.MAX_VALUE; 
        int minIndex = -1;
 
        for (int i = 0; i < numGen; i++)
            if (sptSet[i] == false && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        return minIndex;
    }
	
    public static void main (String [] args) {

        if ( args.length < 2 ) {
            StdOut.println("Execute: java LocateTitan <INput file> <OUTput file>");
            return;
        }
   
        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);

        int numGen = StdIn.readInt();
        HashMap<Integer,Double> generators = new HashMap<Integer,Double>();
        for(int i = 0; i < numGen; i++)
        {
            int generator = StdIn.readInt();
            double funcionality = StdIn.readDouble();
            generators.put(generator,funcionality);
        }

        int[][] adjMatrix = new int[numGen][numGen];


        for(int i = 0; i < numGen; i++)
        {
            for(int j = 0; j < numGen; j++)
            {
                int num = StdIn.readInt();
                adjMatrix[i][j] = (int) ((int) num/(generators.get(i)*generators.get(j)));
            }
        }

        int[] minCost = new int[numGen];

        Boolean DijkstraSet[] = new Boolean[numGen];

        for(int i = 0; i < minCost.length; i++)
        {
            if(i == 0)
            {
                minCost[i] = 0;
            }
            else
            {
                minCost[i] = Integer.MAX_VALUE;
            }

            DijkstraSet[i] = false;
        }

        for(int i = 0; i < numGen-1; i++)
        {
            int u = minDistance(minCost, DijkstraSet, numGen);

            DijkstraSet[u] = true;

            for(int j = 0; j < numGen; j++)
            {
                if (!DijkstraSet[j] && adjMatrix[u][j] != 0 && minCost[u] != Integer.MAX_VALUE && minCost[u] + adjMatrix[u][j] < minCost[j])
                {
                    minCost[j] = minCost[u] + adjMatrix[u][j];

                }
            }
        }

        StdOut.print(minCost[numGen-1]);

    }
}
