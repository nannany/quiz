package quiz.paiza.a.amida;

import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	// あみだのsingleton
	Amidakuji amidakuji = Amidakuji.getAmidakuji();
	Map<IntBuffer, IntBuffer> map = new HashMap<IntBuffer, IntBuffer>();

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
	    ma.plotPoint(i + 1, orgLine, orgPoint, dstPoint);

	    int[] tmp1 = { orgLine, orgPoint };
	    int[] tmp2 = { orgLine + 1, dstPoint };
	    IntBuffer ib1 = IntBuffer.wrap(tmp1);
	    IntBuffer ib2 = IntBuffer.wrap(tmp2);

	    map.put(ib1, ib2);
	    map.put(ib2, ib1);
	}

	int searchLineNum = 0;
	int startPoint = length - 1;
	boolean continueFlag = true;
	while (startPoint != 0 && continueFlag) {
	    flag: for (int i = startPoint - 1; -1 < i; i--) {
		if (amidakuji.getMapping()[searchLineNum][i] != 0) {
		    int[] tmp3 = { searchLineNum + 1, i + 1 };
		    IntBuffer ib3 = IntBuffer.wrap(tmp3);
		    searchLineNum = map.get(ib3).array()[0] - 1;
		    startPoint = map.get(ib3).array()[1] - 1;
		    break flag;
		} else if (i == 0) {
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
    private int[][] mapping;

    public int[][] getMapping() {
	return mapping;
    }

    public void setMapping(int[][] mapping) {
	this.mapping = mapping;
    }

    private Amidakuji() {
    }

    public static Amidakuji getAmidakuji() {
	return amidakuji;
    }

    public void initialize() {
	this.mapping = new int[num][length - 1];
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

    public void setMapping(int mark, int line, int point) {
	this.mapping[line - 1][point - 1] = mark;
    }
}

class MakeAmida {
    Amidakuji amidakuji = Amidakuji.getAmidakuji();

    public void plotPoint(int mark, int orgLine, int orgPoint, int dstPoint) {
	amidakuji.setMapping(mark, orgLine, orgPoint);
	amidakuji.setMapping(mark, orgLine + 1, dstPoint);
    }
}
