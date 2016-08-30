package LeetCode;

import java.util.HashMap;
import java.util.Set;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[5];
		int result=singleNumber(nums);
		System.out.println(result);
	}
	
	public static int singleNumber(int[] nums) {
        HashMap<Integer,Integer> table=new HashMap<Integer,Integer>();
        int result=0;
        for(int i=0;i<nums.length;i++)
        {
            Integer temp=table.get(nums[i]);
            if(temp==null)
            temp=0;
            
            table.put(nums[i],temp+1);
        }
        Set<Integer> st=table.keySet();
        for(Integer i:st)
        {
            Integer temp=table.get(i);
            if(temp==1)
            {
            result=i;
            break;
            }
        }
       return result; 
    }

}
