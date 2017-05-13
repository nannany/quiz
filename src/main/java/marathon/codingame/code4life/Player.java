package marathon.codingame.code4life;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Player {
    static String molecules[] = { "A", "B", "C", "D", "E" };
    static MyStatus myStatus;
    static Map<Integer, String> idStatusMap = new HashMap<Integer, String>();
    static int id = 0;

    public static void main(String args[]) {

	Scanner in = new Scanner(System.in);
	int projectCount = in.nextInt();
	for (int i = 0; i < projectCount; i++) {
	    int a = in.nextInt();
	    int b = in.nextInt();
	    int c = in.nextInt();
	    int d = in.nextInt();
	    int e = in.nextInt();
	}

	while (true) {
	    myStatus = new MyStatus(in.next(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(),
		    in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
	    EnemyStatus enemyStatus = new EnemyStatus(in.next(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(),
		    in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(),
		    in.nextInt());
	    int availableA = in.nextInt();
	    int availableB = in.nextInt();
	    int availableC = in.nextInt();
	    int availableD = in.nextInt();
	    int availableE = in.nextInt();
	    int sampleCount = in.nextInt();
	    List<Sample> sampleList = new ArrayList<Sample>();
	    List<Sample> mySampleList = new ArrayList<Sample>();

	    for (int i = 0; i < sampleCount; i++) {
		Sample sample = new Sample(in.nextInt(), in.nextInt(), in.nextInt(), in.next(), in.nextInt(),
			in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		sampleList.add(sample);
	    }

	    // mySampleList初期化
	    sampleList.stream().filter(sample -> sample.carriedBy == 0).forEach(sample -> mySampleList.add(sample));
	    mySampleList.stream().forEach(s -> System.err.println("my" + s.sampleId));

	    // id 初期化
	    id = sampleList.size() == 0 ? 0 : sampleList.stream().sorted((smp1, smp2) -> {
		return smp2.sampleId - smp1.sampleId;
	    }).findFirst().get().sampleId + 1;
	    System.err.println("id" + id);

	    sampleList.stream().forEach(smple -> System.err.println(smple.sampleId + "carriedId" + smple.carriedBy));

	    String ret = "GOTO SAMPLES";
	    if (sampleList.size() == 0 && !"SAMPLES".equals(myStatus.target)) {
		System.out.println("GOTO SAMPLES");
		continue;
	    }

	    if ("SAMPLES".equals(myStatus.target)) {
		if (getSumOfMySample(sampleList) == 3) {
		    if (mySampleList.stream().anyMatch(sample -> !"diagnosed".equals(idStatusMap.get(sample.sampleId)))
			    || mySampleList.size() == 0) {
			ret = "GOTO DIAGNOSIS";
		    } else {
			ret = "GOTO MOLECULES";
		    }
		} else {
		    // Sample targetSample = sampleList.stream().sorted(new
		    // EvaluateValueComparator())
		    // .filter(sample -> sample.carriedBy ==
		    // -1).findFirst().get();
		    //
		    // ret = "CONNECT " + targetSample.rank;
		    // mySampleList.add(targetSample);
		    // // mySampleList は常に評価値の降順で並んでいるようにする。
		    // mySampleList.stream().sorted(new
		    // EvaluateValueComparator());
		    ret = "CONNECT 2";
		    idStatusMap.put(id, "undiagnosed");
		}
	    } else if ("DIAGNOSIS".equals(myStatus.target)) {
		if (mySampleList.size() != 0 && mySampleList.stream()
			.allMatch(sample -> "diagnosed".equals(idStatusMap.get(sample.sampleId)))) {
		    ret = "GOTO MOLECULES";
		    idStatusMap.forEach((integer, str) -> {
			System.err.println(integer.intValue() + " " + str);
		    });
		} else {
		    Sample targetSample = mySampleList.stream()
			    .filter(sample -> !"diagnosed".equals(idStatusMap.get(sample.sampleId))).findFirst().get();
		    ret = "CONNECT " + targetSample.sampleId;
		    idStatusMap.put(targetSample.sampleId, "diagnosed");
		    mySampleList.add(targetSample);
		    // mySampleList は常に評価値の降順で並んでいるようにする。
		    mySampleList.stream().sorted(new EvaluateValueComparator());
		}
	    } else if ("MOLECULES".equals(myStatus.target)) {
		if (myStatus.sumOfStorage == 10) {
		    ret = "GOTO LABORATORY";
		} else {
		    flag1: for (Sample sample : mySampleList) {
			String shortenMolecule = investigateHaveMolecules(sample);
			if (!"enough".equals(shortenMolecule)) {
			    for (int i = 0; i < molecules.length; i++) {
				if (molecules[i].equals(shortenMolecule)) {
				    ret = "CONNECT " + shortenMolecule;
				    break flag1;
				}
			    }
			} else {
			    ret = "GOTO LABORATORY";
			}
		    }
		}
		// LABORATORY にいる場合
	    } else {
		if (mySampleList.size() == 0) {
		    ret = "GOTO SAMPLES";
		} else {
		    if ("enough".equals(investigateHaveMolecules(mySampleList.get(0)))) {
			ret = "CONNECT " + mySampleList.remove(0).sampleId;
		    } else {
			ret = "GOTO MOLECULES";
		    }
		}
	    }

	    System.out.println(ret);
	}
    }

    static class EvaluateValueComparator implements Comparator<Sample> {
	public int compare(Sample s1, Sample s2) {
	    return evaluateSample(s2) - evaluateSample(s1);
	}
    }

    // sampleに対して、自分が分子を保有していないかどうか調べる。
    static String investigateHaveMolecules(Sample sample) {
	if (myStatus.storageA < sample.costA) {
	    return "A";
	} else if (myStatus.storageB < sample.costB) {
	    return "B";
	} else if (myStatus.storageC < sample.costC) {
	    return "C";
	} else if (myStatus.storageD < sample.costD) {
	    return "D";
	} else if (myStatus.storageE < sample.costE) {
	    return "E";
	} else {
	    return "enough";
	}
    }

    // sampleの価値評価を返す。
    static int evaluateSample(Sample sample) {
	if (sample.rank == 2) {
	    return sample.health - sample.getSimpleTotalCost() + 20;
	} else if (sample.rank == 1) {
	    return sample.health - sample.getSimpleTotalCost() + 10;
	} else {
	    return sample.health - sample.getSimpleTotalCost();
	}
    }

    static int getSumOfMySample(List<Sample> sampleList) {
	int ret = 0;
	for (Sample sample : sampleList) {
	    if (sample.carriedBy == 0) {
		ret++;
	    }
	}
	return ret;
    }

    static int getSumOfEnemySample(List<Sample> sampleList) {
	int ret = 0;
	for (Sample sample : sampleList) {
	    if (sample.carriedBy == 1) {
		ret++;
	    }
	}
	return ret;
    }

    static class Sample {
	int sampleId, carriedBy, rank, health, costA, costB, costC, costD, costE;
	String expertiseGain;

	String status = "unsettled";

	public Sample(int sampleId, int carriedBy, int rank, String expertiseGain, int health, int costA, int costB,
		int costC, int costD, int costE) {
	    super();
	    this.sampleId = sampleId;
	    this.carriedBy = carriedBy;
	    this.rank = rank;
	    this.health = health;
	    this.costA = costA;
	    this.costB = costB;
	    this.costC = costC;
	    this.costD = costD;
	    this.costE = costE;
	    this.expertiseGain = expertiseGain;
	}

	public int getSimpleTotalCost() {
	    return costA + costB + costC + costD + costE;
	}
    }

    static class Status {
	String target;
	int eta, score, storageA, storageB, storageC, storageD, storageE, expertiseA, expertiseB, expertiseC,
		expertiseD, expertiseE;

	int sumOfStorage, sumOfSample;

	public Status(String target, int eta, int score, int storageA, int storageB, int storageC, int storageD,
		int storageE, int expertiseA, int expertiseB, int expertiseC, int expertiseD, int expertiseE) {
	    super();
	    this.target = target;
	    this.eta = eta;
	    this.score = score;
	    this.storageA = storageA;
	    this.storageB = storageB;
	    this.storageC = storageC;
	    this.storageD = storageD;
	    this.storageE = storageE;
	    this.expertiseA = expertiseA;
	    this.expertiseB = expertiseB;
	    this.expertiseC = expertiseC;
	    this.expertiseD = expertiseD;
	    this.expertiseE = expertiseE;
	    this.sumOfStorage = storageA + storageB + storageC + storageD + storageE;
	}
    }

    static class MyStatus extends Status {
	public MyStatus(String target, int eta, int score, int storageA, int storageB, int storageC, int storageD,
		int storageE, int expertiseA, int expertiseB, int expertiseC, int expertiseD, int expertiseE) {
	    super(target, eta, score, storageA, storageB, storageC, storageD, storageE, expertiseA, expertiseB,
		    expertiseC, expertiseD, expertiseE);
	}
    }

    static class EnemyStatus extends Status {

	public EnemyStatus(String target, int eta, int score, int storageA, int storageB, int storageC, int storageD,
		int storageE, int expertiseA, int expertiseB, int expertiseC, int expertiseD, int expertiseE) {
	    super(target, eta, score, storageA, storageB, storageC, storageD, storageE, expertiseA, expertiseB,
		    expertiseC, expertiseD, expertiseE);
	}
    }

}
