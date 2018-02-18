package tryAny;

public class For {
    public static void main(String[] args) {
	// 初期化文複数
	for (int i = 0, j = 1; i < j; i++) {
	    System.out.println(i);
	}

	// 更新文複数
	for (int i = 0; i < 4; i++, tmp(), tmp2()) {
	    System.out.println(i);
	}
    }

    private static void tmp() {
	System.out.println("tmp");
    }

    private static void tmp2() {
	System.out.println("tmp2");
    }
}
