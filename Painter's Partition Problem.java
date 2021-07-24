/*
Given K painters to paint N boards where each painter takes 1 unit of time to paint 1 unit of boards i.e. if the length of a particular board is 5, it will take 5 units of time to paint the board. Compute the minimum amount of time to paint all the boards.

Note that:

Every painter can paint only contiguous segments of boards.
A board can only be painted by 1 painter at maximum.
Input Format
First line contains K which is the number of painters. Second line contains N which indicates the number of boards. Third line contains N space separated integers representing the length of each board.

Constraints
1 <= K <= 10
1 <= N <= 10
1<= Length of each Board <= 10^8

Output Format
Output the minimum time required to paint the board.

Sample Input
2
2
1 10
Sample Output
10
*/
import java.util.*;
import java.io.*;

class Main
{
static int sum(int arr[], int from, int to)
{
	int total = 0;
	for (int i = from; i <= to; i++)
		total += arr[i];
	return total;
}

// bottom up tabular dp
static int findMax(int arr[], int n, int k)
{
	
	int dp[][] = new int[k+1][n+1];

	for (int i = 1; i <= n; i++)
		dp[1][i] = sum(arr, 0, i - 1);


	for (int i = 1; i <= k; i++)
		dp[i][1] = arr[0];

	
	for (int i = 2; i <= k; i++) { 
		for (int j = 2; j <= n; j++) {

			int best = Integer.MAX_VALUE;
			for (int p = 1; p <= j; p++)
				best = Math.min(best, Math.max(dp[i - 1][p],
							sum(arr, p, j - 1)));	
			dp[i][j] = best;
		}
	}
	return dp[k][n];
}
		public static void main(String args[])
		{

		Scanner sc = new Scanner(System.in);
		int k=sc.nextInt();
		int n = sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();

		}
		System.out.println(findMax(arr, n, k));
		}
}
