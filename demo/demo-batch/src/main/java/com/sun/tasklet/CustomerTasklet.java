package com.sun.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class CustomerTasklet implements Tasklet{

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println();
		System.out.println(contribution.toString());
		System.out.println(chunkContext.toString());
		System.out.println("***自定义的tasklet***");
		return null;
	}

	public void execute() {
		System.out.println("-------------------------");
	}
	
}
