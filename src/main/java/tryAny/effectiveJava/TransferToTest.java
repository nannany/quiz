package tryAny.effectiveJava;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class TransferToTest {
    public static void main(String[] args) throws IOException {
	try (InputStream is = new URL("https://docs.oracle.com/javase/9/docs/api/java/io/InputStream.html")
		.openStream()) {
	    is.transferTo(System.out);
	}
    }
}
