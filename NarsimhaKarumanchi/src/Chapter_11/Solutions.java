package Chapter_11;

public class Solutions {

    public int bitonicSeries(int[] arr,int start,int end)
    {
        if(end-start<0)
        {
            return -1;
        }
        int mid=start+(end-start)/2;
        //System.out.println(mid);
        if(mid==start && mid==end)
        {
            return -1;
        }
        if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
        {
            return mid;
        }
        
        else if(arr[mid]>=arr[start])
        {
            return bitonicSeries(arr,mid+1,end);
        }
        else if(arr[mid]>=arr[end])
        {
            return bitonicSeries(arr,start,mid-1);
        }
        else{
            return -1;
        }
    }

    public static void main(String[] args)
    {
        Solutions s=new Solutions();
        int[] arr=new int[]{1,2,3,4,5,6,7,8,9,10,9};
        int res=s.bitonicSeries(arr,0,arr.length-1);
        System.out.println(res);
    }

    public static void t(int[] arr,int l0,int h0,int l1,int h1)
    {
        //t(arr,l0,l0+(h0-l0)/2,l1,l1+(h1-l1)/2);
        //t(arr,l0,l0+(h0-l0)/2,l1,l1+(h1-l1)/2);
        
    }

}