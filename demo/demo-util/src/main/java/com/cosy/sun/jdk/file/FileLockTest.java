package com.cosy.sun.jdk.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileLockTest {


	public void test() {
		method1();
		System.out.println("****");
		method2();
		System.out.println("****");
		method1();
	}
	
	public void method1() {
		try {
			System.out.println("kaishi");
			RandomAccessFile randomAccessFile = new RandomAccessFile("F:\\新建文本文档.txt", "rw");
			System.out.println(randomAccessFile.length());
			FileChannel channel = randomAccessFile.getChannel();
			ByteBuffer b = ByteBuffer.allocate(1024);
			System.out.println(channel.read(b));
			b.flip();
			StringBuilder builder = new StringBuilder();
			while(b.hasRemaining()) {
				builder.append((char)b.get());
			}
			System.out.println(builder.toString());
			
			channel.close();
			randomAccessFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void method2() {
		try {
			System.out.println("kaishi");
			RandomAccessFile randomAccessFile = new RandomAccessFile("F:\\新建文本文档.txt", "rw");
			randomAccessFile.seek(randomAccessFile.length());
			FileChannel channel = randomAccessFile.getChannel();
			ByteBuffer b = ByteBuffer.allocate(1024);
			b.put("sunzhenhua".getBytes());
			b.flip();
			while(b.hasRemaining()) {
				channel.write(b);
			}
			
			channel.close();
			randomAccessFile.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
