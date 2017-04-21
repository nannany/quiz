package quiz.codeChef.iopc2017.maxOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for (int i = 0; i < T; i++) {
	    int N = sc.nextInt();
	    List<Integer> A = new ArrayList<Integer>();
	    for (int j = 0; j < N; j++) {
		A.add(sc.nextInt());
	    }
	    List<Integer> a = A.stream().distinct().sorted().collect(Collectors.toList());
	    if(a.size()==1){
		System.out.println(a.get(0));
	    }else{
		System.out.println(a.get(a.size() - 2));
	    }
	}
    }
}
