package Chapter_12;

public class Solutions {

    public int tournamentMethod(int[] arr,int start,int end)
    {
        if(end-start<=1)
        {
            return (arr[start]>arr[end])?arr[start]:arr[end]; 
        }
        int mid=start+(end-start)/2;
        
        int num1=tournamentMethod(arr,start,mid-1);
        int num2=tournamentMethod(arr,mid,end);
        return (num1>num2)?num1:num2;
    }

    public void permute(char[] chr,int start,int end)
    {
        if(end-start<=0)
        {
            System.out.println(new String(chr));
            return;
        }
        for(int i=start;i<end;i++)
        {
            swap(chr,start,i);
            permute(chr,start+1,end);
            swap(chr,start,i);
        }
    }

    public void swap(char[] chr,int i,int j)
    {
        char temp=chr[i];
        chr[i]=chr[j];
        chr[j]=temp;
    }

    public void combination(char[] chr,String str,int len,int start,int end)
    {
        if(end-start<0)
        {
            return;
        }

        if(str.length()==len)
            {
                System.out.println(str);
            }
        
        for(int i=start;i<end;i++)
        {
            combination(chr,str+chr[i],len,i+1,end);
        }
    }
    
    public static void main(String[] args)
    {
        Solutions s=new Solutions();
        //int[] arr=new int[]{12,10,5,15,18,12,4,16};
        //int res=s.tournamentMethod(arr,0,arr.length-1);
        //System.out.println(res);

        //s.permute("abcd".toCharArray(), 0, 4);
        s.combination("12345".toCharArray(), "", 3, 0, 5);
        
    }
}