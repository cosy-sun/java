package com.sun.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class StepExecutionListenerTwoImpl implements StepExecutionListener {

	@Override
	public void beforeStep(StepExecution stepExecution) {
		System.out.println(this.getClass().getSimpleName() + "\n" + stepExecution.toString() + "\n");
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.out.println(this.getClass().getSimpleName() + "after");
		return ExitStatus.COMPLETED;
	}

}
