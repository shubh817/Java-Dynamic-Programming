/*
Given 3 strings ,the task is to find the longest common sub-sequence in all three given sequences.

Input Format
First line contains first string . Second line contains second string. Third line contains the third string.

Constraints
The length of all strings is |s|< 200

Output Format
Output an integer denoting the length of longest common subsequence of above three strings.

Sample Input
GHQWNV
SJNSDGH
CPGMAH
Sample Output
2
Explanation
"GH" is the longest common subsequence
*/
import java.util.*;
public class Main{

	private static int subSequence(String s1, String s2, String s3) {
		// TODO Auto-generated method stub
		int[][][] dp = new int[s1.length()+1][s2.length()+1][s3.length()+1];
		for (int n = 1; n <= s1.length(); n++) 
		{
			for (int m = 1; m <= s2.length(); m++) 
			{
				for (int o = 1; o <= s3.length(); o++) 
				{
					if (n == 0 || m == 0 || o == 0)
						dp[n][m][o] = 0;
					else if (s1.charAt(n - 1) == s2.charAt(m - 1) && s2.charAt(m - 1) == s3.charAt(o - 1))
						dp[n][m][o] = 1 + dp[n - 1][m - 1][o - 1];
					else
						dp[n][m][o] = Math.max(dp[n - 1][m][o], Math.max(dp[n][m - 1][o], dp[n][m][o - 1]));
				}
			}
		}
		return dp[s1.length()][s2.length()][s3.length()];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		String s3 = sc.next();
		System.out.println(subSequence(s1, s2, s3));
	}

}
