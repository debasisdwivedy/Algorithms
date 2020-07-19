package Chapter_10;

public class Solutions {

    public int[] mergeSort(int[] arr,int start,int end)
    {
        if(start>=end || start<0)
        {
            return null;
        }
        if(start==end-1)
        {
            return new int[]{arr[start]};
        }
        int mid=start+(end-start)/2;
        int[] arr1=mergeSort(arr,start,mid);
        int[] arr2=mergeSort(arr,mid,end);
        int[] temp=new int[end-start];
        int i=0,j=0,k=0;
        while(i<arr1.length&& j<arr2.length)
        {
            if(arr1[i]<arr2[j])
            {
                temp[k]=arr1[i];
                i++;
            }
            else
            {
                temp[k]=arr2[j];
                j++;
            }
            k++;
        }
        while(i<arr1.length)
        {
            temp[k]=arr1[i];
            i++;
            k++;
        }
        while(j<arr2.length)
        {
            temp[k]=arr2[j];
            j++;
            k++;
        }

        return temp;
    }

    public void quickSort(int[] arr,int start,int end)
    {
        if(end>start)
        {
            int pivot = partition(arr,start,end);
            quickSort(arr,start,pivot-1);
            quickSort(arr,pivot+1,end);
        }        
            
    }

    private int partition(int[] arr,int start,int end)
    {
        int pivot=arr[start];
        int i=start;
        int j=end;
        while(i<j)
        {
            while(arr[i]<=pivot)
            {
                i++;
                if(i>j)
                    break;
            }
            while(arr[j]>pivot)
            {
                j--;
                if(i>j)
                    break;
            }
            if(i<j)
                swap(arr,i,j);
        }
        arr[start]=arr[j];
        arr[j]=pivot;
        return j;
    }

    public void swap(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public int[] countingSort(int[] arr,int range)
    {
        int len=arr.length;
        int[] B=new int[range];
        int[] C=new int[len];

        for(int i=0;i<len;i++)
        {
            B[arr[i]]++;
        }
        int j=0;
        for(int i=0;i<range;i++)
        {
            while(B[i]>0)
            {
                C[j]=i;
                B[i]--;
                j++;
            }
            
        }
        return C;
    }



    public static void main(String[] args)
    {
        Solutions s=new Solutions();
        int[] arr={6,7,1,4,5,3,3,2,1,4,7,8};
        int[] res=s.countingSort(arr,10);
        for(int i=0;i<res.length;i++)
        {
            System.out.println(res[i]);
        }

    }
}

