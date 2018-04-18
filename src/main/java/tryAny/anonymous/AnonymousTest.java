package tryAny.anonymous;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnonymousTest {
    public static void main(String[] args) {
	Data d1 = new Data(3, "aaa");
	Data d2 = new Data(1, "bbb");
	Data d3 = new Data(2, "ccc");

	List<Data> list = new ArrayList<Data>();
	list.add(d1);
	list.add(d2);
	list.add(d3);

	list.stream().forEach(System.out::println);// 3,1,2の順で表示

	list.sort(new Comparator<Data>() {
	    public int compare(Data data1, Data data2) {
		if (data1.num > data2.num) {
		    return 1;
		} else {
		    return -1;
		}
	    }
	});

	list.stream().forEach(System.out::println);// 1,2,3の順で表示
    }

    static class Data {
	int num;
	String value;

	Data(int num, String value) {
	    this.num = num;
	    this.value = value;
	}

	@Override
	public String toString() {
	    return num + ":" + value;
	}
    }
}
