import java.util.Scanner;
public class Isort{
	public static void main(String[] args){	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("enter no of elements:");
		int n = sc.nextInt();
		
		int[] a = new int[n];
		System.out.print("enter elements:");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		isort(a);
		System.out.println("sorted array is :");
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]+"");
	}
	
static void isort(int[] a){
		int i, j, item; 
		int n = a.length;
		for(i=1; i<=(n-1); i++)
		{ 
			item = a[i]; 

			for(j=i-1; j>=0 && a[j]>item; j--)
			{ 
				a[j+1] = a[j]; 
			} 
			a[j+1] = item; 
		}
}
}
