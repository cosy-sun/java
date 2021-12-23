package com.sun.policy;

import org.springframework.batch.item.file.separator.RecordSeparatorPolicy;

public class MultRecordSeparatorPolicy implements RecordSeparatorPolicy{

	private String delimiter = ",";
	private int count = 0;
	
	@Override
	public boolean isEndOfRecord(String record) {
		return count(record) == count;
	}

	@Override
	public String postProcess(String record) {
		return record;
	}

	@Override
	public String preProcess(String record) {
		return record;
	}
	
	private int count(String s) {
		String tmp = s;
		int index = -1;
		int count = 0;
		while ((index = s.indexOf(delimiter))!=-1) {
			tmp = tmp.substring(index);
			count ++;
		}
		return count;
	}
	
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}
	
	public void setCount(int count) {
		this.count = count;
	}

}
