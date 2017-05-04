package marathon.codingame.ghost_in_the_cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Player {
    static List<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
    static int factoryCount;
    static int linkCount;
    static HashMap<Integer, MyFactory> myFactorys;
    static HashMap<Integer, EnemyFactory> enemyFactorys;
    static HashMap<Integer, NeutoralFactory> neutoralFactorys;
    static HashMap<Integer, MyTroop> myTroops;
    static HashMap<Integer, EnemyTroop> enemyTroops;
    static HashMap<Integer, String> factoryMap;
    static HashMap<Integer, MyBomb> myBombs;
    static HashMap<Integer, EnemyBomb> enemyBombs;

    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
	factoryCount = in.nextInt(); // the number of factories
	for (int i = 0; i < factoryCount; i++) {
	    graph.add(new ArrayList<Edge>());
	}
	linkCount = in.nextInt(); // the number of links between factories
	for (int i = 0; i < linkCount; i++) {
	    int from = in.nextInt();
	    int to = in.nextInt();
	    int distance = in.nextInt();
	    graph.get(from).add(new Edge(to, distance));
	    graph.get(to).add(new Edge(from, distance));
	}

	// game loop
	flag1: while (true)

	{
	    int entityCount = in.nextInt();
	    myFactorys = new HashMap<Integer, MyFactory>();
	    enemyFactorys = new HashMap<Integer, EnemyFactory>();
	    neutoralFactorys = new HashMap<Integer, NeutoralFactory>();
	    myTroops = new HashMap<Integer, MyTroop>();
	    enemyTroops = new HashMap<Integer, EnemyTroop>();
	    factoryMap = new HashMap<Integer, String>();
	    myBombs = new HashMap<Integer, MyBomb>();
	    enemyBombs = new HashMap<Integer, EnemyBomb>();
	    for (int i = 0; i < entityCount; i++) {
		int entityId = in.nextInt();
		String entityType = in.next();
		int arg1 = in.nextInt();
		int arg2 = in.nextInt();
		int arg3 = in.nextInt();
		int arg4 = in.nextInt();
		int arg5 = in.nextInt();
		if ("FACTORY".equals(entityType)) {
		    if (arg1 == 1) {
			myFactorys.put(entityId, new MyFactory(entityId, arg2, arg3));
			factoryMap.put(entityId, "MINE");
		    } else if (arg1 == -1) {
			enemyFactorys.put(entityId, new EnemyFactory(entityId, arg2, arg3));
			factoryMap.put(entityId, "ENEMY");
		    } else {
			neutoralFactorys.put(entityId, new NeutoralFactory(entityId, arg2, arg3));
			factoryMap.put(entityId, "NEUTORAL");
		    }
		} else if ("TROOP".equals(entityType)) {
		    if (arg1 == 1) {
			myTroops.put(entityId, new MyTroop(arg2, arg3, arg4, arg5));
		    } else {
			enemyTroops.put(entityId, new EnemyTroop(arg2, arg3, arg4, arg5));
		    }
		} else if ("BOMB".equals(entityType)) {
		    if (arg1 == 1) {
			myBombs.put(entityId, new MyBomb(arg2, arg4, arg3));
		    } else {
			enemyBombs.put(entityId, new EnemyBomb(arg2, arg4));
		    }
		}
	    }

	    int minDistance = Integer.MAX_VALUE;
	    int retFrom = 0;
	    int retTo = 0;
	    int retCyborgs = 0;

	    // ニュートラルに送りこむ
	    if (!neutoralFactorys.isEmpty()) {
		int evaluateVal = Integer.MIN_VALUE;
		for (Map.Entry<Integer, MyFactory> myFactory : myFactorys.entrySet()) {
		    ArrayList<Edge> tmpList = graph.get(myFactory.getKey());
		    int tmpEvaluateVal = Integer.MIN_VALUE;
		    for (Edge edge : tmpList) {
			if ("NEUTORAL".equals(factoryMap.get(edge.to))
				&& getTroopSum(edge.to) <= neutoralFactorys.get(edge.to).numCyborgs) {
			    if (evaluateVal < evaluateNeutoral(myFactory.getValue(), neutoralFactorys.get(edge.to),
				    edge.distance)) {
				tmpEvaluateVal = evaluateNeutoral(myFactory.getValue(), neutoralFactorys.get(edge.to),
					edge.distance);
				retTo = edge.to;
				retFrom = myFactory.getKey();
				System.err.println("retTo:" + retTo + " retFrom:" + retFrom + "dis");

			    }
			}
		    }
		    if (evaluateVal < tmpEvaluateVal) {
			evaluateVal = tmpEvaluateVal;
		    }
		    // debug
		    // for (Edge edge : graph.get(myFactory.getKey())) {
		    // System.err.println(edge.to);
		    // }
		}
		if (neutoralFactorys.get(retTo) == null || myFactorys.get(retFrom) == null) {
		    System.out.println("WAIT");
		    continue flag1;
		} else if (myFactorys.get(retFrom).numCyborgs / 2 < neutoralFactorys.get(retTo).numCyborgs) {
		    retCyborgs = myFactorys.get(retFrom).numCyborgs / 2;
		} else {
		    retCyborgs = neutoralFactorys.get(retTo).numCyborgs + 10;
		}
		System.out.println("MOVE " + retFrom + " " + retTo + " " + retCyborgs);
		System.err.println("toNeu:MOVE " + retFrom + " " + retTo + " " + retCyborgs);
		continue flag1;
	    }

	    System.err.println("doubt");
	    int maxCyborgsId = getIdHaveMaxCyborgs();
	    System.err.println("maxCyborgsId:" + maxCyborgsId);

	    // 敵に送り込む
	    if (15 < myFactorys.get(maxCyborgsId).numCyborgs) {
		System.err.println("toEnemy");
		int minDistanceToEnemy = Integer.MAX_VALUE;
		flag2: for (Map.Entry<Integer, EnemyFactory> enemyFactory : enemyFactorys.entrySet()) {
		    if (getDistanceFromMyToEnemy(maxCyborgsId, enemyFactory.getKey()) < minDistanceToEnemy) {
			minDistanceToEnemy = getDistanceFromMyToEnemy(maxCyborgsId, enemyFactory.getKey());
			retTo = enemyFactory.getKey();
		    }
		    retCyborgs = 10;
		    if (50 <= enemyFactory.getValue().numCyborgs && 2 <= enemyFactory.getValue().numProduction) {
			System.out.print("BOMB " + maxCyborgsId + " " + enemyFactory.getKey() + ";");
			break flag2;
		    }
		}
		System.out.println("MOVE " + maxCyborgsId + " " + retTo + " " + retCyborgs);
		System.err.println("toEnemy:MOVE " + maxCyborgsId + " " + retTo + " " + retCyborgs);
		continue flag1;
	    }

	    System.out.println("WAIT");

	}
    }

    // 敵と自分の距離を測る
    static int getDistanceFromMyToEnemy(int myId, int enemyId) {
	ArrayList<Edge> tmpList = graph.get(myId);
	int ret = -1;
	for (Edge edge : tmpList) {
	    if (edge.to == enemyId) {
		ret = edge.distance;
	    }
	}
	return ret;
    }

    // 目的地に向かっているtroopの数を返す
    static int getTroopSum(int destination) {
	int ret = 0;
	for (Map.Entry<Integer, MyTroop> myTroop : myTroops.entrySet()) {
	    if (myTroop.getValue().to == destination) {
		ret += myTroop.getValue().numCyborgs;
	    }
	}
	return ret;
    }

    // 最初ニュートラルを責める際に、どこに向かうか評価する関数
    static int evaluateNeutoral(MyFactory myFactory, NeutoralFactory neutoralFactory, int distance) {
	if (myFactory.numCyborgs == 0) {
	    return Integer.MIN_VALUE;
	} else {
	    return myFactory.numCyborgs - distance + neutoralFactory.numProduction * 5;
	}
    }

    // 自分の工場の中で一番サイボーグ持っているところのIDを返す。
    static int getIdHaveMaxCyborgs() {
	int tmpMax = -1;
	int retId = -1;
	for (Map.Entry<Integer, MyFactory> myFactory : myFactorys.entrySet()) {
	    if (tmpMax < myFactory.getValue().numCyborgs) {
		tmpMax = myFactory.getValue().numCyborgs;
		retId = myFactory.getKey().intValue();
	    }
	}
	return retId;
    }

    static int countMyCyborgs() {
	int ret = 0;
	for (Map.Entry<Integer, MyFactory> myFactory : myFactorys.entrySet()) {
	    ret += myFactory.getValue().numCyborgs;
	}
	return ret;
    }

    static class Edge {
	int to, distance;

	Edge(int to, int distance) {
	    this.distance = distance;
	    this.to = to;
	}
    }

    static class Factory {
	int id, numCyborgs, numProduction;

	public Factory(int id, int numCyborgs, int numProduction) {
	    super();
	    this.id = id;
	    this.numCyborgs = numCyborgs;
	    this.numProduction = numProduction;
	}
    }

    static class MyFactory extends Factory {

	public MyFactory(int id, int numCyborgs, int numProduction) {
	    super(id, numCyborgs, numProduction);
	}
    }

    static class EnemyFactory extends Factory {

	public EnemyFactory(int id, int numCyborgs, int numProduction) {
	    super(id, numCyborgs, numProduction);
	}

    }

    static class NeutoralFactory extends Factory {

	public NeutoralFactory(int id, int numCyborgs, int numProduction) {
	    super(id, numCyborgs, numProduction);
	}

    }

    static class Troop {
	int from, to, numCyborgs, remainTurn;

	public Troop(int from, int to, int numCyborgs, int remainTurn) {
	    this.from = from;
	    this.to = to;
	    this.numCyborgs = numCyborgs;
	    this.remainTurn = remainTurn;
	}
    }

    static class MyTroop extends Troop {

	public MyTroop(int from, int to, int numCyborgs, int remainTurn) {
	    super(from, to, numCyborgs, remainTurn);
	}
    }

    static class EnemyTroop extends Troop {

	public EnemyTroop(int from, int to, int numCyborgs, int remainTurn) {
	    super(from, to, numCyborgs, remainTurn);

	}
    }

    static class Bomb {
	int from, remainTurn;

	public Bomb(int from, int remainTurn) {
	    this.from = from;
	    this.remainTurn = remainTurn;
	}
    }

    static class MyBomb extends Bomb {
	int to;

	public MyBomb(int from, int remainTurn, int to) {
	    super(from, remainTurn);
	    this.to = to;
	}
    }

    static class EnemyBomb extends Bomb {

	public EnemyBomb(int from, int remainTurn) {
	    super(from, remainTurn);
	}
    }
}