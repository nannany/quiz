package tryAny.exception;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionTest3 {
    public static void main(String[] args) {
	try (FileReader in = new FileReader("src/main/java/tryAny/stream/sample.txt");
		FileWriter out = new FileWriter("src/main/java/tryAny/exception/sample.txt");
		AutoCloseTest act = new AutoCloseTest();
		/** AutoCloseTest2 act2 = new AutoCloseTest2(); ←AutoClosableを実装していないのでダメ**/ ) {
	    // AutoCloseTest のcloseが実行される。
	} catch (IOException e) {

	}
    }
}

class AutoCloseTest implements AutoCloseable {
    @Override
    public void close() {
	System.out.println("AutoCloseTest is closed.");
    }
}

class AutoCloseTest2 {
    public void close() {
	System.out.println("AutoCloseTest is closed.");
    }
}