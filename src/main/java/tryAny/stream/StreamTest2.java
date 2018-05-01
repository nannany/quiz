package tryAny.stream;

import java.util.stream.Stream;

public class StreamTest2 {
    public static void main(String[] args) {

	Stream<Data> s = Stream.of(new StreamTest2().new Data("a", 1), new StreamTest2().new Data("b", 2));
	// "a:1 b:2 "

	s.forEach(System.out::print);
    }

    class Data {
	String str;
	int i;

	public Data(String s, int i) {
	    this.str = s;
	    this.i = i;
	}

	@Override
	public String toString() {
	    return this.str + ":" + this.i + "  ";
	}
    }
}
