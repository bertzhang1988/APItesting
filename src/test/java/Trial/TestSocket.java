package Trial;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TestSocket {
	@Test
	public void a() throws IOException {
		Socket s = null;
		try {
			s = new Socket("123.58.251.183", 6000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OutputStream os = s.getOutputStream();
		// 服务器发送数据

		os.write("hello".getBytes());
		os.flush();
		// 服务器读取数据
		InputStream inFromServer = s.getInputStream();
		byte[] buf = new byte[inFromServer.available()];
		inFromServer.read(buf);
		String result = new String(buf);

		System.out.println(result);

		
		inFromServer.close();
		s.close();

	}

	@Test
	public void e() throws IOException {
		Socket s = null;
		try {
			s = new Socket("123.58.251.183", 6000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OutputStream os = s.getOutputStream();
		// 服务器发送数据

		JSONObject jobject = new JSONObject();
		jobject.put("name", "test");
		jobject.put("pwd", "1123");
		jobject.put("sex", "男");
		os.write(JSON.toJSONString(jobject).getBytes());

		// 服务器读取数据
		InputStream inFromServer = s.getInputStream();
		BufferedInputStream buf = new BufferedInputStream(inFromServer);
		
		while (buf.available() != 0) {
			System.out.print((char)buf.read());
		}
		os.close();
		
		inFromServer.close();
		s.close();
	}

}
