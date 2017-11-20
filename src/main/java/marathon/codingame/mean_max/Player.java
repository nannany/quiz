package marathon.codingame.mean_max;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Player {
    static ArrayList<Wreck> wreckList = new ArrayList<>();

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
			Reaper myReaper = new Reaper(unitId, player, mass, radius, x, y, vx, vy);
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

	    System.out.println("WAIT");
	    System.out.println("WAIT");
	    System.out.println("WAIT");
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

	public int getUnitId() {
	    return unitId;
	}

	public void setUnitId(int unitId) {
	    this.unitId = unitId;
	}

	public int getPlayerId() {
	    return playerId;
	}

	public void setPlayerId(int playerId) {
	    this.playerId = playerId;
	}

	public float getMass() {
	    return mass;
	}

	public void setMass(float mass) {
	    this.mass = mass;
	}

	public int getRadius() {
	    return radius;
	}

	public void setRadius(int radius) {
	    this.radius = radius;
	}

	public int getX() {
	    return x;
	}

	public void setX(int x) {
	    this.x = x;
	}

	public int getY() {
	    return y;
	}

	public void setY(int y) {
	    this.y = y;
	}

	public int getVx() {
	    return vx;
	}

	public void setVx(int vx) {
	    this.vx = vx;
	}

	public int getVy() {
	    return vy;
	}

	public void setVy(int vy) {
	    this.vy = vy;
	}
    }

    // 水場
    static class Wreck {
	int unitId;
	int x;
	int y;

	public Wreck(int unitId, int x, int y) {
	    super();
	    this.unitId = unitId;
	    this.x = x;
	    this.y = y;
	}

	public int getUnitId() {
	    return unitId;
	}

	public void setUnitId(int unitId) {
	    this.unitId = unitId;
	}

	public int getX() {
	    return x;
	}

	public void setX(int x) {
	    this.x = x;
	}

	public int getY() {
	    return y;
	}

	public void setY(int y) {
	    this.y = y;
	}

    }
}
