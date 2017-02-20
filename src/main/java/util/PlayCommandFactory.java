package util;

import java.util.ResourceBundle;

/**
* PlayCommandインスタンスを生み出す。
*
* @author tie304340
*
*/
public class PlayCommandFactory {
    /**}
     * 生み出すメソッド
     * @param bundleName プロパティファイルの名前
     * @return PlayCommand インスタンス
     */
    public static PlayCommand getPlayCommand(String bundleName) {
        ResourceBundle rb1 = ResourceBundle.getBundle(bundleName);
        String knownHostPath1 = rb1.getString("known_host_path");
        String host1 = rb1.getString("host");
        String username1 = rb1.getString("username");
        String password1 = rb1.getString("password");
        int port1 = Integer.parseInt(rb1.getString("port"));
        return new PlayCommand(knownHostPath1, host1, username1, password1, port1);
    }
}