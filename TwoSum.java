/**
 * @author akshay
 * This programs takes an unsorted array as input, target sum as input and print count of combination of two numbers which adds upto target.
 * This program also handle duplicates in input. for eg. 3 5 3 5 and target = 8  output: 4 (4 combinations)
 */
import java.util.Scanner;

public class TwoSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Heelo");
		int target = sc.nextInt();
		int nums[] = new int[10];
		for(int i=0; i<10; i++) {
			nums[i] = sc.nextInt();
		}
		int answer = twoSum(nums, target);
		System.out.println(answer);
	}
	
	public static int twoSum(int[] a, int k) {
		int end = a.length-1, sum=0;
		int i, j, start = 0, count=0;
		sort(a,0, a.length);
		while(start<end) {
            sum = a[start] + a[end];
            if(sum == k) {
            	if(a[start] == a[end]) {
            		int temp = end-start+1;
            		count = count+ ( (temp) *(temp-1) )/2;
            		break;
            	} else {
            		int countx = 1, county = 1;
            		while(a[start] == a[start+1]) {
            			start++;countx++;
            		}
            		while(a[end] == a[end-1]) {
            			end--;county++;
            		}
            		count = count + (countx)*(county);
            		start++;end--;
            	}
            } else if(sum > k)
                end--;
            else
                start++;
        }
		return count;
    }
	
	//merge sort
	private static void sort(int[] a, int low, int high) {
		int N = high-low;
		if(N<=1)
			return;
		int mid = low + N/2;
		sort(a,low, mid);
		sort(a, mid, high);
		int []temp = new int[N];
		int i=low, j=mid;
		for(int k=0;k<N;k++) {
			if(i==mid)
				temp[k] = a[j++];
			else if(j==high)
				temp[k] = a[i++];
			else if(a[j] < a[i])
				temp[k] = a[j++];
			else
				temp[k] = a[i++];
		}
		for(int k=0;k<N;k++)
			a[low+k] = temp[k];
	}

}
