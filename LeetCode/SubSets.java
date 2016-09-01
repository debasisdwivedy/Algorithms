package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        int num_bits=(int)Math.pow(2,nums.length);
        for(int i=0;i<num_bits;i++)
        {
            List<Integer> sub=new ArrayList<Integer>();
            int co=1;
            for(int j=0;j<nums.length;j++)
            {
            if((i&co)!=0)
            {
                sub.add(nums[j]);
            }
            co=co<<1;
            }
            result.add(sub);
        }
        return result;
    }

}
