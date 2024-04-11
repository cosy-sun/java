package com.cosy.sun.batch.processer;

import org.springframework.batch.item.ItemProcessor;

import com.cosy.sun.batch.bean.CreditBill;

public class CreditBillProcesser implements ItemProcessor<CreditBill, CreditBill>{

	private int count = 0;
	
	@Override
	public CreditBill process(CreditBill item) throws Exception {
		count ++;
		System.out.println(item.toString());
		if(count % 10 == 9 || count % 10 == 0)
			Thread.sleep(1000);
		return null;
	}

//	private static int count = 0;
//	
//	@Override
//	public CreditBill process(CreditBill item) throws Exception {
//		count++;
//		System.out.println("\n重试次数or跳过次数"+count+item.toString()+ "\n");
//		if(count >5)
//			throw new FileNotFoundException("测试");
//		if (count <= 5)
//			throw new RuntimeException("测试");
//		Thread.sleep(5000);
//		return item;
//	}
	
	
}
