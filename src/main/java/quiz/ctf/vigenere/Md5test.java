package quiz.ctf.vigenere;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5test {
    public static Character[][] map = new Character[28][28];
    public static void main(String[] args) {
	String partOne = "SECCON{";
	String partSecond = "BCDEDEF";
	String partThird = "KLMNOPQ";
	String partForth = "VWXYYZ}";
	String firstSection = "EDOEE";
	String secondSection = "KJWMN";
	String thirdSection = "VUFWY";
	int count = 0;
	Exchange exchange = new Exchange();
	exchange.putMap();
	flag: for (int i = 0; i < 28; i++) {
	    char h1s1 = exchange.getHirabun(map[0][i], firstSection.charAt(0));
	    char h2s1 = exchange.getHirabun(map[0][i], secondSection.charAt(0));
	    char h3s1 = exchange.getHirabun(map[0][i], thirdSection.charAt(0));
	    for (int j = 0; j < 28; j++) {
		char h1s2 = exchange.getHirabun(map[0][j], firstSection.charAt(1));
		char h2s2 = exchange.getHirabun(map[0][j], secondSection.charAt(1));
		char h3s2 = exchange.getHirabun(map[0][j], thirdSection.charAt(1));
		for (int k = 0; k < 28; k++) {
		    char h1s3 = exchange.getHirabun(map[0][k], firstSection.charAt(2));
		    char h2s3 = exchange.getHirabun(map[0][k], secondSection.charAt(2));
		    char h3s3 = exchange.getHirabun(map[0][k], thirdSection.charAt(2));
		    for (int l = 0; l < 28; l++) {
			char h1s4 = exchange.getHirabun(map[0][l], firstSection.charAt(3));
			char h2s4 = exchange.getHirabun(map[0][l], secondSection.charAt(3));
			char h3s4 = exchange.getHirabun(map[0][l], thirdSection.charAt(3));
			for (int m = 0; m < 28; m++) {
			    char h1s5 = exchange.getHirabun(map[0][m], firstSection.charAt(4));
			    char h2s5 = exchange.getHirabun(map[0][m], secondSection.charAt(4));
			    char h3s5 = exchange.getHirabun(map[0][m], thirdSection.charAt(4));
			    String hirabun = partOne + h1s1 + h1s2 + h1s3 + h1s4 + h1s5 + partSecond + h2s1 + h2s2
				    + h2s3 + h2s4 + h2s5 + partThird + h3s1 + h3s2 + h3s3 + h3s4 + h3s5 + partForth;
			    if ("f528a6ab914c1ecf856a1d93103948fe".equals(DigestUtils.md5Hex(hirabun))) {
				System.out.println("success" + hirabun);
				break flag;
			    } else {
				count++;
				System.out.println(count + ":" +hirabun);
			    }
			}
		    }
		}
	    }
	}
	System.out.println(count);
    }
}

// 平文の値を返すためのクラス
class Exchange {
    public Character getHirabun(Character key, Character ango) {
	int gyou = -1;
	int retu = -1;
	for (int i = 0; i < 28; i++) {
	    if (key.equals(Md5test.map[i][0])) {
		gyou = i;
	    }
	}
	if (gyou == -1) {
	    for (int i = 0; i < 28; i++) {
		System.out.println(Md5test.map[i][0]);
	    }
	    System.out.println(key + "aaa" + ango);
	}
	for (int i = 0; i < 28; i++) {
	    if (ango.equals(Md5test.map[gyou][i])) {
		retu = i;
	    }
	}
	return Md5test.map[0][retu];
    }
    public void putMap() {
	for (int i = 0; i < 26; i++) {
	    int forChar = 65 + i;
	    Md5test.map[0][i] = (char) forChar;
	}
	Md5test.map[0][26] = '{';
	Md5test.map[0][27] = '}';

	for (int i = 0; i < 28; i++) {
	    for (int j = 0; j < 28; j++) {
		if (i + j < 28) {
		    Md5test.map[i][j] = Md5test.map[0][i + j];
		} else {
		    Md5test.map[i][j] = Md5test.map[0][i + j - 28];
		}
	    }
	}
    }
}
