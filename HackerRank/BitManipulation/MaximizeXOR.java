package HackerRank.BitManipulation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaximizeXOR {
/*
 * Complete the function below.
 */

    static int maxXor(int l, int r) {
        int max=Integer.MIN_VALUE;
        for(int i=l;i<=r;i++)
            {
            for(int j=i+1;j<=r;j++)
                {
                if((i^j)>max)
                    max=i^j;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());
        
        int _r;
        _r = Integer.parseInt(in.nextLine());
        if(_r>_l && _r>0 && _l>0)
            {
        res = maxXor(_l, _r);
        }
        else
            {
            res=0;
        }
        System.out.println(res);
        
    }
}

