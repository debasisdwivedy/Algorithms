package LeetCode;

import java.util.ArrayList;

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String convert(String s, int numRows) {
        char[] ch=s.toCharArray();
        if(numRows==1)
        return s;
        ArrayList<ArrayList<Character>> result=new ArrayList<ArrayList<Character>>();
        int len=ch.length;
        int counter=0;
        int col=0;
        int next_col=0;
        int flag=1;
        String str="";
        while(counter<len)
        {
            ArrayList<Character> coloumns=new ArrayList<Character>();
            if(col==next_col)
            {
                next_col=next_col+numRows-1;
                flag=1;
                for(int k=0;k<numRows;k++)
                {
                if(counter<len)
                {
                coloumns.add(ch[counter]);
                counter++;
                }
                }
            }
            else
            {
               for(int k=0;k<numRows;k++)
                {
                    if(k==numRows-flag-1)
                    {
                        if(counter<len)
                        {
                        coloumns.add(ch[counter]);
                        counter++;
                        }
                        flag++;
                    }
                    else
                    {
                        coloumns.add(' '); 
                    }
                } 
            }
            result.add(coloumns);
            col++;
        }
        str=printArray(result,numRows);
        return str;
    }
    
    public static String printArray(ArrayList<ArrayList<Character>> result,int numrows)
    {
        String str="";
        int rows=result.size();
        for(int j=0;j<numrows;j++)
        {
            for(int i=0;i<rows;i++)
            {
                ArrayList<Character> temp=result.get(i);
                if(j<temp.size() && temp.get(j)!=' ')
                str=str+temp.get(j);
            }
        }
        return str;
    }
}
