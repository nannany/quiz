package tryAny;

public class InitializeBlock {
    public static void main(String[] args) {
	InitTest i1 = new InitTest(); // JavaSilver
	InitTest i2 = new InitTest(" is dead");// JavaSilver is dead
	InitTest i3 = new InitTest(100, new String[] { "dummy", "point" });// JavaSilver100point
    }

}

class InitTest {
    {
	System.out.print("JavaSilver");
    }

    InitTest() {
	System.out.println();
    }

    InitTest(String str) {
	System.out.println(str);
    }

    InitTest(int a, String... str) {
	System.out.println(a + str[1]);
    }
}