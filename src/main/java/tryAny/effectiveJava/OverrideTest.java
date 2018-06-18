package tryAny.effectiveJava;

import java.util.List;

public class OverrideTest {
    public static void main(String[] args) {
        List<Wine> l = List.of(new Wine(), new SparklingWine(), new Champagne());

        for (Wine w : l) {
            System.out.println(w.name());
            /**
             * wine<br>
             * sparkling wine<br>
             * champagne
             */
        }
    }
}

class Wine {
    String name() {
        return "wine";
    }
}

class SparklingWine extends Wine {
    @Override
    String name() {
        return "sparkling wine";
    }
}

class Champagne extends SparklingWine {
    @Override
    String name() {
        return "champagne";
    }
}