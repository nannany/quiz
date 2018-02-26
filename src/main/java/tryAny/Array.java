package tryAny;

import java.util.ArrayList;

public class Array {
    public static void main(String[] args) {
	ArrayList<String> list = new ArrayList<>();
	list.add("a");
	list.add("b");
	list.add("c");
	list.add("d");
	list.add("e");
	// for (String str : list) {
	// if ("c".equals(str)) {
	// list.remove(str);
	// } else {
	// System.out.println(str);
	// }
	// }

	// さいごから2つ目だとConcurrentModificationExceptionでない。
	for (String str : list) {
	    if ("d".equals(str)) {
		list.remove(str);
	    }
	}

	list.removeIf(s -> "a".equals(s));
	System.out.println(list);
    }
}
