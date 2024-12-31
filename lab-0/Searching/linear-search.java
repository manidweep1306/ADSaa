import java.util.Scanner;
public class lsearch {
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
		int pos = linearSearch(arr, key);		
		if (pos != -1){
			System.out.println("Key is found at position " + pos);
		}
		else {
			System.out.println("Key is not found");
		}
	}
	static int linearSearch(int a[], int k){
		for(int i = 0; i < a.length; i++){
			if(k == a[i]){
				return i + 1;
			}
		}
		return -1;
	}
}
