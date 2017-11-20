package marathon.codingame.mean_max;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Player {
    static ArrayList<Wreck> wreckList = new ArrayList<>();
    static Reaper myReaper;

    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);

	while (true) {
	    // 俺のスコア
	    int myScore = in.nextInt();
	    // 敵1のスコア
	    int enemyScore1 = in.nextInt();
	    // 敵2のスコア
	    int enemyScore2 = in.nextInt();
	    int myRage = in.nextInt();

	    int enemyRage1 = in.nextInt();
	    int enemyRage2 = in.nextInt();

	    int unitCount = in.nextInt();
	    for (int i = 0; i < unitCount; i++) {
		int unitId = in.nextInt();
		int unitType = in.nextInt();
		int player = in.nextInt();
		float mass = in.nextFloat();
		int radius = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		int extra = in.nextInt();
		int extra2 = in.nextInt();

		if (unitType == 0) {
		    if (player == 0) {
			myReaper = new Reaper(unitId, player, mass, radius, x, y, vx, vy);
		    } else if (player == 1) {
			Reaper enemyReaper1 = new Reaper(unitId, player, mass, radius, x, y, vx, vy);
		    } else {
			Reaper enemyReaper2 = new Reaper(unitId, player, mass, radius, x, y, vx, vy);
		    }
		} else if (unitType == 4) {
		    Wreck wreck = new Wreck(unitId, x, y);
		    wreckList.add(wreck);
		}

	    }

	    int retX = nearestWreckFromMyReaper(myReaper).x;
	    int retY = nearestWreckFromMyReaper(myReaper).y;

	    Throttle(retX, retY, 300);
	    System.out.println("WAIT");
	    System.out.println("WAIT");
	}
    }

    /**
     * 加速をsysoutするラッパー
     *
     * @param x
     * @param y
     * @param throttle
     */
    private static void Throttle(int x, int y, int throttle) {
	System.out.println(x + " " + y + " " + throttle);
    }

    /**
     * 指定したReaperから一番近い位置にあるWreckのPosを返す。
     *
     * @return
     */
    private static Pos nearestWreckFromMyReaper(Reaper reaper) {
	Wreck retWreck = new Wreck();
	int distance = Integer.MAX_VALUE;
	for (Wreck w : wreckList) {
	    int tmpDistance = Math.abs(w.x - reaper.x) + Math.abs(w.y - reaper.y);
	    if (tmpDistance < distance) {
		distance = tmpDistance;
		retWreck = w;
	    }
	}

	return new Pos(retWreck.x, retWreck.y);
    }

    // 位置情報
    static class Pos {
	int x, y;

	public Pos(int x, int y) {
	    this.x = x;
	    this.y = y;
	}
    }

    // Reaperのクラス
    static class Reaper {
	int unitId;
	int playerId;
	float mass;
	int radius;
	int x;
	int y;
	int vx;
	int vy;

	public Reaper(int unitId, int playerId, float mass, int radius, int x, int y, int vx, int vy) {
	    super();
	    this.unitId = unitId;
	    this.playerId = playerId;
	    this.mass = mass;
	    this.radius = radius;
	    this.x = x;
	    this.y = y;
	    this.vx = vx;
	    this.vy = vy;
	}

    }

    // 水場
    static class Wreck {
	int unitId;
	int x;
	int y;

	public Wreck() {

	}

	public Wreck(int unitId, int x, int y) {
	    super();
	    this.unitId = unitId;
	    this.x = x;
	    this.y = y;
	}

    }
}
