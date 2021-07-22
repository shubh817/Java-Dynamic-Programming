import java.util.*;
public class Main {
   public static ArrayList<String> getboardpath(int curr, int end, int M) {
		if (curr == end) {
			ArrayList<String> baseres = new ArrayList<>();
			baseres.add("");
			return baseres;
		}
		ArrayList<String> myres = new ArrayList<>();
		for (int dice = 1; dice <= M && curr + dice <= end; dice++) {
			ArrayList<String> rr = getboardpath(curr + dice, end, M);

			for (String val : rr) {
				myres.add(dice + val);
			}

		}
		return myres;

	}

    public static void main(String args[]) {
        // Your Code Here
        Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int n = s.nextInt();
		ArrayList<String> ans = getboardpath(0, a, n);
		
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
		System.out.println();
		System.out.println(ans.size());
    }
}
