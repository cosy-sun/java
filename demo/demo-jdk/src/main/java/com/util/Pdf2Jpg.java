package com.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.junit.Test;

public class Pdf2Jpg {

	@Test
	public void pdfbox() throws Exception {
		ByteArrayOutputStream os = null;
		OutputStream out = null;
		try (InputStream stream = new FileInputStream(new File("D:/pdf.pdf"));
				PDDocument doc = PDDocument.load(stream);
				) {
			PDFRenderer pdfRenderer = new PDFRenderer(doc);
			PDPageTree pages = doc.getPages();
			int pageCount = pages.getCount();
			for (int i = 0; i < pageCount; i++) {
				BufferedImage bim = pdfRenderer.renderImageWithDPI(i, 200);
				os = new ByteArrayOutputStream();
				ImageIO.write(bim, "jpg", os);
				byte[] datas = os.toByteArray();
				out = new FileOutputStream("D:\\abc" + i + ".jpg");
				out.write(datas);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				os.close();
				out.close();
		}

	}

}
