package tryAny.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest2 {
    public static void main(String[] args) {
	try {
	    BufferedReader br = new BufferedReader(new FileReader("src/main/java/tryAny/stream/sample.txt"));
	    int a = Integer.parseInt("a");
	} catch (IOException | NumberFormatException e) {
	    System.out.println(e);
	}
    }
}