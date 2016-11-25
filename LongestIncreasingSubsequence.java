/**
 * Longest increasing subsequence and also prints the sequence in less space complexity.
 * @author akshay
 */

import java.util.Scanner;

public class LongestIncreasingSubsequence {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int answer[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		answer[0] = 1;
		for(int i=1;i<n;i++) {
			answer[i] = 1;
			for(int j=i-1;j>=0;j--) {
				if(arr[j]<arr[i])
					answer[i] = max(answer[j]+1, answer[i]);
			}
		}
		int maxAnswer = answer[0];
		int maxIndex = 0;
		for(int i=1;i<n;i++)
			if(answer[i] > maxAnswer) {
				maxAnswer = answer[i];
				maxIndex = i;
			}
		System.out.println("LIS = "+maxAnswer);
		System.out.println("Sequence consists of ");
		System.out.print(arr[maxIndex]+" ");
		for(int i = maxIndex-1;i>=0;i--) {
			if(arr[i]<arr[maxIndex] && answer[maxIndex] == answer[i]+1) {
				maxIndex = i;
				System.out.print(arr[maxIndex]+" ");
			}
		}
	}

	private static int max(int i, int j) {
		if(i>j)
			return i;
		else
			return j;
	}

}
