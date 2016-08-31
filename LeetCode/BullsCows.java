package LeetCode;

import java.util.HashMap;

public class BullsCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getHint(String secret, String guess) {
        String result="0A0B";
        if(secret.length()==0 || guess.length()==0)
        {
            return result;
        }
        char[] s=secret.toCharArray();
        char[] g=guess.toCharArray();
        
        HashMap<Integer,Integer> count=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> bullcount=new HashMap<Integer,Integer>();
        int cows=0;
        int bulls=0;
        
        for(int i=0;i<s.length;i++)
        {
            int a=Integer.parseInt(s[i]+"");
            int b=Integer.parseInt(g[i]+"");
            
            if(a==b)
            {
               bulls++;
               Integer t=bullcount.get(a);
               if(t==null || t==0)
               {
                   t=0;
                   bullcount.put(a,t+1);
               }
               else
               {
                 bullcount.put(a,t+1);  
               }
            }
            else
            {
               Integer t=count.get(a);
               if(t==null || t==0)
               {
                   t=0;
                   count.put(a,t+1);
               }
               else
               {
                 count.put(a,t+1);  
               }
            }
        }
        
        for(int i=0;i<g.length;i++)
        {
           int b=Integer.parseInt(g[i]+"");; 
           Integer t=count.get(b);
           Integer t1=bullcount.get(b);
           //System.out.println(b+"---->"+t);
           if(t!=null && t>0)
            {
                if(t1==null || t1==0)
                {
               cows++;
               count.put(b,t-1);
                }
                else
                {
                  bullcount.put(b,t1-1);  
                }
            }
        }
        result=""+bulls+"A"+cows+"B";
        return result;
    }
}
