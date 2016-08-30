package LeetCode;

import java.util.HashMap;

public class FindTheDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public char findTheDifference(String s, String t) {
        char[] ch1=s.toCharArray();
        char[] ch2=t.toCharArray();
        char result=ch2[ch2.length-1];
        if(ch1.length==ch2.length)
        {
            return result;
        }
        else
        {
        char[] longer=(ch1.length>ch2.length)?ch1:ch2;
        char[] shorter=(ch1.length<ch2.length)?ch1:ch2;
        HashMap<Character,Integer> status=new HashMap<Character,Integer>();
        for(int i=0;i<shorter.length;i++)
        {
            Integer temp=status.get(shorter[i]);
            if(temp==null)
            temp=0;
            
            status.put(shorter[i],temp+1);
            
        }
        for(int i=0;i<longer.length;i++)
        {
            Integer temp=status.get(longer[i]);
            if(temp==null || temp==0)
            {
               result=longer[i]; 
               break;
            }
            else
            {
              status.put(longer[i],temp-1);  
            }
        }
        }
        return result;
    }
}
