package tryAny.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOTest3 {
    public static void main(String[] args) throws IOException {
	// シリアライズしたデータを格納。
	try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("iotest3.ser"))) {
	    String test = "iotest3";
	    oos.writeObject(test);// これでiotest3.serができる。
	    oos.writeInt(111);
	} catch (IOException e) {
	    throw new IOException(e);
	}

	// シリアライズしたデータを取得してメモリに展開。
	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("iotest3.ser"))) {
	    System.out.println(ois.readObject());
	    System.out.println(ois.readInt());
	} catch (ClassNotFoundException | IOException e) {
	    throw new IOException(e);
	}
    }
}
