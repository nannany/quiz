
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
	    int myShipCount = in.nextInt(); // the number of remaining ships
	    int entityCount = in.nextInt(); // the number of entities (e.g.
					    // ships, mines or cannonballs)

	    int[] entityId = new int[entityCount];
	    String[] entityType = new String[entityCount];
	    int[] x = new int[entityCount];
	    int[] y = new int[entityCount];
	    int[] arg1 = new int[entityCount];
	    int[] arg2 = new int[entityCount];
	    int[] arg3 = new int[entityCount];
	    int[] arg4 = new int[entityCount];

	    int myShipId = -1;

	    List<Barrel> barrelList = new ArrayList<Barrel>();
	    for (int i = 0; i < entityCount; i++) {
		entityId[i] = in.nextInt();
		entityType[i] = in.next();// SHIP or BARREL
		x[i] = in.nextInt();
		y[i] = in.nextInt();
		if (entityType[i].equals("BARREL")) {
		    Barrel barrel = new Barrel(x[i], y[i]);
		    barrelList.add(barrel);
		}
		arg1[i] = in.nextInt();// the ship's rotation
				       // orientation(between 0 and 5)
		arg2[i] = in.nextInt();// the ship's speed (between 0 and 2)
		arg3[i] = in.nextInt();// the ship's stock of rum units
		arg4[i] = in.nextInt();// 1 if the ship is controlled by you, 0
				       // otherwise
		if (arg4[i] == 1) {
		    myShipId = entityId[i];
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

    static class Barrel {
	int x;
	int y;

	public Barrel(int x, int y) {
	    this.x = x;
	    this.y = y;
	}
    }
}