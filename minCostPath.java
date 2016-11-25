/**
 * The following implementation calculates  cost of minimum cost path to reach (m, n) from (0, 0).
 * It also prints path followed in reverse order.
 * @author akshay
 */
import java.util.Scanner;

public class minCostPath {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int input[][] = new int[n][m];
		int answer[][] = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				input[i][j] = sc.nextInt();
			}
		}
		answer[0][0] = input[0][0];
		for(int i=1;i<n;i++) {
			answer[i][0] = answer[i-1][0] + input[i][0];
		}
		for(int j=1;j<m;j++) {
			answer[0][j] = answer[0][j-1] + input[0][j];
		}
		for(int i=1;i<n;i++) {
			for(int j=1;j<m;j++) {
				answer[i][j] = input[i][j] + min(answer[i][j-1], answer[i-1][j], answer[i-1][j-1]);
			}
		}
		System.out.println(answer[n-1][m-1]);
		System.out.println("And the path is ");
		int j=m-1, i =n-1;
		while(i !=0 && j!=0) {
			int temp = answer[i][j] - input[i][j]; 
			if( temp == answer[i-1][j-1]) {
				System.out.println(i+" "+j);
				i--;j--;
			} else if(temp == answer[i][j-1]) {
				System.out.println(i+" "+j);
				j--;
			}
			else if(temp == answer[i-1][j]) {
				System.out.println(i+" "+j);
				i--;
			}
		}
		while(i!=0) {
			System.out.println(i+" "+j);
			i--;
		}
		while(j!=0) {
			System.out.println(i+" "+j);
			j--;
		}
	}

	private static int min(int i, int j, int k) {
		if(i<j && i<k)
			return i;
		if(j<i && j<k)
			return j;
		return k;
	}

}
