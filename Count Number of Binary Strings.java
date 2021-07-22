/*
You are provided an integers N. You need to count all possible distinct binary strings of length N such that there are no consecutive 1’s.

Input Format
First line contains integer t which is number of test case. For each test case, it contains an integer n which is the the length of Binary String.

Constraints
1<=t<=100 1<=n<=90

Output Format
Print the number of all possible binary strings.

Sample Input
2
2
3
Sample Output
3
5
Explanation
1st test case : 00, 01, 10 2nd test case : 000, 001, 010, 100, 101
*/
import java.util.*;
public class Main {
    private static long func(int ci, long[] dp)
    {
        if (ci==1)
        {
            return 2;
        }
		if (ci==2)
        {
            return 3;
        }
        if(dp[ci] != -1)
        {
            return dp[ci];
        }
        long ans=func(ci-1,dp)+func(ci-2,dp);
        return dp[ci] = ans;
    }
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        long t=sc.nextLong();     
        int n=0;                
        for(long i=0;i<t;i++)
        {
            n=sc.nextInt();
            long[] dp = new long[(int)n+1];
            Arrays.fill(dp,-1);
            System.out.println(func(n,dp));
        }
    }
}
