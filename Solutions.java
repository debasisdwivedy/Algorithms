import java.util.ArrayList;
import java.util.Collections;

public class Solutions {
	
	public static void main(String args[])
	{
		int n=85;
		int mask=1;
		int ans=0;
		System.out.println(Integer.toBinaryString(n));
		for(int i=0;i<32;i++)
		{
			//System.out.println("---------");
			int temp=(n&1);
			temp=temp^mask;
			ans=ans+(temp<<i);
			n=n>>1;
		}
		System.out.println(ans);
		
	}
	
	public static int result(int a,int b)
	{
		int counter=1;
		int result1=0;
		int[] sum_carry=new int[2];
		for(int i=0;i<=31;i++)
		{
			int temp_a=a&(counter);
			int temp_b=b&(counter);
			getSum(temp_a,temp_b,sum_carry,i);
			result1=result1+sum_carry[0];
			counter=counter<<1;
		}
		return result1;
	}
	
    public static void getSum(int a, int b,int[] sum_carry,int power) {
        int z=a^b;
        int sum=0;
        int carry=sum_carry[1];
    	if(z==0)
    	{
    		
    		if((a&b)==0)
    		{
    			if(carry==1)
    			{
    				sum=1;
        			carry=0;
    			}
    			else
    			{
    			sum=0;
    			carry=0;
    			}
    		}
    		else
    		{
    			if(carry==1)
    			{
    				sum=1;
        			carry=1;
    			}
    			else
    			{
    			sum=0;
    			carry=1;
    			}
    		}
    	}
    	else
    	{
    		int temp=a|b;
    		if(temp==0)
    		{
    			sum=carry;
    			carry=0;
    		}
    		else
    		{
    			if(carry==1)
    			{
    			sum=0;
        		carry=1;
    			}
    			else
    			{
    				sum=1;
            		carry=0;
    			}
    		}
    	}
    	power=(int)Math.pow(2,power);
    	sum=sum*power;
    	sum_carry[0]=sum;
    	sum_carry[1]=carry;
    }
    
    public static ArrayList<Integer> getBinary(int num)
    {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        while(num>0)
        {
            arr.add(num%2);
            num=num/2;
        }
        Collections.reverse(arr);
        return arr;
    }
     public static int twoCompliment(int num)
     {
    	 int[] sum_carry=new int[2];
    	 int counter=1;
    	 int sum=0;
         for(int i=0;i<31;i++)
         {
        	 if((num&counter)==0)
        	 {
        		 //System.out.println(num+"->"+i+"->"+(num&counter));
        	int temp=(int)Math.pow(2,i);
        	sum=sum+temp;
        	 }
        	counter=counter<<1;
         }
         //System.out.println(Integer.toBinaryString(sum));
         counter=1;
         int result1=0;
         for(int i=0;i<31;i++)
         {
        	 int temp_a=sum&(counter);
 			int temp_b=1&(counter);
         getSum(temp_a,temp_b,sum_carry,i);
         result1=result1+sum_carry[0];
         counter=counter<<1;
         }
         //System.out.println(Integer.toBinaryString(sum_carry[0]));
         return result1;
     }
    
    public static ArrayList<Integer> sumBinary(ArrayList<Integer> num1,ArrayList<Integer> num2)
    {
        ArrayList<Integer> result=new ArrayList<Integer>();
        int filler=Math.abs(num1.size()-num2.size());
        int carryover=0;
        if(num1.size()>num2.size())
        {
            while(filler>0)
            {
                num2.add(0,0);
                filler--;
            }
        }
        else if(num2.size()>num1.size())
        {
           while(filler>0)
            {
                num1.add(0,0);
                filler--;
            } 
        }
        for(int i=num1.size()-1;i>=0;i--)
        {
            int a=num1.get(i);
            int b=num2.get(i);
            if(a==1 && b==1 && carryover==0)
            {
               result.add(0);
               carryover=1;
            }
            else if(a==1 && b==0 && carryover==0)
            {
               result.add(1);
               carryover=0; 
            }
            else if(a==0 && b==1 && carryover==0)
            {
               result.add(1);
               carryover=0; 
            }
            else if(a==0 && b==0 && carryover==0)
            {
                result.add(0);
               carryover=0;
            }
            else if(a==1 && b==1 && carryover==1)
            {
                result.add(1);
               carryover=1;
            }
            else if(a==0 && b==1 && carryover==1)
            {
                result.add(0);
               carryover=1;
            }
            else if(a==0 && b==0 && carryover==1)
            {
                result.add(1);
               carryover=0;
            }
            else if(a==1 && b==0 && carryover==1)
            {
               result.add(0);
               carryover=1; 
            }
        }
        if(carryover==1)
        {
        	result.add(0,1);
        }
        Collections.reverse(result);
        return result;
    }
    
    public static long covertToDecimal(ArrayList<Integer> arr)
    {
        int power=0;
        long sum=0;
        for(int i=arr.size()-1;i>=0;i--)
        {
            sum=sum+(long)arr.get(i)*(long)Math.pow(2,power);
            power++;
        }
        return sum;
    }
    
    public static void printArray(ArrayList<Integer> arr)
    {
        for(int i=0;i<arr.size();i++)
        {
            System.out.print(arr.get(i)+"");
        }
        System.out.println();
    }
}
