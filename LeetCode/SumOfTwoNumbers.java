package LeetCode;

public class SumOfTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=2;
		int b=3;
		getSum(a,b);
	}
	public static int getSum(int a, int b) {
        int sum=0;
        while(b!=0)
        {
            sum=a^b;
            b=a&b;
            a=sum;
            b=b<<1;
        }
        return sum;
    }
}
