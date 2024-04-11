package com.cosy.sun.zip.adaptor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.springframework.stereotype.Component;

import com.cosy.sun.zip.Zip;

@Component
public class JdkZipAdaptor implements Zip {

	@Override
	public byte[] zip(byte[] bytes) {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
				GZIPOutputStream zipOutputStream = new GZIPOutputStream(baos);) {
			zipOutputStream.write(bytes);
			zipOutputStream.flush();
			zipOutputStream.finish();
			return baos.toByteArray();
		} catch (Exception e) {
			return bytes;
		}
	}

	@Override
	public byte[] unzip(byte[] bytes) {
		try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
				GZIPInputStream zip = new GZIPInputStream(bais);) {
			byte[] resByte = new byte[bytes.length];
			zip.read(resByte);
			return resByte;
		} catch (Exception e) {
			return bytes;
		}
	}

	
	
}
