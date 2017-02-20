package util;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * コマンド実行結果のdiffを出力する。 info1.propertiesとinfo2.propertiesに情報を記入する。
 *
 * @author tie304340
 *
 */
public class Main {
    public static void main(String[] args) throws Exception {

	// info1.propertiesから情報を得る。
	ResourceBundle rb1 = ResourceBundle.getBundle("info1");
	PlayCommand pc1 = PlayCommandFactory.getPlayCommand("info1");
	// コマンド実行結果出力先
	PrintStream ps1_1 = new PrintStream(new FileOutputStream(rb1.getString("command_result_outputPath")));
	// 重複排除結果出力先
	PrintStream ps1_2 = new PrintStream(new FileOutputStream(rb1.getString("omit_duplicate_outputPath")));
	String command1 = rb1.getString("command");

	// info2.propertiesから情報を得る。
	ResourceBundle rb2 = ResourceBundle.getBundle("info2");
	PlayCommand pc2 = PlayCommandFactory.getPlayCommand("info2");
	// コマンド実行結果出力先
	PrintStream ps2_1 = new PrintStream(new FileOutputStream(rb2.getString("command_result_outputPath")));
	// 重複排除結果出力先
	PrintStream ps2_2 = new PrintStream(new FileOutputStream(rb2.getString("omit_duplicate_outputPath")));
	String command2 = rb2.getString("command");

	// 標準出力退避
	PrintStream systemOut = System.out;

	String tmp1 = pc1.getStandardOutput(command1);
	System.setOut(ps1_1);
	System.out.println("info1:\n" + tmp1);
	Set<String> stndOutput1 = new HashSet<String>();
	for (int i = 0; i < tmp1.split("\\n", 0).length; i++) {
	    stndOutput1.add(tmp1.split("\\n", 0)[i]);
	}

	String tmp2 = pc2.getStandardOutput(command2);
	System.setOut(ps2_1);
	System.out.println("info2:\n" + tmp2);
	Set<String> stndOutput2 = new HashSet<String>();
	for (int i = 0; i < tmp2.split("\\n", 0).length; i++) {
	    stndOutput2.add(tmp2.split("\\n", 0)[i]);
	}

	// 1つ目の結果を退避させる。
	Set<String> tmpForOmit = new HashSet<String>();
	Iterator<String> ite = stndOutput1.iterator();
	while (ite.hasNext()) {
	    tmpForOmit.add(ite.next());
	}

	// 重複削除
	stndOutput1.removeAll(stndOutput2);
	stndOutput2.removeAll(tmpForOmit);

	System.setOut(ps1_2);
	System.out.println(stndOutput1.toString().replace("[", "").replace("]", "").replace(", ", "\n"));
	System.setOut(ps2_2);
	System.out.println(stndOutput2.toString().replace("[", "").replace("]", "").replace(", ", "\n"));

	System.setOut(systemOut);
	// プロセスを殺す。これしないと送出テキスト消せない。
	System.exit(0);
    }
}