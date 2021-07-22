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
