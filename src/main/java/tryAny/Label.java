package tryAny;

public class Label {
    public static void main(String[] args) {
	ff();

    }

    private static void ff() {
	// コードブロック
	BLOCK: {
	    int a;
	    a = 1;
	    System.out.println("徹");
	    if (a == 1) {
		break BLOCK;
	    }
	    System.out.println("通らない");
	}
    }
}
