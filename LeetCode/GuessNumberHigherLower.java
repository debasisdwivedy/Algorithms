package LeetCode;

public class GuessNumberHigherLower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int guess(int num)
	{
		return 0;
	}
	public int guessNumber(int n) {
        int status=-1;
        int count=0;
        int prev=0;
        int counter=n;
        while(status!=0)
        {
           status=guess(n);
           
           if(status!=0)
           {
               counter=n;
           if(status==1)
           {
               if(n!=prev)
               n=n+(Math.abs(n-prev)/2);
               else
               n=n+1;
           }
           else
           {
               if(n!=prev)
              n=n-(Math.abs(n-prev)/2); 
              else
              n=n-1;
           }
           }
           prev=counter;
           count++;
        }
        return n;
    }
}
