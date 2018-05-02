package tryAny.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class IOTest1 {
    public static void main(String[] args) {
	try (PrintWriter pw = new PrintWriter("out.txt")) {
	    pw.println("Hello world");
	    // BufferedWriterではboolean、doubleといったプリミティブ型をそのまま出力させることはできない。
	    pw.println(true);
	    pw.println(0.4);
	} catch (FileNotFoundException e) {
	    System.out.println(e);
	}
    }
}
