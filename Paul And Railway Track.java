/*
A railway track is made with the help of two horizontal rails and wooden sleepers as seen in figure.

Drag Racing

There are two horizontal rails X and Y. On railway line X, N numbers are written and on railway line Y, M numbers are written

Paul works as engineer in railway department. Paul was tasked to join these two rails to with sleepers to complete the railway track.

But there is a condition to join the rails with sleepers. The sleepers will be put on the position i and j such that -

The number written on X at ith position i.e X[i] should be equal to the number written on Y at jth position i.e Y[j].

The sleepers should not intersect or cross each other at all.

Sleepers cannot intersect or cross each other at the ends .

Return the maximum number of sleepers that Paul has to connect to complete the railway track.

Input Format
First line contains two integers N and M i.e the count of numbers written on each rail X and Y. Second line contains N numbers that are written on rail X. Third line contains M numbers that are written on rail Y.

Constraints
Output Format
A single integer, the maximum number of sleepers that Paul has to connect to complete the railway track.

Sample Input
6 5
1 3 7 1 7 5
1 9 2 5 1
Sample Output
2
*/
import java.util.*;
public class Main {
    static int sol(int[] x,int[] y,int n,int m,int[][] dp){
        if(n==0 || m==0)
            return 0;
        if(dp[n][m]!=-1)
            return dp[n][m];
        if(x[n-1]==y[m-1])
            return 1+sol(x,y,n-1,m-1,dp);
        int c1=sol(x,y,n-1,m,dp);
        int c2=sol(x,y,n,m-1,dp);
        return dp[n][m]=Math.max(c1,c2);
    }
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] x=new int[n];
        int[] y=new int[m];
        for(int i=0;i<n;i++){
            x[i]=sc.nextInt();
        }
        for(int i=0;i<m;i++){
            y[i]=sc.nextInt();
        }
        int[][] dp=new int[n+1][m+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
            System.out.println(sol(x,y,n,m,dp));
    }
}
