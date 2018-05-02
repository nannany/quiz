package tryAny.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

public class IOTest5 {
    public static void main(String[] args) throws IOException {
	Path p = Paths.get("out.txt");

	// 作成日時
	System.out.println((FileTime) Files.getAttribute(p, "creationTime"));

	// サイズ
	System.out.println((long) Files.getAttribute(p, "size"));

	// シンボリックリンクか否か
	System.out.println((boolean) Files.getAttribute(p, "isSymbolicLink"));
    }
}
