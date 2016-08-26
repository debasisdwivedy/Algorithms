package HackerRank.BitManipulation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LonelyInteger {
     private static int lonelyInteger(int[] a) {
         ArrayList<Integer> common=new ArrayList<Integer>();
         for(int i=0;i<a.length;i++)
            {
            int sum=0;
            for(int j=i+1;j<a.length;j++)
                {
                if((a[i]^a[j])==0)
                    {
                    common.add(a[i]);
                    break;
                }
            }
             if(!common.contains(a[i]))
                 return a[i];
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(lonelyInteger(a));
    }

}

