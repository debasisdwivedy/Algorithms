package NarsimhaKarumanchi.src.tree_Chapter_10;

public class Problems {
	
	public static void main(String[] args) {
		int[] arr=new int[]{32,57,91,52,82,46,91,32,74,53,8};
		int[] res=mergeSort(arr,0,arr.length);
		print(res);
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
			System.out.print(arr[i]+" ");
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
	
	public static int[] countingSort(int[] arr,int base,int power)
	{
		if(arr.length==0)
		{
			return null;
		}
		
		int d=(int)Math.pow(base, power);
		int r=(int)Math.pow(base, power-1);
		int[] sarr=new int[10];
		int[] res=new int[arr.length];
		
		for(int i=0;i<arr.length;i++)
		{
			sarr[(arr[i]%d)/r]++;
		}
		//print(sarr);
		for(int i=1;i<sarr.length;i++)
		{
			sarr[i]=sarr[i]+sarr[i-1];
		}
		//print(sarr);
		for(int i=arr.length-1;i>=0;i--)
		{
			sarr[(arr[i]%d)/r]--;
			res[sarr[(arr[i]%d)/r]]=arr[i];
			
		}
		return res;
	}
	
	public static int[] radixSort(int[] arr,int max_number_of_digits)
	{
		int r=1;
		while(r<=max_number_of_digits)
		{
			arr=countingSort(arr,10,r);
			r++;
		}
		return arr;
	}
	
	public static int[] mergeSort(int[] arr,int start,int end)
	{
		/*
		 * divide
		 * sort
		 * merge
		 * 
		 */
		
		int q=(start+end)/2;
		int[] arr1=merge(arr,start,q,end);
		return arr1;
	}
	
	public static int[] merge(int[] arr,int start,int mid, int end)
	{
		if(start>=end-1)
		{
			return arr;
		}
		int[] arr1=new int[mid-start];
		int[] arr2=new int[end-mid];
		int count=0;
		for(int i=start;i<mid;i++)
		{
			arr1[count]=arr[i];
			count++;
		}
		count=0;
		for(int i=mid;i<end;i++)
		{
			arr2[count]=arr[i];
			count++;
		}
		int[] res1=merge(arr1,0,arr1.length/2,arr1.length);
		int[] res2=merge(arr2,0,arr2.length/2,arr2.length);
		return merge(res1,res2);
	}
	
	public static int[] merge(int[] arr1,int[] arr2)
	{
		int i=0;
		int j=0;
		int count=0;
		int[] result=new int[arr1.length+arr2.length];
		
		while(i<arr1.length || j<arr2.length)
		{
			if(i>=arr1.length)
			{
				result[count]=arr2[j];
				j++;
				count++;
			}
			
			else if(j>=arr2.length)
			{
				result[count]=arr1[i];
				i++;
				count++;
			}
			else
			{
				if(arr1[i]<arr2[j])
				{
					result[count]=arr1[i];
					i++;
					count++;
				}
				else
				{
					result[count]=arr2[j];
					j++;
					count++;
				}
		}
		}
		return result;
	}

}