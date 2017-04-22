
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);

	// game loop
	while (true) {
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
		}
		if (entityType[i].equals("CANNONBALL")) {
		    Cannonball cannonball = new Cannonball(x[i], y[i], arg1[i], arg2[i]);
		    cannonballList.add(cannonball);
		}
		if (entityType[i].equals("MINE")) {
		    Mine mine = new Mine(x[i], y[i]);
		    mineList.add(mine);
		}
	    }
	    int targetX = -1, targetY = -1;
	    int distance = 1000000000;
	    for (Barrel barrel : barrelList) {
		int tmpDistance = Math.abs(x[myShipId] - barrel.x) + Math.abs(y[myShipId] - barrel.y);

		if (tmpDistance < distance) {
		    targetX = barrel.x;
		    targetY = barrel.y;
		    distance = tmpDistance;
		}
	    }

	    for (int i = 0; i < myShipCount; i++) {
		System.out.println("MOVE " + targetX + " " + targetY);
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