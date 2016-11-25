/**
 * Given two strings str1 and str2 and below operations that can performed on str1. 
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 * @author akshay
 */
import java.util.Scanner;

public class EditDistance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int m = s1.length(), n = s2.length();
		int answer[][] = new int[m+1][n+1];
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				if(i==0)
					answer[i][j] = j;
				else if(j==0)
					answer[i][j] = i;
				else if(s1.charAt(i-1) == s2.charAt(j-1))
					answer[i][j] = answer[i-1][j-1];
				else {
					answer[i][j] = 1 + min(answer[i][j-1], answer[i-1][j], answer[i-1][j-1]);
				}
			}
		}
		System.out.println(answer[n][m]);
	}

	private static int min(int i, int j, int k) {
		if(i<j && i<k)
			return i;
		if(j<i && j<k)
			return j;
		return k;
	}

}
