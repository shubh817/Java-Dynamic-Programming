/*
Given a gold mine (M) of n*m dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons. Initially the miner is at first column but can be at any row. He can move only (right->,right up /,right down) that is from a given cell, the miner can move to the cell diagonally up towards the right or right or diagonally down towards the right. Your task is to find out maximum amount of gold which he can collect.

Input Format
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer n and m denoting the size of the matrix. Then in the next line are n*m space separated values of the matrix.

Constraints
1<=T<=100

1<=n,m<=20

1<=M[][]<=100

Output Format
For each test case in a new line print an integer denoting the max gold the miner could collect.

Sample Input
2
3 3 
1 3 3 2 1 4 0 6 4
2 2
1 2 3 4
Sample Output
12
7
*/
import java.util.*;
public class Main {
	static int max(int[][] m,int row,int col){
		int[][] dp=new int[row][col];
		for(int[] x:dp)
			Arrays.fill(x,0);
		for (int c=col-1;c>=0;c--)
        {
            for (int r=0;r<row;r++)
            {
				int right=(c==col-1)?0:dp[r][c+1];
				int right_up=(r==0 || c==col-1)?0:dp[r-1][c+1];
				int right_down=(r==row-1 || c==col-1)?0:dp[r+1][c+1];
				dp[r][c]=m[r][c]+Math.max(right,Math.max(right_up,right_down));
			}
		}
		int res=dp[0][0];
        for (int i=1;i<row;i++)
            res=Math.max(res,dp[i][0]);
             
        return res;
	}
    public static void main (String args[]) {
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		while(tc>0){
			int row=sc.nextInt();
			int col=sc.nextInt();
			int[][] m=new int[row][col];
			for(int i=0;i<row;i++){
				for(int j=0;j<col;j++){
					m[i][j]=sc.nextInt();
				}
			}
			System.out.println(max(m,row,col));
			tc--;
		}
    }
}
