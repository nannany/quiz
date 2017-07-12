package quiz.challengeBook.coneology_poj2932;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    static int N;
    static double[] x, y, r;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	x = new double[N];
	y = new double[N];
	r = new double[N];
	for (int i = 0; i < N; i++) {
	    x[i] = sc.nextDouble();
	    y[i] = sc.nextDouble();
	    r[i] = sc.nextDouble();
	}

	ArrayList<Event> events = new ArrayList<Event>();
	for (int i = 0; i < N; i++) {
	    events.add(new Event(x[i] - r[i], i));
	    events.add(new Event(x[i] + r[i], i + N));
	}

	events.sort(new Comparator<Event>() {
	    public int compare(Event e1, Event e2) {
		if (e2.end - e1.end > 0) {
		    return 1;
		} else if (e1.end - e2.end == 0) {
		    return 0;
		} else {
		    return -1;
		}
	    }
	});

	TreeSet<Event> outers = new TreeSet<Event>(new ComparatorForTreeSet());
	ArrayList<Integer> res = new ArrayList<Integer>();

	for (int i = 0; i < events.size(); i++) {
	    int id = events.get(i).index % N;
	    if (events.get(i).index < N) {
		Event it = outers.ceiling(new Event(y[id], id));
		Event it2 = outers.lower(new Event(y[id], id));
		if (!outers.isEmpty() && it != outers.last() && inside(id, it.index)) {
		    continue;
		}
		if (!outers.isEmpty() && it != outers.first() && inside(id, it2.index)) {
		    continue;
		}
		res.add(id);
		outers.add(new Event(y[id], id));
	    } else {
		outers.remove(new Event(y[id], id));
	    }
	}

	Collections.sort(res);

	System.out.println(res.size());
	for (int i = 0; i < res.size(); i++) {
	    System.out.printf("%d%c", res.get(i) + 1, i + 1 == res.size() ? '\n' : ' ');
	}

    }

    static boolean inside(int i, int j) {
	double dx = x[i] - x[j];
	double dy = y[i] - y[j];
	return dx * dx + dy * dy <= r[j] * r[j];
    }

    static class ComparatorForTreeSet implements Comparator<Event> {
	public int compare(Event e1, Event e2) {
	    if (e2.end - e1.end > 0) {
		return 1;
	    } else if (e1.end - e2.end == 0) {
		return 0;
	    } else {
		return -1;
	    }
	}
    }

    // end が端。indexに関して、0~N-1が左端、N~2N-1が右端。
    static class Event implements Comparator {
	double end;
	int index;

	public Event(double end, int index) {
	    super();
	    this.end = end;
	    this.index = index;
	}

	public int compare(Object o1, Object o2) {
	    Event e1 = (Event) o1;
	    Event e2 = (Event) o2;
	    if (e1.end - e2.end < 0) {
		return -1;
	    } else if (e1.end - e2.end == 0) {
		return 0;
	    } else {
		return 1;
	    }
	}

    }
}
