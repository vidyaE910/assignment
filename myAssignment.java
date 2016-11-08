//This is the java program to implement the knapsack problem using Dynamic Programming
import java.util.Scanner;
public class Assignment 
{
    static int max(int r, int s) 
        { 
            return (r > s)? r : s; 
        }
        static int knapSack(int t, int y[], int x[], int n)
        {
            int i, w;
            int [][]K = new int[n+1][t+1];
    	   // Build table K[][] in bottom up manner
            for (i = 0; i <= n; i++)
            {
                for (w = 0; w <= t; w++)
                {
                    if (i==0 || w==0)
                        K[i][w] = 0;
                    else if (y[i-1] <= w)
                        K[i][w] = max(x[i-1] + K[i-1][w-y[i-1]],  K[i-1][w]);
                    else
                        K[i][w] = K[i-1][w];
                }
            }
            return K[n][t];
        }
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            //System.out.println("Enter the number of items: ");
            //int n = sc.nextInt();
			int n = 101;
            System.out.println("Enter the items weights: ");
            int []y = new int[n];
            for(int i=0; i<n; i++)
                y[i] = sc.nextInt();
            System.out.println("Enter the items values: ");
            int []x = new int[n];
            for(int i=0; i<n; i++)
                x[i] = sc.nextInt();
            //System.out.println("Enter the maximum capacity: ");
            //int W = sc.nextInt();
			int t = 10000;
			System.out.println("The number of items: " + n);
			System.out.println("The Maximum Capacity: " + t);
			System.out.println(" ");
            System.out.println("The maximum value that can be put in a knapsack of capacity W is: " + knapSack(t, y, x, n));
            sc.close();
        }
}
