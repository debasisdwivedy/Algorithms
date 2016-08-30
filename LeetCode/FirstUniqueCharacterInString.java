package LeetCode;

import java.util.HashMap;

public class FirstUniqueCharacterInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int firstUniqChar(String s) {
        char[] ch=s.toCharArray();
        HashMap<Character,Integer> status=new HashMap<Character,Integer>();
        int result=-1;
        for(int i=0;i<ch.length;i++)
        {
            Integer temp=status.get(ch[i]);
            if(temp==null)
            temp=0;
            
            status.put(ch[i],temp+1);
        }
        
        for(int i=0;i<ch.length;i++)
        {
           Integer temp=status.get(ch[i]);
           if(temp==1)
           {
              result=i;
              break;
           }
        }
        return result;
    }
}
