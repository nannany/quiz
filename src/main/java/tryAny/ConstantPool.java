package tryAny;

public class ConstantPool {
    public static void main(String[] args) {
	String a1 = "constpool1";
	String b1 = "constpool1";
	System.out.println(a1 == b1);

	String a2 = new String("constpool2");
	String b2 = "constpool2";
	System.out.println(a2 == b2);
    }
}
