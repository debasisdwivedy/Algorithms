import java.util.Scanner;


public class DynamicProgramming {

	/*public static void main (String[] args) {
	//code
	
	String s1="ABCBDAB";
	String s2="BDCABA";
	long startTime = System.currentTimeMillis();
	char[] a1=s1.toCharArray();
	char[] a2=s2.toCharArray();
	int[][] c=LCS(a1,a2);
	long stopTime = System.currentTimeMillis();
	System.out.println(stopTime - startTime);
	//printArray(c);
	char[] sol=reconstruct(c,a1,a2);
	printArray(sol);
}

static int[][] LCS(char[] a1,char[] a2)
{
	//int matrix_size=a1.length*a2.length;
	int[][] c=new int[a1.length][a2.length];
	
	for(int i=0;i<a1.length;i++)
	{
		for(int j=0;j<a2.length;j++)
		{
			//if(c[i][j]==0)
			if(a1[i]==a2[j])
			{
				int temp=0;
				if(i-1>=0 && j-1>=0)
				{
					temp=c[i-1][j-1];
				}
				c[i][j]=temp+1;
			}
			else
			{
				int a=0;
				int b=0;
				if(i-1>=0 && j>=0)
				{
					a=c[i-1][j];
				}
				if(i>=0 && j-1>=0)
				{
					b=c[i][j-1];
				}
				c[i][j]=Math.max(a, b);
			}
		}
	}
	return c;
}

static void printArray(char[] arr)
{
	
		for(int j=0;j<arr.length;j++)
		{
			System.out.print(arr[j]+" ");
		}
		
}

static char[] reconstruct(int[][] arr,char[] a1,char[] a2)
{
	int rows=arr.length;
	int cols=arr[0].length;
	
	//check same number surrounding. if not present, goto diagonal which would definitely be different
	int size=arr[rows-1][cols-1];
	char[] sol=new char[size];
	int i=rows-1;
	int j=cols-1;
	size--;
	while(i>=0 && j>=0)
	{
			
			if(j-1>=0 && arr[i][j-1]==arr[i][j])
			{
				j=j-1;
			}
			else if(i-1>=0 && arr[i-1][j]==arr[i][j])
			{
				i=i-1;
			}
			else
			{
				sol[size]=a1[i];
				size--;
				i=i-1;
				j=j-1;
			}
	}
	return sol;
}*/

public static void main (String[] args) {
	//code
	Scanner sc=new Scanner(System.in);
	int testcases=sc.nextInt();
	for(int i=0;i<testcases;i++)
	{
	    int size=sc.nextInt();
	    int[] arr=new int[size];
	    for(int j=0;j<size;j++)
	    {
	        arr[j]=sc.nextInt();
	    }
	    int c=LIS(arr);
	    //Arrays.sort(c);
	    //printArray(c);
	    //int[] sol=createSeq(c,arr);
	    System.out.println(c);
	    //printArray(sol);
	}
}

static int LIS(int[] arr)
{
	int max=Integer.MIN_VALUE;
    int size=arr.length;
    int[] c=new int[size];
    for(int i=0;i<size;i++)
    {
    	c[i]=1;
    }
    for(int i=1;i<size;i++)
    {
    	for(int j=0;j<i;j++)
    	{
       if(arr[i]>arr[j])
       {
    	   c[i]=Math.max(c[i], c[j]+1);
       }
       if(max<c[i])
       {
    	   max=c[i];
       }
    }
    }
    return max;
}

static int[] createSeq(int[] c,int[] arr)
{
    int len=arr.length;
    int size=c[len-1];
    int[] sol=new int[size];
    size--;
    int i=len-1;
    int j=i-1;
    while(i>=0)
    {
        if(c[j]<c[i])
        {
        	System.out.println(size+"-->"+arr[i+1]);
        	sol[size]=arr[i+1]; 
        	size--;
        }
        i--;
        
    }
    return sol;
}

static void printArray(int[] arr)
{
	
		for(int j=0;j<arr.length;j++)
		{
			System.out.print(arr[j]+" ");
		}
		
}

static void print(int[][] arr)
{
	for(int i=0;i<arr[0].length;i++)
	{
		for(int j=0;j<arr.length;j++)
		{
			System.out.print(arr[i][j]+" ");
		}
		System.out.println();
	}
}
}
