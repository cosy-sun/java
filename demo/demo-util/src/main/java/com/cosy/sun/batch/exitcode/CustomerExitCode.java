package com.cosy.sun.batch.exitcode;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.launch.support.ExitCodeMapper;

public class CustomerExitCode implements ExitCodeMapper{

	@Override
	public int intValue(String exitCode) {
		if (exitCode.equals(ExitStatus.COMPLETED.getExitCode()))
			return 1;
		if (exitCode.equals(ExitStatus.FAILED.getExitCode()))
			return 2;
		return 0;
	}

}
