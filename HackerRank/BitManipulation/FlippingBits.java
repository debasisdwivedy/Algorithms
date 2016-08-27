package HackerRank.BitManipulation;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FlippingBits {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        long[] arr=new long[size];
        int count=0;
        while(sc.hasNext())
            {
            arr[count]=sc.nextLong();
            count++;
        }
        
        for(int i=0;i<arr.length;i++)
            {
            long result=flipBits(arr[i]);
            System.out.println(result);
        }
    }
    
    public static long flipBits(long num)
        {
        //System.out.println(Integer.toBinaryString(num));
        long interim=1;
        long result=0;
        for(int i=0;i<32;i++)
            {
            long temp=num&interim;
            //System.out.print(temp+"");
            if(temp!=0)
                {
                temp=0;
            }
            else
                {
                temp=1;
            }
            //System.out.print(temp+"");
            result=result+temp*(long)(Math.pow(2,i));
            /*if(temp==0)
                {
                //System.out.print(temp+"");
            result=result+1*(int)(Math.pow(2,i));
            }*/
            
            interim=interim<<1;
        }
        //System.out.println();
        //System.out.println(Long.toBinaryString(result));
        return result;
    }
}

    

