import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class GFG {
	static java.util.ArrayList<Integer> newStart=null;
    static java.util.ArrayList<Integer> newEnd=null;
	public static void main (String[] args) {
		//code
		System.out.print(Math.pow(2, 31));
	}
	public static void printArray(int[] arr)
    {
    for(int i=0;i<arr.length;i++)
        {
        System.out.print(arr[i]+" ");
    }
}
	public static void quickSort(Integer[] arr1,Integer[] arr2,
			int start,int end)
			{
			    if(start<end)
			    {
			    int pivot=arr1[start].intValue();
			    int pindex=end;
			    
			    for(int i=end;i>start;i--)
			    {
			        if(arr1[i]>=pivot)
			        {
			          swap(arr1,i,pindex); 
			          swap(arr2,i,pindex);
			          pindex--;
			        }
			    }
			    swap(arr1,start,pindex);
			    swap(arr2,start,pindex);
			    quickSort(arr1,arr2,start,pindex-1);
			    quickSort(arr1,arr2,pindex+1,end);
			    }
			}
			
			public static void swap(Integer[] arr,int i,int j)
			{
			    int temp=arr[i].intValue();
			    arr[i]=arr[j];
			    arr[j]=temp;
			}
			
			public static void printArray(Integer[] arr)
				{
				    for(int i=0;i<arr.length;i++)
				    {
				        System.out.print(arr[i].intValue()+" ");
				    }
				}
	
    
	}
	
