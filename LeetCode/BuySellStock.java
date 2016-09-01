package LeetCode;

public class BuySellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices) {
        //HashMap<Integer,Integer> g=new HashMap<Integer,Integer>();
        int result=0;
        int min_element=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++)
        {
            int a=prices[i];
            if(a<min_element)
            {
                min_element=a;
            }
            if(a-min_element>result)
            result=a-min_element;
        }
        return result;
    }
}
