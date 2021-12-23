package com.sun.lineMapper;

import java.util.Map;

import org.springframework.batch.item.file.LineMapper;

import com.sun.bean.CreditBill;

public class JsonLineMapper implements LineMapper<CreditBill>{

	private org.springframework.batch.item.file.mapping.JsonLineMapper lineMapper;
	
	@Override
	public CreditBill mapLine(String line, int lineNumber) throws Exception {
		CreditBill creditBill = new CreditBill();
		Map<String, Object> mapLine = lineMapper.mapLine(line, lineNumber);
		creditBill.setAccountId((String) mapLine.get("accountId"));
		return creditBill;
	}

}
