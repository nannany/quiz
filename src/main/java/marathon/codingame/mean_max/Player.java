package marathon.codingame.mean_max;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Player {
    static HashMap<Integer, Wreck> wreckMap;
    static HashMap<Integer, Tanker> tankerMap;
    static ArrayList<Tar> tarList;
    static ArrayList<Oil> oilList;
    static Looter myReaper;
    static Looter enemyReaper1;
    static Looter enemyReaper2;
    static Looter myDestroyer;
    static Looter enemyDestroyer1;
    static Looter enemyDestroyer2;
    static Looter myDoof;
    static Looter enemyDoof1;
    static Looter enemyDoof2;

    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);

	while (true) {
	    // 俺のスコア
	    int myScore = in.nextInt();
	    // 敵1のスコア
	    int enemyScore1 = in.nextInt();
	    // 敵2のスコア
	    int enemyScore2 = in.nextInt();
	    // 俺のレイジ
	    int myRage = in.nextInt();
	    // 敵1のレイジ
	    int enemyRage1 = in.nextInt();
	    // 敵2のレイジ
	    int enemyRage2 = in.nextInt();

	    int unitCount = in.nextInt();
	    wreckMap = new HashMap<>();
	    tankerMap = new HashMap<>();
	    tarList = new ArrayList<>();
	    oilList = new ArrayList<>();
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

		// reaper
		if (unitType == 0) {
		    if (player == 0) {
			myReaper = new Looter(unitId, player, mass, radius, x, y, vx, vy);
		    } else if (player == 1) {
			enemyReaper1 = new Looter(unitId, player, mass, radius, x, y, vx, vy);
		    } else {
			enemyReaper2 = new Looter(unitId, player, mass, radius, x, y, vx, vy);
		    }
		    // destroyer
		} else if (unitType == 1) {
		    if (player == 0) {
			myDestroyer = new Looter(unitId, player, mass, radius, x, y, vx, vy);
		    } else if (player == 1) {
			enemyDestroyer1 = new Looter(unitId, player, mass, radius, x, y, vx, vy);
		    } else {
			enemyDestroyer2 = new Looter(unitId, player, mass, radius, x, y, vx, vy);
		    }
		    // doof
		} else if (unitType == 2) {
		    if (player == 0) {
			myDoof = new Looter(unitId, player, mass, radius, x, y, vx, vy);
		    } else if (player == 1) {
			enemyDoof1 = new Looter(unitId, player, mass, radius, x, y, vx, vy);
		    } else {
			enemyDoof2 = new Looter(unitId, player, mass, radius, x, y, vx, vy);
		    }
		    // tanker
		} else if (unitType == 3) {
		    Tanker tanker = new Tanker(unitId, player, mass, radius, x, y, vx, vy, extra, extra2);
		    tankerMap.put(unitId, tanker);
		} else if (unitType == 4) {
		    Wreck wreck = new Wreck(unitId, x, y, extra);
		    wreckMap.put(unitId, wreck);
		} else if (unitType == 5) {
		    Tar tar = new Tar(unitId, x, y, extra);
		    tarList.add(tar);
		} else if (unitType == 6) {
		    Oil oil = new Oil(unitId, x, y, extra);
		    oilList.add(oil);
		}
	    }

	    /**
	     * 水持ってるtanker見つけたらreaper,destroyer同時に襲いに行く。
	     * 水持ってるやつ見つけるまでは、reaperは水探して、destroyerはほかの邪魔しに行く。
	     */
	    if (!tankerMap.entrySet().stream().anyMatch(t -> t.getValue().waterCapacity == 0)) {
		// reaper
		Pos tmpPos = nearestWreckFromMyReaper(myReaper);
		// 距離
		// int tmpDistance = (int) Math.sqrt((tmpPos.x - myReaper.x) ^ 2
		// + (tmpPos.y - myReaper.y) ^ 2);
		throttle(tmpPos.x, tmpPos.y, 300);
		// destroyer
		if (enemyScore1 > enemyScore2) {
		    throttle(enemyReaper1.x, enemyReaper1.y, 300);
		} else {
		    throttle(enemyReaper2.x, enemyReaper2.y, 300);
		}
		// 水がある場合
	    } else if (!wreckMap.isEmpty()) {
		// reaper
		Pos tmpPos = nearestWreckFromMyReaper(myReaper);
		throttle(tmpPos.x, tmpPos.y, 300);
		int id = tankerMap.entrySet().stream().filter(t -> t.getValue().waterCapacity == 0)
			.max((t1, t2) -> t1.getValue().water - t2.getValue().water).get().getValue().unitId;
		throttle(tankerMap.get(id).x, tankerMap.get(id).y, 300);
	    } else {
		int id = tankerMap.entrySet().stream().filter(t -> t.getValue().waterCapacity == 0)
			.max((t1, t2) -> t1.getValue().water - t2.getValue().water).get().getValue().unitId;
		throttle(tankerMap.get(id).x, tankerMap.get(id).y, 300);
		throttle(tankerMap.get(id).x, tankerMap.get(id).y, 300);

	    }

	    // doof操作
	    if ((getDistance(myDoof, enemyReaper1) < 1000 || getDistance(myDoof, enemyReaper2) < 1000)
		    && getDistance(myDoof, myReaper) > 1000) {
		if (myRage > 60) {
		    if (getDistance(myDoof, enemyReaper1) < 1000) {
			skill(enemyReaper1.x, enemyReaper1.y);
		    } else {
			skill(enemyReaper2.x, enemyReaper2.y);
		    }
		} else {
		    if (enemyScore1 > enemyScore2) {
			throttle(enemyReaper1.x, enemyReaper1.y, 300);
		    } else {
			throttle(enemyReaper2.x, enemyReaper2.y, 300);
		    }
		}
	    } else {
		if (enemyScore1 > enemyScore2) {
		    throttle(enemyReaper1.x, enemyReaper1.y, 300);
		} else {
		    throttle(enemyReaper2.x, enemyReaper2.y, 300);
		}
	    }
	}

    }

    /**
     * 加速をsysoutするラッパー
     *
     * @param x
     * @param y
     * @param throttle
     */
    private static void throttle(int x, int y, int throttle) {
	System.out.println(x + " " + y + " " + throttle);
    }

    /**
     * SKILL実行ラッパー
     *
     * @param x
     * @param y
     */
    private static void skill(int x, int y) {
	System.out.println("SKILL " + x + " " + y);
    }

    /**
     * 任意の2機の距離を返す。
     *
     * @param l1
     * @param l2
     * @return
     */
    private static int getDistance(Looter l1, Looter l2) {
	if (l2.playerId == 0) {
	    System.err.println("myReaper:" + (int) Math.sqrt(Math.pow((l1.x - l2.x), 2) + Math.pow((l1.y - l2.y), 2)));
	} else if (l2.playerId == 1) {
	    System.err.println("enemy1:" + (int) Math.sqrt((l1.x - l2.x) ^ 2 + (l1.y - l2.y) ^ 2));
	} else if (l2.playerId == 2) {
	    System.err.println("enemy2:" + (int) Math.sqrt((l1.x - l2.x) ^ 2 + (l1.y - l2.y) ^ 2));
	}
	return (int) Math.sqrt(Math.pow((l1.x - l2.x), 2) + Math.pow((l1.y - l2.y), 2));
    }

    /**
     * 任意の2機の中間地点をかえす。
     *
     * @param l1
     * @param l2
     * @return
     */
    private static Pos getMidPos(Looter l1, Looter l2) {
	int retX = (l1.x + l2.x) / 2;
	int retY = (l1.y + l2.y) / 2;
	return new Pos(retX, retY);
    }

    /**
     * 指定したReaperから一番近い位置にあるWreckのPosを返す。
     *
     * @return
     */
    private static Pos nearestWreckFromMyReaper(Looter reaper) {
	Wreck retWreck = new Wreck();
	int distance = Integer.MAX_VALUE;
	for (Map.Entry<Integer, Wreck> w : wreckMap.entrySet()) {
	    int tmpDistance = Math.abs(w.getValue().x - reaper.x) + Math.abs(w.getValue().y - reaper.y);
	    if (tmpDistance < distance) {
		distance = tmpDistance;
		retWreck = w.getValue();
		System.err.println(w.getValue().unitId);
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

    // Looterのクラス
    static class Looter {
	int unitId;
	int playerId;
	float mass;
	int radius;
	int x;
	int y;
	int vx;
	int vy;

	public Looter(int unitId, int playerId, float mass, int radius, int x, int y, int vx, int vy) {
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

    // Tankerのクラス
    static class Tanker extends Looter {
	int water, waterCapacity;

	public Tanker(int unitId, int playerId, float mass, int radius, int x, int y, int vx, int vy, int water,
		int waterCapacity) {
	    super(unitId, playerId, mass, radius, x, y, vx, vy);
	    this.water = water;
	    this.waterCapacity = waterCapacity;
	}

    }

    // 水場
    static class Wreck {
	int unitId;
	int x;
	int y;
	int water;

	public Wreck() {

	}

	public Wreck(int unitId, int x, int y, int water) {
	    this.unitId = unitId;
	    this.x = x;
	    this.y = y;
	    this.water = water;
	}
    }

    // tar
    static class Tar {
	int unitId, x, y, duration;

	public Tar(int unitId, int x, int y, int duration) {
	    this.unitId = unitId;
	    this.x = x;
	    this.y = y;
	    this.duration = duration;
	}
    }

    // oil
    static class Oil {
	int unitId, x, y, duration;

	public Oil(int unitId, int x, int y, int duration) {
	    this.unitId = unitId;
	    this.x = x;
	    this.y = y;
	    this.duration = duration;
	}
    }
}
