package tryAny.effectiveJava;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagrams {
    public static void main(String[] args) throws IOException {
        File dictionary = new File("/application/gradle/getting-started.html");
        int minGroupSize = 2;

        Map<String, Set<String>> groups = new HashMap<>();

        // 例1 start
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();
                groups.computeIfAbsent(alphabetize(word), (unused) -> new TreeSet<>()).add(word);
            }
        }
        for (Set<String> group : groups.values()) {
            if (group.size() >= minGroupSize) {
                System.out.println(group.size() + ":" + group);
            }
        }
        // 例1 end

        // 例2 start(こっちは一行毎でアナグラム取っているから例1と結果違う)
        Path dictionary2 = Paths.get("/application/gradle/getting-started.html");
        try (Stream<String> words = Files.lines(dictionary2)) {
            words.collect(Collectors.groupingBy(word -> word.chars().sorted()
                    .collect(StringBuilder::new, (sb, c) -> sb.append((char) c), StringBuilder::append).toString()))
                    .values().stream().filter(group -> group.size() >= minGroupSize)
                    .map(group -> group.size() + ":" + group).forEach(System.out::println);
        }
        // 例2 end

        // 例3 start（例2と同じ結果）
        try (Stream<String> words = Files.lines(dictionary2)) {
            words.collect(Collectors.groupingBy(word -> alphabetize(word)))
            .values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .forEach(g -> System.out.println(g.size() + ":" + g));
        }
        // 例3 end
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
