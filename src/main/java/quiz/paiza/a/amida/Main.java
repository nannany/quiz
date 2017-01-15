package quiz.paiza.a.amida;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	// あみだのsingleton
	Amidakuji amidakuji = Amidakuji.getAmidakuji();
	Map<String, String> map = new HashMap<String, String>();

	Scanner sc = new Scanner(System.in);

	int length = sc.nextInt();
	amidakuji.setLength(length);
	int num = sc.nextInt();
	amidakuji.setNum(num);

	amidakuji.initialize();

	int sideNum = sc.nextInt();

	for (int i = 0; i < sideNum; i++) {
	    int orgLine = sc.nextInt();
	    int orgPoint = sc.nextInt();
	    int dstPoint = sc.nextInt();
	    MakeAmida ma = new MakeAmida();
	    ma.plotPoint(String.valueOf(i + 1), orgLine, orgPoint, dstPoint);

	    int[] tmp1 = { orgLine - 1, orgPoint - 1 };
	    int[] tmp2 = { orgLine, dstPoint - 1 };
	    map.put(Arrays.toString(tmp1), Arrays.toString(tmp2));
	    map.put(Arrays.toString(tmp2), Arrays.toString(tmp1));
	}

	// for (int j = 0; j < length - 1; j++) {
	// for (int i = 0; i < num; i++) {
	// System.out.print(amidakuji.getMapping().get(i).get(j) + " ");
	// }
	// System.out.println();
	// }

	for (int i = 0; i < num; i++) {
	    Collections.reverse(amidakuji.getMapping().get(i));
	}

	int searchLineNum = 0;
	int startPoint = 0;
	boolean continueFlag = true;
	while (startPoint != length && continueFlag) {
	    flag: for (int i = startPoint; i < length - 1; i++) {
		if (!amidakuji.getMapping().get(searchLineNum).get(i).equals("0")) {
		    int[] tmp3 = { searchLineNum, length - i - 2 };
		    searchLineNum = Integer.parseInt(map.get(Arrays.toString(tmp3)).split(",", 0)[0].replace("[", ""));
		    startPoint = length
			    - Integer.parseInt(
				    map.get(Arrays.toString(tmp3)).split(",", 0)[1].replace("]", "").replace(" ", ""))
			    - 1;
		    break flag;
		} else if (i == length - 2) {
		    continueFlag = false;
		}
	    }
	}
	System.out.println(searchLineNum + 1);
    }
}

class Amidakuji {
    private static Amidakuji amidakuji = new Amidakuji();

    private static int num;
    private static int length;
    private List<List<String>> mapping = new ArrayList<List<String>>();

    private Amidakuji() {
    }

    public static Amidakuji getAmidakuji() {
	return amidakuji;
    }

    public void initialize() {
	for (int i = 0; i < num; i++) {
	    List<String> list = new ArrayList<String>();
	    for (int j = 0; j < length - 1; j++) {
		list.add("0");
	    }
	    mapping.add(list);
	}
    }

    public int getNum() {
	return num;
    }

    public void setNum(int num) {
	this.num = num;
    }

    public int getLength() {
	return length;
    }

    public void setLength(int length) {
	this.length = length;
    }

    public List<List<String>> getMapping() {
	return mapping;
    }

    public void setMapping(String mark, int line, int point) {
	this.mapping.get(line - 1).set(point - 1, mark);
    }
}

class MakeAmida {
    Amidakuji amidakuji = Amidakuji.getAmidakuji();

    public void plotPoint(String mark, int orgLine, int orgPoint, int dstPoint) {
	amidakuji.setMapping(mark + "L", orgLine, orgPoint);
	amidakuji.setMapping(mark + "R", orgLine + 1, dstPoint);
    }
}
