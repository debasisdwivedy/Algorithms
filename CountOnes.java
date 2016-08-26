
public class CountOnes {
//Given a number count the number of one bits in it
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=7;
		int count=0;
		int mask=1;
		while(n>0)
		{
			if((n&mask)==1)
				count++;
			n=n>>1;
		}
		System.out.println(count);

	}

}
