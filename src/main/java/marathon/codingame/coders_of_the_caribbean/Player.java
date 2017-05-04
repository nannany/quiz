
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Player {

    // 0:なんもなし。1:地雷。2:ラム。
    static int[][] allOverMap;

    static int[][] oddOffset = { { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 1 } };
    static int[][] evenOffset = { { 1, 0 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 } };

    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);

	// game loop
	while (true) {
	    allOverMap = new int[23][21];
	    Arrays.fill(allOverMap, 0);
	    int myShipCount = in.nextInt(); // 自分の機体数
	    int entityCount = in.nextInt();

	    int[] entityId = new int[entityCount];
	    String[] entityType = new String[entityCount];
	    int[] x = new int[entityCount];
	    int[] y = new int[entityCount];
	    int[] arg1 = new int[entityCount];
	    int[] arg2 = new int[entityCount];
	    int[] arg3 = new int[entityCount];
	    int[] arg4 = new int[entityCount];

	    int myShipId = -1;

	    List<MyShip> myShipList = new ArrayList<MyShip>();
	    List<EnemyShip> enemyShipList = new ArrayList<EnemyShip>();
	    List<Barrel> barrelList = new ArrayList<Barrel>();
	    List<Cannonball> cannonballList = new ArrayList<Cannonball>();
	    List<Mine> mineList = new ArrayList<Mine>();
	    for (int i = 0; i < entityCount; i++) {
		entityId[i] = in.nextInt();
		entityType[i] = in.next();// SHIP or BARREL or CANNONBALL or
					  // MINE
		x[i] = in.nextInt();
		y[i] = in.nextInt();
		arg1[i] = in.nextInt();
		arg2[i] = in.nextInt();
		arg3[i] = in.nextInt();
		arg4[i] = in.nextInt();
		if (arg4[i] == 1) {
		    myShipId = entityId[i];
		}
		if (entityType[i].equals("SHIP") && arg4[i] == 1) {
		    MyShip myShip = new MyShip(x[i], y[i], arg1[i], arg2[i], arg3[i]);
		    myShipList.add(myShip);
		}
		if (entityType[i].equals("SHIP") && arg4[i] == 0) {
		    EnemyShip enemyShip = new EnemyShip(x[i], y[i], arg1[i], arg2[i], arg3[i]);
		    enemyShipList.add(enemyShip);
		}
		if (entityType[i].equals("BARREL")) {
		    Barrel barrel = new Barrel(x[i], y[i], arg1[i]);
		    barrelList.add(barrel);
		    allOverMap[x[i]][y[i]] = 2;
		}
		if (entityType[i].equals("CANNONBALL")) {
		    Cannonball cannonball = new Cannonball(x[i], y[i], arg1[i], arg2[i]);
		    cannonballList.add(cannonball);
		}
		if (entityType[i].equals("MINE")) {
		    Mine mine = new Mine(x[i], y[i]);
		    mineList.add(mine);
		    allOverMap[x[i]][y[i]] = 1;
		}
	    }

	    for (MyShip myShip : myShipList) {
		List<Barrel> nearBarrelList = getNearBarrel(myShip.x, myShip.y, barrelList);

		System.out.println("MOVE " + nearBarrelList.get(0).x + " " + nearBarrelList.get(0).y);
	    }
	}
    }

    // 地雷関係なく、近い順に並べ替えた。
    static List<Barrel> getNearBarrel(int x, int y, List<Barrel> barrelList) {
	List<Barrel> retList = new ArrayList<Barrel>();
	retList = barrelList.stream().sorted(new Comparator<Barrel>() {
	    public int compare(Barrel barrel1, Barrel barrel2) {
		return (Math.abs(barrel1.x - x) + Math.abs(barrel1.y - y))
			- (Math.abs(barrel2.x - x) + Math.abs(barrel2.y - y));
	    }
	}).collect(Collectors.toList());

	return retList;
    }

    // 地雷込で、近い順
    static List<Coordinates> getBarrelBypass(Coordinates start, Coordinates goal) {
	class Distance {
	    int distance;
	    Coordinates coordinates;

	    Distance(int distance, Coordinates coordinates) {
		this.distance = distance;
		this.coordinates = coordinates;
	    }
	}
	int[][] prev = new int[23][21];

	int[][] d = new int[23][21];
	Arrays.fill(d, Integer.MAX_VALUE);
	d[start.x][start.y] = 0;

	boolean[][] used = new boolean[23][21];
	Arrays.fill(used, false);

	Distance s = new Distance(0, start);
	Queue<Distance> que = new LinkedList<Distance>();

	que.add(s);
	while (!que.isEmpty()) {
	    Distance distance = que.poll();
	    Coordinates coordinates = distance.coordinates;

	    if (distance.coordinates.equals(goal)) {
		break;
	    }

	    // 奇数行目で動く場合
	    if (coordinates.y % 2 == 1) {
		for (int i = 0; i < 6; i++) {
		    int nextX = oddOffset[i][0] + coordinates.x;
		    int nextY = oddOffset[i][1] + coordinates.y;
		    if (!used[nextX][nextY] && 0 <= nextX && nextX < 23 && 0 <= nextY && nextY < 21) {
			Distance tmpDis = new Distance(distance.distance++, new Coordinates(nextX, nextY));
			d[nextX][nextY] = tmpDis.distance;
			que.add(tmpDis);
		    }
		}
		// 偶数行目で動く場合
	    } else {
		for (int i = 0; i < 6; i++) {
		    int nextX = evenOffset[i][0] + coordinates.x;
		    int nextY = evenOffset[i][1] + coordinates.y;
		    if (!used[nextX][nextY] && 0 <= nextX && nextX < 23 && 0 <= nextY && nextY < 21) {
			Distance tmpDis = new Distance(distance.distance++, new Coordinates(nextX, nextY));
			d[nextX][nextY] = tmpDis.distance;
			que.add(tmpDis);
		    }
		}
	    }
	}

    }

    static class MyShip extends Coordinates {
	// 回転の向き
	// 0:→、１:右上。。。。
	int rotationOrientation;
	// 速さ。0~2
	int speed;
	// rumのストック。100まで
	int stock;

	public MyShip(int x, int y, int rotationOrientation, int speed, int stock) {
	    super(x, y);
	    this.rotationOrientation = rotationOrientation;
	    this.speed = speed;
	    this.stock = stock;
	}
    }

    static class EnemyShip extends Coordinates {
	// 回転の向き
	// 0:→、１:右上。。。。
	int rotationOrientation;
	// 速さ。0~2
	int speed;
	// rumのストック。100まで
	int stock;

	public EnemyShip(int x, int y, int rotationOrientation, int speed, int stock) {
	    super(x, y);
	    this.rotationOrientation = rotationOrientation;
	    this.speed = speed;
	    this.stock = stock;
	}
    }

    static class Barrel extends Coordinates {
	int amount;

	public Barrel(int x, int y, int amount) {
	    super(x, y);
	    this.amount = amount;
	}
    }

    static class Cannonball extends Coordinates {
	// どの機体から発射されたか
	int fromWhere;
	// あと何ターンで着弾するか
	int leftBeforeLand;

	public Cannonball(int x, int y, int fromWhere, int leftBeforeLand) {
	    super(x, y);
	    this.fromWhere = fromWhere;
	    this.leftBeforeLand = leftBeforeLand;
	}
    }

    static class Mine extends Coordinates {
	public Mine(int x, int y) {
	    super(x, y);
	}
    }

    static class Coordinates {
	int x, y;

	public Coordinates(int x, int y) {
	    this.x = x;
	    this.y = y;
	}

    }
}