package com.cosy.sun.algorithm.design.cyrptoandzip;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipTest {

//	public static void main(String[] args) throws Exception {
//		FileInputStream fis= new FileInputStream(new File("E:\\szh.txt"));
//		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File("E:\\szh.zip")));
//		BufferedInputStream bis = new BufferedInputStream(fis);
//		zos.putNextEntry(new ZipEntry(new File("E:\\szh.txt").getName()));
//		byte[] b = new byte[1024];
//		int i;
//		while((i = bis.read(b)) != -1) {
//			zos.write(b);
//		}
//		System.out.println("wancheng");
//		
//		fis.close();
//		zos.close();
//		bis.close();
//		
//	}
//	public static void main(String[] args) {
//		File src = new File("E:\\ych");
//		File srcTo = new File("E:\\ych.zip");
//		try {
//			new ZipTest().comress(src,srcTo);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ;
//		}
//	}
	public void comress(File src, File srcTo) throws Exception {
		FileOutputStream fosSrcTo = new FileOutputStream(srcTo);
		ZipOutputStream zos = new ZipOutputStream(fosSrcTo);
		String basestr = "";
		zipSrc(src, zos, basestr);
	}
	
	private void zipSrc(File src, ZipOutputStream zos, String baseStr) throws Exception{
		if(!src.exists()) {
			return ;
		}
		File[] listFiles = src.listFiles();
		for(File InnerSrc : listFiles) {
			System.out.println(InnerSrc.getName());
			if(InnerSrc.isDirectory()) {
				zos.putNextEntry(new ZipEntry(baseStr+InnerSrc.getName()+"/"));
				System.out.println(baseStr+InnerSrc.getName()+"/");
				
				zipSrc(InnerSrc, zos, baseStr+InnerSrc.getName()+"/");
			}
			if(InnerSrc.isFile()) {
				//read file
				try {
					readFileToZip(InnerSrc, zos, baseStr);
				}catch(Exception e) {
					System.out.println("Exception");
					return ;
				}
			}
			
		}
	}
	
	@SuppressWarnings("unused")
	private void readFileToZip(File src, ZipOutputStream zos, String baseStr) throws Exception{
		byte[] b = new byte[1024];
		int count;
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		zos.putNextEntry(new ZipEntry(baseStr+src.getName()));
		System.out.println(baseStr+src.getName());
		while((count = bis.read(b)) != -1) {
			zos.write(b);
		}
		bis.close();
	}
	
}
