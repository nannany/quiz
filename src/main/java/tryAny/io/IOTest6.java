package tryAny.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class IOTest6 {
    public static void main(String[] args) throws IOException {
	Path p = Paths.get("src");

	// ファイルが現れたら標準出力するようにする。
	Files.walkFileTree(p, new SimpleFileVisitor<Path>() {
	    @Override
	    public FileVisitResult visitFile(Path path, BasicFileAttributes bfa) throws IOException {
		System.out.println(path);
		return FileVisitResult.CONTINUE;
	    }
	});

	// ディレクトリのみ出力するようにする。
	Files.walk(p).filter(path -> {
	    try {
		return (boolean) Files.getAttribute(path, "isDirectory");
	    } catch (IOException e) {
		System.out.println(e);
		return false;
	    }
	}).forEach(System.out::println);
    }
}
