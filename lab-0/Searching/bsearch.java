import java.util.Scanner;
public class bsearch {
	public static void main(String args[]){
		Scanner read = new Scanner(System.in);
		
		System.out.print("Enter the no. of elements: ");
		int n = read.nextInt();
		int[] arr = new int[n];
		
		System.out.println("Enter the elements: ");
		for(int i = 0; i < n; i++){
			arr[i] = read.nextInt();
		}
		
		System.out.print("Enter the key: ");
		int key = read.nextInt();
		int pos = binarySearch(arr, key);		
		if (pos != -1){
			System.out.println("Key is found at position " + pos);
		}
		else {
			System.out.println("Key is not found");
		}
	}
	static int binarySearch(int a[], int k){
		int low = 0, high = a.length;
		while(low <= high){
			int mid = (low + high) / 2;
			if(a[mid] == k)
				return mid + 1;
			else if(a[mid] < k)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
		}
}
