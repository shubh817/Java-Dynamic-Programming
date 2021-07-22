/*
Given two sequences A, B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.

Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, “ACE” is a subsequence of “ABCDE” while “AEC” is not).

Input Format
Input number of test cases The first argument of input contains a string, A. The second argument of input contains a string, B.

Constraints
1<=T<=100
1 <= length(A), length(B) <= 100

Output Format
Return an integer representing the answer as described in the problem statement.

Sample Input
1
rabbbit
rabbit
Sample Output
3
Explanation
These are the possible removals of characters:
    => A = "ra_bbit" 
    => A = "rab_bit" 
    => A = "rabb_it"
*/
import java.util.*;
public class Main{

	private static long subSequence(String source, String target, int n, int m, long[][] dp) {
		// TODO Auto-generated method stub
		
		if(m == 0) {
			return 1; 
		}
		if(n == 0) {
			return 0;
		}
		
		if(dp[n][m] != -1) {
			return dp[n][m];
		}
		long inc = 0, exc = 0;
		
		if(source.charAt(n - 1) == target.charAt(m - 1)) {
			inc = subSequence(source, target, n - 1, m - 1,  dp);
		}

		exc = subSequence(source, target, n - 1, m, dp);
		
		return dp[n][m] = inc + exc;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        String source="";
        String target="";
        int n=0,m=0;
        for(int i=1;i<=t;i++)
        {
		    source = sc.next();
		    target = sc.next();
		
    		n = source.length();
    		m = target.length();
    		
    		long[][] dp = new long[n + 1][m + 1];
    		
    		for(long[] row : dp) {
    			Arrays.fill(row, -1);
    		}
    		
    		
    		System.out.println(subSequence(source, target, n, m, dp));
        }
	}

}
