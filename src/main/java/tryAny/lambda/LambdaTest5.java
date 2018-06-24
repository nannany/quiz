package tryAny.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaTest5 {
    public static void main(String[] args) {
        List<Musician> l = Arrays.asList(new Musician("Eric Dolphy", Musician.Category.JAZZ),
                new Musician("Jimi Hendrix", Musician.Category.ROCK),
                new Musician("J.S.Bach", Musician.Category.CLASSICAL),
                new Musician("Charles Mingus", Musician.Category.JAZZ));

        Map<Musician.Category, List<String>> m = l.stream().collect(Collectors.groupingBy(Musician::getCategory,
                Collectors.mapping(Musician::getName, Collectors.toList())));

        System.out.println(m);
    }
}

class Musician {
    enum Category {
        ROCK, JAZZ, CLASSICAL
    }

    private String name;
    private Category category;

    public Musician(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

}
