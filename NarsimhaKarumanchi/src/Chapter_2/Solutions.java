package Chapter_2;

public class Solutions {

    public static void main(final String[] args) {
        final String str = "ABC";
        System.out.println("hello");
        binary(str.toCharArray(), 3, 0);
    }

    public static void binary(char[] chr, int len, int start) {
        
        if(start>=len)
        {
            System.out.println(chr);
            return;
        }
        
        for (int i = start; i < len; i++) {
            swap(chr, start, i);
            binary(chr, len, start+1);
            swap(chr, start, i);
        }
    }

    public static void swap(char[] chr, int i, int j) {
        final char ch = chr[i];
		chr[i] = chr[j];
		chr[j] = ch;
	}

    
}