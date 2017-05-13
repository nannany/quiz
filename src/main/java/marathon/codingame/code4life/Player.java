package marathon.codingame.code4life;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Player {
    static String molecules[] = { "A", "B", "C", "D", "E" };
    static MyStatus myStatus;

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

	List<Sample> mySampleList = new ArrayList<Sample>();
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
	    for (int i = 0; i < sampleCount; i++) {
		Sample sample = new Sample(in.nextInt(), in.nextInt(), in.nextInt(), in.next(), in.nextInt(),
			in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		sampleList.add(sample);
	    }

	    sampleList.stream().forEach(smple -> System.err.println(smple.sampleId));

	    String ret = "GOTO DIAGNOSIS";
	    if ("DIAGNOSIS".equals(myStatus.target)) {
		if (getSumOfMySample(sampleList) == 3) {
		    ret = "GOTO MOLECULES";
		} else {
		    Sample targetSample = sampleList.stream().sorted(new Comparator<Sample>() {
			public int compare(Sample s1, Sample s2) {
			    return evaluateSample(s2) - evaluateSample(s1);
			}
		    }).filter(sample -> sample.carriedBy == -1).findFirst().get();

		    ret = "CONNECT " + targetSample.sampleId;
		    mySampleList.add(targetSample);

		    // mySampleList は常に評価値の降順で並んでいるようにする。
		    mySampleList.stream().sorted(new Comparator<Sample>() {
			public int compare(Sample s1, Sample s2) {
			    return evaluateSample(s2) - evaluateSample(s1);
			}
		    });
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
		    ret = "GOTO DIAGNOSIS";
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
	return sample.health - sample.getSimpleTotalCost();
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
