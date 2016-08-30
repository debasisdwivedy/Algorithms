package LeetCode;

import java.util.HashMap;

public class RansomNote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean canConstruct(String ransomNote, String magazine) {
        char[] ch1=ransomNote.toCharArray();
        char[] ch2=magazine.toCharArray();
        HashMap<Character,Integer> status=new HashMap<Character,Integer>();
        boolean result=true;
        for(int i=0;i<ch2.length;i++)
        {
            Integer temp=status.get(ch2[i]);
            if(temp==null)
            temp=0;
            
            status.put(ch2[i],temp+1);
        }
        
        for(int i=0;i<ch1.length;i++)
        {
           Integer temp=status.get(ch1[i]);
           if(temp==null ||temp==0)
           {
           result=false;
           break;
           }
           else
           {
              status.put(ch1[i],temp-1); 
           }
        }
        return result;
    }

}
