package com.cosy.sun.socket.httprequest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

	@SuppressWarnings("unused")
	private static final String GET = "get";

	@SuppressWarnings("unused")
	private static final String POST = "post";

	public static void main(String[] args) throws Exception {
		// 设置请求的url
		String spec = "http://www.csii.com.cn/csii/";
		// 创建http连接
		HttpURLConnection httpUrlConnection = (HttpURLConnection) new URL(spec).openConnection();
		// 进行连接
		httpUrlConnection.connect();
		// 设置超时时间
		httpUrlConnection.setConnectTimeout(5000);
		// 设置请求类型
		// httpUrlConnection.setRequestMethod(GET);
		// 返回响应码
		int responseCode = httpUrlConnection.getResponseCode();
		// 返回响应的长度
		int contentLength = httpUrlConnection.getContentLength();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			// 获取输入流
			InputStream inputStream = httpUrlConnection.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			char[] c = new char[contentLength];
			// 将 读取 到的字符放在char数组中
			bufferedReader.read(c);
			String str = new String(c);
			System.out.println(str);
			File file = new File("com.sun.httprequest.response.txt");
			FileWriter fileWriter = new FileWriter(file, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println(str);//将响应写到文件中
			printWriter.flush();
			printWriter.close();
		}

	}

}
