import java.util.Scanner;
public class Ssort{
	public static void main(String[] args){	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("enter no of elements:");
		int n = sc.nextInt();
		
		int[] a = new int[n];
		System.out.print("enter elements:");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		ssort(a);
		System.out.println("sorted array is :");
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]+"");
	}
	
static void ssort(int[] a){

	int i,j,temp,minpos; 
	int n=a.length;
	for(i=0; i<=(n-2); i++) 

	{ 

		minpos = i; 

		for(j=i+1; j<=(n-1); j++) 

		{ 

		    if(a[j]<a[minpos])
		    {
		     minpos=j; 
		    } 

		} 

		temp = a[i]; 

		a[i] = a[minpos]; 

		a[minpos] = temp; 

	 } 

	}
} 
