package com.cosy.sun.batch.fieldSetMapper;

import com.cosy.sun.batch.bean.CreditBill;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class CustFieldSetMapper implements FieldSetMapper<CreditBill>{

	@Override
	public CreditBill mapFieldSet(FieldSet fieldSet) throws BindException {
		CreditBill creditBill = new CreditBill();
		creditBill.setAccountId(fieldSet.readString("accountId"));
		creditBill.setName(fieldSet.readString("name"));
		creditBill.setAddress(fieldSet.readString("address"));
		creditBill.setAmount(Double.valueOf(fieldSet.readString("amount")));
		creditBill.setData(fieldSet.readString("data"));
		return creditBill;
	}

}
