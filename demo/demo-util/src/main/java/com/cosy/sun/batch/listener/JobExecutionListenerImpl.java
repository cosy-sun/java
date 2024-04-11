package com.cosy.sun.batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;

//public class JobExecutionListenerImpl implements JobExecutionListener{
//
//	/*
//	 * beforJob的配置顺序按照配置顺序执行
//	 * afterJob的配置按照反序执行 
//	 */
//	
//	@Override
//	public void beforeJob(JobExecution jobExecution) {
//		System.out.println("job执行之前");
//	}
//
//	@Override
//	public void afterJob(JobExecution jobExecution) {
//		System.out.println("job执行之后");
//	}
//
//}

public class JobExecutionListenerImpl{

	/*
	 * beforJob的配置顺序按照配置顺序执行
	 * afterJob的配置按照反序执行 
	 */
	@BeforeJob
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("job执行之前");
	}

	@AfterJob
	public void afterJob(JobExecution jobExecution) {
		System.out.println("job执行之后");
	}

}