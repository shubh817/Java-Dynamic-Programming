import java.util.Arrays;
import java.util.*;
public class Main {

	private static int ways(int n, int[] dp) {
		// TODO Auto-generated method stub

		if(n == 0 || n == 1) {
			return 1;
		}
		
		
		if(dp[n] != -1) { 
			return dp[n];
		}
		
		
		int c1 = ways(n - 1, dp);
		int c2 = ways(n - 2, dp);
		
		int  result= c1 + c2;
		dp[n] = result;
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(ways(n, dp));
	}

}
