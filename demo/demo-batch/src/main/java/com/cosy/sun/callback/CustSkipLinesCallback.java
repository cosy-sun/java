package com.cosy.sun.callback;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.LineCallbackHandler;

public class CustSkipLinesCallback implements LineCallbackHandler,FlatFileHeaderCallback{

	private String line;
	
	@Override
	public void handleLine(String line) {
		this.line = line;
		System.out.println(line);
	}

	@Override
	public void writeHeader(Writer writer) throws IOException {
		writer.write(line);
	}

	
}
