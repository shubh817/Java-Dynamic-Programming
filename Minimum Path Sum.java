/*
Josh is stuck in a m*n grid. He has to travel from top left to bottom right.For every cell to pass, there is a specific amount of money josh has to pay. Your task is to find out minimum amount of money josh has to pay to reach bottom right.

Input Format
First line contains two space separated integers m and n i.e number of rows and columns of grid. m lines follow each containing n integers, denoting the cost of which josh has to pay to pass through that cell.

Constraints
None

Output Format
A single integer denoting minimum cost josh has to pay.

Sample Input
3 3 
1 3 1
1 5 1
4 2 1
Sample Output
7
Explanation
Josh will take 1→3→1→1→1 path to minimize the amount he has to pay
*/
import java.util.*;
public class Main {
    static int sol(int[][] grid,int cr,int cc,int er,int ec,int[][] dp)
    {
        if(cr>er || cc>ec)
            return Integer.MAX_VALUE;
        if(dp[cr][cc]!=-1)
            return dp[cr][cc];
        if(cr==er && cc==ec)
            return grid[cr][cc];
        int c1=sol(grid,cr,cc+1,er,ec,dp);
        int c2=sol(grid,cr+1,cc,er,ec,dp);
        int min=Math.min(c1,c2);
        return grid[cr][cc]+min;
    }
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int er=sc.nextInt();
        int ec=sc.nextInt();
        int[][] grid=new int[er][ec];
        int[][] dp=new int[er][ec];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        for(int i=0;i<er;i++){
            for(int j=0;j<ec;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        System.out.println(sol(grid,0,0,er-1,ec-1,dp));
    }
}
