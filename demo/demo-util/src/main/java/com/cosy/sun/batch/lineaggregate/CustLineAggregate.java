package com.cosy.sun.batch.lineaggregate;

import org.springframework.batch.item.file.transform.ExtractorLineAggregator;

public class CustLineAggregate extends ExtractorLineAggregator<String>{

	private String delimiter = ";";
	private String[] names;
	
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}
	
	public void setNames(String[] names) {
		this.names = names;
	}
	
	@Override
	protected String doAggregate(Object[] fields) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i< fields.length; i  ++) {
			if(i == fields.length - 1)
				builder.append(names[i] + "=" + fields[i]);
			else
				builder.append(names[i] + "=" + fields[i] + delimiter);
		}
		System.out.println(builder.toString());
		return builder.toString();
	}

}
