package tryAny;

import java.nio.ByteBuffer;

public class Cast {
    public static void main(String[] args) {
	// short桁あふれ
	long a = 32768;
	int b = (int) a;
	short c = (short) b;
	byte[] byteShort = ByteBuffer.allocate(2).putShort(c).array();
	System.out.println("shortの桁あふれ");
	for (byte b1 : byteShort) {
	    System.out.printf("%x ", b1);
	}
	System.out.println();
	System.out.println("32768の時のint　" + b);
	System.out.println("32768の時のshort　" + c);

	// int桁あふれ
	long aa = 2147483648L;
	int bb = (int) aa;
	short cc = (short) bb;
	byte[] byteInt = ByteBuffer.allocate(4).putInt(bb).array();
	System.out.println("int,shortの桁あふれ");
	for (byte b2 : byteInt) {
	    System.out.printf("%x ", b2);
	}
	System.out.println();
	System.out.println("2147483648の時のint　" + bb);
	System.out.println("2147483648の時のshort　" + cc);
    }
}
