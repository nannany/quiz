package util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

/**
* リモートにあるサーバにてシェルを実行し、標準出力を返す。
*
* @author tie304340
*
*/
public class PlayCommand {

    private Session session;

    private ChannelExec channel;

    public PlayCommand(String knownHostPath, String host, String userName, String password, int port) {
        try {
            JSch jsch = new JSch();
            jsch.setKnownHosts(knownHostPath);
            session = jsch.getSession(userName, host, port);
            session.setPassword(password);
            session.connect();
            channel = (ChannelExec) session.openChannel("exec");
        } catch (JSchException e) {
            // 例外時の処理
        }
    }

    // 標準出力を得るためのメソッド
    public String getStandardOutput(String command) throws Exception {
        // コマンド実行する。
        this.channel.setCommand(command);
        channel.connect();
        BufferedInputStream stndStream = new BufferedInputStream(channel.getInputStream());
        ByteArrayOutputStream normal_outputStream = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        while (true) {
            int len = stndStream.read(buf);
            if (len <= 0) {
                break;
            }
            normal_outputStream.write(buf, 0, len);
        }
        String normal_message = new String(normal_outputStream.toByteArray(), StandardCharsets.UTF_8);
        channel.disconnect();
        return normal_message;

    }
}
