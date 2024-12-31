import java.util.Scanner;
public class bsort{
	public static void main(String[] args){	
		long start = System.nanoTime();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("enter no of elements:");
		int n = sc.nextInt();
		
		int[] a = new int[n];
		System.out.print("enter elements:");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		bsort(a);
		System.out.println("sorted array is :");
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]+"");
		long end = System.nanoTime();
		double time = (end - start) / 1000000.0;
		System.out.println("\nTime taken: " + time + "milliseconds");
	}
	
	static void bsort(int[] a){
			int n = a.length;
			for (int i=0;i<(n-1);i++){
				for (int j=0;j<(n-1-i);j++){
					if (a[j] > a[j+1]){
						int temp = a[j];
						a[j] = a[j + 1];
						a[j + 1] = temp;
                    }
                }
            }
	}
}	
