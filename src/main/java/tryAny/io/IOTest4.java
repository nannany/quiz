package tryAny.io;

import java.nio.file.Path;
import java.nio.file.Paths;

public class IOTest4 {
    public static void main(String[] args) {
	Path p = Paths.get("C:\\x\\y\\z");
	System.out.printf("一番上（根）：%s,根から2つ目：%s,一番下：%s,根を除いた数：%d", p.getRoot(), p.getName(1), p.getFileName(),
		p.getNameCount());

	System.out.println();
	System.out.println(p.subpath(1, 3));// y\z
    }
}
