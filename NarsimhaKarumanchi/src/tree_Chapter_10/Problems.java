package tree_Chapter_10;

public class Problems {
	
	public static void main(String[] args) {
		int[] arr=new int[]{3,2,5,7,9,1,5,2,8};
		heapSort(arr);
		print(arr);
	}
	
	public static boolean containsDuplicate(int[] arr)
	{
		quickSort(arr,0,arr.length);
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i-1]==arr[i])
			{
				return false;
			}
		}
		return true;
	}
	
	public static void quickSort(int[] arr,int start,int end)
	{														
		if(end-start<=1)									
		{													
			return;
		}
		int pivot=start;
		int pindex=end-1;
		for(int i=end-1;i>start;i--)
		{
			if(arr[i]>arr[pivot])
			{
				swap(arr,i,pindex);
				pindex--;
			}
		}
		swap(arr,pivot,pindex);
		
		quickSort(arr,start,pindex);
		quickSort(arr,pindex+1,end);
	}
	
	public static void swap(int[] arr,int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void print(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	
	public static void heapSort(int[] arr)
	{
		//buildHeap(arr,0,0,arr.length);
		for(int i=0;i<arr.length;i++)
		{
			
			buildHeap(arr,0,0,arr.length-1-i);
			swap(arr,0,arr.length-1-i);
			
		}
	}
	
	public static void buildHeap(int[] arr,int index,int start,int end)
	{
		if(end<=0)
		{
			return;
		}
		
		for(int i=start;i<=end/2;i++)
		{
			int par=i;
			int left=2*i+1;
			int right=2*i+2;
			if(right<=end)
			{
			if(arr[par]<arr[left] || arr[par]<arr[right])
			{
				if(arr[left]>arr[right])
				{
					swap(arr,i,left);
					buildHeap(arr,left,start,end-1);
				}
				else
				{
					swap(arr,i,right);
					buildHeap(arr,right,start,end-1);
				}
			}
			}
			else
			{
				if(left<=end && arr[par]<arr[left])
				{
					swap(arr,i,left);
					buildHeap(arr,left,start,end-1);
				}
			}
		}
	}
	
	public static void countingSort(int[] arr)
	{
		
	}
	
	public static void radixSort(int[] arr)
	{
		
	}

}