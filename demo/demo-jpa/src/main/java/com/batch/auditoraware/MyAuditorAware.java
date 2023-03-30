package com.batch.auditoraware;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("myAuditorAware")
@Lazy
public class MyAuditorAware implements AuditorAware<Integer>{

	@Override
	public Optional<Integer> getCurrentAuditor() {
		// TODO Auto-generated method stub
		return Optional.of(10);
	}

}
