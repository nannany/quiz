package tryAny.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StreamTest3 {
    public static void main(String[] args) {
	try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/tryAny/stream/sample.txt"))) {
	    br.lines().forEach(System.out::println);

	    Files.lines(Paths.get("src/main/java/tryAny/stream/sample.txt")).forEach(System.out::println);
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
}
