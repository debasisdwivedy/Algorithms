package LeetCode;

public class CountingBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=7;
		countBits(n);
	}

	public static int[] countBits(int num) {
        int[] result=new int[num+1];
        for(int j=0;j<=num;j++)
        {
            int counter=1;
            int count=0;
            for(int i=0;i<32;i++)
            {
                int temp=j&counter;
                if(temp!=0)
                count++;
                counter=counter<<1;
            }
            result[j]=count;
        }
        return result;
    }
}
