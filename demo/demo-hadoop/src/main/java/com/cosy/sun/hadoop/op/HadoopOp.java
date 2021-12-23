package com.cosy.sun.hadoop.op;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HadoopOp {

	@Autowired
	private FileSystem fileSystem;
	
	public void exist(String path) throws Exception {
		fileSystem.mkdirs(new Path(path));
	}
	
}
